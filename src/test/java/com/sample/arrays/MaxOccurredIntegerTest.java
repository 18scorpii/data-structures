package com.sample.arrays;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

public class MaxOccurredIntegerTest {
    @Test
    public void testMaxOccurredSmallestIntegerUsingMap(){
        int[] lowerRange = {1, 4, 4, 13, 21};
        int[] upperRange = {15, 8, 12, 20, 30};
        MaxOccurredInteger maxOccurredInteger = new MaxOccurredInteger();
        int result = maxOccurredInteger.findMaxOccurredSmallestIntegerUsingMap(5, lowerRange, upperRange);
        MatcherAssert.assertThat("Result matches", result == 4);
    }

    @Test
    public void testMaxOccurredSmallestInteger(){
        int[] lowerRange = {1, 4, 4, 13, 21};
        int[] upperRange = {15, 8, 12, 20, 30};
        MaxOccurredInteger maxOccurredInteger = new MaxOccurredInteger();
        int result = maxOccurredInteger.findMaxOccurredSmallestInteger(5, lowerRange, upperRange);
        MatcherAssert.assertThat("Result matches", result == 4);
    }
}
