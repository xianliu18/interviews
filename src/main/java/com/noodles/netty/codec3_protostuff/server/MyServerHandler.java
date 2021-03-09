package com.noodles.netty.codec3_protostuff.server;

import com.alibaba.fastjson.JSON;
import com.noodles.netty.codec3_protostuff.util.MsgUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.SocketChannel;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName MyServerHandler
 * @Description 自定义 handler
 * @Author noodles
 * @Date 2021/3/9 16:49
 */
public class MyServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        SocketChannel channel = (SocketChannel)ctx.channel();
        System.out.println("链接开始~~");
        System.out.println("链接报告信息：新增一个客户端链接。channelId: " + channel.id());
        System.out.println("链接报告IP: " + channel.localAddress().getHostString());
        System.out.println("链接报告Port: " + channel.localAddress().getPort());
        System.out.println("链接报告完毕");
        // 响应客户端
        String str = "通知客户端链接建立成功" + " " + new Date() + " " + channel.localAddress().getHostString() + "\r\n";
        ctx.writeAndFlush(MsgUtil.buildMsg(channel.id().toString(), str));
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        System.out.println("客户端断开链接" + ctx.channel().localAddress().toString());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 接收到消息类型: " + msg.getClass());
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 接收到消息内容: " + JSON.toJSONString(msg));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
        System.out.println("异常信息: \r\n" + cause.getMessage());
    }
}
