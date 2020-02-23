package com.sample.sort;

import org.junit.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class MultiColumnSortTest {
    @Test
    public void sortByMultipleColumns(){
        MultiColumnSort multiColumnSort = new MultiColumnSort();
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(50, "Alpha2", Instant.now()));
        persons.add(new Person(50, "Alpha", Instant.now()));
        persons.add(new Person(10, "Gamma", Instant.now()));
        persons.add(new Person(34, "Centa", Instant.now()));
        persons.add(new Person(75, "Delta", Instant.now()));
        persons.add(new Person(25, "Tongo", Instant.now()));
        List<Person> streamSortedPersons = multiColumnSort.getStreamSortedPersons(persons);
        streamSortedPersons.stream().forEach(System.out::println);
        System.out.println();
        List<Person> listSortedPersons = multiColumnSort.getListSortedPersons(persons);
        listSortedPersons.stream().forEach(System.out::println);
        System.out.println();
        List<Person> sortedPersons = multiColumnSort.getSortedPersons(persons);
        sortedPersons.stream().forEach(System.out::println);

    }
}
