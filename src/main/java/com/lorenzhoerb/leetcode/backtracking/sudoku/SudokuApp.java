package com.lorenzhoerb.leetcode.backtracking.sudoku;

public class SudokuApp {
    public static void main(String[] args) {
        SudokuBoard board = new SudokuBoard(new Integer[][]{
                {8, null, null, 4, 1, null, 9, null, null},
                {null, 2, null, null, null, null, 1, null, 5},
                {null, 6, null, null, 2, null, null, 7, 4},
                {4, null, null, null, 7, null, null, null, null},
                {null, 5, 2, null, null, null, null, 4, null},
                {null, 1, null, 5, null, 9, null, null, 7},
                {null, null, null, null, null, 4, null, null, 3},
                {null, null, null, null, null, 6, null, 1, null},
                {2, null, 8, null, 5, 7, 4, 9, null}
        });
        System.out.println("--- Before --- ");
        System.out.println(board);
        SudokuSolver solver = new Solver();
        boolean solved = solver.solve(board);
        System.out.println("--- After --- ");
        System.out.println(board);
    }
}
