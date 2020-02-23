package com.sample.datastruct;

/*
Queue:
    A queue is an ordered list of elements.
    It always works in first in first out(FIFO) fashion.
    All the elements get inserted at the REAR and removed from the FRONT of the queue.
    Queue is a collection of one or more elements arranged in memory in a contiguous fashion
LinkedList:
    A linked list is also an ordered list of elements.
    You can add an element anywhere in the list, change an element anywhere in the list, or remove an element from any position in the list
    A linked list is a collection of one or more elements arranged in memory in a dis-contiguous fashion

Java LinkedList implements Queue and Dequeue (Double Ended Queue Interface) - so it can work as a Stack or Queue)
 */
public class SingleLinkedList {
    private Node head, tail;
    private int length;
    SingleLinkedList(){
        head = tail = null;
        length = 0;
    }
    //always added to the rear
    void add(Node node){
        if(node != null){
            if(head == null){
                head = tail = node;
            }
            tail.setNext(node);
            tail = node;
            length++;
        }
    }
    int size(){
        return length;
    }
    Node getHead(){
        return head;
    }
    Node getTail(){
        return tail;
    }
    //always removed from the head
    Node remove(){
        Node removedNode = head;
        if(removedNode != null) {
            head = removedNode.getNext();
            removedNode.setNext(null);
            length--;
        }
        return removedNode;

    }
    static class Node{
        private int data;
        private Node next;
        Node(int data){
            this.data = data;
        }
        void setNext(Node node){
            this.next = node;
        }
        Node getNext(){
            return this.next;
        }
        int getData(){
            return data;
        }
        @Override
        public String toString(){
            return String.valueOf(data);
        }
    }
}

