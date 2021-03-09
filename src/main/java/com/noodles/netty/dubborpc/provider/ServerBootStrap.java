package com.noodles.netty.dubborpc.provider;


import com.noodles.netty.dubborpc.netty.NettyServer;

/**
 * @ClassName ServerBootStrap
 * @Description 启动服务提供者
 * @Author noodles
 * @Date 2021/3/9 9:21
 */
public class ServerBootStrap {
    public static void main(String[] args) {
        // 启动服务
        NettyServer.startServer("127.0.0.1", 8015);
    }
}
