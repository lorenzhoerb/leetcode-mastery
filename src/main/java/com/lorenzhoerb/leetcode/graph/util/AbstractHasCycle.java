package com.lorenzhoerb.leetcode.graph.util;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class AbstractHasCycle {

    public static void main(String[] args) {
        boolean[][] adj = new boolean[][]{
                {false, true, false},
                {true, false, true},
                {false, false, false},
        };
        Graph<Integer> graph = new AdjGraph(adj);
        System.out.println(hasCycle(graph));
    }

    public static <T> boolean hasCycle(Graph<T> graph) {
        Set<T> visited = new HashSet<>();
        Stack<T> inStack = new Stack<>();
        for (T node : graph.getNodes())
            if (hasCycle(graph, node, visited, inStack)) return true;
        return false;
    }

    public static <T> boolean hasCycle(Graph<T> graph, T node, Set<T> visited, Stack<T> inSTack) {
        if (inSTack.contains(node)) return true;
        if (visited.contains(node)) return false;

        visited.add(node);
        inSTack.push(node);

        for (T neighbor : graph.getNeighbors(node)) {
            if (hasCycle(graph, neighbor, visited, inSTack)) return true;
        }

        inSTack.pop();

        return false;
    }
}
