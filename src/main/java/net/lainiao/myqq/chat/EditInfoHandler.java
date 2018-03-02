package net.lainiao.myqq.chat;

import com.alibaba.fastjson.JSONObject;
import io.netty.channel.ChannelHandlerContext;
import net.lainiao.myqq.entity.Account;
import net.lainiao.myqq.model.CommonMess;
import net.lainiao.myqq.model.EditInfoRequestModel;
import net.lainiao.myqq.model.EditInfoResponseModel;
import net.lainiao.myqq.model.MessType;
import org.springframework.stereotype.Component;

@Component
public class EditInfoHandler extends CommonHandler  {
    public   void handler(ChannelHandlerContext ctx, CommonMess commonMess) {
        EditInfoRequestModel requestModel= JSONObject.parseObject(commonMess.getContent(),EditInfoRequestModel.class);
        EditInfoResponseModel responseModel=new EditInfoResponseModel();
        Account account=new Account();
        account.setId(requestModel.getId());
        account.setNickname(requestModel.getNickname());
        account.setGender(requestModel.getGender());
        account.setBlood(requestModel.getBlood());
        account.setConste(requestModel.getConste());
        account.setAge(requestModel.getAge());
        account.setUserpass(requestModel.getUserpass());
        account.setFaceimg(requestModel.getFaceimg());
        account =accountService.update(account);

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
        responseClient(ctx,-MessType.EditInfo,responseModel);

    }
}
