package com.lorenzhoerb.leetcode.arrstr;

import java.util.Arrays;

/**
 * 88. Merge Sorted Array
 * <p>
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 * <p>
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * <p>
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 4, 5, 6, 0};
        merge(arr1, 5, new int[]{3}, 1);
        System.out.println(Arrays.toString(arr1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        int mIndex = m - 1;
        int nIndex = n - 1;
        int lastIdx = n + m - 1;

        while (nIndex > 0) {
            if (mIndex > 0 && nums1[mIndex] > nums2[nIndex]) {
                nums1[lastIdx--] = nums1[mIndex--];
            } else {
                nums1[lastIdx--] = nums2[nIndex--];
            }
        }

    }
}
