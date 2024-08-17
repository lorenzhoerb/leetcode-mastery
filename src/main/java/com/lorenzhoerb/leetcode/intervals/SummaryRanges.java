package com.lorenzhoerb.leetcode.intervals;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        List<String> result = summaryRanges(new int[]{0, 1, 2, 4, 5, 7, 10, 12, 13, 14, 15, 16, 17, 18, 19, 20, 22});
        System.out.println(result);
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> intervals = new ArrayList<>();
        for (int i = 0; i < nums.length; i++ ) {
            int start = nums[i];
            while (i < nums.length - 1 && nums[i] + 1 == nums[i+1]) {
                i++;
            }

            if(start != nums[i]) intervals.add(start + "->" + nums[i]);
            else intervals.add(Integer.toString(start));
        }
        return intervals;
    }
}
