package com.sample.problems;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayStreams {
    public int[] shiftArrayPositions(int[] input, int position){
        //use IntStream to read this given array and convert the stream to the array map with positions moved
        int[] output = IntStream.range(0, input.length).map(p->input[(p+position)%input.length]).toArray();
        return output;
    }



    public int nonMatchingCharactersBetweenStrings(String first, String second){
        char[] firstChars = first.toCharArray();
        char[] secondChars = second.toCharArray();
        //To create a stream of char array we need to explicitly auto box it
        List<Character> firstCharsList = IntStream.range(0, firstChars.length).mapToObj(p->firstChars[p]).collect(Collectors.toList());
        List<Character> secondCharsList = IntStream.range(0, secondChars.length).mapToObj(p->secondChars[p]).collect(Collectors.toList());
        List<Character> matchingCharsList = firstCharsList.stream().filter(p->secondCharsList.remove(p)).collect(Collectors.toList());
        //secondCharsList now contains the chars that are not removed via matching
        //So total non matching chars are
        return (firstCharsList.size() - matchingCharsList.size()) + secondCharsList.size();
    }
}
