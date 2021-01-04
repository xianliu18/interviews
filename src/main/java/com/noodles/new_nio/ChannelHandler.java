package com.noodles.new_nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * 通道处理器
 */
public class ChannelHandler {

    private SocketChannel channel;
    private Charset charset;

    public ChannelHandler(SocketChannel channel, Charset charset) {
        this.channel = channel;
        this.charset = charset;
    }

    public void writeAndFlush(Object msg) {
        try {
            byte[] bytes = msg.toString().getBytes(charset);
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            channel.write(writeBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SocketChannel channel() {
        return channel;
    }
}
