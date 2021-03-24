package com.noodles.leetcode;

/**
 * @ClassName ValidPalindrome
 * @Description Valid Palindrome
 *      - 参考链接： https://leetcode.com/problems/valid-palindrome/
 * @Author noodles
 * @Date 2021/3/24 10:27
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
        String temp = ".,";
        System.out.println(isPalindrome(temp));
    }

    /**
     * https://leetcode.com/problems/valid-palindrome/discuss/40029/Accepted-pretty-Java-solution(271ms)
     */
    public static boolean isPalindrome2(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        char front;
        char back;
        while (i <= j) {
            front = s.charAt(i);
            back = s.charAt(j);
            if (!Character.isLetterOrDigit(front)) {
                i++;
            } else if (!Character.isLetterOrDigit(back)) {
                j--;
            } else {
                if (Character.toLowerCase(front) != Character.toLowerCase(back)) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }

    public static boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            while (i < j && (s.charAt(i) < 'a' || s.charAt(i) > 'z')) {
                i++;
            }
            while (j > i && (s.charAt(j) < 'a' || s.charAt(j) > 'z')) {
                j--;
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
