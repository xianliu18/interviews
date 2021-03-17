package com.noodles.io.bio.server;


import com.noodles.io.bio.ChannelAdapter;
import com.noodles.io.bio.ChannelHandler;

import java.net.Socket;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName BioServerHandler
 * @Description bio 服务器端
 * @Author noodles
 * @Date 2021/1/4 18:30
 */
public class BioServerHandler extends ChannelAdapter {

    public BioServerHandler(Socket socket, Charset charset) {
        super(socket, charset);
    }

    @Override
    public void channelActive(ChannelHandler ctx) {
        System.out.println("连接报告LocalAddress:" + ctx.socket().getLocalAddress());
        ctx.writeAndFlush("hi! BioServer send message to you\n");
    }

    @Override
    public void channelRead(ChannelHandler ctx, Object msg) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 接收到的消息:" + msg);
        ctx.writeAndFlush("hi, 服务端已经接受到你的消息了~~");
    }

}
