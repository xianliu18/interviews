package com.noodles.io.aio.client;

import com.noodles.io.aio.ChannelAdapter;
import com.noodles.io.aio.ChannelHandler;

import java.io.IOException;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;
import java.util.Date;

/**
 * @ClassName AioClientHandler
 * @Description 客户端消息处理器
 * @Author noodles
 * @Date 2021/1/4 16:46
 */
public class AioClientHandler extends ChannelAdapter {

    public AioClientHandler(AsynchronousSocketChannel channel, Charset charset) {
        super(channel, charset);
    }

    @Override
    public void channelActive(ChannelHandler ctx) {
        try {
            System.out.println("链接报告信息:" + ctx.channel().getRemoteAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void channelnative(ChannelHandler ctx) {

    }

    @Override
    public void channelRead(ChannelHandler ctx, Object msg) {
        System.out.println("客户端收到：" + new Date() + msg + "\r\n");
        ctx.writeAndFlush("客户端消息处理成功！\r\n");
    }


}
