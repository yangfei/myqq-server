package net.lainiao.myqq.chat;

import com.alibaba.fastjson.JSONObject;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import net.lainiao.myqq.entity.Account;
import net.lainiao.myqq.model.GetSysMessResponseModel;
import net.lainiao.myqq.model.LoginRequestModel;
import net.lainiao.myqq.model.LoginResponseModel;
import net.lainiao.myqq.model.MessType;
import net.lainiao.myqq.model.CommonMess;
import net.lainiao.myqq.netty.Global;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoginHandler  extends CommonHandler  {
    public void handler(ChannelHandlerContext ctx, CommonMess commonMess) {
        LoginRequestModel requestModel= JSONObject.parseObject(commonMess.getContent(),LoginRequestModel.class);
        Account account=new Account();
        account.setUsername(requestModel.getUsername());
        account.setUserpass(requestModel.getUserpass());
        account=accountService.login(account);
        LoginResponseModel responseModel=new LoginResponseModel();
        if(account==null) {
            responseModel.setState(-1);
            responseModel.setMess("登录失败，用户名或着密码错误!");
        }
        else {
            responseModel.setState(1);
            responseModel.setAge(account.getAge());
            responseModel.setBlood(account.getBlood());
            responseModel.setConste(account.getConste());
            responseModel.setCreatetime(account.getCreatetime());
            responseModel.setGender(account.getGender());
            responseModel.setId(account.getId());
            responseModel.setNickname(account.getNickname());
            responseModel.setUsername(account.getUsername());
            responseModel.setLineState(1);
            responseModel.setFaceimg(account.getFaceimg());
            Global.currentChannel.put(account.getId(),ctx.channel());
            Global.currentAccount.put(ctx.channel(),account.getId());
        }
        responseClient(ctx,-MessType.Login,responseModel);
        if(responseModel.getState()==1){
            List<Account> accounts=accountService.getFriends(account.getId());
            for(Account temAcc:accounts){
                if(Global.currentChannel.containsKey(temAcc.getId())){
                    GetSysMessResponseModel sysMessResponseModel=new GetSysMessResponseModel();
                    sysMessResponseModel.setState(1);
                    sysMessResponseModel.setFromId(account.getId());
                    sysMessResponseModel.setSysMessType(5);
                    Channel channel=Global.currentChannel.get(temAcc.getId());
                    responseClient(channel,-MessType.GetSysMess,sysMessResponseModel);
                }
            }
        }
    }
}
