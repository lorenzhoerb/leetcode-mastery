package com.lorenzhoerb.leetcode.backtracking.sudoku;

public class Solver implements SudokuSolver {
    @Override
    public boolean solve(SudokuBoard board) {
        return solve(board, 0, 0);
    }

    private boolean solve(SudokuBoard board, int x, int y) {
        // if reached last row, a solution was found
        if (y == 9) return true;

        // if reached last column, go to next row
        if (x == 9) return solve(board, 0, y + 1);

        // if field is already filled out, got to the next one
        if (board.get(x, y) != null) return solve(board, x + 1, y);

        for (int value = 1; value <= 9; value++) {
            board.set(x, y, value);
            if (board.isValid()) {
                if (solve(board, x + 1, y)) {
                    return true;
                }
            }
        }

        // no solution was found
        board.set(x, y, null);

        return false;
    }
}
