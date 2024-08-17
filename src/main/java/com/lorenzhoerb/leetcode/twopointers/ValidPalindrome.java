package com.lorenzhoerb.leetcode.twopointers;

import java.util.Arrays;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 * <p>
 * Given a string s, return true if it is a palindrome, or false otherwise.
 */
public class ValidPalindrome {
    public static void main(String[] args) {
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if(!Character.isLetterOrDigit(leftChar)) {
                left++;
            } else if(!Character.isLetterOrDigit(rightChar)) {
                right--;
            } else {
                if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) return false;
                left++;
                right--;
            }

        }
        return true;
    }
}
