package com.sample.datastruct;

public class SingleLinkedListMiddleElement {
    int findMiddleElementOnCustomLinkedListWithSinglePass(SingleLinkedList singleLinkedList){
        SingleLinkedList.Node middle = singleLinkedList.getHead();
        SingleLinkedList.Node current = singleLinkedList.getHead();
        int length = 0;
        while(current.getNext() != null){
            length++;
            if(length % 2 == 0){
                middle = middle.getNext();
            }
            current = current.getNext();
        }
        return middle != null? middle.getData():-1;
    }
}
