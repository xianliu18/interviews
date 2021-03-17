package com.noodles.io.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;

/**
 * @ClassName ChannelHandler
 * @Description 处理器
 * @Author noodles
 * @Date 2021/1/4 16:45
 */
public class ChannelHandler {

    private AsynchronousSocketChannel channel;
    private Charset charset;

    public ChannelHandler(AsynchronousSocketChannel channel, Charset charset) {
        this.channel = channel;
        this.charset = charset;
    }

    public void writeAndFlush(Object msg) {
        byte[] bytes = msg.toString().getBytes(charset);
        ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
        writeBuffer.put(bytes);
        writeBuffer.flip();
        channel.write(writeBuffer);
    }

    public AsynchronousSocketChannel channel() {
        return channel;
    }

    public void setChannel(AsynchronousSocketChannel channel) {
        this.channel = channel;
    }
}
