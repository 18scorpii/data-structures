package com.sample.problems;

public class ConsecutiveIntegers {
    /*
    Use a double for loop to count consecutive integers matches to a given total value
    Complexity is O(n) on outer loop in worst case scenario and
    again O(n) in inner loop, so its O(n^2)
     */
    public int[] findPositionOfConsecutiveIntegers(int[] input, int totalValue){
        int[] result = new int[2];
        if (input == null || input.length == 0)
            return result;
        for(int k = 0; k < input.length; k++){
            //check if sum of Consecutive Integers matches the total value counting from the klth position
            int startIndex = k;
            int endIndex = -1;
            int sum = 0;
            for(int i = k; i < input.length; i++){
                sum += input[i];
                if(sum == totalValue){
                    endIndex = i;
                }else if(sum > totalValue){
                    break;
                }else{
                    continue;
                }
            }
            //if endIndex is calculated, then break from the outer loop also
            if(endIndex != -1){
                result[0] = startIndex;
                result[1] = endIndex;
                break;
            }
        }
        return result;
    }
}
