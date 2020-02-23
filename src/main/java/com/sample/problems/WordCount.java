package com.sample.problems;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class WordCount {
    /*
        uses flatMap to split each line into words by using the regex
        and converting that String array into a Stream of data
        Remember to close the Java Stream when the source is a IO Operation
     */
    int getRepeatedWordCountOn(String word, Path path){
        int result = 0;
        try(Stream<String> dataStream = Files.lines(path)){
            result = (int) dataStream.flatMap(line -> Stream.of(line.split(" +")))
                    .filter(w -> word.equals(w))
                    .count();
        }catch (IOException exp){
            exp.printStackTrace();
        }
        return result;
    }
}
