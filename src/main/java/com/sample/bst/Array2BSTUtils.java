package com.sample.bst;

import java.util.Arrays;

public class Array2BSTUtils {
    public static BST arrayToBST(Integer[] arr){
        Arrays.sort(arr);
        BST bst = new BST(arrayToBST(arr, 0, arr.length-1));
        return bst;
    }
    private static Node arrayToBST(Integer[] arr, int start, int end){
        if (start > end) { //add the boundary condition
            return null;
        }
        //BST root starts with the mid value of a sorted array
        int mid = (start+end)/2;
        Node node = new Node(arr[mid]);
        node.left = arrayToBST(arr, start, mid-1);
        node.right = arrayToBST(arr, mid+1, end);
        return node;
    }
}
