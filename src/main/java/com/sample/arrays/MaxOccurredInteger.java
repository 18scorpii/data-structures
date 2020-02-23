package com.sample.arrays;

import com.sun.tools.javac.util.Assert;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaxOccurredInteger {
    /*
        For a given set of array ranges, increment a source array and identify the maximum occurred smallest number
        https://www.geeksforgeeks.org/maximum-occurred-integer-n-ranges/
        Use PrefixSumMethod for better performance
        Range Indexes Starts from 1 and Its Inclusive
     */
    public int findMaxOccurredSmallestIntegerUsingMap(int rangeSize, int[] lowerRange, int[] upperRange){
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>(); //Number, Occurrences
        for(int k = 0; k < rangeSize; k++){
            int start = lowerRange[k];
            int end = upperRange[k];
            for(int i = start; i <= end; i++){
                if(map.containsKey(i)){
                    map.put(i, map.get(i)+1);
                }else{
                    map.put(i, 1);
                }
            }
        }
        //now identify the lowest key that has maximum occurrences
        //Sorting approach, sort by values desc and followed by keys asc
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Comparator<Map.Entry<Integer, Integer>> comparator = (e1, e2) -> {
            if(e1.getValue() < e2.getValue()) return 1;
            else if (e1.getValue() > e2.getValue()) return -1;
            else{
                return e1.getKey().compareTo(e2.getKey());
            }
        };
        list.sort(comparator);
        result = list.get(0).getKey();
        return result;
    }

    public int findMaxOccurredSmallestInteger(int rangeSize, int[] lowerRange, int[] upperRange){
        int result = 0;
        int[] arr = new int[100]; //assuming the ranges are within 100
        // add the occurrences as the array value by adding 1 each time the index occurs on the ranges
        // by doing a prefix sum, we can accumulate from LHS starting from lower limit to upper limit,
        // after that at postion upper limit - 1, the value is decremented
        // the final answer is the least index where the value is at its maximum
        for(int k = 0; k < rangeSize; k++){
            arr[lowerRange[k]] += 1;
            arr[upperRange[k]+1] -= 1;
        }
        //now identify the value which has maximum accumulation and identify its least index
        //we cannot sort the array as we will loose its index position
        int leastIndex = -1;
        int maxOccurrence = 0;
        for(int k = 1; k < arr.length; k++){
            arr[k] += arr[k-1]; //doing array prefix
            if(maxOccurrence < arr[k]){
                maxOccurrence = arr[k];
                if(leastIndex < k){
                    leastIndex = k;
                }
            }
        }
        IntStream.range(0, 100).forEach(k-> System.out.println(k+"-"+arr[k]));
        result = leastIndex;
        return result;
    }
}
