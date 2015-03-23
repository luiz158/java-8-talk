package pl.mszarlinski.talks.cp.presentation.java8.optional;

import org.junit.Assert;
import org.junit.Test;
import pl.mszarlinski.talks.cp.commons.Address;
import pl.mszarlinski.talks.cp.commons.Person;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maciej on 2015-03-13.
 */
public class OptionalTest {

    @Test
    public void testSimpleUsage() {
        // given
        Optional<String> maybe = Optional.empty();

        // when
        if (maybe.isPresent()) {
            Assert.fail();
        }

        String language = maybe.orElse("Java");

        // then
        assertEquals("Java", language);
    }

    @Test(expected = NullPointerException.class)
    public void testFailFast() {
        Optional.of(null);
    }

    /**
     * Wersja "bieda".
     */
    @Test
    public void testImperativeUsage() {
        Optional<Person> maybePerson = Optional.of(new Person());

        if (maybePerson.isPresent()) {
            Optional<Address> address = maybePerson.get().getAddress();
            if (address.isPresent()) {
                Optional<String> street = address.get().getStreet();
                if (street.isPresent()) {
                    processStreet(street.get());
                }
            }
        }
    }

    private static void processStreet(String street) {
        System.out.println("Street: " + street);
    }

    @Test
    public void testMonadicUsage() {
        Optional<Person> maybePerson = Optional.of(new Person());

        maybePerson.flatMap(p -> p.getAddress())
                   .flatMap(a -> a.getStreet())
                   .ifPresent(OptionalTest::processStreet);
    }

    @Test
    public void testAutomaticNullToEmptyTransformation() {
        // given
        Optional<Person> maybePerson = Optional.of(new Person(null));

        // when
        int length = maybePerson.map(p -> p.getName())
                .map(s -> s.length()) // this will explode in Guava
                .orElse(0);

        // then
        assertEquals(0, length);
    }

    @Test(expected = NullPointerException.class)
    public void testAutomaticNullToEmptyTransformation_Guava() {
        // given
        com.google.common.base.Optional<Person> maybePerson = com.google.common.base.Optional.of(new Person(null));

        // when
        int length = maybePerson.transform(p -> p.getName())
                .transform(s -> s.length())
                .or(0);
    }
}