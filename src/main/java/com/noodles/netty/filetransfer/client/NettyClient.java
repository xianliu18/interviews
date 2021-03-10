package com.noodles.netty.filetransfer.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @Description: 客户端
 * @Author: noodles
 * @create: 2021-03-09 22:07
 */
public class NettyClient {

    private EventLoopGroup workerGroup = new NioEventLoopGroup();
    private Channel channel;

    public ChannelFuture connect(String host, int port) {
        ChannelFuture channelFuture = null;
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workerGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.AUTO_READ, true)
                    .handler(new MyChannelInitializer());
            channelFuture = bootstrap.connect(host, port).syncUninterruptibly();
            this.channel = channelFuture.channel();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != channelFuture && channelFuture.isSuccess()) {
                System.out.println("netty client start done.");
            } else {
                System.out.println("netty client start error.");
            }
        }
        return channelFuture;
    }

    public void destroy() {
        if (null == channel) {
            return;
        }
        channel.close();
        workerGroup.shutdownGracefully();
    }
}
