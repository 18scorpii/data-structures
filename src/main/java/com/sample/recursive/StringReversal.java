package com.sample.recursive;

public class StringReversal {

    public void recursiveMethod(int k){
        //define boundary condition for exiting
        if(k <= 0 ){
            return;
        }else{
            System.out.println(String.format("Before : Recursion [%d]", k));
            recursiveMethod(--k);
            System.out.println(String.format("After : Recursion [%d]", k));
        }
    }
    /*
    Use StringBuilder as an object reference to do reversing of a given string
     */
    public void recursiveReverseString(StringBuilder reverse, String input){
        if(input == null || input.length() == 0){
            return;
        }else{
            System.out.println(String.format("Before : Reverse [%s], Input [%s]", reverse, input));
            reverse = reverse.append(input.charAt(input.length()-1));
            input = input.substring(0, input.length()-1);
            recursiveReverseString(reverse, input);
            System.out.println(String.format("After : Reverse [%s], Input [%s]", reverse, input));
        }
    }

    /*
    Uses return value to reverse a given string via recursion
     */
    public String recursiveReverseStringWithReturn(String input){
        if(input == null || input.length() == 0){
            return "";
        }else {
            char lastChar = input.charAt(input.length()-1);
            String reverse = lastChar + recursiveReverseStringWithReturn(input.substring(0, input.length() - 1));
            System.out.println(String.format("Reverse [%s], Input [%s]", reverse, input));
            return reverse;
        }
    }
}
