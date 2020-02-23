package com.sample.datastruct;

public class SingleLinkedListReversal {
    /*
    By providing the head of a singly linked list, we can get all its next elements
    The problem is to reverse this chaining from last to first
     */
    SingleLinkedList.Node reverse(SingleLinkedList.Node current){
        //since each elements connection is going to be erased and recreated in the other direction
        //we need to maintain that info in temporary variables called next and previous
        SingleLinkedList.Node next = null;
        SingleLinkedList.Node previous = null;
        while(current != null){
            //capture the forward connection into the 'next' variable
            next = current.getNext();
            //set that it to a backward connection, for first iteration it will be null,
            // but that's alright as the last element will have null for next connection
            current.setNext(previous);
            //capture the current pointer as the new backward reference that's useful for next iteration
            previous = current;
            //move the pointer from current to next so we can go into another loop
            current = next;
        }
        return previous;
    }
}
