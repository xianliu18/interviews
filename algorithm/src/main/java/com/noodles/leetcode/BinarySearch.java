package com.noodles.leetcode;

/**
 * @Description: 二分查找
 * @Author: noodles
 * @create: 2021-03-24 21:49
 */
public class BinarySearch {
    public static void main(String[] args) {

    }

    public static int binarySearch(int array[], int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (target < array[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
