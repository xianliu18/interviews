package com.noodles.netty.tcp;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @ClassName TcpClient
 * @Description 出站/入站的客户端
 * @Author noodles
 * @Date 2020/12/31 19:10
 */
public class TcpClient {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup clientGroup = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(clientGroup)
                     .channel(NioSocketChannel.class)
                     .handler(new TcpClientInitializer());

            ChannelFuture cf = bootstrap.connect("127.0.0.1", 8015).sync();
            cf.channel().closeFuture().sync();
        } finally {
            clientGroup.shutdownGracefully();
        }
    }
}
