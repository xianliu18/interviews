package com.noodles.netty.inboundAndOutbound;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ClassName BoundClientHandler
 * @Description TODO
 * @Author 客户端自定义业务处理handler
 * @Date 2020/12/31 19:17
 */
public class BoundClientHandler extends SimpleChannelInboundHandler<Long> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Long msg) throws Exception {
        System.out.println("服务器的地址为：" + ctx.channel().remoteAddress());
        System.out.println("收到服务的消息为：" + msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("BoundClientHandler 发送数据~~");
        // 发送数据
        ctx.writeAndFlush(123456L);
    }
}
