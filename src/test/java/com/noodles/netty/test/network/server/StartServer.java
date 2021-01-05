package com.noodles.netty.test.network.server;

import com.noodles.netty.rpc.network.server.ServerSocket;

/**
 * @ClassName StartServer
 * @Description 服务端测试类
 * @Author noodles
 * @Date 2021/1/5 10:37
 */
public class StartServer {
    public static void main(String[] args) {
        System.out.println("准备启动服务器~~~");
        new Thread(new ServerSocket()).start();
        System.out.println("服务器启动完成^_^");
    }
}
