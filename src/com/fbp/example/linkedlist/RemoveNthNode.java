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

        public ListNode setNext(ListNode node) {
            next = node;
            return node;
        }
    }

    public static void main(String[] args) {
        //20 380 349 322 389
        //424 429 120 64 691 677
        // 58 327 631 916 203 484
        // 918 596 252 509 644 33
        // 460
        ListNode node = new ListNode(20);
        node.setNext(new ListNode(380))
                .setNext(new ListNode(349))
                .setNext(new ListNode(322))
                .setNext(new ListNode(389))
                .setNext(new ListNode(424))
                .setNext(new ListNode(429))
                .setNext(new ListNode(120))
                .setNext(new ListNode(64))
                .setNext(new ListNode(691))
                .setNext(new ListNode(677))
                .setNext(new ListNode(58))
                .setNext(new ListNode(327)).setNext(new ListNode(631)).setNext(new ListNode(916))
                .setNext(new ListNode(203)).setNext(new ListNode(484)).setNext(new ListNode(918))
                .setNext(new ListNode(596)).setNext(new ListNode(252)).setNext(new ListNode(509))
                .setNext(new ListNode(644)).setNext(new ListNode(33)).setNext(new ListNode(460));

        node = removeNthFromEnd(node, 82);
        print(node);
    }

    public static ListNode removeNthFromEnd(ListNode a, int b) {
        ListNode fast = a;
        ListNode slow = null;
        ListNode slower = null;
        if (b == findLength(a))
            return null;

        while (b >= 0) {
            fast = a;
            while (b != 0 && fast.next != null) {
                fast = fast.next;
                b--;
            }
            b--;
        }


        slow = a;
        while (fast.next != null) {
            slower = slow;
            fast = fast.next;
            slow = slow.next;
        }

        if (slower == null) {
            return null;
        } else {
            slower.next = slow.next;
        }

        return a;
    }

    private static void print(ListNode a) {
        while (a != null) {
            System.out.println(a.val);
            a = a.next;
        }
    }

    private static int findLength(ListNode a) {
        if (a != null) {
            int counter = 1;
            while (a.next != null) {
                a = a.next;
                counter++;
            }
            return counter;
        }
        return 0;
    }

}
