package com.noodles.leetcode;

import java.util.HashSet;
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

    }

    public static int longestRepeatingSubstring(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            int mid = l + (r - l + 1)/2;
            if (f(s, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public static boolean f(String s, int length) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i <= s.length() - length; i++) {
            int j = i + length - 1;
            String sub = s.substring(i, j + 1);
            if (seen.contains(sub)) {
                return true;
            }
            seen.add(sub);
        }
        return false;
    }
}
