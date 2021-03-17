package com.noodles.jvm.oom;

/**
 * @ClassName UnableCreateNewThreadDemo
 * @Description OutOfMemoryError: unable to create new native thread
 *
 * 参考链接：https://www.bilibili.com/video/BV1zb411M7NQ?p=85
 *
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
