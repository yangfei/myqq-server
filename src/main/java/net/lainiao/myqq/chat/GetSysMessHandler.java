package net.lainiao.myqq.chat;

import com.alibaba.fastjson.JSONObject;
import io.netty.channel.ChannelHandlerContext;
import net.lainiao.myqq.entity.Account;
import net.lainiao.myqq.entity.SysMess;
import net.lainiao.myqq.model.GetSysMessRequestModel;
import net.lainiao.myqq.model.GetSysMessResponseModel;
import net.lainiao.myqq.model.MessType;
import net.lainiao.myqq.model.CommonMess;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class GetSysMessHandler extends CommonHandler  {
    public void handler(ChannelHandlerContext ctx, CommonMess commonMess) {
        GetSysMessRequestModel requestModel= JSONObject.parseObject(commonMess.getContent(),GetSysMessRequestModel.class);
        List<SysMess> list= sysMessService.getMessByAccount(requestModel.getId());
        for(SysMess mess:list){
            GetSysMessResponseModel responseModel=new GetSysMessResponseModel();
            responseModel.setContent(mess.getContent());
            int fromId=mess.getFromid();
            responseModel.setFromId(fromId);
            if(fromId==0){
                responseModel.setFromNickName("系统消息");
            }
            else{
                Account account=accountService.selectByPrimaryKey(fromId);
                responseModel.setFromNickName(account.getNickname());
                responseModel.setFaceimg(account.getFaceimg());
            }
            responseModel.setSysMessType(mess.getMesstype());
            responseClient(ctx,-MessType.GetSysMess,responseModel);
            sysMessService.delete(mess.getId());
        }

    }
}
