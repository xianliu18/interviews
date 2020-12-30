package com.noodles.nio.network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @ClassName NioClient
 * @Description nio客户端
 * @Author noodles
 * @Date 2020/12/30 13:48
 */
public class NioClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        // 设置非阻塞
        socketChannel.configureBlocking(false);
        // 设置服务器地址
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 8888);
        // 连接服务器
        if (!socketChannel.connect(socketAddress)) {
            while (!socketChannel.finishConnect()) {
                System.out.println("连接服务器失败，进入其他处理逻辑");
            }
        }
        // 连接成功，发送数据
        String str = "客户端脚踏祥云走来了~~~~";
        ByteBuffer buffer = ByteBuffer.wrap(str.getBytes());
        // 发送数据
        socketChannel.write(buffer);
        // 等待输入
        System.in.read();
    }
}
