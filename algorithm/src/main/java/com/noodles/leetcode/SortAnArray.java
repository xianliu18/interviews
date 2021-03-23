package com.noodles.leetcode;

/**
 * @Description: Sort An Array
 *      参考链接: 912  https://leetcode.com/problems/sort-an-array/
 * @Author: noodles
 * @create: 2021-03-23 21:33
 */
public class SortAnArray {
    public static void main(String[] args) {
//        int[] nums = {5, 2, 3, 1};
        int[] nums = {5, 1, 1, 2, 0, 0};
        sortArray(nums);
        for (int i : nums) {
            System.out.print(i + "\t");
        }
    }

    public static int[] sortArray(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSort(int[] nums, int low, int hi) {
        if (hi <= low) {
            return;
        }
        int j = partition(nums, low, hi);
        quickSort(nums, low, j - 1);
        quickSort(nums, j + 1, hi);
    }

    private static int partition(int[] nums, int low, int hi) {
        int i = low;
        int j = hi + 1;
        int pivot = nums[low];
        while (true) {
            while (nums[++i] < pivot) {
                if (i == hi) {
                    break;
                }
            }
            while (pivot < nums[--j]) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, low, j);
        return j;
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
