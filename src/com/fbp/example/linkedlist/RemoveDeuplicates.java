package com.fbp.example.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class RemoveDeuplicates {
    //Definition for singly-linked list.
    static class ListNode {
        public int val;

        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        public ListNode setNext(ListNode next) {
            this.next = next;
            return next;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(33);
        node.setNext(new ListNode(22)).setNext(new ListNode(22)).setNext(new ListNode(55));

        node = removeDuplicates(node);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    public static ListNode deleteDuplicates(ListNode root) {
        if (root == null)
            return root;

        ListNode slowPtr = null;
        ListNode fastPtr = null;
        ListNode tempPtr = null;
        ListNode anotherPtr = null;
        boolean didSwapHappened = false;

        for (anotherPtr = null, fastPtr = root; fastPtr != null; ) {
            slowPtr = fastPtr;
            tempPtr = fastPtr;
            anotherPtr = fastPtr;
            while (tempPtr.next != null) {
                tempPtr = tempPtr.next;
                if (slowPtr.val == tempPtr.val) {
                    slowPtr.next = tempPtr.next;
                    didSwapHappened = true;
                }
            }
            fastPtr = fastPtr.next;
            if (fastPtr != null)
                if (didSwapHappened) {
                    anotherPtr.next = fastPtr.next;
                }
        }

        return root;
    }

    public static ListNode removeDuplicates(ListNode root) {
        if (root == null || root.next == null)
            return root;

        Set<Integer> set = new HashSet<>();
        set.add(root.val);

        ListNode nxtToNxt = null;
        ListNode temp = root;
        while (temp.next != null) {
            int val = root.next.val;
            if (!set.add(val)) {
                nxtToNxt = temp.next.next;
                temp.next = nxtToNxt;
            }

            temp = temp.next;
        }

        return root;
    }

}
