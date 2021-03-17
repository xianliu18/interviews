package com.noodles.io.nio.channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName NioFileChannelCopy
 * @Description 使用FileChannel完成文件的拷贝
 * @Author noodles
 * @Date 2020/12/30 10:22
 */
public class NioFileChannelCopy {

    public static void main(String[] args) throws IOException {
        // 输入流
        FileInputStream fileInputStream = new FileInputStream("D:\\source.txt");
        FileChannel inputChannel = fileInputStream.getChannel();

        // 输出流
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\target.txt");
        FileChannel outputChannel = fileOutputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(512);

        // 循环读取数据
        while (true) {

            // 清空buffer
            buffer.clear();

            int read = inputChannel.read(buffer);
            // 如果 read 等于 -1， 表示已读完
            if (read == -1) {
                break;
            }
            buffer.flip();
            outputChannel.write(buffer);
        }

        // 关闭流
        fileInputStream.close();
        fileOutputStream.close();
    }
}
