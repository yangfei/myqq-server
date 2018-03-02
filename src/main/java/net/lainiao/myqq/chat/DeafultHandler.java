package net.lainiao.myqq.chat;

import io.netty.channel.ChannelHandlerContext;
import net.lainiao.myqq.model.DefaultResponseModel;
import net.lainiao.myqq.model.CommonMess;
import org.springframework.stereotype.Component;

@Component
public class DeafultHandler extends CommonHandler {
    public void handler(ChannelHandlerContext ctx, CommonMess commonMess) {
        DefaultResponseModel responseModel=new DefaultResponseModel();
        responseModel.setState(0);
        responseModel.setMess("未定义的消息类型");
        responseClient(ctx,0, responseModel);
    }
}
