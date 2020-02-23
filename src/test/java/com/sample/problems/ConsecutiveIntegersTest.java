package com.sample.problems;

import org.hamcrest.Matchers;
import org.junit.Test;

public class ConsecutiveIntegersTest {
    @Test
    public void testIfThePositionOfConsecutiveIntegersForAGivenTotal(){
        int[] input = {1,23,3,4,5,6,7,8,9};
        ConsecutiveIntegers consecutiveIntegers = new ConsecutiveIntegers();
        int[] result = consecutiveIntegers.findPositionOfConsecutiveIntegers(input, 21);
        org.hamcrest.MatcherAssert.assertThat("Start Index", result[0], Matchers.is(5));
        org.hamcrest.MatcherAssert.assertThat("End Index", result[1], Matchers.is(7));
    }
    //1 5 3 2
}
