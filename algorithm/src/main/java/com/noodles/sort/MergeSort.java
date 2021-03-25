package com.noodles.sort;

import java.util.Arrays;

/**
 * @ClassName MergeSort
 * @Description MergeSort
 *      参考链接： https://www.bilibili.com/video/BV1QE41177ST
 * @Author noodles
 * @Date 2021/3/25 9:59
 */
public class MergeSort {
    public static void main(String[] args) {

    }

    public static int[] mergeSort(int[] array) {
        int[] helper = Arrays.copyOf(array, array.length);
        mergeSort(array, helper, 0, array.length - 1);
        return array;
    }

    public static void mergeSort(int[] array, int[] helper, int left, int right) {
        if (right - left < 1) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(array, helper, left, mid);
        mergeSort(array, helper, mid + 1, right);
        merge(array, helper, left, mid, right);
    }

    public static void merge(int[] array, int[] helper, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            helper[i] = array[i];
        }
        int leftStart = left;
        int rightStart = mid + 1;
        for (int i = left; i <= right; i++) {
            if (leftStart > mid) {
                array[i] = helper[rightStart++];
            } else if (rightStart > right) {
                array[i] = helper[leftStart++];
            } else if (helper[leftStart] < helper[rightStart]) {
                array[i] = helper[leftStart++];
            } else {
                array[i] = helper[rightStart++];
            }
        }
    }
}
