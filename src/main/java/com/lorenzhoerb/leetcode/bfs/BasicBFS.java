package com.lorenzhoerb.leetcode.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BasicBFS {
    public static void main(String[] args) {
        Node n1 = new Node(1, null, null);
        Node n2 = new Node(2, n1, null);
        Node n3 = new Node(3, n2, null);
        n1.left = n2;


        System.out.println(findDFS(n1, 2));
    }

    public static Node findDFS(Node tree, int target) {
        return findDFS(tree, target, new HashSet<>());
    }

    public static Node findDFS(Node n, int target, Set<Node> visited) {
        if (n == null || visited.contains(n)) return null;
        if (n.value == target) return n;
        visited.add(n);  // Mark node as visited
        Node left = findDFS(n.left, target, visited);
        if (left != null) return left;
        return findDFS(n.right, target, visited);  // Simplified return
    }

    public static Node findBFS(Node tree, int target) {
        if (tree == null) return null;
        Queue<Node> frontier = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        frontier.add(tree);
        while (!frontier.isEmpty()) {
            Node n = frontier.poll();
            visited.add(n);
            if (n.value == target) return n;
            if (n.left != null && !visited.contains(n.left)) frontier.add(n.left);
            if (n.right != null && !visited.contains(n.right)) frontier.add(n.right);
        }

        return null;
    }

    public static boolean hasCycle(Node tree) {
        if (tree == null) return false;
        Queue<Node> frontier = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        frontier.add(tree);
        while (!frontier.isEmpty()) {
            Node n = frontier.poll();
            if (visited.contains(n)) return true;
            visited.add(n);
            if (n.left != null) frontier.add(n.left);
            if (n.right != null) frontier.add(n.right);
        }

        return false;
    }

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }


        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
}
