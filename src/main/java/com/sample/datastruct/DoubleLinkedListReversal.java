package com.sample.datastruct;

public class DoubleLinkedListReversal {
    DoubleLinkedList.Node reverse(DoubleLinkedList.Node current){
        DoubleLinkedList.Node next = null;
        DoubleLinkedList.Node previous = null;
        while(current != null){
            next = current.getNext();
            current.setNext(previous);
            current.setPrevious(next);
            previous = current;
            current = next;
        }
        return previous;
    }
}
