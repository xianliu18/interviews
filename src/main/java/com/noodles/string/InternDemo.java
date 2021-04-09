package com.noodles.string;

/**
 * @ClassName Intern
 * @Description  intern() 方法
 * @Author noodles
 * @Date 2021/4/9 9:23
 */
public class InternDemo {

    public static void main(String[] args) {
        String str_1 = new String("ab");
        String str_2 = new String("ab");
        String str_3 = "ab";

        System.out.println(str_1 == str_2);
        System.out.println(str_1 == str_2.intern());
        System.out.println(str_1.intern() == str_2.intern());
        System.out.println(str_1 == str_3);
        System.out.println(str_1.intern() == str_3);
    }

}
