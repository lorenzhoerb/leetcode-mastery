package com.lorenzhoerb.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        List<List<Integer>> r = backtrack(new int[]{20, 30, 1, 5}, 100);
        System.out.println(r);
    }

    public static List<List<Integer>> backtrack(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[candidates.length];
        backtrack(candidates, 0, target,  new ArrayList<>(), 0, result);
        return result;
    }

    public static void backtrack(int[] candidates, int start, int target, List<Integer> current, int currentSum, List<List<Integer>> result) {
        if (currentSum == target) {
            result.add(List.copyOf(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];
            if(candidate + currentSum <= target)   {
                current.add(candidate);
                backtrack(candidates, i, target, current, currentSum + candidate, result);
                current.remove(current.size() - 1);
            }
        }
    }
}
