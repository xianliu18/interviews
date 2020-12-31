package com.noodles.netty.simple;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @ClassName NettyServer
 * @Description netty服务器端
 * @Author noodles
 * @Date 2020/12/30 18:14
 */
public class NettyServer {
    public static void main(String[] args) throws InterruptedException {
        /*
         * 1，创建 BossGroup 和 WorkerGroup
         * 2, BossGroup 负责接收客户端的连接；
         *    WorkerGroup 负责网络的读写
         */
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            // 创建服务器端的启动对象，配置参数
            ServerBootstrap bootstrap = new ServerBootstrap();

            // 配置参数
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128) // 设置线程队列等待连接的个数
                    .childOption(ChannelOption.SO_KEEPALIVE, true)//设置保持活动连接状态
                    .childHandler(new ChannelInitializer<SocketChannel>() {// 创建一个通道初始化对象
                        // 给pipeline 设置处理器
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new NettyServerHandler());
                        }
                    });// 设置workerGroup的EventLoop对应的管道处理器

            System.out.println(".....服务器准备好了.....");
            // 绑定端口,启动服务器
            ChannelFuture cf = bootstrap.bind(6668).sync();

            // Future-Listener 机制
            // 给 ChannelFuture 注册监听器，监听端口绑定事件
            cf.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    if (cf.isSuccess()) {
                        System.out.println("监听端口6668成功~");
                    } else {
                        System.out.println("监听端口6668失败！");
                    }
                }
            });

            // 对关闭通道事件进行监听
            cf.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
