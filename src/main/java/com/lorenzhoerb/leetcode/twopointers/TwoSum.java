package com.lorenzhoerb.leetcode.twopointers;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int lp = 0;
        int rp = numbers.length - 1;

        int curr;
        while (lp < rp) {
            curr = numbers[lp] + numbers[rp];
            if (curr == target) return new int[]{lp + 1, rp + 1};
            if (curr < target) lp++;
            else rp--;
        }
        return null;
    }
}
