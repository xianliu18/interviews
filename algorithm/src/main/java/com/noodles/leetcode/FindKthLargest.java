package com.noodles.leetcode;

import com.alibaba.fastjson.JSON;

/**
 * @ClassName FindKthLargest
 * @Description Kth Largest Element in an Array
 *      参考链接： https://leetcode.com/problems/kth-largest-element-in-an-array/
 * @Author noodles
 * @Date 2021/3/24 11:10
 */
public class FindKthLargest {
    public static void main(String[] args) {
//        int[] nums = {7, 8, 3, 2, 1, 5, 6, 4};
        int[] nums = {3, 2, 1, 5, 6, 4};
        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(nums, 2));
        System.out.println(findKthLargest(nums2, 4));
    }

    /**
     * QuickSelect: https://en.wikipedia.org/wiki/Quickselect
     *
     * https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/60312/AC-Clean-QuickSelect-Java-solution-avg.-O(n)-time
     */
    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private static int quickSelect(int[] nums, int low, int high, int k) {
        int pivot = low;

        // use quick sort's idea
        // put nums that are <= pivot to the left
        // put nums that are > pivot to the right
        for (int j = low; j < high; j++) {
            System.out.println("j: " + j + " pivot: " + pivot);
            if (nums[j] <= nums[high]) {
                swap(nums, pivot++, j);
            }
            System.out.println(JSON.toJSONString(nums));
        }
        swap(nums, pivot, high);

        // count the nums that are > pivot from high
        int count = high - pivot + 1;
        // pivot is the one
        if (count == k) {
            return nums[pivot];
        }
        if (count > k) {
            return quickSelect(nums, pivot + 1, high, k);
        }
        return quickSelect(nums, low, pivot - 1, k - count);
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
