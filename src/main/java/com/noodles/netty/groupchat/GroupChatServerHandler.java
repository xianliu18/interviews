package com.noodles.netty.groupchat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;

/**
 * @ClassName GroupChatServerHandler
 * @Description 自定义服务器handler
 * @Author noodles
 * @Date 2020/12/31 14:53
 */
public class GroupChatServerHandler extends SimpleChannelInboundHandler<String> {

    // 管理所有的channel
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        // 获取当前的channel
        Channel channel = ctx.channel();

        channelGroup.forEach(ch -> {
            if (channel != ch) {
                ch.writeAndFlush("[客户]" + channel.remoteAddress() + "发送了消息" + msg + "\n");
            } else {
                ch.writeAndFlush("[自己]发送了消息" + msg + "\n");
            }
        });
    }

    /**
     * @Author noodles
     * @Description 一旦建立连接，第一个被执行的方法。 将当前channel，加入到channelGroup中
     * @Date 2020/12/31 15:01
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        // 向其他客户端推送，有新客户端上线的消息
        channelGroup.writeAndFlush("[客户端]" + channel.remoteAddress() + "加入聊天...\n");
        channelGroup.add(channel);
    }

    /***
     * @Author noodles
     * @Description 断开连接
     * @Date 2020/12/31 15:09
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        // 向其他客户端推送，有人离线的消息
        channelGroup.writeAndFlush("[客户端]" + channel.remoteAddress() + "离开聊天...\n");
    }

    /**
     * @Author noodles
     * @Description 表示channel处于活动状态
     * @Date 2020/12/31 15:06
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + " 上线了");
    }

    /***
     * @Author noodles
     * @Description channel 离线
     * @Date 2020/12/31 15:08
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + " 离线了~");
    }

    /**
     * @Author noodles
     * @Description 异常处理
     * @Date 2020/12/31 15:14
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }


}
