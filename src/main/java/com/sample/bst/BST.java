package com.sample.bst;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

/*
 BST is the main class to test the BST implementation
 It has a Node class which captures each entry in the BST
 The methods available in a Typical BST are
    isEmpty() - verifies if the BST has null root
    clear() - clears the BST's root Node
    getRoot() - returns the root node
    size() - finds the number of nodes in this BST
 */
public class BST {
    Node root;
    public BST(Node root){
        this.root = root;
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public void clear(){
        this.root = null;
    }

    public int size(){
        int size = 0;
        Node current = root;
        Stack<Node> stack = new Stack<>();
        while(!stack.empty() || current != null){
            if(current != null){
                stack.push(current);
                current = current.left;
            }else{
                size++;
                current = stack.pop();
                current = current.right;
            }
        }
        return size;
    }

    void add(int data){
        if(root == null) {
            root = new Node(data);
            return;
        }
        //otherwise add the data to the correct node position
        Queue<Node> queue = new ArrayDeque<>();
        Node current = root;
        queue.add(current);
        while(!queue.isEmpty()){
            current = queue.poll();
            if(data > current.data){
                if(current.right != null){
                    queue.add(current.right);
                }else{
                    current.right = new Node(data);
                }
            }else{
                if(current.left != null){
                    queue.add(current.left);
                }else{
                    current.left = new Node(data);
                }
            }
        }
    }
}
