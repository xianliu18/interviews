package com.noodles.leetcode.array;

/**
 * @ClassName ReverseString
 * @Description Reverse String
 *      参考链接： https://leetcode.com/problems/reverse-string/
 *              https://www.bilibili.com/video/BV1V54y1Q7bd
 * @Author noodles
 * @Date 2021/3/25 18:09
 */
public class ReverseString {
    public static void main(String[] args) {
        String str = "thisisaTest";
        char[] p = str.toCharArray();
        reverseString(p);
        for (char c : p) {
            System.out.print(c);
        }
    }

    public static void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        // Two pointers opposite direction
        while (i < j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }
}
