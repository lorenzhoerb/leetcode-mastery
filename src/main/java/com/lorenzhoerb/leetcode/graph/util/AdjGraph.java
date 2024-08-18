package com.lorenzhoerb.leetcode.graph.util;

import java.util.ArrayList;
import java.util.List;

public class AdjGraph implements Graph<Integer> {

    private final boolean[][] adj;

    public AdjGraph(boolean[][] adj) {
        this.adj = adj;
    }

    @Override
    public List<Integer> getNeighbors(Integer node) {
        List<Integer> neighbors = new ArrayList<>();
        for (int i = 0; i < nodes(); i++) {
            if (adj[node][i]) neighbors.add(i);
        }
        return neighbors;
    }

    @Override
    public int positiveDegree(Integer node) {
        return 0;
    }

    @Override
    public int negativeDegree(Integer node) {
        return 0;
    }

    @Override
    public int degree(Integer node) {
        return 0;
    }

    @Override
    public List<Integer> getNodes() {
        List<Integer> nodes = new ArrayList<>();
        for (int i = 0; i < nodes(); i++) {
            nodes.add(i);
        }
        return nodes;
    }

    @Override
    public int nodes() {
        return adj.length;
    }
}
