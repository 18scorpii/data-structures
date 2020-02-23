package com.sample.arrays;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public class PrefixSumArrayTest {
    @Test
    public void testPrefixSumOfAnArray(){
        PrefixSumArray prefixSumArray = new PrefixSumArray();
        Integer[] output = prefixSumArray.prefixSumOfArray(new Integer[] {10, 20, 10, 5, 15});
        Integer[] expectedOutput = {10, 30, 40, 45, 60};
        MatcherAssert.assertThat(output, Matchers.arrayContaining(expectedOutput));
    }
}
