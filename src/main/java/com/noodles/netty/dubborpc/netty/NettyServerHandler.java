package com.noodles.netty.dubborpc.netty;

import com.noodles.netty.dubborpc.provider.HelloServiceImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @ClassName NettyServerHandler
 * @Description
 * @Author noodles
 * @Date 2021/3/9 9:31
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        // 获取客户端发送的消息，并调用服务
        System.out.println("msg = " + msg);
        // 客户端调用服务器的 API，需要定义一个协议
        // 比如，要求每次发消息，必须以某个字符串开头："HelloService#hello#"
        if (msg.toString().startsWith("HelloService#hello#")) {
            String result = new HelloServiceImpl().hello(msg.toString().substring(msg.toString().lastIndexOf("#") + 1));
            ctx.writeAndFlush(result);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }
}
