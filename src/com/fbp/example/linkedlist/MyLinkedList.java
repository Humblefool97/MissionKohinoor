package com.fbp.example.linkedlist;

/**
 * Created by rajeevranganathan on 18/09/17 for MissionKohinoor.
 */
public class MyLinkedList<T> {
    Node<T> root;
    int size;

    enum position {
        APPEND,
        PREPEND,
        MIDDLE,
        RANDOM
    }

    public void add(T data, position where) {
        switch (where) {
            case APPEND:
                handleAppendNode(data);
                break;
            case RANDOM:
                break;
            case PREPEND:
                handlePrependNode(data);
                break;
            case MIDDLE:
                handleInsertMiddle(data);
                break;
        }
    }

    private void handleInsertMiddle(T data) {
        Node<T> node = new Node<>(data);
        if (root == null) {
            root = node;
            return;
        }

        Node<T> slowPtr = root;
        Node<T> fastPtr = root;
        while (fastPtr!=null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        node.next = slowPtr.next;
        slowPtr.next = node;
    }

    /**
     * Append mode
     *
     * @param data
     */

    private void handleAppendNode(T data) {
        Node<T> node = new Node<>(data);
        if (root == null) {
            root = node;
            return;
        }
        Node<T> tempNode = root;
        while (tempNode.getNext() != null) {
            tempNode = tempNode.getNext();
        }

        tempNode.setNext(node);
    }

    /**
     * Insert node in the beginning of the list
     *
     * @param data
     */
    private void handlePrependNode(T data) {
        Node<T> node = new Node<>(data);
        if (root == null) {
            root = node;
            return;
        }
        node.next = root;
        root = node;
    }

    public void print() {
        if (root == null)
            System.out.println("Empty list");

        Node<T> node = root;
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    /**
     * naive way of removing duplicate nodes from a ll
     */
    public void removeDups() {
        if (root == null)
            throw new IllegalStateException("Can't operate on a null list");

        Node<T> slowPtr = null;
        Node<T> fastPtr = null;
        Node<T> tempPtr = null;

        for (fastPtr = root; fastPtr != null; ) {
            slowPtr = fastPtr;
            tempPtr = fastPtr;

            while (tempPtr.next != null) {
                tempPtr = tempPtr.next;
                if (slowPtr.data == tempPtr.data) {
                    slowPtr.next = tempPtr.next;
                }
            }
            fastPtr = fastPtr.next;
        }

    }
}
