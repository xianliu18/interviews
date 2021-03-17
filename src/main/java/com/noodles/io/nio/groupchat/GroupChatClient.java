package com.noodles.io.nio.groupchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @ClassName GroupChatClient
 * @Description 群聊客户端
 * @Author noodles
 * @Date 2020/12/30 15:08
 */
public class GroupChatClient {
    // 定义相关属性
    private final String HOST = "127.0.0.1";
    private final int PORT = 8888;
    private Selector selector;
    private SocketChannel socketChannel;
    private String userName;

    public GroupChatClient() {
        try {
            selector = Selector.open();
            // 连接服务器
            socketChannel = SocketChannel.open(new InetSocketAddress(HOST, PORT));
            // 设置非阻塞
            socketChannel.configureBlocking(false);
            // 将 channel 注册到selector
            socketChannel.register(selector, SelectionKey.OP_READ);
            // 得到userName
            userName = socketChannel.getLocalAddress().toString().substring(1);
            System.out.println(userName + " is ok...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * 向服务器发送消息
     */
    public void sendInfo(String info) {
        info = userName + ": " + info;
        try {
            ByteBuffer buffer = ByteBuffer.wrap(info.getBytes());
            socketChannel.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * 读取服务端回复的消息
     */
    public void readInfo() {
        try {
            int readChannels = selector.select();
            if (readChannels > 0) {
                Iterator<SelectionKey> keyIter = selector.selectedKeys().iterator();
                while (keyIter.hasNext()) {
                    SelectionKey key = keyIter.next();
                    if (key.isReadable()) {
                        // 获取对应通道
                        SocketChannel channel = (SocketChannel)key.channel();
                        // 得到一个Buffer
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        channel.read(buffer);
                        // 输出消息
                        System.out.println(new String(buffer.array()));
                    }
                    // 移除当前SelectionKey
                    keyIter.remove();
                }
            } else {
                System.out.println("没有可用的通道~~");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // 启动客户端
        GroupChatClient chatClient = new GroupChatClient();

        // 启动一个线程, 读取来自服务器端的数据
        new Thread() {
            public void run() {
                while (true){
                    chatClient.readInfo();
                    try {
                        Thread.currentThread().sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        // 发送数据给服务器
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String msg = scanner.nextLine();
            chatClient.sendInfo(msg);
        }
    }
}
