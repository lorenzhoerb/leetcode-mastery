package com.lorenzhoerb.leetcode.slidingwindow;

/**
 * 209. Minimum Size Subarray Sum
 * <p>
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a
 * subarray
 * whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen2(15, new int[]{5,1,3,5,10,7,4,9,2,8}));

    }

    public static int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0) return 0;
        int min = nums.length;
        int lp = 0; int rp = 0;

        int sum = 0;
        while (rp < nums.length) {
            sum += nums[rp];
            if(sum >= target) {
                min = rp-lp+1;
                break;
            } else {
                rp++;
            }
        }


        if(rp >= nums.length -1 && sum < target) return 0;

        while (lp < nums.length) {
            if(sum - nums[lp] >= target) {
                sum -= nums[lp];
                lp++;
                min = rp-lp+1;
            } else if (rp < nums.length - 1) {
                sum += -nums[lp++] + nums[++rp];
            } else {
                return min;
            }
        }

        return 0;
    }

    public static int minSubArrayLen2(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left++];
            }
        }

        return left == 0 ? 0 : minLength;
    }
}
