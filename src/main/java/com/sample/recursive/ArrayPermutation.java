package com.sample.recursive;

import java.util.Arrays;

/*
Identify al the combinations (Factorials) possible on a given array elements
 */
public class ArrayPermutation {
    /*
    Factorial Formula ->  n! = n * (n-1)! ; where n! = 1 when n = 0 or 1
     */
    public int findFactorial(int k){
        if (k <= 1) return 1;
        return k * findFactorial(k-1);
    }

    /*
    To get all combinations of an array or string, use the Factorial formula
    By keeping n on a for loop and (n-1)! using a recursion
     */
    public void maxPermutations(String given, String remaining){
        if(remaining == null || remaining.length() == 0){
            System.out.println(given);
        }else{
            System.out.println(String.format("Given [%s], Remaining [%s]", given, remaining));
            for(int k = 0; k < remaining.length(); k++){
                char selected = remaining.charAt(k);
                maxPermutations(given+selected,
                        remaining.substring(0, k)+remaining.substring(k+1));
            }
        }
    }
}
