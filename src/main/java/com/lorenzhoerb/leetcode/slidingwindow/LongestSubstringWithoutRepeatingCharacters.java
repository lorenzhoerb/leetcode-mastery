package com.lorenzhoerb.leetcode.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters
 * <p>
 * Given a string s, find the length of the longest
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbbb"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("aab"));
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        int left = 0;
        int longestSubString = 0;
        Set<Character> windowSet = new HashSet<>();

        for (int right = 0; right < n; right++) {
            while (windowSet.contains(chars[right])) {
                windowSet.remove(chars[left++]);
            }
            windowSet.add(chars[right]);
            longestSubString = Math.max(longestSubString, right - left + 1);
        }

        return left == 0 ? n : longestSubString;
    }
}
