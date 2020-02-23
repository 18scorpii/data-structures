package com.sample.problems;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public class ArrayReversalTest {
    @Test
    public void testArrayReversal(){
        int[] arr = new int[]{3,5,7,2,3,5,8,9};
        int[] arr_expected = new int[]{9,8,5,3,2,7,5,3};
        arr = new ArrayReversal().reverseGivenArray(arr);
        MatcherAssert.assertThat(arr, Matchers.is(arr_expected));
    }

    @Test
    public void testStringReversal(){
        String str = "welcome";
        String str_expected = "emoclew";
        str = new ArrayReversal().reverseGivenString(str);
        System.out.println(str);
        MatcherAssert.assertThat(str, Matchers.equalTo(str_expected));
    }
}
