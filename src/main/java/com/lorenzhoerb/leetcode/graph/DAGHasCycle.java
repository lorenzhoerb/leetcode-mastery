package com.lorenzhoerb.leetcode.graph;

public class DAGHasCycle {

    public static void main(String[] args) {
        boolean[][] adj = new boolean[][]{
                {false, true, false},
                {false, false, true},
                {false, false, false},
        };
        System.out.println(hasCycle(adj));
    }

    public static boolean hasCycle(boolean[][] adj) {
        int n = adj.length;
        boolean[] visited = new boolean[n];
        boolean[] inStack = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (hasCycle(adj, i, visited, inStack)) return true;
        }
        return false;
    }

    public static boolean hasCycle(boolean[][] adj, int node, boolean[] visited, boolean[] inStack) {
        if (inStack[node]) return true;
        if (visited[node]) return false;

        visited[node] = true;
        inStack[node] = true;

        for (int i = 0; i < adj.length; i++) {
            if (adj[node][i] && hasCycle(adj, i, visited, inStack)) return true;
        }

        inStack[node] = false;

        return false;
    }

}
