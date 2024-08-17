package com.lorenzhoerb.leetcode.hashmap;

import java.util.HashMap;

/**
 * 205. Isomorphic Strings
 * <p>
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
 */
public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
    }


    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> chars = new HashMap<>();
        HashMap<Character, Character> charBack = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(chars.containsKey(s.charAt(i))) {
                if(chars.get(s.charAt(i)) != t.charAt(i)) return false;
            } else {
                chars.put(s.charAt(i), t.charAt(i));
                charBack.put(t.charAt(i), s.charAt(i));
            }
        }
        return true;
    }

}
