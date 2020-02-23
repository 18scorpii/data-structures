package com.sample.problems;

import java.util.stream.Stream;

public class ArrayReversal {
    int[] reverseGivenArray(int[] arr){
        if(arr == null || arr.length < 2){
            return arr;
        }
        for (int k = 0 ; k < arr.length/2; k++){
            int tmp = arr[k];
            arr[k] = arr[arr.length-1-k];
            arr[arr.length-1-k] = tmp;
        }
        return arr;
    }

    String reverseGivenString(String str){
        if(str == null || str.length() < 2)
            return str;
        StringBuilder builder = new StringBuilder(str);
        for(int k = 0; k < str.length()/2; k++){
            builder.setCharAt(k, str.charAt(str.length()-1-k));
            builder.setCharAt(str.length()-1-k, str.charAt(k));
        }
        return builder.toString();
    }
}
