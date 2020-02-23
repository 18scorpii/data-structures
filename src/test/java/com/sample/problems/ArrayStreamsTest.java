package com.sample.problems;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public class ArrayStreamsTest {
    @Test
    public void testArrayOffsetByPositions(){
        int[] input = {30,21,54,67,31,87,43,57};
        //Move array by 3 positions
        Integer[] expected = {67,31,87,43,57,30,21,54};
        ArrayStreams arrayStreams = new ArrayStreams();
        int[] output = arrayStreams.shiftArrayPositions(input, 3);
        MatcherAssert.assertThat(output, Matchers.is(expected));
    }

    @Test
    public void testNonMatchingCharsCount(){
        String s1 = "catnd";
        String s2 = "catanddog";
        ArrayStreams arrayStreams = new ArrayStreams();
        int unmatchedCharCount = arrayStreams.nonMatchingCharactersBetweenStrings(s1,s2);
        MatcherAssert.assertThat("NonMatchingCountTest", unmatchedCharCount == 4);
    }
}
