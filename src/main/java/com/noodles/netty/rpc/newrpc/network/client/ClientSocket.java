package com.noodles.netty.rpc.newrpc.network.client;

import com.noodles.netty.rpc.newrpc.network.codec.RpcDecoder;
import com.noodles.netty.rpc.newrpc.network.codec.RpcEncoder;
import com.noodles.netty.rpc.newrpc.network.msg.Request;
import com.noodles.netty.rpc.newrpc.network.msg.Response;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @ClassName ClientSocket
 * @Description 客户端socket
 * @Author noodles
 * @Date 2021/1/5 15:26
 */
public class ClientSocket implements Runnable {

    private ChannelFuture future;

    private String inetHost;
    private int inetPort;

    public ClientSocket(String inetHost, int inetPort) {
        this.inetHost = inetHost;
        this.inetPort = inetPort;
    }


    @Override
    public void run() {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workerGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.AUTO_READ, true)
                    .handler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new RpcDecoder(Response.class));
                            ch.pipeline().addLast(new RpcEncoder(Request.class));
                            ch.pipeline().addLast(new MyClientHandler());
                        }
                    });
            ChannelFuture cf = bootstrap.connect(inetHost, inetPort).sync();
            this.future = cf;
            cf.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }

    public ChannelFuture getFuture() {
        return future;
    }

    public void setFuture(ChannelFuture future) {
        this.future = future;
    }
}
