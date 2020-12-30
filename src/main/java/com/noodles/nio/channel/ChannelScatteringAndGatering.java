package com.noodles.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * @ClassName ChannelScatteringAndGatering
 * @Description Scattering 和 Gathering 使用
 * @Author noodles
 * @Date 2020/12/30 11:13
 */
public class ChannelScatteringAndGatering {
    /*
     * Scattering：将数据一次写入到buffer，使用buffer数组；
     * Gathering： 从buffer读取数据，使用buffer数组
     */
    public static void main(String[] args) throws IOException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress socketAddress = new InetSocketAddress(8015);

        // 绑定端口到socket，并启动
        serverSocketChannel.socket().bind(socketAddress);

        // 创建buffer数组
        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);

        // 等客户端连接（telnet）
        SocketChannel socketChannel = serverSocketChannel.accept();

        int messageLength = 8;

        // 循环读取
        while (true) {
            int byteRead = 0;
            while (byteRead < messageLength) {
                long count = socketChannel.read(byteBuffers);
                byteRead += count;

                // 打印
                Arrays.asList(byteBuffers).stream().map(buffer -> "position = " +
                        buffer.position() + ", limit = " + buffer.limit()).forEach(System.out::println);

                // 将所有的buffer进行flip
                Arrays.asList(byteBuffers).forEach(buffer -> buffer.flip());

                // 将数据回显到客户端
                long byteWrite = 0;
                while (byteWrite < messageLength) {
                    long writeCount = socketChannel.write(byteBuffers);
                    byteWrite += writeCount;
                }

                // buffer进行clear
                Arrays.asList(byteBuffers).forEach(buffer -> buffer.clear());

                System.out.println("byteRead = " + byteRead + " byteWrite = " + byteWrite);
            }
        }
    }
}
