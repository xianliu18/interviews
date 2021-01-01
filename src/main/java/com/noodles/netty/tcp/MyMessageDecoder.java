package com.noodles.netty.tcp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * @ClassName MyMessageDecoder
 * @Description 自定义解码器
 * @Author noodles
 * @Date 2021/1/1 15:33
 */
public class MyMessageDecoder extends ReplayingDecoder<Void> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("MyMessageDecoder 被调用~~~");
        // 将二进制字节码，转换为 MessageProtocol 数据包
        int length = in.readInt();

        byte[] content = new byte[length];
        in.readBytes(content);

        MessageProtocol messageProtocol = new MessageProtocol();
        messageProtocol.setLen(length);
        messageProtocol.setContent(content);

        out.add(messageProtocol);
    }
}
