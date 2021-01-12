package com.noodles.asm;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName GCOverheadDemo
 * @Description GC 异常示例
 * @Author noodles
 * @Date 2021/1/11 14:31
 */
public class GCOverheadDemo {

    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<>();

//        ByteBuffer.allocateDirect();

        try {
            while (true) {
                list.add(String.valueOf(++i).intern());
            }
        } catch (Throwable e) {
            System.out.println("***************i:" + i);
            e.printStackTrace();
            throw e;
        }
    }
}
