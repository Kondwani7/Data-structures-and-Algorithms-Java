package com.LinkedList;

import com.company.Main;

import java.util.List;

//singly linked list
public class LinkedList {
    //declare a head
    private static ListNode head;
    private static class ListNode {
        final int data; //head of list
        private ListNode next; //pointer of list
        //data = integer, pointer = next
        public ListNode(int data) {
            this.data = data;//set to the data we insert
            this.next = null;// set to null
        }
    }
    //print the linked  list
    public void display(){
        //assigning a current node as the head of our list
        ListNode current = head;
        while(current != null) {
            System.out.println(current.data + "--> ");
            //ensuring that the current node traverses through each node until it reaches the node
            // last pointer = null
            current = current.next;
        }
        System.out.println("null");
    }
    //get length of a linked list
    public void linkedListLength(){
        int count = 0;
        ListNode current = head;
        while(current != null){
            count++;
            current = current.next;
        }
        System.out.println(count);
    }
    //insert new node at the head of the list
    public void insertFirst(int newData){
        //new node with data but points to null
        ListNode newNode = new ListNode(newData);
        //insert it behind the head by making the new node's pointer point to the old head
        newNode.next = head;
        //make the  head the new node;
        head = newNode;
    }
    //insert at the end of a linked list
    public void insertEnd(int newData){
        ListNode newNode = new ListNode(newData);
        ListNode current = head;
        //check of the list only has a head
        if(current == null){
            current.next = newNode;
            return;
        }else{
            //while our pointer is not null
            while(null != current.next){
                //traverse till the end of the node
                current = current.next;
            }
            //let the pointer now point towards our new node
            current.next = newNode;
        }
        //else if not empty
    }

    public static  void main (String [] args){
        //ensure the l1 list is of our linked list main class
        LinkedList l1 = new LinkedList();
        //insert the head and its data
        l1.head = new ListNode(2);
        //insert data for other nodes
        ListNode  second = new ListNode(4);
        ListNode third = new ListNode(6);
        ListNode fourth = new ListNode(8);
        ListNode fifth = new ListNode(10);
        ListNode sixth = new ListNode(13);
        ListNode seventh = new ListNode(17);
        ListNode eighth = new ListNode(22);
        //connect the pointers
        l1.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        seventh.next = eighth;

        //get linked list length
        //l1.linkedListLength();
        //insert a node at the start of the linked list
        l1.insertFirst(0);
        l1.insertFirst(1);
        //insert a node at the end of a linked list
        l1.insertEnd(28);
        //print linked list
        l1.display();

    }
}
