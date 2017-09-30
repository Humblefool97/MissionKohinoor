package com.fbp.example.linkedlist;

import java.util.List;

public class RemoveNthNode {
    //   Definition for singly-linked list.
    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node = removeNthFromEnd(node, 2);
        print(node);
    }

    public static ListNode removeNthFromEnd(ListNode a, int b) {
        int counter = b;
        ListNode fast = a;
        ListNode slow = null;
        ListNode slower = null;

        while (counter != 0 && fast != null) {
            fast = fast.next;
            counter--;
        }

        if (fast == null)
            return a;
        slow = a;
        while (fast.next != null) {
            slower = slow;
            fast = fast.next;
            slow = slow.next;
        }

        slower.next = slow.next;

        return a;
    }

    private static void print(ListNode a) {
        while (a != null) {
            System.out.println(a.val);
            a = a.next;
        }
    }

}
