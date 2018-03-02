package net.lainiao.myqq.chat;

import com.alibaba.fastjson.JSONObject;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import net.lainiao.myqq.entity.Account;
import net.lainiao.myqq.entity.ChatMess;
import net.lainiao.myqq.model.*;
import net.lainiao.myqq.model.CommonMess;
import net.lainiao.myqq.netty.Global;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class SendChatMesHandler extends CommonHandler  {

    public void handler(ChannelHandlerContext ctx, CommonMess commonMess) {
        SendChatMessRequestModel requestModel= JSONObject.parseObject(commonMess.getContent(),SendChatMessRequestModel.class);
        if(requestModel.getTargetType()==0){
            if(Global.currentChannel.containsKey(requestModel.getTargetId())){
                Channel channel=Global.currentChannel.get(requestModel.getTargetId());
                GetOffLineChatMessResponseModel responseModel=new GetOffLineChatMessResponseModel();
                Account account=accountService.selectByPrimaryKey(requestModel.getId());
                responseModel.setNickName(account.getNickname());
                responseModel.setChatMessType(0);
                responseModel.setContent(requestModel.getContent());
                responseModel.setFromid(requestModel.getId());
                responseModel.setCreatetime(new Date());
                responseClient(channel,-MessType.GetOffLineChatMess,responseModel);
            }
            else{
                ChatMess chatMess=new ChatMess();
                chatMess.setCreatetime(new Date());
                chatMess.setContent(requestModel.getContent());
                chatMess.setFromid(requestModel.getId());
                chatMess.setTargetid(requestModel.getTargetId());
                chatMess.setTargettype(0);
                chatMessService.insert(chatMess);
            }
        }
        else{
            //处理群组消息
        }
        SendChatMessResponseModel responseModel=new SendChatMessResponseModel();
        responseModel.setState(1);
        responseClient(ctx,-MessType.SendChatMess,responseModel);
    }
}
