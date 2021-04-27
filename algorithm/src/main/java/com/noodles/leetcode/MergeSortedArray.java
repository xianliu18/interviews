package com.noodles.leetcode;

/**
 * @Description: Merge Sorted Array
 *      参考连接: https://leetcode.com/problems/merge-sorted-array/
 * @Author: noodles
 * @create: 2021-04-27 10:45
 */
public class MergeSortedArray {
    public static void main(String[] args) {

    }

    public static void mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1;
        int tail2 = n - 1;
        int finished = m + n - 1;
        while (tail1 >= 0 && tail2 >= 0) {
            nums1[finished--] = (nums1[tail1] > nums2[tail2]) ? nums1[tail1--] : nums2[tail2--];
        }
        if (tail2 >= 0) {
            nums1[finished--] = nums2[tail2--];
        }
    }
}
