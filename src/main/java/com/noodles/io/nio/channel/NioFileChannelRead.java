package com.noodles.io.nio.channel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName NioFileChannelRead
 * @Description 从本地文件读取数据，并打印
 * @Author noodles
 * @Date 2020/12/30 10:11
 */
public class NioFileChannelRead {

    public static void main(String[] args) throws IOException {
        // 创建一个输入流
        File file = new File("D:\\file01.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        // 获取fileChannel
        FileChannel channel = fileInputStream.getChannel();
        
        // 创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate((int)file.length());

        // 将通道数据读入到缓冲区
        channel.read(buffer);

        System.out.println(new String(buffer.array()));

        // 关闭流
        fileInputStream.close();
    }
}
