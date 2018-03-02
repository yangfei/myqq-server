package net.lainiao.myqq.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.util.CharsetUtil;
import net.lainiao.myqq.ApplicationStartup;
import net.lainiao.myqq.chat.LoginOutHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Map;


public class MyWebSocketServerHandler extends SimpleChannelInboundHandler<Object> {
    private static final Logger logger = LoggerFactory.getLogger(WebSocketServerHandshaker.class.getName());
    private WebSocketServerHandshaker handshaker;


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Global.group.add(ctx.channel());
        logger.info("客户端与服务端连接开启：" + ctx.channel().remoteAddress().toString());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Global.group.remove(ctx.channel());
        logger.info("客户端与服务端连接关闭：" + ctx.channel().remoteAddress().toString());
    }

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof FullHttpRequest) {
            handleHttpRequest(ctx, ((FullHttpRequest) msg));
        }
        else if (msg instanceof WebSocketFrame) {
            if (msg instanceof TextWebSocketFrame) {
                String request = ((TextWebSocketFrame) msg).text();
                MyMessHandler.executer(ctx, request);
            }
            else {
                WebSocketFrame frame = (WebSocketFrame) msg;
                // 判断是否关闭链路的指令
                if (frame instanceof CloseWebSocketFrame) {
                    System.out.println(1);
                    handshaker.close(ctx.channel(), (CloseWebSocketFrame) frame.retain());
                    return;
                }
                // 判断是否ping消息
                if (frame instanceof PingWebSocketFrame) {
                    ctx.channel().write(new PongWebSocketFrame(frame.content().retain()));
                    return;
                }
                // 判断是否Pone消息
                if (frame instanceof PongWebSocketFrame) {
                    ctx.channel().write(new PingWebSocketFrame(frame.content().retain()));
                    return;
                }
            }
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    private void handleHttpRequest(ChannelHandlerContext ctx, FullHttpRequest req) {
        if (!req.getDecoderResult().isSuccess() || (!"websocket".equals(req.headers().get("Upgrade")))) {
            sendHttpResponse(ctx, req,
                    new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST));
            return;
        }
        HttpMethod method = req.getMethod();
        String uri = req.getUri();
        QueryStringDecoder queryStringDecoder = new QueryStringDecoder(uri);
        Map<String, List<String>> parameters = queryStringDecoder.parameters();
        WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory(
                "ws://" + req.headers().get(HttpHeaders.Names.HOST) + uri, null, false);
        handshaker = wsFactory.newHandshaker(req);
        if (handshaker == null) {
            WebSocketServerHandshakerFactory.sendUnsupportedWebSocketVersionResponse(ctx.channel());
        }
        else {
            handshaker.handshake(ctx.channel(), req);
        }
    }

    private static void sendHttpResponse(ChannelHandlerContext ctx, FullHttpRequest req, DefaultFullHttpResponse res) {
        if (res.getStatus().code() != 200) {
            ByteBuf buf = Unpooled.copiedBuffer(res.getStatus().toString(), CharsetUtil.UTF_8);
            res.content().writeBytes(buf);
            buf.release();
        }
        ChannelFuture f = ctx.channel().writeAndFlush(res);
        if (!HttpHeaders.isKeepAlive(req) || res.getStatus().code() != 200) {
            f.addListener(ChannelFutureListener.CLOSE);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.error("通信系统出现异常:", cause);
        if(Global.currentAccount.containsKey(ctx.channel())){
            int accId=Global.currentAccount.get(ctx.channel());
            ApplicationContext context= ApplicationStartup.context;
            context.getBean(LoginOutHandler.class).loginOut(accId);
        }
        Global.loginOut(ctx);
    }
}