package com.lorenzhoerb.leetcode.arrstr;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 0, 0, 1, 1, 2, 2};
        flag(a);
        System.out.println(Arrays.toString(a));
    }

    public static void flag(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {
            if(arr[mid] == 0) {
                swap(arr, mid, low);
                low++;
            } else if (arr[mid] == 1){
                mid++;
            } else {
                swap(arr, mid, high);
                high--;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
