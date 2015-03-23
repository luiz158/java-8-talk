package pl.mszarlinski.talks.cp.presentation.java8.stream;

import org.junit.Before;
import org.junit.Test;
import pl.mszarlinski.talks.cp.commons.Person;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * Created by Maciej on 2015-03-20.
 */
public class ConsumingStreamTest {

    private List<Person> PEOPLE;

    @Before
    public void setUp() {
        Person p1 = new Person("Zuzia");
        p1.setSalary(1000);

        Person p2 = new Person("Krzysio");
        p2.setSalary(2000);

        Person p3 = new Person("Stanisława");
        p3.setSalary(1500);

        Person p4 = new Person("Włodzimierz");
        p4.setSalary(2000);

        PEOPLE = asList(p1, p2, p3, p4);
    }

    @Test
    public void testJoining() {
        String result = PEOPLE.stream()
                .map(Person::getName)
                .collect(Collectors.joining(", "));
        System.out.println(result);
    }


    @Test
    public void testGroupingBy() {
        Map<Float, List<Person>> result = PEOPLE.stream()
                .collect(Collectors.groupingBy(Person::getSalary));
        System.out.println(result);
    }

    @Test
    public void testPartitioningBy() {
        Map<Boolean, List<Person>> result = PEOPLE.stream()
                .collect(Collectors.partitioningBy(
                        p -> p.getSalary() > 1000));
        System.out.println(result);
    }

    @Test
    public void testReduce() {
        float totalSalary = PEOPLE.stream()
                .map(Person::getSalary)
                .reduce(0f, Float::sum);
        System.out.println(totalSalary);
    }
}
