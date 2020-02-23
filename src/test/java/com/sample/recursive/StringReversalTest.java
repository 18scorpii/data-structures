package com.sample.recursive;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

/*
    Add the RunWith annotation to allow annotated mokito objects to be created or Uncomment the Before call.
 */
@RunWith(MockitoJUnitRunner.class)
public class StringReversalTest {
    @Mock
    StringReversal mockStringReversal;
    @Spy
    StringReversal spyStringReversal;

//    @Before
//    public void before(){
//        MockitoAnnotations.initMocks(this);
//    }

    /*
        Mocks the call without making any real call
     */
    @Test
    public void testMockSimpleMethodRecursion(){
        mockStringReversal.recursiveMethod(10);
        Mockito.verify(mockStringReversal, Mockito.times(1)).recursiveMethod(10);
    }

    /*
        Spy mock allows the actual call to be made on the mocked object
     */
    @Test
    public void testSpySimpleMethodRecursion(){
        spyStringReversal.recursiveMethod(10);
        Mockito.verify(spyStringReversal, Mockito.times(1)).recursiveMethod(10);
    }

    @Test
    public void testStringMethodRecursion(){
        StringReversal stringReversal = new StringReversal();
        StringBuilder reverse = new StringBuilder();
        //If String type is passed, we get. empty output for reverse
        //Java always uses pass by value and in-case of strings, they are recreated in string pool
        stringReversal.recursiveReverseString(reverse, "12345");
        MatcherAssert.assertThat("Reverse String", reverse.toString(), Matchers.equalTo("54321"));
    }

    @Test
    public void testStringMethodRecursionWithReturn(){
        StringReversal stringReversal = new StringReversal();
        String reverse = stringReversal.recursiveReverseStringWithReturn("12345");
        /* String == will fail as they are created by different references in memory pool */
        MatcherAssert.assertThat("Reversed", ! ("54321" == reverse));
        MatcherAssert.assertThat("Reversed", "54321".equals(reverse));
    }
}
