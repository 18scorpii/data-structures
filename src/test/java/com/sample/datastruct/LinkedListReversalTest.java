package com.sample.datastruct;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LinkedListReversalTest {
    @Test
    public void testReversalOfSingleLInkedList(){
        Integer[] arr = {3,1,5,4,8};
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        List<SingleLinkedList.Node> nodeList = Arrays.asList(arr).stream().map(p->new SingleLinkedList.Node(p.intValue())).collect(Collectors.toList());
        for(SingleLinkedList.Node node : nodeList){
            singleLinkedList.add(node);
            System.out.print(node+"\t");
        }
        System.out.println();

        SingleLinkedListReversal singleLinkedListReversal = new SingleLinkedListReversal();
        SingleLinkedList.Node reversedHead = singleLinkedListReversal.reverse(singleLinkedList.getHead());
        while(reversedHead != null){
            System.out.print(reversedHead+"\t");
            reversedHead = reversedHead.getNext();
        }
        System.out.println();
    }

    @Test
    public void testReversalOfDoubleLInkedList(){
        Integer[] arr = {3,1,5,4,8};
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        List<DoubleLinkedList.Node> nodeList = Arrays.asList(arr).stream().map(p->new DoubleLinkedList.Node(p.intValue())).collect(Collectors.toList());
        for(DoubleLinkedList.Node node : nodeList){
            doubleLinkedList.add(node);
            System.out.print(node+"\t");
        }
        System.out.println();

        DoubleLinkedListReversal doubleLinkedListReversal = new DoubleLinkedListReversal();
        DoubleLinkedList.Node reversedHead = doubleLinkedListReversal.reverse(doubleLinkedList.getHead());
        while(reversedHead != null){
            System.out.print(reversedHead+"\t");
            reversedHead = reversedHead.getNext();
        }
        System.out.println();
        /*
        After its reversed, taking the head again (which will be the original tail)
        Now when doing previous, we will see the original LinkedList sequence,
        Provided the LINKs are setup properly.
         */
        DoubleLinkedList.Node reversedTail = doubleLinkedList.getHead();
        while(reversedTail != null){
            System.out.print(reversedTail+"\t");
            reversedTail = reversedTail.getPrevious();
        }
    }
}
