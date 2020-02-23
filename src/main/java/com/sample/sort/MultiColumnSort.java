package com.sample.sort;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.Instant;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MultiColumnSort {

    //Uses a Comparator.comparing Functional via streams
    List<Person> getStreamSortedPersons(List<Person> persons){
        if(persons != null){
            persons = persons.stream()
                    .sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getName))
                    .collect(Collectors.toList());
        }
        return persons;
    }

    //Uses a Comparator function using List of data
    List<Person> getListSortedPersons(List<Person> persons){
        if(persons != null){
            persons.sort((p1,p2) -> {
                if (p1.getAge() == p2.getAge()){
                    return p1.getName().compareTo(p2.getName());
                }else{
                    return p1.getAge() - p2.getAge();
                }
            });
        }
        return persons;
    }


    //Uses a Comparator function using Arrays of data (for casting)
    List<Person> getSortedPersons(List<Person> persons){
        if(persons != null){
            Person[] personsArray = new Person[persons.size()];
            personsArray = persons.toArray(personsArray);
            Arrays.sort(personsArray, (p1,p2) -> {
                if (p1.getAge() == p2.getAge()){
                    return p1.getName().compareTo(p2.getName());
                }else{
                    return p1.getAge() - p2.getAge();
                }
            });
            persons = Arrays.asList(personsArray);
        }
        return persons;
    }

}
@Data
@AllArgsConstructor
@ToString
class Person{
    int age;
    String name;
    Instant dob;
}
