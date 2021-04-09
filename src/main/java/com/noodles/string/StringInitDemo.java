package com.noodles.string;

/**
 * @ClassName StringInitDemo
 * @Description 字符串初始化方式
 * @Author noodles
 * @Date 2021/4/9 9:20
 */
public class StringInitDemo {

    public static void main(String[] args) {
        String str_01 = "abc";
        System.out.println("默认方式:" + str_01);

        String str_02 = new String(new char[]{'a', 'b', 'c'});
        System.out.println("char方式:" + str_02);

        String str_03 = new String(new int[]{0x61, 0x62, 0x63}, 0, 3);
        System.out.println("int 方式:" + str_03);

        String str_04 = new String(new byte[]{0x61, 0x62, 0x63});
        System.out.println("byte 方式:" + str_04);
    }

}
