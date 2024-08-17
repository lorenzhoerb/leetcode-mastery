package com.lorenzhoerb.leetcode.graph;

public class Cycle {

    static class Node {
        Node next;

        public Node() {
        }

        public Node(Node next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node m = new Node();
        Node n = new Node(new Node(new Node(new Node(m))));
        m.next = n;
        System.out.println(hasCycle(m));

    }

    public static boolean hasCycle(Node tree) {
        if (tree == null) return false;
        Node slow = tree;
        Node fast = tree.next;
        do {
            if (slow == fast) return true;
            slow = slow.next;
            if (fast != null && fast.next != null) fast = fast.next;
            if (fast != null && fast.next != null) fast = fast.next;
        } while (slow != null && fast != null);

        return false;
    }

}
