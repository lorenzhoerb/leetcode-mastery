package com.lorenzhoerb.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 * <p>
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 */
public class Permutations {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> results = new ArrayList<>();
        backtrack(nums, used, new ArrayList<>(), results);
        return results;
    }

    private static void backtrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> results) {
        if (current.size() == nums.length) {
            results.add(List.copyOf(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            current.add(nums[i]);

            backtrack(nums, used, current, results);

            used[i] = false;
            current.remove(current.size() - 1);
        }
    }
}
