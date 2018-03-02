package net.lainiao.myqq.chat;

import com.alibaba.fastjson.JSONObject;
import io.netty.channel.ChannelHandlerContext;
import net.lainiao.myqq.entity.Account;
import net.lainiao.myqq.entity.ChatMess;
import net.lainiao.myqq.model.*;
import net.lainiao.myqq.model.CommonMess;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class GetOffLineChatMessHandler extends CommonHandler  {

    public void handler(ChannelHandlerContext ctx, CommonMess commonMess) {
        GetOffLineChatMessRequestModel requestModel= JSONObject.parseObject(commonMess.getContent(),GetOffLineChatMessRequestModel.class);
        List<ChatMess> list=chatMessService.getOffLineChatMessByAccount(requestModel.getId());
        for(ChatMess chatMess:list){
            GetOffLineChatMessResponseModel responseModel=new GetOffLineChatMessResponseModel();
            responseModel.setCreatetime(chatMess.getCreatetime());
            responseModel.setFromid(chatMess.getFromid());
            responseModel.setContent(chatMess.getContent());
            responseModel.setChatMessType(chatMess.getTargettype());
            Account account=accountService.selectByPrimaryKey(chatMess.getFromid());
            responseModel.setNickName(account.getNickname());
            responseModel.setFaceimg(account.getFaceimg());
            responseClient(ctx,-MessType.GetOffLineChatMess,responseModel);
            chatMessService.delete(chatMess.getId());
        }
    }
}
