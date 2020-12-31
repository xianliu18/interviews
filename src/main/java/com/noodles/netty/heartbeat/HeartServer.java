package com.noodles.netty.heartbeat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName HeartServer
 * @Description 心跳检测机制
 * @Author noodles
 * @Date 2020/12/31 15:44
 */
public class HeartServer {
    public static void main(String[] args) throws InterruptedException {

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();

            serverBootstrap.group(bossGroup, workerGroup)
                           .channel(NioServerSocketChannel.class)
                           .handler(new LoggingHandler(LogLevel.INFO))
                           .childHandler(new ChannelInitializer<SocketChannel>() {
                               @Override
                               protected void initChannel(SocketChannel ch) throws Exception {
                                   ChannelPipeline pipeline = ch.pipeline();

                                   // IdleStateHandler
                                   // 1, 处理空闲状态的handler
                                   // readerIdleTime: 表示多长时间没有读，就会发送一个心跳检测包检测是否连接

                                   // 当 IdleStateEvent 触发后，就会传递给管道的下一个handler去处理，
                                   // 通过回调下一个 handler 的 userEventTriggered
                                   pipeline.addLast(new IdleStateHandler(3, 5, 7, TimeUnit.SECONDS));
                                   // 加入对空闲检测，进一步处理的handler
                                   pipeline.addLast(new HeartServerHandler());
                               }
                           });

            // 启动服务器
            ChannelFuture channelFuture = serverBootstrap.bind(8015).sync();
            channelFuture.channel().closeFuture().sync();

        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
