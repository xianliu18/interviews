package com.noodles.netty.tcp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * @ClassName TcpClientHandler
 * @Description 客户端自定义handler
 * @Author noodles
 * @Date 2021/1/1 12:29
 */
public class TcpClientHandler extends SimpleChannelInboundHandler<MessageProtocol> {

    private int count;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol msg) throws Exception {
        int len = msg.getLen();
        byte[] content = msg.getContent();

        System.out.println("客户端接收到消息如下：");
        System.out.println("长度=" + len);
        System.out.println("消息内容为:" + new String(content, CharsetUtil.UTF_8));
        System.out.println("客户端接收的次数为:" + (++this.count));
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // 发送10条数据
        for (int i = 0; i < 10; i++) {
            String mes = "年轻人，我看你骨骼精奇";
            byte[] content = mes.getBytes(CharsetUtil.UTF_8);
            int length = mes.getBytes(CharsetUtil.UTF_8).length;

            MessageProtocol messageProtocol = new MessageProtocol();
            messageProtocol.setLen(length);
            messageProtocol.setContent(content);
            ctx.writeAndFlush(messageProtocol);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}
