package com.lorenzhoerb.leetcode.twopointers;

import java.util.Arrays;

public class InsertWithBinary {
    public static void main(String[] args) {

        int[] a = insert(new int[]{1, 2, 5, 10, 22, 24}, 25);
        System.out.println(Arrays.toString(a));
    }

    public static int[] insert(int[] numbers, int valueToInsert) {
        int low = 0;
        int high = numbers.length - 1;
        int mid = 0;

        while (low <= high) {
            mid = low + (high - low) / 2;
            int current = numbers[mid];
            if (valueToInsert < current) high = mid - 1;
            else if (valueToInsert > current) low = mid + 1;
            else break;
        }

        int insertIndex = valueToInsert < numbers[mid] ? mid : mid + 1;

        int[] result = new int[numbers.length + 1];

        // Copy elements before the insertion index
        System.arraycopy(numbers, 0, result, 0, insertIndex);

        // Insert the new value
        result[insertIndex] = valueToInsert;

        // Copy the remaining elements after the insertion index
        System.arraycopy(numbers, insertIndex, result, insertIndex + 1, numbers.length - insertIndex);

        return result;
    }
    // 0, 1, 2, 3
    // 1, 2, 10, 20
    // c        c

}
