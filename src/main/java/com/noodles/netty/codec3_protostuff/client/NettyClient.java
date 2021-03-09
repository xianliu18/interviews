package com.noodles.netty.codec3_protostuff.client;

import com.noodles.netty.codec3_protostuff.util.MsgUtil;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @ClassName NettyClient
 * @Description 客户端
 * @Author noodles
 * @Date 2021/3/9 16:40
 */
public class NettyClient {

    public static void main(String[] args) {
        new NettyClient().connect("127.0.0.1", 8015);
    }

    private void connect(String host, int port) {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workerGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.AUTO_READ, true)
                    .handler(new MyChannelInitializer());

            ChannelFuture future = bootstrap.connect(host, port).sync();

            future.channel().writeAndFlush(MsgUtil.buildMsg(future.channel().id().toString(), "使用protobuf通信格式的客户端"));
            future.channel().writeAndFlush(MsgUtil.buildMsg(future.channel().id().toString(), "使用protobuf通信格式的客户端"));
            future.channel().writeAndFlush(MsgUtil.buildMsg(future.channel().id().toString(), "使用protobuf通信格式的客户端"));
            future.channel().writeAndFlush(MsgUtil.buildMsg(future.channel().id().toString(), "使用protobuf通信格式的客户端"));

            future.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}
