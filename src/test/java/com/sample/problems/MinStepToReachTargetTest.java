package com.sample.problems;

import org.hamcrest.MatcherAssert;

import java.util.ArrayList;
import java.util.List;

public class MinStepToReachTargetTest {
    @org.junit.Test
    public void test() {
        //https://www.geeksforgeeks.org/minimum-steps-reach-target-knight/
        int[] arr = {3, 5, 7, 2, 3, 5, 8, 9};
        MinStepToReachTarget minStepToReachTarget = new MinStepToReachTarget();
        List<List<Integer>> lot = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);row1.add(0);row1.add(0);
        List<Integer> row2 = new ArrayList<>();
        row2.add(1);row2.add(0);row2.add(0);
        List<Integer> row3 = new ArrayList<>();
        row3.add(1);row3.add(9);row3.add(1);
        lot.add(row1);
        lot.add(row2);
        lot.add(row3);
        int[] target = minStepToReachTarget.getTargetLocation(lot);  //target is 9
        System.out.println(String.format("Target is located at [%d,%d]", target[0], target[1]));
        System.out.println();
        int res = minStepToReachTarget.solution(lot);
        MatcherAssert.assertThat("Minimum Steps Verfied", res == 3);
    }

}