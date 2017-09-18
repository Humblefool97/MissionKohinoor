package com.fbp.example.linkedlist;

/**
 * Created by rajeevranganathan on 18/09/17 for MissionKohinoor.
 */
public class Driver {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1, MyLinkedList.position.APPEND);
        list.add(2, MyLinkedList.position.APPEND);

        //  list.print();
        list.add(0, MyLinkedList.position.PREPEND);
        //    list.print();
        list.add(3, MyLinkedList.position.MIDDLE);
        list.print();
        list.add(3, MyLinkedList.position.MIDDLE);
        list.add(3, MyLinkedList.position.MIDDLE);
        list.add(3, MyLinkedList.position.MIDDLE);
        list.print();

        list.removeDups();
        list.print();
//        list.add(2, MyLinkedList.position.APPEND);
//        list.add(2, MyLinkedList.position.APPEND);
//
//        list.print();
//        list.removeDups();
//        list.print();


    }
}
