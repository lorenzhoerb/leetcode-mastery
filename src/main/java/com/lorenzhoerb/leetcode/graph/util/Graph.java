package com.lorenzhoerb.leetcode.graph.util;

import java.util.List;

public interface Graph<T> {
    List<T> getNodes();
    int nodes();
    List<T> getNeighbors(T node);
    int positiveDegree(T node);
    int negativeDegree(T node);
    int degree(T node);
}
