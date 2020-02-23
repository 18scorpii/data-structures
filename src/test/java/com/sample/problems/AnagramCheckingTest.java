package com.sample.problems;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

public class AnagramCheckingTest {
    @Test
    public void testNumberOfAnagramsOnTheGivenString(){
        String str = "abba";
        //count the possible substring of that string that are anagram of each other
        //answer is 4 ==> [a,a] ; [b,b] ; [ab,ba] ; [abb, bba]
        AnagramChecking anagramChecking = new AnagramChecking();
        int result  = anagramChecking.anagramsSubStringCount(str);
        MatcherAssert.assertThat("No Matches", result == 4 );
        MatcherAssert.assertThat("No Matches", anagramChecking.anagramsSubStringCount("kkkk") == 10 );
        MatcherAssert.assertThat("No Matches", anagramChecking.anagramsSubStringCount("cdcd") == 5 );
        MatcherAssert.assertThat("No Matches", anagramChecking.anagramsSubStringCount("ifailuhkqqhucpoltgtyovarjsnrbfpvmupwjjjfiwwhrlkpekxxnebfrwibylcvkfealgonjkzwlyfhhkefuvgndgdnbelgruel") == 399 );

    }
}
