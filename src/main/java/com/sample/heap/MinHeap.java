package com.sample.heap;

import java.util.Arrays;

public class MinHeap {
// https://github.com/bephrem1/backtobackswe/blob/master%2FSorting%2C%20Searching%2C%20%26%20Heaps%2FImplementABinaryHeap%2FImplementABinaryHeap.java

    int[] data;
    int size = 0;
    int capacity = 5;

    MinHeap(){
        this.data = new int[capacity];
    }

    void ensureCapacity(){
        if(size == capacity){
            capacity = capacity * 2;
            this.data = Arrays.copyOf(data, capacity);
        }
    }

    void add(int n){
        //always add to the end
        ensureCapacity();
        data[size] = n;
        size++;
        heapifyUp();
    }
    int remove(){
        //always take from head which is supposed to be the min value
        if(size > 0){
            int minItem = data[0];
            swap(0, size-1);    //swapping tail to head
            size--;
            heapifyDown();      //make sure top is lowest value by comparing downwards
            return minItem;
        }else{
            return -1;
        }
    }
    void heapifyUp(){
        //move the newly added item UP to its correct place in the tree
        int childIndex = size-1;
        while(isParentExists(childIndex) && getParentValue(childIndex) > data[childIndex]){
            swap(childIndex,getParentIndex(childIndex));
            childIndex = getParentIndex(childIndex);
        }
    }
    void heapifyDown(){
        //check if current is head is the smallest
        int index = 0;
        while(isLeftChildExists(index)){    //for binary tree if left child is not present, right will be empty
            //take the smallest of 2 children and compare with parent
            int smallestIndex = (isRightChildExists(index) && getRightChildValue(index) < getLeftChildValue(index))?
                    getRightChildIndex(index): getLeftChildIndex(index);
            if(data[index] > data[smallestIndex]) {
                swap(index, smallestIndex);
                index = smallestIndex;
            }else{
                break;
            }
        }
    }
    void swap(int fromIndex, int toIndex){
        int tmp = data[fromIndex];
        data[fromIndex] = data[toIndex];
        data[toIndex] = tmp;
    }
    void printHeap(){
        for(int k =0; k < size; k++)
            System.out.print("\t"+data[k]);
        System.out.println();
    }
    int getRightChildIndex(int parentIndex){
        return 2 * parentIndex + 2;
    }
    boolean isRightChildExists(int parentIndex){
        return 2 * parentIndex + 2 < size;
    }
    int getRightChildValue(int parentIndex){
        return data[2 * parentIndex + 2];
    }

    int getLeftChildIndex(int parentIndex){
        return 2 * parentIndex + 1;
    }
    boolean isLeftChildExists(int parentIndex){
        return 2 * parentIndex + 1 < size;
    }
    int getLeftChildValue(int parentIndex){
        return data[2 * parentIndex + 1];
    }

    int getParentIndex(int leftChildIndex){
        return (leftChildIndex - 1)/2;
    }
    boolean isParentExists(int leftChildIndex){
        return (leftChildIndex - 1)/2 >= 0;
    }
    int getParentValue(int leftChildIndex){
        return data[(leftChildIndex - 1)/2];
    }
}
