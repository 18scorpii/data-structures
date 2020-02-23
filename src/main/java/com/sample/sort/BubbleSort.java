package com.sample.sort;
//https://www.youtube.com/watch?v=pkkFqlG0Hds&list=PL2_aWCzGMAwKedT2KfDMB9YA5DgASZb3U

public class BubbleSort {
    /*
    Bubble sort uses N^2 by comparing each element with each other element
     */
    public void bubbleSort(Integer[] unsorted){
        int n = unsorted.length;
        for(int k = 0; k < n ; k++){
            for(int i = 1; i < (n - k); i++){
                if(unsorted[i-1] > unsorted[i]){
                    // that means 1st value is bigger than 2nd value, so swap it till the last position as needed
                    int tmp = unsorted[i-1];
                    unsorted[i-1] = unsorted[i];
                    unsorted[i] = tmp;
                }
            }
        }
    }
}
