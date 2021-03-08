package com.noodles.netty.buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

/**
 * @ClassName NettyByteBuf02
 * @Description NettyByteBuf 示例
 * @Author noodles
 * @Date 2021/3/8 11:43
 */
public class NettyByteBuf02 {

    public static void main(String[] args) {

        // 创建 ByteBuf
        ByteBuf byteBuf = Unpooled.copiedBuffer("hello, world!", Charset.forName("utf-8"));

        if (byteBuf.hasArray()) {

            byte[] content = byteBuf.array();

            // 将 content 转成字符串
            System.out.println(new String(content, Charset.forName("utf-8")));

            System.out.println("byteBuf = " + byteBuf);
        }
    }

}
