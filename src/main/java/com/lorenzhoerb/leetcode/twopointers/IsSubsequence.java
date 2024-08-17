package com.lorenzhoerb.leetcode.twopointers;

/**
 * 392. Is Subsequence
 * <p>
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * <p>
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 */
public class IsSubsequence {
    public static void main(String[] args) {

        System.out.println(isSubsequence("abc", "bhaklc"));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;
        if(t.length()<s.length()){
            return false;
        }
        int j=0;
        for(int i=0;i<t.length();i++){
            if(t.charAt(i)==s.charAt(j)) j++;
            if(j==s.length()) return true;
        }
        return false;
    }
}
