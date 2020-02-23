package com.sample.datastruct;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LinkedListTest {
    @Test
    public void testCustomLinkedListForEntries(){
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        List<SingleLinkedList.Node> nodeList = IntStream.range(10,110)
                .map(p->(int)(Math.random()*p))
                .mapToObj(p->new SingleLinkedList.Node(p))
                .collect(Collectors.toList());
        for(SingleLinkedList.Node node : nodeList){
            singleLinkedList.add(node);
            System.out.println(node);
        }
        MatcherAssert.assertThat("Verify linked list has all items", singleLinkedList.size(), Matchers.is(100));
    }

    @Test
    public void testAdditionAndRemovalOfNodesInTheSingleinkedList(){
        Integer[] arr = new Integer[]{2,32,233,34,345,545,6,55,767,88,83,321,22,4,654};
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        List<SingleLinkedList.Node> nodeList = Arrays.asList(arr).stream().map(p->new SingleLinkedList.Node(p.intValue())).collect(Collectors.toList());
        for(SingleLinkedList.Node node : nodeList){
            singleLinkedList.add(node);
        }
        MatcherAssert.assertThat("Verify Length", singleLinkedList.size() == 15);
        MatcherAssert.assertThat("Verify Head", singleLinkedList.getHead().getData() == 2);
        MatcherAssert.assertThat("Verify Tail", singleLinkedList.getTail().getData() == 654);
        MatcherAssert.assertThat("Verify Removal", singleLinkedList.remove().getData() == 2);
        MatcherAssert.assertThat("Verify Head", singleLinkedList.getHead().getData() == 32);
        MatcherAssert.assertThat("Verify Length", singleLinkedList.size() == 14);
    }

    @Test
    public void testAdditionAndRemovalOfNodesInTheDoubleLinkedList(){
        Integer[] arr = new Integer[]{2,32,233,34,345,545,6,55,767,88,83,321,22,4,654};
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        List<DoubleLinkedList.Node> nodeList = Arrays.asList(arr).stream().map(p->new DoubleLinkedList.Node(p.intValue())).collect(Collectors.toList());
        for(DoubleLinkedList.Node node : nodeList){
            doubleLinkedList.add(node);
        }
        MatcherAssert.assertThat("Verify Length", doubleLinkedList.size() == 15);
        MatcherAssert.assertThat("Verify Head", doubleLinkedList.getHead().getData() == 2);
        MatcherAssert.assertThat("Verify Tail", doubleLinkedList.getTail().getData() == 654);
        MatcherAssert.assertThat("Verify Removal", doubleLinkedList.remove().getData() == 2);
        MatcherAssert.assertThat("Verify Head", doubleLinkedList.getHead().getData() == 32);
        MatcherAssert.assertThat("Verify Length", doubleLinkedList.size() == 14);
    }
}
