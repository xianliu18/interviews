package com.noodles.netty.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @ClassName MyServer
 * @Description 基于WebSocket的长连接
 * @Author noodles
 * @Date 2020/12/31 16:40
 */
public class MyServer {
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

                                   // http 的编解码器
                                   pipeline.addLast(new HttpServerCodec());
                                   // 以 块 方式写，添加 ChunkedWrite 处理器
                                   pipeline.addLast(new ChunkedWriteHandler());
                                   // http 数据在传输过程中是分段的，HttpObjectAggregator，就是将多个段聚合
                                   pipeline.addLast(new HttpObjectAggregator(8192));

                                   // websocket 是以 帧（frame） 形式传播
                                   // WebSocketServerProtocolHandler 核心功能是将 http 协议升级为 ws 协议，保持长连接
                                   pipeline.addLast(new WebSocketServerProtocolHandler("/hello"));

                                   // 自定义 handler
                                   pipeline.addLast(new MyTextWebSocketFrameHandler());
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
