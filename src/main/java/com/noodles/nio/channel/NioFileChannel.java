package com.noodles.nio.channel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName NioFileChannel
 * @Description ByteBuffer和FileChannel结合
 * @Author noodles
 * @Date 2020/12/25 16:58
 */
public class NioFileChannel {
    /*
     * 需求：
     *     1，使用ByteBuffer和FileChannel，将“测试001”写入file01.txt中
     *     2，如果文件不存在，就创建
     */
    public static void main(String[] args) throws IOException {
        String str = "测试001";

        // 创建一个输出流
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\file01.txt");

        // 通过fileOutputStream获取 FileChannel
        FileChannel channel = fileOutputStream.getChannel();

        // 创建一个缓冲区 ByteBuffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 将 str 放入 byteBuffer
        buffer.put(str.getBytes());

        // 对 byteBuffer 进行 flip
        buffer.flip();

        // 将 byteBuffer 数据写入到 fileChannel
        channel.write(buffer);

        // 关闭流
        fileOutputStream.close();
    }
}
