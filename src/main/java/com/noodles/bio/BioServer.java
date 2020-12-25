package com.noodles.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName BioServer
 * @Description Bio模型的服务器
 * @Author noodles
 * @Date 2020/12/24 18:20
 */
public class BioServer {
    /*
     * 1, 使用BIO模型编写一个服务器端，监听端口8015，当有客户端连接时，就启动一个线程与之通讯；
     * 2，使用线程池机制，可以连接多个客户端
     */
    public static void main(String[] args) throws IOException {
        // 1, 创建线程池
        ExecutorService threadPool = Executors.newCachedThreadPool();

        // 2, 创建serverSocket
        ServerSocket serverSocket = new ServerSocket(8015);

        System.out.println("服务器启动了。。。");

        while (true) {
            // 监听，等待客户端连接
            final Socket socket = serverSocket.accept();

            System.out.println("连接到一个客户端");

            // 创建一个线程，与客户端通讯
            threadPool.execute(() -> handler(socket));
        }
    }

    // 读取客户端请求内容
    public static void handler(Socket socket) {
        try {
            // 打印当前线程信息
            System.out.println("线程id：" + Thread.currentThread().getId() + "  名称:" + Thread.currentThread().getName());
            byte[] bytes = new byte[1024];
            InputStream  inputStream = socket.getInputStream();
            // 循环读取客户端发送的数据
            while (true) {
                System.out.println("线程id：" + Thread.currentThread().getId() + "  名称:" + Thread.currentThread().getName());
                int read = inputStream.read(bytes);
                if (read != -1) {
                    // 打印客户端发送的数据
                    System.out.println(new String(bytes, 0, read));
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭连接
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
