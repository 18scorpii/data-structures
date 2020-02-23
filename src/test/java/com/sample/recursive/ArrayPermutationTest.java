package com.sample.recursive;

import com.sample.recursive.ArrayPermutation;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RunWith(MockitoJUnitRunner.class)
public class ArrayPermutationTest {
    @Spy
    ArrayPermutation arrayPermutation;
    @Test
    public void testAllPermutationsOfAnGivenArray(){
        int[] arr = {1,2,3,4};
        int result = arrayPermutation.findFactorial(arr.length);
        MatcherAssert.assertThat(result, Matchers.is(24));
    }

    @Test
    public void printPermutations(){
        int[] arr = {1,2,3,4};
        String str = IntStream.of(arr).mapToObj(String::valueOf).collect(Collectors.joining());
        arrayPermutation.maxPermutations("", str);
        Mockito.verify(arrayPermutation, Mockito.times(1)).maxPermutations("", str);
    }
}
