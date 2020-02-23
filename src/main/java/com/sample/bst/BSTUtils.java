package com.sample.bst;

import java.util.Arrays;

public class BSTUtils {
    public static void printNode(Node node){
        //This method uses PreOrder Traversal    ==> Root, Left, Right
        //Other Options are -> InOrderTraversal (L, Root, R) or PostOrder Traversal (L, R, Root)
        if(node != null) {
            System.out.print(node.data+"\t");
            printNode(node.left);
            printNode(node.right);
        }
    }

    public static boolean isValidBST(BST bst){
        return validateBST(bst.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private static boolean validateBST(Node node, int min, int max){
        if(node == null)    //empty node is a valid BST condition
            return true;
        if(node.data < min || node.data > max){ //Check if the value of the node breaches the boundary condition
            return false;
        }
        if(validateBST(node.left, min, node.data)){
            return validateBST(node.right, node.data, max);
        }else{
            return false;
        }
    }

    public static Node addNodeRecursively(Node node, int data){
        if (node == null)
            return new Node(data);
        if(data > node.data){
            //try on right subtree, if it does not exists return it as so, so it can be added to the parent
            node.right = addNodeRecursively(node.right, data);
        }else if (data < node.data){
            //try on left subtree
            node.left = addNodeRecursively(node.left, data);
        }else{
            //data already exists, no need to add
        }
        return node;
    }

    public static boolean isBalanced(Node root){
        if (root == null)
            return true;
        if(getHeight(root) == -1)
            return false;
        else
            return true;

    }
    static int getHeight(Node node){
        if(node == null)
            return 0;
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        if( left == -1 || right == -1)
            return -1; //something not balanced
        if( Math.abs(left-right) > 1)
            return -1;  //the diff is more than 1
        else
            return Math.max(left, right)+1; //adding 1 for each level by taking the max of its children

    }
}
