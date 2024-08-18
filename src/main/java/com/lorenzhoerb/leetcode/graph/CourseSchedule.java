package com.lorenzhoerb.leetcode.graph;

import java.util.HashSet;

/**
 * 207. Course Schedule
 * <p>
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 * <p>
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 */
public class CourseSchedule {
    public static void main(String[] args) {
        System.out.println(canFinish(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}}));

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        //[a][b] has 'a' prerequisite 'b'
        boolean[][] adj = new boolean[numCourses][numCourses];
        boolean[] visited = new boolean[numCourses];
        boolean[] inStack = new boolean[numCourses];
        for (int[] pre : prerequisites) {
            adj[pre[0]][pre[1]] = true;
        }
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(adj, i, visited, inStack)) return false;
        }
        return true;
    }

    public static boolean hasCycle(boolean[][] adj, int node, boolean[] visited, boolean[] inStack) {
        if (inStack[node]) return true;
        if (visited[node]) return false;

        visited[node] = true;
        inStack[node] = true;

        for (int i = 0; i < adj.length; i++) {
            if (adj[node][i]) {
                if (hasCycle(adj, i, visited, inStack)) return true;
            }
        }

        inStack[node] = false;

        return false;
    }

}
