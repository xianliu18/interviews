package com.noodles.nio;

import java.nio.IntBuffer;

/**
 * @ClassName BasicBuffer
 * @Description buffer类型基本使用
 * @Author noodles
 * @Date 2020/12/25 15:41
 */
public class BasicBuffer {

    public static void main(String[] args) {
        // 创建一个buffer
        IntBuffer intBuffer = IntBuffer.allocate(5);

        // 存入数据
        for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i * 2);
        }

        // buffer 读写切换
        intBuffer.flip();

        // 打印数据
        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }
    }
}
