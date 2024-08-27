package com.lorenzhoerb.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 *
 * <p>
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 * <p>
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 */
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {


        List<String> letters =  letterCombinations("253");
        System.out.println(letters);
    }

    public static List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return new ArrayList<>();
        HashMap<Character, String> digitMap = new HashMap<>();
        digitMap.put('2', "abc");
        digitMap.put('3', "def");
        digitMap.put('4', "ghi");
        digitMap.put('5', "jkl");
        digitMap.put('6', "mno");
        digitMap.put('7', "pqrs");
        digitMap.put('8', "tuv");
        digitMap.put('9', "wxyz");
        char[] charDigits = digits.toCharArray();
        StringBuilder builder = new StringBuilder();
        List<String> results = new ArrayList<>();
        generateWords(charDigits, 0, builder, results, digitMap);
        return results;
    }

    public static void generateWords(char[] digits, int currentIndex, StringBuilder combination, List<String> results, HashMap<Character, String> digitMap) {
        if (combination.length() >= digits.length || currentIndex >= digits.length) {
            results.add(combination.toString());
            if(combination.length() > 0 ) combination.deleteCharAt(combination.length() - 1);
            return;
        }
        for (Character c : digitMap.get(digits[currentIndex]).toCharArray()) {
            generateWords(digits, currentIndex + 1, combination.append(c), results, digitMap);
        }
        if(combination.length() > 0 ) combination.deleteCharAt(combination.length() - 1);
    }
}
