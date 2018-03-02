package net.lainiao.myqq.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import net.lainiao.myqq.ApplicationStartup;
import net.lainiao.myqq.config.NettyConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NettyServer {
    private static final Logger logger= LoggerFactory.getLogger(NettyServer.class);
    public void run() {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workGroup);
            b.channel(NioServerSocketChannel.class);
            b.childHandler(new ChildChannelHandler());
            NettyConfig nettyConfig= ApplicationStartup.context.getBean(NettyConfig.class);
            int port=nettyConfig.getPort();
            logger.info("NettyServer Start For Port:"+nettyConfig.getPort());
            Channel ch = b.bind(port).sync().channel();
            ch.closeFuture().sync();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}
