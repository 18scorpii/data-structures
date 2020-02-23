package com.sample.sort;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;

public class BubbleSortTest {
    @Test
    public void testSortingUsingBubbleSort() {
        Integer[] arr = new Integer[]{3,5,7,2,3,5,8,9};
        Arrays.stream(arr).forEach(p->System.out.print(p+"\t"));
        System.out.println();
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(arr);
        Arrays.stream(arr).forEach(p->System.out.print(p+"\t"));
        MatcherAssert.assertThat("Check if its sorted", arr, Matchers.arrayContaining(new Integer[]{2,3,3,5,5,7,8,9}));
    }
}
