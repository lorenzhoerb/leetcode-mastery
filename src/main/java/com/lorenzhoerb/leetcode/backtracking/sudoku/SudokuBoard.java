package com.lorenzhoerb.leetcode.backtracking.sudoku;

import java.util.HashSet;
import java.util.Set;

public class SudokuBoard {
    private static final int BOARD_SIZE = 9;
    private Integer[][] board;

    public SudokuBoard() {
        this.board = new Integer[BOARD_SIZE][BOARD_SIZE];
    }

    public SudokuBoard(Integer[][] board) {
        this.board = board;
    }

    public void set(int x, int y, Integer value) {
        validateBoardSize(x, y);
        board[y][x] = value;
    }

    public Integer get(int x, int y) {
        validateBoardSize(x, y);
        return board[y][x];
    }

    public boolean isValid() {
        return areRowsValid() && areColumnsValid() && areSubgridsValid();
    }

    private boolean areRowsValid() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < BOARD_SIZE; j++) {
                Integer value = board[i][j];
                if (value != null && !rowSet.add(value)) {
                    return false; // Duplicate found in row
                }
            }
        }
        return true;
    }

    private boolean areColumnsValid() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < BOARD_SIZE; j++) {
                Integer value = board[j][i];
                if (value != null && !colSet.add(value)) {
                    return false; // Duplicate found in column
                }
            }
        }
        return true;
    }

    private boolean areSubgridsValid() {
        for (int row = 0; row < BOARD_SIZE; row += 3) {
            for (int col = 0; col < BOARD_SIZE; col += 3) {
                if (!isSubgridValid(row, col)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSubgridValid(int startRow, int startCol) {
        Set<Integer> subgridSet = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Integer value = board[startRow + i][startCol + j];
                if (value != null && !subgridSet.add(value)) {
                    return false; // Duplicate found in 3x3 subgrid
                }
            }
        }
        return true;
    }

    private static void validateBoardSize(int x, int y) {
        if (x < 0 || x >= BOARD_SIZE || y < 0 || y >= BOARD_SIZE) {
            throw new RuntimeException("Invalid board field (x: " + x + ", y: " + y + ")");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < board.length; i++) {
            if (i > 0 && i % 3 == 0) {
                sb.append("-----------\n");
            }

            for (int j = 0; j < board[i].length; j++) {
                if (j > 0 && j % 3 == 0) {
                    sb.append("|");
                }

                Integer cell = board[i][j];
                if (cell == null) {
                    sb.append('#');
                } else {
                    sb.append(cell);
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
