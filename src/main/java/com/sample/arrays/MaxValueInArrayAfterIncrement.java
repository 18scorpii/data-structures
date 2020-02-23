package com.sample.arrays;

import java.util.stream.IntStream;

public class MaxValueInArrayAfterIncrement {
    public int findMaxValueInArrayAfterIncrement(int arraySize, int rangeSize, int[][] ranges){
        int result = 0;
        //adding a plus 1 to accomodate end case scenario to negate the sum
        int[] arr = new int[arraySize+1];
        for(int k = 0; k < rangeSize; k++){
            //adding minus 1 to handle the array index vs range index as they start with 1 and not zero
            arr[ranges[k][0]-1] += ranges[k][2];
            arr[ranges[k][1]-1+1] -= ranges[k][2];
        }
        int maxValue = 0;
        for(int k = 1; k < arr.length; k++){
            arr[k] += arr[k-1];
            if(maxValue < arr[k]){
                maxValue = arr[k];
            }
        }
        IntStream.range(0, arraySize).forEach(k-> System.out.println(k+"-"+arr[k]));
        result = maxValue;
        return result;
    }
}
