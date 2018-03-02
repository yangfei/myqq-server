package net.lainiao.myqq.chat;

import com.alibaba.fastjson.JSONObject;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import net.lainiao.myqq.entity.Account;
import net.lainiao.myqq.entity.SysMess;
import net.lainiao.myqq.model.AddFriendRequestModel;
import net.lainiao.myqq.model.AddFriendResponseModel;
import net.lainiao.myqq.model.MessType;
import net.lainiao.myqq.model.GetSysMessResponseModel;
import net.lainiao.myqq.model.CommonMess;
import net.lainiao.myqq.netty.Global;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class AddFriendHandler extends CommonHandler  {

    public void handler(ChannelHandlerContext ctx, CommonMess commonMess) {
        AddFriendRequestModel requestModel= JSONObject.parseObject(commonMess.getContent(),AddFriendRequestModel.class);
        if(Global.currentChannel.containsKey(requestModel.getTargetId())){
            Account account=accountService.selectByPrimaryKey(requestModel.getId());
            GetSysMessResponseModel sysMessResponseModel=new GetSysMessResponseModel();
            sysMessResponseModel.setState(1);
            sysMessResponseModel.setFromId(requestModel.getId());
            sysMessResponseModel.setFromNickName(account.getNickname());
            sysMessResponseModel.setSysMessType(1);
            sysMessResponseModel.setContent(requestModel.getMess());
            sysMessResponseModel.setFaceimg(account.getFaceimg());
            Channel channel=Global.currentChannel.get(requestModel.getTargetId());
            responseClient(channel,-MessType.GetSysMess,sysMessResponseModel);
        }
        else{
            SysMess sysMess=new SysMess();
            sysMess.setCreatetime(new Date());
            sysMess.setContent(requestModel.getMess());
            sysMess.setFromid(requestModel.getId());
            sysMess.setTargetid(requestModel.getTargetId());
            sysMess.setMesstype(1);
            sysMessService.insert(sysMess);
        }
        AddFriendResponseModel responseModel=new AddFriendResponseModel();
        responseModel.setState(1);
        responseClient(ctx,-MessType.AddFriend,responseModel);
    }
}
