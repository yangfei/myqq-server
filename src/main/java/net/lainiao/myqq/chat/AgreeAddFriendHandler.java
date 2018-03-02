package net.lainiao.myqq.chat;

import com.alibaba.fastjson.JSONObject;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import net.lainiao.myqq.entity.Account;
import net.lainiao.myqq.entity.Friend;
import net.lainiao.myqq.entity.SysMess;
import net.lainiao.myqq.model.*;
import net.lainiao.myqq.model.CommonMess;
import net.lainiao.myqq.netty.Global;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class AgreeAddFriendHandler extends CommonHandler  {

    public void handler(ChannelHandlerContext ctx, CommonMess commonMess) {
        AgreenAddFriendRequestModel requestModel= JSONObject.parseObject(commonMess.getContent(),AgreenAddFriendRequestModel.class);
        if(requestModel.getResult()==1){
            Friend friend=new Friend();
            friend.setAccountid(requestModel.getId());
            friend.setFriendid(requestModel.getTargetId());
            friendService.createFriend(friend);
            friend=new Friend();
            friend.setAccountid(requestModel.getTargetId());
            friend.setFriendid(requestModel.getId());
            friendService.createFriend(friend);
            if(Global.currentChannel.containsKey(requestModel.getTargetId())){
                Account account=accountService.selectByPrimaryKey(requestModel.getId());
                GetSysMessResponseModel sysMessResponseModel=new GetSysMessResponseModel();
                sysMessResponseModel.setState(1);
                sysMessResponseModel.setFromId(requestModel.getId());
                sysMessResponseModel.setFromNickName(account.getNickname());
                sysMessResponseModel.setSysMessType(2);
                sysMessResponseModel.setFaceimg(account.getFaceimg());
                Channel channel=Global.currentChannel.get(requestModel.getTargetId());
                responseClient(channel,-MessType.GetSysMess,sysMessResponseModel);
            }
            else{
                SysMess sysMess=new SysMess();
                sysMess.setCreatetime(new Date());
                sysMess.setContent(null);
                sysMess.setFromid(requestModel.getId());
                sysMess.setTargetid(requestModel.getTargetId());
                sysMess.setMesstype(2);
                sysMessService.insert(sysMess);
            }

            Account account=accountService.selectByPrimaryKey(requestModel.getTargetId());
            GetFriendsResponseModel responseModel=new GetFriendsResponseModel();
            responseModel.setFriendid(account.getId());
            responseModel.setNickName(account.getNickname());
            responseModel.setFaceimg(account.getFaceimg());
            if(Global.currentChannel.containsKey(account.getId())){
                responseModel.setState(1);
            }
            else{
                responseModel.setState(0);
            }
            responseClient(ctx,-MessType.GetFriends,responseModel);
        }
        else{

            if(Global.currentChannel.containsKey(requestModel.getTargetId())){
                Account account=accountService.selectByPrimaryKey(requestModel.getId());
                GetSysMessResponseModel sysMessResponseModel=new GetSysMessResponseModel();
                sysMessResponseModel.setState(1);
                sysMessResponseModel.setFromId(requestModel.getId());
                sysMessResponseModel.setFromNickName(account.getNickname());
                sysMessResponseModel.setSysMessType(3);
                sysMessResponseModel.setContent(requestModel.getResultMess());
                sysMessResponseModel.setFaceimg(account.getFaceimg());
                Channel channel=Global.currentChannel.get(requestModel.getTargetId());
                responseClient(channel,-MessType.GetSysMess,sysMessResponseModel);
            }
            else{
                SysMess sysMess=new SysMess();
                sysMess.setCreatetime(new Date());
                sysMess.setContent(requestModel.getResultMess());
                sysMess.setFromid(requestModel.getId());
                sysMess.setTargetid(requestModel.getTargetId());
                sysMess.setMesstype(3);
                sysMessService.insert(sysMess);
            }
        }

        AgreenAddFriendResponseModel responseModel=new AgreenAddFriendResponseModel();
        responseModel.setState(1);
        responseClient(ctx,-MessType.AgreeAddFriend,responseModel);
    }
}
