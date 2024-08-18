package com.lorenzhoerb.leetcode.linkedlist;

/**
 * 2. Add Two Numbers
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        // 82 + 39 = 121
        //82
        //39
        //1
        ListNode a = addTwoNumbers(new ListNode(2, new ListNode(8)), new ListNode(9, new ListNode(3)));
        System.out.println("A");
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode end = dummy;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;
            int newVal = l1Val + l2Val + carry;
            carry = newVal / 10;
            int digit = newVal % 10;
            end.next = new ListNode(digit);
            end = end.next;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(carry != 0) {
            end.next = new ListNode(carry);
        }

        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


}
