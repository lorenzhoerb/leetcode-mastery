package com.lorenzhoerb.leetcode.general;

/**
 * 278. First Bad Version
 * <p>
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * <p>
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * <p>
 * You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 */
public class FirstBadVersion {
    public static void main(String[] args) {
        System.out.println(firstBadVersion(1));
    }

    public static int firstBadVersion(int n) {
        if(n == 1) return 1;
        if(n == 2) return isBadVersion(1) ? 1 : 2;
        int low = 1;
        int mid;
        int high = n;


        while (low != high - 1) {
            mid = low + (int) Math.ceil((double) (high - low) / 2);
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return isBadVersion(low) ? low : high;
    }

    public static boolean isBadVersion(int x) {
        return x >= 1;
    }
}
