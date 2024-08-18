package com.lorenzhoerb.leetcode.treetraversal;

public class TreeTraversal {

    public static void main(String[] args) {
        Node root = new Node(5, new Node(4, new Node(3), null), new Node(6));
        postOrder(root);
    }

    /**
     * Used for binary trees to get tree in order.
     * @param root
     */
    public static void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    /**
     * Used to copy array
     */
    public static void preOrder(Node root) {
        if (root == null) return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void postOrder(Node root) {
        if (root == null) return;
        preOrder(root.left);
        preOrder(root.right);
        System.out.println(root.val);
    }




    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public Node(int val) {
            this.val = val;
        }

        public Node() {
        }
    }
}
