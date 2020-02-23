package com.sample.bst;

public class BST2ArrayUtils
{
    public static Integer[] bstToArray(Node root){
        BST bst = new BST(root);
        Integer[] arr = new Integer[bst.size()];
        bstToArray(arr, root, 0);
        return arr;
    }
    private static int bstToArray(Integer[] arr, Node node, int index){
        if(node != null){
            //passing index as return value as we are not sure if the node exists or not to push the index up
            arr[index] = node.data;
            index++;
            index = bstToArray(arr, node.left, index);
            index = bstToArray(arr, node.right, index);
        }
        return index;
    }
}
