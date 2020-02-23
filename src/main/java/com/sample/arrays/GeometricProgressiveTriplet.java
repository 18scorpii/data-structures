package com.sample.arrays;

import java.util.*;
import java.util.stream.Collectors;

public class GeometricProgressiveTriplet {
    /*
        https://www.geeksforgeeks.org/number-gp-geometric-progression-subsequences-size-3/

        For a given array, find the trilets that are multiple of the ratio, so that i < j < k
        For ex arr[] = {1, 1, 2, 2, 4} and ratio is 2
        So the triplets are 1, 2, 4
        Possible triplets indexes are 0-2-4, 0-3-4, 1-2-4, 2-2-4 => Total 4
        This approach uses O(n^3), so not ideal
     */
    public int findNumberOfTripletsUsingLoops(int[] arr, int ratio){
        int result = 0;
        Arrays.sort(arr);   //we will sort it first so that all entries are aligned for checking
        for(int i = 0; i < arr.length -2; i++){ //skipping last 2 as we need to accommodate j & k
            int first = arr[i];
            int second = first * ratio;
            int third = second * ratio;
            for(int j = i+1; j < arr.length -1; j++){
                if(arr[j] == second) {
                    for (int k = j + 1; k < arr.length; k++) {
                        if(arr[k] == third) {
                            result++;
                        }
                        if(arr[k] > third) break;   //no need to continue as values are already sorted
                    }
                }
                if(arr[j] > second) break;
            }
        }
        return result;
    }

    /*
        On a sorted array for any i, j, k
        Better approach is take the middle element 'j' and make one loop in O(n) times
        Identify the occurrences for i = j /ratio  and k = j * ratio
        Multiple the occurrences to get all combinations of triplets
        Sample input {1, 1, 2, 2, 4} and ratio 2 => 4

     */
    public long findNumberOfTriplets(long[] arr, long ratio){
        long result = 0;
        Arrays.sort(arr);
        Map<Long, Long> mapValuesByCount = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(i->i,Collectors.counting()));
        Map<Long, Long> mapLeftValuesByCount = new HashMap<>();
        mapLeftValuesByCount.put(arr[0], 1L);
        for(int j = 1; j < arr.length -1; j++){
            long second = arr[j];
            long first = arr[j] / ratio;
            long third = arr[j] * ratio;
            if(mapLeftValuesByCount.containsKey(first) && mapValuesByCount.containsKey(third)){
                //count how many times first and third are present from the point of the middle element
                long leftCount = mapLeftValuesByCount.get(first);
                long rightCount = mapValuesByCount.get(third) - mapLeftValuesByCount.getOrDefault(third, 0L);
                if(second == third) rightCount--;   //edge case when all elements are same
                result += leftCount * rightCount;
            }
            checkAndAddCountValuesInLeftHash(mapLeftValuesByCount, second);
        }
        System.out.println(result);
        return result;
    }

    private void checkAndAddCountValuesInLeftHash(Map<Long, Long> mapLeftValuesByCount, long second){
        if(mapLeftValuesByCount.containsKey(second)){
            mapLeftValuesByCount.put(second, mapLeftValuesByCount.get(second)+1);
        }else{
            mapLeftValuesByCount.put(second, 1L);
        }
    }
}
