package com.noodles.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName MergeIntervals
 * @Description Merge Intervals
 *      参考链接： https://leetcode.com/problems/merge-intervals/
 * @Author noodles
 * @Date 2021/3/24 10:01
 */
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] newInter = merge(intervals);
        for (int[] inter : newInter) {
            System.out.println(inter[0] + "\t" + inter[1]);
        }
    }


    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // Sort by ascending starting point
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                newInterval = interval;
                result.add(interval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
