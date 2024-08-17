package com.lorenzhoerb.leetcode.arrstr;

/**
 * 189. Rotate Array
 * <p>
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,6,7};
        rotate(a, 3);
        System.out.println(a.toString());

    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) return;
        // avoid rotating twice with no result. E.g. an array with 3 elements,
        // rotating 3 times has the same result as rotating 2 times.
        int kNew = k % n;
        // nothing to rotate
        if (kNew == n) return;

        int[] newArr = new int[n];
        for (int i = 0; i < n; i++) {
            int newIndex = (i + kNew) % n;
            newArr[newIndex] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = newArr[i];
        }

    }
}
