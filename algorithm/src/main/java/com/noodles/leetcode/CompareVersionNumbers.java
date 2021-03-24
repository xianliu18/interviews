package com.noodles.leetcode;

/**
 * @ClassName CompareVersionNumbers
 * @Description Compare Version Numbers
 *      参考链接： https://leetcode.com/problems/compare-version-numbers/
 * @Author noodles
 * @Date 2021/3/24 9:30
 */
public class CompareVersionNumbers {
    public static void main(String[] args) {
        String v1 = "2.23";
        String v2 = "2.3";
        System.out.println(compareVersionWithOutSplit(v1, v2));
        System.out.println(compareVersionWithSplit(v1, v2));
    }

    /**
     * https://leetcode.com/problems/compare-version-numbers/discuss/50774/Accepted-small-Java-solution.
     */
    public static int compareVersionWithSplit(String v1, String v2) {
        String[] arrA = v1.split("\\.");
        String[] arrB = v2.split("\\.");

        int length = Math.max(arrA.length, arrB.length);
        for (int i = 0; i < length; i++) {
            int tempA = i < arrA.length ? Integer.parseInt(arrA[i]) : 0;
            int tempB = i < arrB.length ? Integer.parseInt(arrB[i]) : 0;
            if (tempA > tempB) {
                return 1;
            } else if (tempA < tempB) {
                return -1;
            }
        }
        return 0;
    }

    /**
     * 地址: https://leetcode.com/problems/compare-version-numbers/discuss/50788/My-JAVA-solution-without-split
     */
    public static int compareVersionWithOutSplit(String v1, String v2) {
        int tempA;
        int tempB;
        int lenA = v1.length();
        int lenB = v2.length();
        int i = 0;
        int j = 0;
        while (i < lenA || j < lenB) {
            tempA = 0;
            tempB = 0;
            while (i < lenA && v1.charAt(i) != '.') {
                tempA = tempA * 10 + v1.charAt(i++) - '0';
            }
            while (j < lenB && v2.charAt(j) != '.') {
                tempB = tempB * 10 + v2.charAt(j++) - '0';
            }
            if (tempA > tempB) {
                return 1;
            } else if (tempA < tempB) {
                return -1;
            } else {
                i++;
                j++;
            }
        }
        return 0;
    }
}
