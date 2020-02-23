package com.sample.datastruct;

public class DoubleLinkedList {
    private Node head;
    private Node tail;
    private int length;
    DoubleLinkedList(){
        this.head = this.tail = null;
    }
    /*
    Always new items are added to the tail
     */
    void add(Node node){
        if(node != null){
            if(head == null){
                head = tail = node;
            }
            length++;
            tail.setNext(node);
            node.setPrevious(tail);
            tail = node;
        }
    }
    /*
    Always old items are added from the head
     */
    Node remove(){
        Node removedNode = head;
        if(removedNode != null){
            head = removedNode.next;
            removedNode.setNext(null);
            head.setPrevious(null);
            length--;
        }
        return removedNode;
    }
    int size(){
        return length;
    }
    Node getHead(){
        return this.head;
    }
    Node getTail(){
        return this.tail;
    }
    static class Node {
        private Node next;
        private Node previous;
        private int data;

        Node(int data){
            this.data = data;
            this.next = this.previous = null;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }
}
