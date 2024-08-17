package com.lorenzhoerb.leetcode.hashmap;

import java.util.HashMap;

/**
 * 383. Ransom Note
 * <p>
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 * <p>
 * Each letter in magazine can only be used once in ransomNote.
 */
public class RansomNote {
    public static void main(String[] args) {

    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> charCounter = new HashMap<>();
        for (Character c : magazine.toCharArray()) {
            charCounter.merge(c, 1, Integer::sum);
        }

        for (Character c : ransomNote.toCharArray()) {
            int count = charCounter.getOrDefault(c, 0);
            if (count == 0) {
                return false;
            }
            charCounter.put(c, count - 1);
        }
        return true;
    }
}
