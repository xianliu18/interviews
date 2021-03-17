package com.noodles.io.new_nio.server;


import com.noodles.io.new_nio.ChannelAdapter;
import com.noodles.io.new_nio.ChannelHandler;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NioServerHandler extends ChannelAdapter {

    public NioServerHandler(Selector selector, Charset charset) {
        super(selector, charset);
    }

    @Override
    public void channelActive(ChannelHandler ctx) {
        try {
            System.out.println("链接报告LocalAddress:" + ctx.channel().getLocalAddress());
            ctx.writeAndFlush("Nio Server 电波");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void channelRead(ChannelHandler ctx, Object msg) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 接收到消息:" + msg);
        ctx.writeAndFlush("服务器反馈消息$$$$");
    }
}
