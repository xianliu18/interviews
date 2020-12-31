package com.noodles.netty.inboundAndOutbound;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @ClassName MyLongToByteEncoder
 * @Description 客户端编码器
 * @Author noodles
 * @Date 2020/12/31 19:15
 */
public class MyLongToByteEncoder extends MessageToByteEncoder<Long> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Long msg, ByteBuf out) throws Exception {
        System.out.println("MyLongToByteEncoder 被调用");
        out.writeLong(msg);
    }
}
