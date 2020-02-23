package com.sample.heap;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class HeapTest {
    @Test
    public void testMinHeap(){
        int[] arr = IntStream.range(10,20).map(p->(int)(Math.random()*p)).toArray();
        Arrays.stream(arr).forEach(p->System.out.print("\t"+p));
        System.out.println();
        MinHeap minHeap = new MinHeap();
        for(int k : arr){
            minHeap.add(k);
        }
        minHeap.printHeap();
        System.out.println(minHeap.remove());
        minHeap.printHeap();
        System.out.println(minHeap.remove());
        minHeap.printHeap();
        System.out.println(minHeap.remove());
        minHeap.printHeap();
        System.out.println(minHeap.remove());
        minHeap.printHeap();
        System.out.println(minHeap.remove());
        minHeap.printHeap();
        System.out.println(minHeap.remove());
        minHeap.printHeap();
        System.out.println(minHeap.remove());
        minHeap.printHeap();
        System.out.println(minHeap.remove());
        minHeap.printHeap();
        System.out.println(minHeap.remove());
        minHeap.printHeap();
        System.out.println(minHeap.remove());
        minHeap.printHeap();
        System.out.println(minHeap.remove());
        minHeap.printHeap();
    }
}
