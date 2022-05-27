package com.LinkedList;

public class LinkedList {
    //generic Linked list
    private  ListNode head; //head of the list
    public static void main (String [] args) {
        System.out.println("linked list implementation");
    }
    private static class ListNode{
        private int data; // generic data type
        private ListNode next;//its pointer to the next item on the list
        //getter
        public ListNode(int data){
            this.data = data;
            this.next = null; //the list only one has element so it only points to null
        }
    }
}
