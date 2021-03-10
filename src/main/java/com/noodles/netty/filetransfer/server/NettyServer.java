package com.noodles.netty.filetransfer.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Description: 服务端
 * 参考链接：https://bugstack.cn/itstack-demo-netty-2/2019/08/19/netty案例-netty4.1中级拓展篇四-Netty传输文件-分片发送-断点续传.html
 * @Author: noodles
 * @create: 2021-03-09 22:09
 */
public class NettyServer {
    private EventLoopGroup bossGroup = new NioEventLoopGroup();
    private EventLoopGroup workerGroup = new NioEventLoopGroup();
    private Channel channel;

    public ChannelFuture bing(int port) {
        ChannelFuture channelFuture = null;
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childHandler(new MyChannelInitializer());
            channelFuture = bootstrap.bind(port).syncUninterruptibly();
            this.channel = channelFuture.channel();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != channelFuture && channelFuture.isSuccess()) {
                System.out.println("server start done~~~");
            } else {
                System.out.println("server start error!");
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
        bossGroup.shutdownGracefully();
    }

    public Channel getChannel() {
        return channel;
    }
}
