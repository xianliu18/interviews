package com.noodles.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @ClassName NettyServerHandler
 * @Description 自定义Handler
 * @Author noodles
 * @Date 2020/12/30 19:26
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    /*
     * 1, 自定义Handler需要继承netty的某个HandlerAdapter
     * 2, 这时，自定义的Handler，才能称为Handler
     */

    // 读取客户端发送的消息
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // ByteBuf 是 Netty 提供
        ByteBuf buf = (ByteBuf)msg;
        System.out.println("客户端发送的消息是：" + buf.toString(CharsetUtil.UTF_8));
        System.out.println("客户端地址为: " + ctx.channel().remoteAddress());
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("This is a test from server", CharsetUtil.UTF_8));
    }

    // 处理异常，关闭通道
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

}
