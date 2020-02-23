package com.sample.arrays;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

public class MaxValueInArrayAfterIncrementTest {

    /*
    a b k
    1 5 3
    4 8 7
    6 9 1
    https://www.geeksforgeeks.org/maximum-value-array-m-range-increment-operations/
    Ranges are given as a to b and the value to be incremented is given in k
    Identify the maximum value on a given array of size - n
     */
    @Test
    public void testMaxValueInArrayAfterIncrement(){
        MaxValueInArrayAfterIncrement maxValueInArrayAfterIncrement = new MaxValueInArrayAfterIncrement();
        int[] row1 = {1, 2, 200};
        int[] row2 = {2, 5, 100};
        int[] row3 = {3, 4, 100};
        int[][] ranges = {row1, row2, row3};
        int result = maxValueInArrayAfterIncrement.findMaxValueInArrayAfterIncrement(5, 3, ranges);
        MatcherAssert.assertThat("Matches", result == 300);
    }
}
