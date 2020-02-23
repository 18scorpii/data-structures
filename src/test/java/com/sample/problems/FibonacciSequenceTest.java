package com.sample.problems;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class FibonacciSequenceTest {
    @Test
    public void testFibonacciSequenceExceution(){
        FibonacciSequence fibonacciSequence = new FibonacciSequence();
        Collection<Integer> result = fibonacciSequence.executeFibonacciSequenceUsingInteger(10);
        assertThat("Checking if proper sequence is generated", result, equalTo(Arrays.<Integer>asList(0,1,1,2,3,5,8,13,21,34)));
    }

    @Test
    public void testFibonacciSequenceForReturnSize(){
        FibonacciSequence fibonacciSequence = new FibonacciSequence();
        Collection<Integer> result = fibonacciSequence.executeFibonacciSequenceUsingInteger(100);
        MatcherAssert.assertThat("Checking if all items requested are generated", result, hasSize(equalTo(100)));
    }

    /*
        Integer Max limit crosses when Fibonacci sequence reached 48
     */
    @Test
    public void testFibonacciSequenceForNegativeNumbers(){
        FibonacciSequence fibonacciSequence = new FibonacciSequence();
        Collection<Integer> result = fibonacciSequence.executeFibonacciSequenceUsingInteger(48);
        MatcherAssert.assertThat("Checking if number ran out of max value", result,     Matchers.hasItems(Matchers.lessThan(0)));
    }

    @Test
    public void testFibonacciSequenceForNonNegativeNumbersWithLimitedLength(){
        FibonacciSequence fibonacciSequence = new FibonacciSequence();
        Collection<Integer> result = fibonacciSequence.executeFibonacciSequenceUsingInteger(47);
        MatcherAssert.assertThat("Checking if number ran out of max value", result,     Matchers.not(Matchers.hasItems(Matchers.lessThan(0))));
    }

    @Test
    public void testFibonacciSequenceForNonNegativeNumbers(){
        FibonacciSequence fibonacciSequence = new FibonacciSequence();
        Collection<BigInteger> result = fibonacciSequence.executeFibonacciSequenceUsingBigInteger(1000);
        MatcherAssert.assertThat("Checking if number ran out of max value", result, Matchers.not(Matchers.hasItems(Matchers.lessThan(BigInteger.ZERO))));
    }

    @Test
    public void testSequenceUsingRecursiveMethod(){
        FibonacciSequence fibonacciSequence = new FibonacciSequence();
        List<Integer> result = new ArrayList<>();
        fibonacciSequence.executeFibonacciSequenceUsingIntegerViaRecursion(result,10);
        //result.stream().forEach(p-> System.out.println(p));
        MatcherAssert.assertThat("Checking if output matches", result, Matchers.equalTo(Arrays.asList(0,1,1,2,3,5,8,13,21,34)));
    }

    @Test
    public void testSequenceUsingRecursiveMethodWithReturn(){
        FibonacciSequence fibonacciSequence = new FibonacciSequence();
        //Forms the fibonacci number using the formula n = (n-1) + (n-2), by recursively calling for each entry
        int result = fibonacciSequence.calculateFibonacciNumberUsingRecursionForLimit(10);
        //result.stream().forEach(p-> System.out.println(p));
        MatcherAssert.assertThat("Checking if output matches", result, Matchers.equalTo(55));
    }

    @Test
    public void testFindFibonacciAtLimit(){
        FibonacciSequence fibonacciSequence = new FibonacciSequence();
        //Uses a forward counter to get the fibonacci numer till the limit
        // starting values are already passed, so we start the counter at 1
        int result = fibonacciSequence.findFibonacciAtLimit(0, 1, 10, 1);
        MatcherAssert.assertThat("Checking if output matches", result, Matchers.equalTo(55));
    }
}
