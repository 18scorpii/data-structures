package com.sample.problems;

import org.junit.Test;

import java.util.List;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

public class SumOfArrayPairsTest {
    @Test
    public void testExecutionOfSumOfArrayPairs(){
        SumOfArrayPairs sumOfArrayPairs = new SumOfArrayPairs();
        List<int[]> result = sumOfArrayPairs.findArrayPairsUsingIterativeMethod(5, new int[]{2,3,5,4,1,7});
        MatcherAssert.assertThat("Check array has values", result, Matchers.not(Matchers.empty()));
        MatcherAssert.assertThat("Check if matching pair matches given value", result, Matchers.containsInAnyOrder(
                new int[]{2, 3},
                new int[]{4, 1}
        ));
    }

    @Test
    public void testExecutionOfSumOfArrayPairsForRepeatedEntries(){
        SumOfArrayPairs sumOfArrayPairs = new SumOfArrayPairs();
        List<int[]> result = sumOfArrayPairs.findArrayPairsUsingIterativeMethod(6, new int[]{2,5,3,5,4,1,3,7});
        MatcherAssert.assertThat("Check array has values", result, Matchers.not(Matchers.empty()));
        MatcherAssert.assertThat("Check if matching pair matches given value", result, Matchers.containsInAnyOrder(
                new int[]{2, 4},
                new int[]{3, 3},
                new int[]{5, 1},
                new int[]{5, 1}
        ));
    }

    @Test
    public void testExecutionOfSumOfArrayPairsUsingHashsetMethod(){
        SumOfArrayPairs sumOfArrayPairs = new SumOfArrayPairs();
        List<int[]> result = sumOfArrayPairs.findArrayPairsUsingHashset(5, new int[]{2,3,5,4,1,7});
        MatcherAssert.assertThat("Check array has values", result, Matchers.not(Matchers.empty()));
        MatcherAssert.assertThat("Check if matching pair matches given value", result, Matchers.containsInAnyOrder(
                new int[]{2, 3},
                new int[]{3, 2},
                new int[]{4, 1},
                new int[]{1, 4}
        ));
    }

    @Test
    public void testExecutionOfSumOfArrayPairsUsingBaseCaseScenario(){
        SumOfArrayPairs sumOfArrayPairs = new SumOfArrayPairs();
        List<int[]> result = sumOfArrayPairs.findArrayPairsUsingBestCaseScenarioWithReversing(5, new int[]{2,3,5,4,1,7});
        MatcherAssert.assertThat("Check array has values", result, Matchers.not(Matchers.empty()));
        //result.stream().forEach(p-> System.out.println(p[0]+"\t"+p[1]));
        MatcherAssert.assertThat("Check if matching pair matches given value", result, Matchers.containsInAnyOrder(
                new int[]{2, 3},
                new int[]{3, 2},
                new int[]{4, 1},
                new int[]{1, 4}
        ));
    }

    @Test
    public void testExecutionOfSumOfArrayPairsUsingBestCaseScenarioForAvoidingReversePairs(){
        SumOfArrayPairs sumOfArrayPairs = new SumOfArrayPairs();
        List<int[]> result = sumOfArrayPairs.findArrayPairsUsingBestCaseScenario(5, new int[]{2,3,5,4,1,7});
        MatcherAssert.assertThat("Check array has values", result, Matchers.not(Matchers.empty()));
        MatcherAssert.assertThat("Check if matching pair matches given value", result, Matchers.containsInAnyOrder(
                new int[]{2, 3},
                new int[]{1, 4}
        ));
    }

    @Test
    public void testExecutionOfSumOfArrayPairsUsingBestCaseScenarioForRepeatedEntriesAndAvoidingReversePairs(){
        SumOfArrayPairs sumOfArrayPairs = new SumOfArrayPairs();
        List<int[]> result = sumOfArrayPairs.findArrayPairsUsingBestCaseScenario(6, new int[]{2,5,3,5,4,1,3,7});
        //sorted order is {1,2,3,3,4,5,5,7})
        MatcherAssert.assertThat("Check array has values", result, Matchers.not(Matchers.empty()));
        result.stream().forEach(p-> System.out.println(p[0]+"\t"+p[1]));
        MatcherAssert.assertThat("Check if matching pair matches given value", result, Matchers.containsInAnyOrder(
                new int[]{2, 4},
                new int[]{3, 3},
                new int[]{1, 5}
        ));
    }
}
