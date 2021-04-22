package com.noodles.leetcode.array;

import org.junit.Test;

/**
 * @Description: https://leetcode.com/problems/maximum-subarray/
 * @Author: noodles
 * @create: 2021-04-22 08:31
 */
public class MaximumSubarray53 {
    public static void main(String[] args) {
        int[] arr1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] arr2 = {-3, -2, -1};
        int result = maxSubArray(arr1);
        int result2 = maxSubArray(arr2);
        System.out.println(result);
        System.out.println(result2);
    }

    private static int maxSubArray(int[] arr) {
        int max = arr[0];
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (sum < 0) {
                sum = arr[i];
            } else {
                sum += arr[i];
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

}
