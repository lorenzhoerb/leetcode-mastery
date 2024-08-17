package com.lorenzhoerb.leetcode.binarytreebfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. Binary Tree Right Side View
 * <p>
 * Given the root of a binary tree, imagine yourself standing on the right
 * side of it, return the values of the nodes you can see ordered from top to bottom.
 */
public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        List<Integer> result = rightSideView(
                new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)))
        );
        System.out.println(result.toString());
    }

    public static List<Integer> rightSideView(TreeNode root) {
        Queue<QueueNode> frontier = new LinkedList<>();
        List<Integer> results = new ArrayList<>();
        frontier.add(new QueueNode(root, 0));
        while (!frontier.isEmpty()) {
            QueueNode node = frontier.poll();
            if(node == null || node.node == null) continue;
            if (node.node.right != null) frontier.add(new QueueNode(node.node.right, node.level + 1));
            if (node.node.left != null) frontier.add(new QueueNode(node.node.left, node.level + 1));
            if (node.level == results.size()) results.add(node.level, node.node.val);
        }
        return results;
    }

    public static class QueueNode {
        TreeNode node;
        int level;

        public QueueNode(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
