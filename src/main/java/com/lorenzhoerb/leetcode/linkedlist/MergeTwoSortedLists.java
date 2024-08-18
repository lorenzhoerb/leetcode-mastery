package com.lorenzhoerb.leetcode.linkedlist;

/**
 * 21. Merge Two Sorted Lists
 * <p>
 * You are given the heads of two sorted linked lists list1 and list2.
 * <p>
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Return the head of the merged linked list.
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4))), new ListNode(1, new ListNode(3, new ListNode(4))));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode start = null;
        ListNode end = null;
        ListNode p1 = list1;
        ListNode p2= list2;

        while (p1 != null || p2 != null) {
            ListNode toAdd;
            if(p1 == null) {
               toAdd = p2;
               p2 = p2.next;
            } else if(p2 == null) {
                toAdd = p1;
                p1 = p1.next;
            } else {
                if(p1.val <= p2.val) {
                   toAdd = p1;
                   p1 = p1.next;
                } else {
                    toAdd = p2;
                    p2 = p2.next;
                }
            }

            if(start == null) {
                start = toAdd;
            }
            if(end == null)  {
                end = toAdd;
            } else{
                end.next = toAdd;
                end = end.next;
            }
        }

        return start;
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
