package com.noodles.netty.rpc.newrpc.network.server;

import com.noodles.netty.rpc.newrpc.domain.LocalServerInfo;
import com.noodles.netty.rpc.newrpc.network.codec.RpcDecoder;
import com.noodles.netty.rpc.newrpc.network.codec.RpcEncoder;
import com.noodles.netty.rpc.newrpc.network.msg.Request;
import com.noodles.netty.rpc.newrpc.network.msg.Response;
import com.noodles.netty.rpc.newrpc.util.NetUtil;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.context.ApplicationContext;

/**
 * @ClassName ServerSocket
 * @Description 服务器端socket
 * @Author noodles
 * @Date 2021/1/5 16:32
 */
public class ServerSocket implements Runnable {

    private ChannelFuture cf;

    private transient ApplicationContext applicationContext;

    public ServerSocket(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public boolean isActiveSocketServer() {
        if (cf != null) {
            return cf.channel().isActive();
        } else {
            return false;
        }
    }

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
                            ch.pipeline().addLast(new MyServerHandler(applicationContext));
                        }
                    });
            // 启动初始端口
            int port = 22201;
            while (NetUtil.isPortUsing(port)) {
                port++;
            }
            LocalServerInfo.LOCAL_HOST = NetUtil.getHost();
            LocalServerInfo.LOCAL_PORT = port;

            // 注册服务
            this.cf = bootstrap.bind(port).sync();
            this.cf.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }
}
