package net.lainiao.myqq.chat;

import com.alibaba.fastjson.JSONObject;
import io.netty.channel.ChannelHandlerContext;
import net.lainiao.myqq.entity.Account;
import net.lainiao.myqq.model.*;
import net.lainiao.myqq.model.CommonMess;
import net.lainiao.myqq.netty.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class GetFriendsHandler extends CommonHandler  {
    @Autowired
    GetSysMessHandler getSysMessHandler;
    @Autowired
    GetOffLineChatMessHandler getOffLineChatMessHandler;

    public void handler(ChannelHandlerContext ctx, CommonMess commonMess) {
        GetFriendsRequestModel requestModel= JSONObject.parseObject(commonMess.getContent(),GetFriendsRequestModel.class);
        if(requestModel.getTargetId()==0){
            List<Account> accounts=accountService.getFriends(requestModel.getId());
            for(Account account: accounts){
                GetFriendsResponseModel responseModel=new GetFriendsResponseModel();
                responseModel.setFriendid(account.getId());
                responseModel.setNickName(account.getNickname());
                responseModel.setFaceimg(account.getFaceimg());
                if(Global.currentChannel.containsKey(account.getId())){
                    responseModel.setState(1);
                }else{
                    responseModel.setState(0);
                }
                responseClient(ctx,-MessType.GetFriends,responseModel);
            }
            getSysMessHandler.handler(ctx,commonMess);
            getOffLineChatMessHandler.handler(ctx,commonMess);
        }
        else{
            Account account=accountService.selectByPrimaryKey(requestModel.getTargetId());
            GetFriendsResponseModel responseModel=new GetFriendsResponseModel();
            responseModel.setFriendid(account.getId());
            responseModel.setNickName(account.getNickname());
            responseModel.setFaceimg(account.getFaceimg());
            if(Global.currentChannel.containsKey(account.getId())){
                responseModel.setState(1);
            }else{
                responseModel.setState(0);
            }
            responseClient(ctx,-MessType.GetFriends,responseModel);
        }

    }
}
