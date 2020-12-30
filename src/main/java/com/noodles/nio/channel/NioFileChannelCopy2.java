package com.noodles.nio.channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @ClassName NioFileChannelCopy2
 * @Description 使用FileChannel完成文件的拷贝(transferFrom方法)
 * @Author noodles
 * @Date 2020/12/30 10:44
 */
public class NioFileChannelCopy2 {

    public static void main(String[] args) throws IOException {
        // 输入流
        FileInputStream fileInputStream = new FileInputStream("D:\\source.txt");
        FileChannel inputChannel = fileInputStream.getChannel();

        // 输出流
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\target01.txt");
        FileChannel outputChannel = fileOutputStream.getChannel();

        // 利用 transFrom 完成拷贝
        outputChannel.transferFrom(inputChannel, 0, inputChannel.size());

        // 关闭流
        fileInputStream.close();
        fileOutputStream.close();
    }
}
