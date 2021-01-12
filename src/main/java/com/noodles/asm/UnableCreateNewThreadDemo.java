package com.noodles.asm;

/**
 * @ClassName UnableCreateNewThreadDemo
 * @Description 异常演示
 * @Author noodles
 * @Date 2021/1/11 14:56
 */
public class UnableCreateNewThreadDemo {
    public static void main(String[] args) {
        for (int i = 1; ; i++) {
            System.out.println("******************* i = " + i);

            new Thread(() -> {
                try {
                  Thread.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "" + i).start();
        }
    }
}
