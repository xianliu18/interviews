package com.noodles.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.nio.ByteBuffer;

/**
 * @ClassName NettyClientHandler
 * @Description 客户端handler
 * @Author noodles
 * @Date 2020/12/30 19:44
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    // 当通道就绪后，就会触发该方法
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("client：" + ctx);
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello server", CharsetUtil.UTF_8));
    }

    // 当通道有读取事件时，会触发
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf)msg;
        System.out.println("服务器的回复消息为：" + buf.toString(CharsetUtil.UTF_8));
        System.out.println("服务器地址为：" + ctx.channel().remoteAddress());
    }


    // 异常处理
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
