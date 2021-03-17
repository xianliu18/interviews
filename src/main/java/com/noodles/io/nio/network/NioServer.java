package com.noodles.io.nio.network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName NioServer
 * @Description 服务器端
 * @Author noodles
 * @Date 2020/12/30 12:01
 */
public class NioServer {

    public static void main(String[] args) throws IOException {

        /*
         * ServerSocketChannel： 负责监听新的客户端Socket连接
         * SocketChannel: 负责具体的读写操作
         */

        // 创建 ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // 得到selector对象
        Selector selector = Selector.open();

        // 服务端监听端口8888
        serverSocketChannel.socket().bind(new InetSocketAddress(8888));
        // 设置为非阻塞
        serverSocketChannel.configureBlocking(false);

        // 把 serverSocketChannel 注册到 selector
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        // 等待客户端连接
        while (true) {

            // 设置监听超时时间为 1秒
            if (selector.select(1000) == 0) {
                System.out.println("服务器等待了1秒，无连接");
                continue;
            }

            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            // 遍历 Set<SelectionKey>
            Iterator<SelectionKey> keyIter = selectionKeys.iterator();
            while (keyIter.hasNext()) {
                SelectionKey key = keyIter.next();
                // 根据事件类型，增加处理逻辑
                if (key.isAcceptable()) {
                    // 生成对应的 SocketChannel, 并注册到 selector
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    System.out.println("客户端连接成功，生成对应的socketChannel：" + socketChannel.hashCode());
                    // 将 socketChannel 设置为非阻塞
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }

                if (key.isReadable()) {
                    // 通过SelectionKey，获取对应的channel
                    SocketChannel channel = (SocketChannel)key.channel();
                    // 获取关联的buffer
                    ByteBuffer buffer = (ByteBuffer)key.attachment();
                    channel.read(buffer);
                    System.out.println("客户端发送的数据为：" + new String(buffer.array()));
                }

                // 手动从集合中移除 SelectionKey
                keyIter.remove();
            }
        }
    }
}
