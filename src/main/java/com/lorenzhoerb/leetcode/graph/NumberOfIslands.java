package com.lorenzhoerb.leetcode.graph;


/**
 * 200. Number of Islands
 * <p>
 * Given an m x n 2D binary grid grid which represents
 * a map of '1's (land) and '0's (water), return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by
 * connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands {

    public static final char LAND = '1';

    public static void main(String[] args) {
        char[][] array = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(array));

    }

    public static int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        int numberOfIslands = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                char tile = grid[y][x];
                if (tile == LAND && !visited[y][x]) {
                    numberOfIslands++;
                    visitIsland(grid, visited, x, y);
                }
            }
        }

        return numberOfIslands;
    }

    private static void visitIsland(char[][] grid, boolean[][] visited, int x, int y) {
        if (x < 0 || x >= grid[0].length || y < 0
                || y >= grid.length || visited[y][x]
                || grid[y][x] != LAND) return;
        visited[y][x] = true;
        visitIsland(grid, visited, x - 1, y);
        visitIsland(grid, visited, x + 1, y);
        visitIsland(grid, visited, x, y - 1);
        visitIsland(grid, visited, x, y + 1);
    }
}
