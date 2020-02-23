package com.sample.problems;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    Print the Fibonacci Sequence using a best case approach
    Fibonacci numbers are 0, 1, 1, 2, 3, 5, 8, 13, 21, etc  Basically the formula is (n) + (n+1) = (n+2)
 */
public class FibonacciSequence {
    //Use the Streams.iterate method that accepts a Seed and a Unary Operator,
    // such that the infinite iterator loop calls the f(seed), f(f(seed)), etc


    Collection<Integer> executeFibonacciSequenceUsingInteger(int length) {
        return Stream
                .iterate(new int[]{0, 1}, p -> new int[]{p[1], p[0] + p[1]})
                .limit(length)
                .map(p -> p[0])
                .collect(Collectors.toList());
    }

    /*
    Using BigInteger as values stored as Int will become negative after around 48 iterations
     */
    List<BigInteger> executeFibonacciSequenceUsingBigInteger(int length) {
        return Stream
                .iterate(new BigInteger[]{BigInteger.ZERO, BigInteger.ONE}, p -> new BigInteger[]{p[1], p[0].add(p[1])})
                .limit(length)
                .map(p -> p[0])
                .collect(Collectors.toList());
    }

    void executeFibonacciSequenceUsingIntegerViaRecursion(List<Integer> result, int length) {
        if (result.size() < 2) {
            //start seeding
            result.add(0);
            result.add(1);
        } else if (result.size() >= length) {
            return;
        } else {
            int lastIndex = result.size() - 1;
            result.add(result.get(lastIndex - 1) + result.get(lastIndex));
        }
        executeFibonacciSequenceUsingIntegerViaRecursion(result, length);
    }

    int calculateFibonacciNumberUsingRecursionForLimit(int n) {
        System.out.println("Called with N "+n);
        if(n == 0){
            return 0;
        }else if (n == 1){
            return 1;
        }else{
            return calculateFibonacciNumberUsingRecursionForLimit(n-1)
                    + calculateFibonacciNumberUsingRecursionForLimit(n-2);
        }
    }

    int findFibonacciAtLimit(int previous, int current, int limit, int counter){
        if(counter == limit){
            return current;
        }else {
            return findFibonacciAtLimit(current, current + previous, limit, ++counter);
        }
    }

}
