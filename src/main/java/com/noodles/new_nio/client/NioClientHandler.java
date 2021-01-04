package com.noodles.new_nio.client;


import com.noodles.new_nio.ChannelAdapter;
import com.noodles.new_nio.ChannelHandler;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 客户端处理器
 */
public class NioClientHandler extends ChannelAdapter {

    public NioClientHandler(Selector selector, Charset charset) {
        super(selector, charset);
    }

    @Override
    public void channelActive(ChannelHandler ctx) {
        try {
            System.out.println("链接信息报告localAddress:" + ctx.channel().getLocalAddress());
            ctx.writeAndFlush("Nio client send message to you^-^");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void channelRead(ChannelHandler ctx, Object msg) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 接收到消息:" + msg);
        ctx.writeAndFlush("客户端已经收到消息,请服务到确认~~~");
    }
}
