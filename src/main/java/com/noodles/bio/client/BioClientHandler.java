package com.noodles.bio.client;

import com.noodles.bio.ChannelAdapter;
import com.noodles.bio.ChannelHandler;

import java.net.Socket;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName BioClientHandler
 * @Description 客户端处理器
 * @Author noodles
 * @Date 2021/1/4 18:26
 */
public class BioClientHandler extends ChannelAdapter {

    public BioClientHandler(Socket socket, Charset charset) {
        super(socket, charset);
    }

    @Override
    public void channelActive(ChannelHandler ctx) {
        System.out.println("链接报告LocalAddress:" + ctx.socket().getLocalAddress());
        System.out.println("Bio client msg for you \r\n");
    }

    @Override
    public void channelRead(ChannelHandler ctx, Object msg) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "接收到消息:" + msg);
        ctx.writeAndFlush("hi 客户端已经接收到你的消息了！\r\n");
    }
}
