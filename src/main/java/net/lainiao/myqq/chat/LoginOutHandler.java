package net.lainiao.myqq.chat;

import com.alibaba.fastjson.JSONObject;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import net.lainiao.myqq.entity.Account;
import net.lainiao.myqq.model.*;
import net.lainiao.myqq.model.CommonMess;
import net.lainiao.myqq.netty.Global;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class LoginOutHandler extends CommonHandler  {

    public void handler(ChannelHandlerContext ctx, CommonMess commonMess) {
        LoginOutRequestModel requestModel= JSONObject.parseObject(commonMess.getContent(),LoginOutRequestModel.class);
        loginOut(requestModel.getId());
        LoginOutResponseModel responseModel=new LoginOutResponseModel();
        responseModel.setState(1);
        responseClient(ctx,-MessType.LoginOut,responseModel);
        Global.loginOut(ctx);
    }

    public void loginOut(int accId){
        List<Account> accounts=accountService.getFriends(accId);
        for(Account account:accounts){
            if(Global.currentChannel.containsKey(account.getId())){
                GetSysMessResponseModel sysMessResponseModel=new GetSysMessResponseModel();
                sysMessResponseModel.setState(1);
                sysMessResponseModel.setFromId(accId);
                sysMessResponseModel.setSysMessType(4);
                sysMessResponseModel.setFaceimg(account.getFaceimg());
                Channel channel=Global.currentChannel.get(account.getId());
                responseClient(channel,-MessType.GetSysMess,sysMessResponseModel);
            }
        }
    }
}
