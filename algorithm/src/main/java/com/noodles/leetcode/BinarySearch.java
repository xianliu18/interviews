package com.noodles.leetcode;

/**
 * @Description: 二分查找
 *      参考连接: https://www.bilibili.com/video/BV1Ng4y1q7E3
 * @Author: noodles
 * @create: 2021-03-24 21:49
 */
public class BinarySearch {
    public static void main(String[] args) {

    }

    /**
     * 寻找一个准确值
     *      1, 循环条件: l <= r
     *      2, 缩减搜索空间: l = mid + 1, r = mid - 1
     */
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

    /**
     * 寻找一个模糊值(例如, 比 4 大的最小数)
     *      1, 循环条件: l < r
     *      2, 缩减搜索空间: l = mid, r = mid - 1  或者  l = mid + 1, r = mid
     */

    /**
     * 2.1 找一个模糊值 (First Occurance of 2)
     *      循环条件: l < r
     *      缩减搜索空间: l = mid + 1, r = mid
     */
    public static int binarySearch2(int[] arr, int k) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int mid = l + (r - l)/2;
            if (arr[mid] < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    /**
     * 2.2 找一个模糊值 (Last Occurance of 2)
     *     循环条件: l < r
     *     缩减搜索空间: l = mid, r = mid - 1
     */
    public static int binarySearch3(int[] arr, int k) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int mid = l + (r - l + 1)/2;
            if (arr[mid] > k) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }


    /**
     * 万用型 (Closet to 2)
     *      1, 循环条件: l < r - 1
     *      2, 缩减搜索空间: l = mid, r = mid
     */
    public static int binarySearch4(int[] arr, int k) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r - 1) {
            int mid = l + (r - l)/2;
            if (arr[mid] < k) {
                l = mid;
            } else {
                r = mid;
            }
        }

        if (arr[r] < k) {
            return r;
        } else if (arr[l] > k) {
            return l;
        } else {
            return k - arr[l] < arr[r] - k ? l : r;
        }
    }

}
