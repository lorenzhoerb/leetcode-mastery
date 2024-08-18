package com.lorenzhoerb.leetcode.graph;

import java.util.*;

/**
 * 133. Clone Graph
 * <p>
 * Given a reference of a node in a connected undirected graph.
 * <p>
 * Return a deep copy (clone) of the graph.
 * <p>
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 * <p>
 * class Node {
 * public int val;
 * public List<Node> neighbors;
 * }
 * <p>
 * <p>
 * Test case format:
 * <p>
 * For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with val == 1, the second node with val == 2, and so on. The graph is represented in the test case using an adjacency list.
 * <p>
 * An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.
 * <p>
 * The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.
 */
public class CloneGraph {

    public static void main(String[] args) {

    }

    public static Node cloneGraph(Node node) {
        if (node == null) return null;
        HashMap<Node, Node>  nodeMap = new HashMap<>();
        return clone(node, nodeMap);
    }

    private static Node clone(Node node, HashMap<Node, Node> nodeMap) {
        if (nodeMap.containsKey(node)) return nodeMap.get(node);

        Node copy = new Node(node.val);
        nodeMap.put(node, copy);

        for (Node child : node.neighbors) {
            copy.neighbors.add(clone(child, nodeMap));
        }

        return copy;
    }

    public static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


}
