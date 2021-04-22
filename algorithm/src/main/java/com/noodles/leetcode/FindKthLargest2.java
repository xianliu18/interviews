package com.noodles.leetcode;

/**
 * @Description:
 * @Author:
 * @create: 2021-04-22 09:22
 */
public class FindKthLargest2 {

    public int quickSelect(int[] nums, int low, int high, int k) {
        int pivot = low;

        for (int i = low; i < high; i++) {
            if (nums[i] <= nums[high]) {
                swap(nums, pivot++, i);
            }
        }
        swap(nums, pivot, high);

        int count = high - pivot + 1;
        if (count == k) {
            return nums[pivot];
        }
        if (count > k) {
            return quickSelect(nums, pivot + 1, high, k);
        }
        return quickSelect(nums, low, pivot - 1, k - count);
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
