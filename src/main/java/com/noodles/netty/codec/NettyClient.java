package com.noodles.netty.codec;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufEncoder;

/**
 * @ClassName NettyClient
 * @Description 客户端
 * @Author noodles
 * @Date 2020/12/30 19:37
 */
public class NettyClient {
    public static void main(String[] args) throws InterruptedException {
        // 客户端只需要一个事件循环组
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

        try {
            // 创建客户端启动对象
            Bootstrap bootstrap = new Bootstrap();

            // 设置相关参数
            bootstrap.group(eventLoopGroup) // 设置线程组
                    .channel(NioSocketChannel.class) // 设置客户端通道的实现类
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            // 加入Protobuf 编解码器
                            pipeline.addLast("encoder", new ProtobufEncoder());
                            // 加入自定义处理器
                            pipeline.addLast(new NettyClientHandler());
                        }
                    });

            System.out.println("客户端启动了");

            // 连接服务器
            ChannelFuture cf = bootstrap.connect("127.0.0.1", 6668).sync();
            // 监听，通道关闭事件
            cf.channel().closeFuture().sync();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
