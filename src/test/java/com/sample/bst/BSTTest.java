package com.sample.bst;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
Visualization of BST @ https://www.cs.usfca.edu/~galles/visualization/BST.html
 */
public class BSTTest {
    @Test
    public void testLoadingAndUnloadingBSTWithData(){
        Integer[] input = new Integer[]{2,3,1,4, 5,112,34,56,67,8,5};
        BST bst = Array2BSTUtils.arrayToBST(input);
        System.out.println(bst.size());
        BSTUtils.printNode(bst.root);
        /*
                            5
                    2               5
                1      3        8       56

         */
        System.out.println();
        Integer[] output = BST2ArrayUtils.bstToArray(bst.root);
        MatcherAssert.assertThat(output, Matchers.arrayContainingInAnyOrder(input));
        MatcherAssert.assertThat(BSTUtils.isValidBST(bst), Matchers.is(true));
        System.out.println(bst.size());
        BSTUtils.addNodeRecursively(bst.root, 5);
        BSTUtils.addNodeRecursively(bst.root, 50);
        BSTUtils.addNodeRecursively(bst.root, 500);
        BSTUtils.addNodeRecursively(bst.root, 5000);
        MatcherAssert.assertThat(BSTUtils.isValidBST(bst), Matchers.is(true));
        System.out.println(bst.size());
        BSTUtils.printNode(bst.root);
        System.out.println();
        System.out.println(BSTUtils.isBalanced(bst.root));
    }

    @Test
    public void testBSTCOrrectness(){
        Node n1 = new Node(5);
        Node n11 = new Node(4);
        Node n12 = new Node(7);
        n1.left = n11;
        n1.right = n12;
        Node n111 = new Node(3);
        Node n112 = new Node(6);
        n11.left = n111;
        n11.right = n112;
        MatcherAssert.assertThat(BSTUtils.isValidBST(new BST(n1)), Matchers.is(false));
    }
}
