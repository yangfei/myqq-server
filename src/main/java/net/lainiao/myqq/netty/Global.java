package net.lainiao.myqq.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.concurrent.ConcurrentHashMap;

public class Global {
    public static ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    public static ConcurrentHashMap<Integer,Channel> currentChannel=new ConcurrentHashMap<>();
    public static ConcurrentHashMap<Channel,Integer> currentAccount=new ConcurrentHashMap<>();

    public static void loginOut(ChannelHandlerContext ctx) {
        if (Global.currentAccount.containsKey(ctx.channel())) {
            Integer key = Global.currentAccount.get(ctx.channel());
            Global.currentChannel.remove(key);
            Global.currentAccount.remove(ctx.channel());
        }
        Global.group.remove(ctx.channel());
        ctx.close();
    }
}
