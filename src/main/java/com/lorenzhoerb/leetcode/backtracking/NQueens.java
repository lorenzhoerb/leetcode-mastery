package com.lorenzhoerb.leetcode.backtracking;


import java.util.HashSet;
import java.util.Set;

/**
 * N-Queens II
 * <p>
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 * <p>
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 */
public class NQueens {
    public static void main(String[] args) {
        System.out.println(totalNQueens(12));
    }



    public static int totalNQueens(int n) {
        return backtrack(n, 0, new boolean[n], new boolean[2 * n], new boolean[2 * n]);
    }

    private static int backtrack(int n, int row, boolean[] columns, boolean[] mainDiagonals, boolean[] antiDiagonals) {
        if (row == n) {
            return 1;
        }

        int solutions = 0;
        for (int col = 0; col < n; col++) {
            int mainDiagIdx = row - col + n;
            int antiDiagIdx = row + col;

            if (columns[col] || mainDiagonals[mainDiagIdx] || antiDiagonals[antiDiagIdx]) {
                continue;
            }

            columns[col] = true;
            mainDiagonals[mainDiagIdx] = true;
            antiDiagonals[antiDiagIdx] = true;

            solutions += backtrack(n, row + 1, columns, mainDiagonals, antiDiagonals);

            columns[col] = false;
            mainDiagonals[mainDiagIdx] = false;
            antiDiagonals[antiDiagIdx] = false;
        }

        return solutions;
    }
}
