package net.lainiao.myqq.chat;

import com.alibaba.fastjson.JSON;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import net.lainiao.myqq.model.CommonMess;
import net.lainiao.myqq.service.AccountService;
import net.lainiao.myqq.service.ChatMessService;
import net.lainiao.myqq.service.FriendService;
import net.lainiao.myqq.service.SysMessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class CommonHandler {
    @Autowired
    AccountService accountService;
    @Autowired
    SysMessService sysMessService;
    @Autowired
    FriendService friendService;
    @Autowired
    ChatMessService chatMessService;
    public abstract void handler(ChannelHandlerContext ctx, CommonMess commonMess);

    public void responseClient(ChannelHandlerContext ctx, int messType, Object modelJson) {
        CommonMess mess = new CommonMess();
        mess.setMessType(messType);
        mess.setContent(JSON.toJSONString(modelJson));
        String responseJson = JSON.toJSONString(mess);
        TextWebSocketFrame frame = new TextWebSocketFrame(responseJson);
        ctx.channel().writeAndFlush(frame);
    }

    public void responseClient(Channel channel, int messType, Object modelJson) {
        CommonMess mess = new CommonMess();
        mess.setMessType(messType);
        mess.setContent(JSON.toJSONString(modelJson));
        String responseJson = JSON.toJSONString(mess);
        TextWebSocketFrame frame = new TextWebSocketFrame(responseJson);
        channel.writeAndFlush(frame);
    }
}
