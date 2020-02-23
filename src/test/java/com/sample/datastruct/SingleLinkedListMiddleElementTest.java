package com.sample.datastruct;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SingleLinkedListMiddleElementTest {

    @Test
    public void testMiddleElementOnCustomLinkedListWithSinglePass(){
        Integer[] arr = new Integer[]{2,32,233,34,345,545,6,55,767,88,83,321,22,4,654,60,75};
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        List<SingleLinkedList.Node> nodeList = Arrays.asList(arr).stream().map(p->new SingleLinkedList.Node(p.intValue())).collect(Collectors.toList());
        for(SingleLinkedList.Node node : nodeList){
            singleLinkedList.add(node);
        }
        SingleLinkedListMiddleElement middleElement = new SingleLinkedListMiddleElement();
        MatcherAssert.assertThat("Middle Element",
                middleElement.findMiddleElementOnCustomLinkedListWithSinglePass(singleLinkedList) == 767);
    }
}
