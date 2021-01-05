package com.noodles.netty.rpc.network.client;

import com.noodles.netty.rpc.network.codec.RpcDecoder;
import com.noodles.netty.rpc.network.codec.RpcEncoder;
import com.noodles.netty.rpc.network.msg.Request;
import com.noodles.netty.rpc.network.msg.Response;
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
 * @Description 客户端Socket
 * @Author noodles
 * @Date 2021/1/5 10:33
 */
public class ClientSocket implements Runnable{

    private ChannelFuture future;

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
                        protected void initChannel(SocketChannel ch) {
                            ch.pipeline().addLast("rpcDecoder", new RpcDecoder(Response.class));
                            ch.pipeline().addLast("rpcEncoder", new RpcEncoder(Request.class));
                            ch.pipeline().addLast("myClientHandler", new MyClientHandler());
                        }
                    });
            ChannelFuture cf = bootstrap.connect("127.0.0.1", 8015).sync();
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
