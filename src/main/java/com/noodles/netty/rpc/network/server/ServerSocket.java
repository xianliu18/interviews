package com.noodles.netty.rpc.network.server;

import com.noodles.netty.rpc.network.codec.RpcDecoder;
import com.noodles.netty.rpc.network.codec.RpcEncoder;
import com.noodles.netty.rpc.network.msg.Request;
import com.noodles.netty.rpc.network.msg.Response;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @ClassName ServerSocket
 * @Description 服务器端
 * @Author noodles
 * @Date 2021/1/5 10:36
 */
public class ServerSocket implements Runnable {

    private ChannelFuture cf;

    @Override
    public void run() {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new RpcDecoder(Request.class));
                            ch.pipeline().addLast(new RpcEncoder(Response.class));
                            ch.pipeline().addLast(new MyServerHandler());
                        }
                    });

            ChannelFuture cf = null;
            cf = bootstrap.bind(8015).sync();
            cf.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }
}
