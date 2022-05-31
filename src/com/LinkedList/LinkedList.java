package com.LinkedList;


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
    public void display(ListNode head){
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
        }else{
            //while our pointer is not null
            while(null != current.next){
                //traverse till the end of the node
                current = current.next;
            }
            //let the pointer now point towards our new node
            current.next = newNode;
        }
    }
    //insert at the target position
    public void insertPosition(int position, int newData){
        ListNode newNode = new ListNode(newData);
        //if the list is null
        if(position == 1) {
            //the new node's pointer should now point our old head
            newNode.next = head;
            //the new node is the new head
            head = newNode;
        } else {
            //node at the end of linked list
            ListNode previous = head;
            int count = 1;
            //while the count traverses through to the end of the linked list
            while(count < position -1 ){
                //set a pointer at the end of our linked list
                previous = previous.next;
                count++;
            }
            // |previous|next| --> |current|next| --> ....
            ListNode current = previous.next;
            // |previous|next| --> |newNode|next| (not linked) |current|next| --> ...
            previous.next =  newNode;
            // |previous|next| --> |newNode|next| --> |current|next| ---> ...
            newNode.next = current;

        }
    }
    //delete the first element in the linked list
    public void deleteFirst(){
        if(head ==null){
            head = null;
        } else{
            //|temp|next|  |head|next|-->
            ListNode temp = head;
            //|temp|next| --> |head|next| -->
            head = head.next;
            //|temp|next| -> null |head|next| --> ...
            temp.next = null;
        }
    }
    //delete the last element in the linked list
    public void deleteLast(){
        if (head == null || head.next == null) {
            head = null;
        } else{
           ListNode current = head;
           ListNode previous = null;
           while(current.next != null){
               //update previous as the data
               previous = current;
               //and current as the next pointer of the previous node
               current =  current.next;
           }
           previous.next = null;
        }
    }

    public void deletePosition(int position) {
        if(position == 1){
            head = head.next;
        } else{
            ListNode previous = head;
            int count = 1;
            while (count < position -1){
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            //delete the node from the list
            previous.next = current.next;
        }
    }
    //search if a specific value is in one of the nodes of a linked list
    public boolean searchValue(ListNode head,int targetData){
        ListNode current = head;
        //loop until we find it
        while(current !=null){
            if(current.data == targetData){
                return true;
            }
            current = current.next;
        }
        return false;
    }
    //reverse a linked list
    public ListNode reverseLinkedList(ListNode head){
        ListNode current = head;
        ListNode previous = null;
        ListNode nextNode = null;
        //traverse through the list to then end
        if (head == null){
            return head;
        } else {
            while (current!= null){
                //|current|next| --> |nextNode|next|
                nextNode = current.next;
                // |current|next| --> null
                current.next = previous;
                //|previous|next| - the first node
                previous = current;
                // |current|next| - the next node
                current = nextNode;
                //the final linked list
                /// null <-- |previous|next| <-- |current|next| <-- |nextNode|next|
            }
            System.out.println(previous);
            return previous;
        }

    }
    //find the middle node in a linked list
    public ListNode getMiddleNode(ListNode head){
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        if(head == null){
            return head;
        } else{
            while(fastPtr !=null && fastPtr.next !=null ){
                slowPtr =slowPtr.next;
                //moving twice as fast as the slow pointer
                fastPtr = fastPtr.next.next;
            }
            return slowPtr;
        }
    }
    //find the nth node from the end of the linked list
    public ListNode getNthNode(int n){
        ListNode mainPtr = head;
        ListNode refPtr = head;
        int count = 0;

        if(n <0){
            throw new IllegalArgumentException("invalid value: n= " + n);
        }

        if(head == null){
            return head;
        } else {
            //first traverse to the list till we get to the target n value on the node
            while(count < n){
                if(refPtr == null){
                    throw  new IllegalArgumentException(n + " is greater than the number of nodes in the list");
                }
                refPtr = refPtr.next;
                count++;
            }
            //used to ensure the main pointer becomes our references pointer
            while (refPtr !=null){
                refPtr = refPtr.next;
                mainPtr = mainPtr.next;
            }
            return mainPtr;
        }
    }
    //remove duplicates from a sorted linked list
    public void removeDuplicates(){
        ListNode current = head;
        if(head == null){
            return ;
        }

        while(current != null && current.next != null){
            //if a duplicate, replace the next with its next, in essence delete the duplicate node
            if(current.data == current.next.data){
                current.next = current.next.next;
            } else{
                //if not the case, continue traversing through the linked list
                current = current.next;
            }
        }
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
        ListNode nineth = new ListNode( 24);
        ListNode ten = new ListNode(35);
        ListNode eleven = new ListNode(43);
        ListNode twelve = new ListNode(44);
        ListNode thirteen = new ListNode(44);
        ListNode fourteen = new ListNode(45);
        ListNode fifthteen  = new ListNode(46);
        ListNode sixteen = new ListNode(46);
        ListNode seventeen = new ListNode(48);
        ListNode eighteen = new ListNode(49);



        //connect the pointers
        l1.head.next = second; //|l1|next| --> |second|next|
        second.next = third; //|l1|next| --> |second|next| --> |third|next|
        third.next = fourth; //|l1|next| --> |second|next| --> |third|next|
        fourth.next = fifth; //|l1|next| --> |second|next| --> |third|next| --> |fourth|next|
        fifth.next = sixth; //|l1|next| --> |second|next| --> |third|next| --> |fourth|next| --> |fifth|next|
        sixth.next = seventh; //|l1|next| --> |second|next| --> |third|next| --> |fourth|next| --> |fifth|next| --> |sixth| next|
        seventh.next = eighth;//|l1|next| --> |second|next| --> |third|next| --> |fourth|next| --> |fifth|next| --> |sixth| next| --> |seventh|next|
        eighth.next = nineth; //|l1|next| --> |second|next| --> |third|next| --> |fourth|next| --> |fifth|next| --> |sixth| next| --> |seventh|next| --> |eight|next|--> null
        nineth.next = ten;
        ten.next = eleven;
        eleven.next = twelve;
        twelve.next = thirteen;
        thirteen.next = fourteen;
        fourteen.next = fifthteen;
        fifthteen.next = sixteen;
        sixteen.next = seventeen;
        seventeen.next = eighteen;


        //get linked list length
        //l1.linkedListLength();
        //insert a node at the start of the linked list
        l1.insertFirst(0);
        //insert a node at the end of a linked list
        l1.insertEnd(28);
        l1.insertEnd(35);
        l1.insertPosition(5, 7);
        //remove the first element
        l1.deleteFirst();
        //remove the last element
        l1.deleteLast();
        //insert at a specific position
        l1.deletePosition(10);
        //print linked list
        //l1.display();
        //search if a specific value is in one of the nodes in the linked list
        /*
        if(l1.searchValue(head, 25)){
            System.out.println("Key found");
        } else {
            System.out.println("key not found");
        }
        */


        //reverse a linked list
        //ListNode reversedList =  l1.reverseLinkedList(head);
        //System.out.println(reversedList);
        //remove duplicates
        l1.removeDuplicates();
        l1.display(head);
        //find middle node
        ListNode middleNode = l1.getMiddleNode(head);
        System.out.println("The middle node of the linked list: " + middleNode.data);
        //return the nth node in the list
        ListNode targetNode = l1.getNthNode(3);
        System.out.println("The nth node from the end of the linked list: " + targetNode.data);

    }
}
