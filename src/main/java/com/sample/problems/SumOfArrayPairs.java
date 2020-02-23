package com.sample.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SumOfArrayPairs {
    /*
    Assumptions Include - Allowing duplicated entries, Avoiding reverse of same pair
    Uses O(n^2) as we do a double iteration
    The first loop starts from 0, but inner loop starts from outer loop index + 1
     */
    List<int[]> findArrayPairsUsingIterativeMethod(int sum, int[] givenArray){
        List<int[]> result = new ArrayList<>();
        //check for boundary conditions
        if (givenArray == null || givenArray.length < 2)
            return result;
        for(int k = 0; k < givenArray.length; k++){
            for(int j = k + 1; j < givenArray.length; j++){
                //always going into forward comparision as we dont want to add the reverse of same pair
                if(givenArray[k] + givenArray[j] == sum){
                    result.add(new int[]{givenArray[k], givenArray[j]});
                }
            }
        }
        return result;
    }

    /*
        Assumptions Include - Avoiding Duplicates but Allowing reverse of same pairs
        Using single loop by O(n) by adding all items in a duplicated Collection - Space complicity increases by O(n)
        Create a Hashset, identify the Y value using the logic Y = SUM - X and check if Y presents in the Hashset
     */
    List<int[]> findArrayPairsUsingHashset(int sum, int[] givenArray){
        List<int[]> result = new ArrayList<>();
        //check for boundary conditions
        if (givenArray == null || givenArray.length < 2)
            return result;

        HashSet<Integer> uniqueSet = new HashSet<Integer>();
        for( int entry : givenArray){
            uniqueSet.add(entry);
        }

        for(int k = 0; k < givenArray.length; k++){
            int otherEntry = sum - givenArray[k];
            if(uniqueSet.contains(otherEntry)){
                result.add(new int[]{givenArray[k], otherEntry});
                // To avoid reverse pair addition remove the compared entry from the Set
                //uniqueSet.remove(givenArray[k]);
            }
        }
        return result;
    }

    /*
    Use NLog(N) approach by first sorting the data and then comparing pairs at first and last position
    No additional Space Complexity
    Assumptions Include - Allowing duplicated entries, Allowing reverse of same pair
    Sort the data and compare first with last, when SUM is less, increment first and
    If sum is greater decrement the last, until the first is not greater than last (2 remove reverse pairs)
     */
    List<int[]> findArrayPairsUsingBestCaseScenarioWithReversing(int sum, int[] givenArray){
        List<int[]> result = new ArrayList<>();
        //check for boundary conditions
        if (givenArray == null || givenArray.length < 2)
            return result;
        Arrays.sort(givenArray);
        int first = 0;
        int last = givenArray.length - 1;
        while(first <= givenArray.length-1 && last >= 0){
            System.out.println(String.format("First Index [%d], Last Index [%d]", first, last));
            if (givenArray[first] + givenArray[last] == sum) {
                result.add(new int[]{givenArray[first], givenArray[last]});
                first++;    //moving on as the given index is already matched
                last--;     //moving on as the given index is already matched
            }else if(givenArray[first] + givenArray[last] > sum){
                last--;
            }else if(givenArray[first] + givenArray[last] < sum){
                first++;
            }
        }
        return result;
    }


    /*
    Use NLog(N) approach by first sorting the data and then comparing pairs at first and last position
    No additional Space Complexity
    Assumptions Include - Allowing duplicated entries, Avoiding reverse of same pair
     */
    List<int[]> findArrayPairsUsingBestCaseScenario(int sum, int[] givenArray){
        List<int[]> result = new ArrayList<>();
        //check for boundary conditions
        if (givenArray == null || givenArray.length < 2)
            return result;
        Arrays.sort(givenArray); //{1,2,3,4,5,7}
        int first = 0;
        int last = givenArray.length - 1;
        while(first < last){
            System.out.println(String.format("First Index [%d], Last Index [%d]", first, last));
            if (givenArray[first] + givenArray[last] == sum) {
                result.add(new int[]{givenArray[first], givenArray[last]});
                first++;    //moving on as the given index is already matched
                last--;     //moving on as the given index is already matched
            }else if(givenArray[first] + givenArray[last] > sum){
                last--;
            }else if(givenArray[first] + givenArray[last] < sum){
                first++;
            }
        }
        return result;
    }
}
