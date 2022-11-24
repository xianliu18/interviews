package com.noodles.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description: Longest Repeating Substring
 *      参考资料: https://leetcode.com/problems/longest-repeating-substring/
 *      https://www.bilibili.com/video/BV1Ng4y1q7E3
 * @Author: noodles
 * @create: 2021-03-25 20:49
 */
public class LongestRepeatingSubstring {
    public static void main(String[] args) {
        String s = "abcabcdmmmmmvumowbb";
        int m = lengthOfLongestSubString(s);
        System.out.println(m);
    }

    public static int lengthOfLongestSubString(String s) {
        if (s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) +  1);
            }
            map.put(s.charAt(i), i);
            System.out.println("i: " + i + "\tj: " + j);
            max = Math.max(max, i - j + 1);
        }

        return max;
    }
}
