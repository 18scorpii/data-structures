package com.sample.arrays;

public class PrefixSumArray {
    public Integer[] prefixSumOfArray(Integer[] input){
        Integer[] output = new Integer[input.length];
        output[0] = input[0];
        for(int k = 1; k < input.length; k++){
            output[k] = output[k-1]+input[k];
        }
        return output;
    }
}
