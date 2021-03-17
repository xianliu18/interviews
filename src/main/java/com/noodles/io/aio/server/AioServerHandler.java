package com.noodles.io.aio.server;

import com.noodles.io.aio.ChannelAdapter;
import com.noodles.io.aio.ChannelHandler;

import java.io.IOException;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;
import java.util.Date;

/**
 * @ClassName AioServerHandler
 * @Description aio 服务端处理器
 * @Author noodles
 * @Date 2021/1/4 16:47
 */
public class AioServerHandler extends ChannelAdapter {

    public AioServerHandler(AsynchronousSocketChannel channel, Charset charset) {
        super(channel, charset);
    }

    @Override
    public void channelActive(ChannelHandler ctx) {
        try {
            System.out.println("客户端链接地址信息：" + ctx.channel().getRemoteAddress());
            // 通知客户端链接建立成功
            ctx.writeAndFlush("服务端链接创建成功" + " " + new Date() + " " + ctx.channel().getRemoteAddress() + "\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void channelnative(ChannelHandler ctx) {

    }

    @Override
    public void channelRead(ChannelHandler ctx, Object msg) {
        System.out.println("服务端收到：" + new Date() + " " + msg + "\r\n");
        ctx.writeAndFlush("服务端信息处理Success!\r\n");
    }
}
