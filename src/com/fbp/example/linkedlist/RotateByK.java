package com.fbp.example.linkedlist;

/**
 * Created by rajeevranganathan
 */
public class RotateByK {
    //   Definition for singly-linked list.
    static class ListNode {
        public int val;
        public RotateByK.ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        public RotateByK.ListNode setNext(RotateByK.ListNode node) {
            next = node;
            return node;
        }
    }

    private static ListNode rotateByk(ListNode a, int b) {
        ListNode head = a;
        int k = b;

        if (head == null || k <= 0)
            return head;

        int len = findLength(a);
        k = k % len;
        if (k == 0)
            return head; //one cycle
        ListNode p = head;
        ListNode q = head;

        while (k != 0) {
            p = p.next;
            k--;
        }

        while (p.next != null) {
            q = q.next;
            p = p.next;
        }

        p.next = head;
        head = q.next;
        q.next = null;

        return head;
    }

    private static int findLength(ListNode a) {
        int count = 1;
        while (a != null) {
            a = a.next;
            count++;
        }

        return count;
    }
}
