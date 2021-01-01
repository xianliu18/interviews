package com.noodles.netty.tcp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @ClassName MyMessageEncoder
 * @Description 自定义编码器
 * @Author noodles
 * @Date 2021/1/1 15:31
 */
public class MyMessageEncoder extends MessageToByteEncoder<MessageProtocol> {
    @Override
    protected void encode(ChannelHandlerContext ctx, MessageProtocol msg, ByteBuf out) throws Exception {
        System.out.println("MyMessageEncoder encode方法被调用~~~");
        out.writeInt(msg.getLen());
        out.writeBytes(msg.getContent());
    }
}
