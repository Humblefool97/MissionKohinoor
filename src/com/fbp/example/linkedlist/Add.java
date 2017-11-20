package com.fbp.example.linkedlist;

/**
 * Created by rajeevranganathan
 */
public class Add {
    //   Definition for singly-linked list.
    static class ListNode {
        public int val;
        public Add.ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        public Add.ListNode setNext(Add.ListNode node) {
            next = node;
            return node;
        }
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(7).setNext(new ListNode(6)).setNext(new ListNode(8));
        ListNode b = new ListNode(9).setNext(new ListNode(5)).setNext(new ListNode(4));

        ListNode res = addTwoNumbers(a, b);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }

    public static ListNode addTwoNumbers(ListNode a, ListNode b) {
        ListNode node, prev = null, head = null;
        int sum = 0, carry = 0;

        //a = 7->6->8;b=9->5->4
        //768+954= 1722
        while (a != null || b != null || carry != 0) {
            node = new ListNode(0);
            sum = carry;//1

            //first time
            if (head == null)
                head = node;

            //always be one node before node
            if (prev != null)
                prev.next = node;//6->2->0->NULL

            //Traverse A
            if (a != null) {
                sum += a.val; //9
                a = a.next;  //null
            }

            //Traverse B
            if (b != null) {
                sum += b.val;//13
                b = b.next;//null
            }

            //Store w/o  carry
            node.val = sum % 10; //3->NULL
            //Get carry
            sum /= 10; //1

            carry = sum;//1

            prev = node;//6->2->3->NULL

        }
        return head;
    }


}
