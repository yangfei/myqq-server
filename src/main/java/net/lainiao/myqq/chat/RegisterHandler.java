package net.lainiao.myqq.chat;

import com.alibaba.fastjson.JSONObject;
import io.netty.channel.ChannelHandlerContext;
import net.lainiao.myqq.entity.Account;
import net.lainiao.myqq.model.CommonMess;
import net.lainiao.myqq.model.MessType;
import net.lainiao.myqq.model.RegisetRequestModel;
import net.lainiao.myqq.model.RegisetResponseModel;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;

@Component
public class RegisterHandler  extends CommonHandler  {
    public   void handler(ChannelHandlerContext ctx, CommonMess commonMess) {
        RegisetRequestModel requestModel= JSONObject.parseObject(commonMess.getContent(),RegisetRequestModel.class);
        RegisetResponseModel responseModel=new RegisetResponseModel();
        int count=accountService.getCountByUserName(requestModel.getUsername());
        if(count==0){
            Account account=new Account();
            account.setNickname(requestModel.getNickname());
            account.setGender(requestModel.getGender());
            account.setBlood(requestModel.getBlood());
            account.setConste(requestModel.getConste());
            account.setAge(requestModel.getAge());
            account.setUsername(requestModel.getUsername());
            account.setUserpass(requestModel.getUserpass());
            account.setCreatetime(new Date());
            account.setState(1);
            Random rand = new Random();
            account.setFaceimg(rand.nextInt(100));
            count=accountService.insert(account);
            if(count>0){
                responseModel.setState(1);
            }
            else{
                responseModel.setState(0);
                responseModel.setMess("服务端错误!");
            }
        }
        else{
            responseModel.setState(0);
            responseModel.setMess("用户名已经存在!");
        }
        responseClient(ctx,-MessType.Register,responseModel);
    }
}
