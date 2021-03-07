package com.noodles.nio.groupchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @ClassName GroupChatServer
 * @Description 群聊系统客户端
 * @Author noodles
 * @Date 2020/12/30 14:22
 */
public class GroupChatServer {
    private Selector selector;
    private ServerSocketChannel listenChannel;
    private static final int PORT = 8888;

    // 初始化
    public GroupChatServer() {
        try {
            selector = Selector.open();
            listenChannel = ServerSocketChannel.open();
            listenChannel.socket().bind(new InetSocketAddress(PORT));
            // 设置非阻塞模式
            listenChannel.configureBlocking(false);
            // 注册到selector
            listenChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // 创建服务器对象
        GroupChatServer chatServer = new GroupChatServer();
        chatServer.listen();
    }

    /**
     * @Description 监听处理逻辑
     */
    public void listen() {
        try {
            // 循环处理
            while (true) {
                int count = selector.select(2000);
                // count 大于零，表示有事件发生
                if (count > 0) {
                    Iterator<SelectionKey> keyIter = selector.selectedKeys().iterator();
                    while (keyIter.hasNext()) {
                        SelectionKey key = keyIter.next();
                        // 监听 accept 事件
                        if (key.isAcceptable()) {
                            SocketChannel socketChannel = listenChannel.accept();
                            socketChannel.configureBlocking(false);
                            socketChannel.register(selector, SelectionKey.OP_READ);
                            System.out.println(socketChannel.getRemoteAddress() + "上线了");
                        }
                        // 监听 read 事件
                        if (key.isReadable()) {
                            readData(key);
                        }
                        // 删除key
                        keyIter.remove();
                    }
                } else {
//                    System.out.println("暂时没有连接发生，等待中。。。");
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        } finally {

        }
    }

    /***
     * @Description 读取客户端消息
     */
    private void readData(SelectionKey key) {
        // 关联的channel
        SocketChannel channel = null;
        try {
            channel = (SocketChannel)key.channel();
            // 创建Buffer
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int count = channel.read(buffer);
            if (count > 0) {
                String msg = new String(buffer.array());
                System.out.println("客户端发送的消息为：" + msg);
                // 向其他客户端转发消息
                sendInfoToOtherClients(msg, channel);
            }
        } catch (IOException e) {
            try {
                System.out.println(channel.getRemoteAddress() + "离线了。。。");
                // 取消注册
                key.cancel();
                // 关闭通道
                channel.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    /***
     * @Description 转发消息给其他客户端（通道）
     */
    private void sendInfoToOtherClients(String msg, SocketChannel self) throws IOException {
        System.out.println("服务器转发消息中。。。");
        for (SelectionKey key : selector.keys()) {
            // 获取对应的channel
            Channel targetChannel = key.channel();

            // 排除自己
            if (targetChannel instanceof SocketChannel && targetChannel != self) {
                SocketChannel dest = (SocketChannel)targetChannel;
                // 将msg存储到buffer
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                // 将buffer写入到channel
                dest.write(buffer);
            }
        }
    }


}
