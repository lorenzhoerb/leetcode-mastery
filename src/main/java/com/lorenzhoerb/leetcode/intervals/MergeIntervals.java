package com.lorenzhoerb.leetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. Merge Intervals
 * <p>
 * Given an array of intervals where intervals[i] = [starti, endi], merge all
 * overlapping intervals, and return an array of the non-overlapping intervals
 * that cover all the intervals in the input.
 */
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}, {3, 4}, {14, 17}};
        int[][] merged = merge(intervals);
        System.out.println(merged.toString());
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return intervals;
        int[][] sorted = Arrays.copyOf(intervals, intervals.length);
        Arrays.sort(sorted, Comparator.comparingInt(i -> i[0]));

        List<int[]> mergedIntervals = new ArrayList<>();

        int start = sorted[0][0];
        int end = sorted[0][1];
        for (int i = 1; i < sorted.length; i++) {
            int[] pair = sorted[i];
            if (pair[0] > end) {
                mergedIntervals.add(new int[]{start, end});
                start = pair[0];
                end = pair[1];
            } else {
                end = Math.max(end, pair[1]);
            }
        }
        mergedIntervals.add(new int[]{start, end});

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
