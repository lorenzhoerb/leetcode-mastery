package com.lorenzhoerb.leetcode.intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. Insert Interval
 * <p>
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 * <p>
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 * <p>
 * Return intervals after the insertion.
 * <p>
 * Note that you don't need to modify intervals in-place. You can make a new array and return it.
 */
public class InsertInterval {
    public static void main(String[] args) {
        int[][] result = insert(new int[][]{{2, 5}, {6, 9}}, new int[]{3, 5});

        System.out.println("a");
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int low = 0;
        int high = intervals.length - 1;
        int mid = 0;

        while (low <= high) {
            mid = low + (high - low) / 2;
            int curStart = intervals[mid][0];
            int targetStart = newInterval[0];
            if (curStart == targetStart) {
                intervals[mid][1] = Math.max(intervals[mid][1], newInterval[1]);
                return intervals;
            } else if (curStart < targetStart) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }


        List<int[]> insertedIntervals = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if(i == mid) {
                while (i < intervals.length && intervals[i][1] < newInterval[1]) {
                   i++;
                }
                int[] newly = new int[]{Math.min(newInterval[0], intervals[mid][0]), Math.max(newInterval[1], intervals[i][1])};
                insertedIntervals.add(newly);
            } else {
                insertedIntervals.add(intervals[i]);
            }
        }

        return insertedIntervals.toArray(new int[insertedIntervals.size()][]);
    }

}
