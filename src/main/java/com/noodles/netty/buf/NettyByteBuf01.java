package com.noodles.netty.buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @ClassName NettyByteBuf01
 * @Description ByteBuf 示例
 * @Author noodles
 * @Date 2021/3/8 11:38
 */
public class NettyByteBuf01 {

    public static void main(String[] args) {

        ByteBuf buffer = Unpooled.buffer(10);

        for (int i = 0; i < 8; i++) {
            buffer.writeByte(i);
        }

        System.out.println("capacity = " + buffer.capacity());

        // 输出
//        for (int i = 0; i < buffer.capacity(); i++) {
//            System.out.println(buffer.getByte(i));
//        }
        for (int i = 0; i < buffer.capacity(); i++) {
            System.out.println(buffer.readByte());
        }
    }
}
