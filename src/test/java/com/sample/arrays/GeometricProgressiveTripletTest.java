package com.sample.arrays;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class GeometricProgressiveTripletTest {

    @Test
    public void testGeometricProgressiveTripletWithLoops(){
        GeometricProgressiveTriplet geometricProgressiveTriplet = new GeometricProgressiveTriplet();
        int[] arr = {1, 1, 2, 2, 4};
        int result = geometricProgressiveTriplet.findNumberOfTripletsUsingLoops(arr, 2);
        MatcherAssert.assertThat("Matches", result == 4);
    }

    @Test
    public void testGeometricProgressiveTriplet(){
        GeometricProgressiveTriplet geometricProgressiveTriplet = new GeometricProgressiveTriplet();
        long[] arr = {1, 1, 2, 2, 4};
        long result = geometricProgressiveTriplet.findNumberOfTriplets(arr, 2);
        MatcherAssert.assertThat("Matches", result == 4);
    }

    @Test
    public void testGeometricProgressiveTriplet2(){
        GeometricProgressiveTriplet geometricProgressiveTriplet = new GeometricProgressiveTriplet();
        long[] arr = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        long result = geometricProgressiveTriplet.findNumberOfTriplets(arr, 1);
        System.out.println(result);
        MatcherAssert.assertThat("Matches", result == 161700);
    }

    @Test
    public void testGeometricProgressiveTriplet3(){
        try(Stream<String> stream = Files.lines(Paths.get(new URI("file:///Users/kamal/workspace/java-programs/src/test/java/com/sample/arrays/input06.txt")))){
            long[] longs = stream
                    .flatMap(line-> Stream.of(line.split(" +")))
                    .map(Long::valueOf)
                    .mapToLong(l->l)
                    .toArray();
            System.out.println(longs.length);
            GeometricProgressiveTriplet geometricProgressiveTriplet = new GeometricProgressiveTriplet();
            long result = geometricProgressiveTriplet.findNumberOfTriplets(longs, 3);
            System.out.println(result);
            MatcherAssert.assertThat("", result ==      2325652489L);
        }catch (Exception exp){
            exp.printStackTrace();
        }
    }
}
