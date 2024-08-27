package com.lorenzhoerb.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {
    public static void main(String[] args) {
        System.out.println(permutations("abc"));
    }

    public static List<String> permutations(String word) {
        List<String> solution = new ArrayList<>();
        boolean[] used = new boolean[word.length()];
        permutations(word, used, new StringBuilder(), solution);
        return solution;
    }

    public static void permutations(String word, boolean[] used, StringBuilder c, List<String> solution) {
        if (c.length() == word.length()) {
            solution.add(c.toString());
            return;
        }
        for (int i = 0; i < word.length(); i++) {
            if (used[i]) continue;

            used[i] = true;
            c.append(word.charAt(i));

            permutations(word, used, c, solution);

            used[i] = false;
            c.deleteCharAt(c.length() - 1);
        }
    }
}
