package com.noodles.netty.tcp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.util.UUID;

/**
 * @ClassName TcpServerHandler
 * @Description 服务器端自定义handler
 * @Author noodles
 * @Date 2021/1/1 12:33
 */
public class TcpServerHandler extends SimpleChannelInboundHandler<MessageProtocol> {

    private int count;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol msg) throws Exception {
        // 接收消息，并处理
        int len = msg.getLen();
        byte[] content = msg.getContent();

        System.out.println("服务器接收到消息如下：");
        System.out.println("长度=" + len);
        System.out.println("内容为：" + new String(content, CharsetUtil.UTF_8));
        System.out.println("服务器接收的消息包数量为：" + (++this.count));

        // 响应消息
        String respCont = UUID.randomUUID().toString();
        byte[] respBytes = respCont.getBytes("utf-8");
        int respLen = respBytes.length;

        MessageProtocol messageProtocol = new MessageProtocol();
        messageProtocol.setLen(respLen);
        messageProtocol.setContent(respBytes);

        ctx.writeAndFlush(messageProtocol);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
