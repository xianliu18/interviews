package com.noodles.netty.test.filetransfer;

import com.noodles.netty.filetransfer.server.NettyServer;

/**
 * @ClassName NettyServerTest
 * @Description 服务端
 * @Author noodles
 * @Date 2021/3/10 9:14
 */
public class NettyServerTest {
    public static void main(String[] args) {
        new NettyServer().bing(8015);
    }
}
