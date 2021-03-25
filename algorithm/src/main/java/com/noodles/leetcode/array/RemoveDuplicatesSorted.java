package com.noodles.leetcode.array;

/**
 * @ClassName RemoveDuplicatesSorted
 * @Description Remove Duplicates from Soted Array
 *      参考链接： https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *      https://www.bilibili.com/video/BV1V54y1Q7bd
 * @Author noodles
 * @Date 2021/3/25 18:22
 */
public class RemoveDuplicatesSorted {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 5, 5};
        int m = removeDuplicates(arr);
        for (int i = 0; i < m; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int removeDuplicates(int[] arr) {
        int i = 0;
        int j = 0;
        while (j < arr.length) {
            // if not duplicate, keep it, otherwise skip it
            if (i == 0 || arr[j] != arr[i - 1]) {
                arr[i++] = arr[j++];
            } else {
                j++;
            }
        }
        // i is now at the length of the new array, [0, i) is what we want
        return i;
    }
}
