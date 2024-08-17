package com.lorenzhoerb.leetcode.general;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1, 2}, 2));

    }

    /**
     * Finds the index of the target
     *
     * @param target target number to find the index of
     * @param nums   ordered array asc
     * @return index of target if target exists in nums else -1
     */
    public static int binarySearch(int[] nums, int target) {
        int low = 0;
        int mid;
        int high = nums.length;

        while (low <= high) {
            mid = low + ((high - low) / 2);
            int current = nums[mid];
            if (current == target) return mid;
            else if (current < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

}
