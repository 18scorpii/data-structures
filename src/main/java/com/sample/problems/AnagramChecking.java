package com.sample.problems;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnagramChecking {
    //Anagram is a rearrange of chars in all possible ways
    //To test anagram we need atleast 2 strings (for comparrsion)
    //In this example, a string is given and anagram to be done based on its substrings
    //For example, to a given string abba
    //Possible substrings are [a, ab, abb, abba, b, bb, bba, b, ba, a]
    //After that identify anagrams between the strings - By sorting chars and matching

    int anagramsSubStringCount(String str){
        System.out.println(str);
        List<String> list = getAllPossibleSubStrings(str);
        System.out.println(list);
        printMatchingStrings(list);
        int result = findCountOfMatchingPairs(list);
        return result;
    }

    List<String> getAllPossibleSubStrings(String str){
        List<String> list = new ArrayList<>();
        if(str == null) return list;
        char[] chars = str.toCharArray();
        for(int k = 0; k < chars.length; k++){
            for(int i = k+1; i <= chars.length; i++){   //doing forward comparision to choose substring combinations and
                // also adding lastindex via '<=' for substring lastindex
                list.add(getCanonicalString(str.substring(k,i)));   //adding canonical strings so that its easy to compare later
            }
        }
        return list;
    }

    int findCountOfMatchingPairs(List<String> list){
        int result = 0;
       for(int k = 0 ; k < list.size(); k++){
           for(int i = k+1; i < list.size(); i++){
               //compare 2 substrings in the going forward way so that they are not counted again
               if(list.get(k).equals(list.get(i))){
                   result++;
               }
           }
       }
        return result;
    }

    void printMatchingStrings(List<String> list){
        Map<String, List<String>> anagramMap = new HashMap<>();
        for(int k = 0; k < list.size(); k++){
            String key = getCanonicalString(list.get(k));
            if(anagramMap.containsKey(key)){
                anagramMap.get(key).add(list.get(k));
            }else{
                List<String> sublist = new ArrayList();
                sublist.add(list.get(k));
                anagramMap.put(key, sublist);
            }
        }
        Iterator<String> itr = anagramMap.keySet().iterator();
        while(itr.hasNext()){
            String key = itr.next();
            System.out.printf("Key [%s], Values [%s] \n", key, anagramMap.get(key));
        }
    }
    String getCanonicalString(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
