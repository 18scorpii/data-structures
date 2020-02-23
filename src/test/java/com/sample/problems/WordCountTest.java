package com.sample.problems;

import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.Matchers;

/*
    Notice the usage of Java IO VS NIO - https://dzone.com/articles/java-nio-vs-io
    IO is using IO Stream and its a Blocking call versus
    NIO is using IO Buffers and its non blocking, meaning same thread can do multi processing using different channels
 */
public class WordCountTest {
    @Test
    public void testExecutionOfWordCount(){
        WordCount wordCount = new WordCount();
        Path path = Paths.get("src/test/java/com/sample/problems/WordCountTest.java");
        int count = wordCount.getRepeatedWordCountOn("import", path);
        assertThat("Check the number of times word is repeated", count, Matchers.is(7));
    }
}
