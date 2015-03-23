package pl.mszarlinski.talks.cp.presentation.java8.stream;

import org.fest.assertions.api.Assertions;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Math.sqrt;
import static java.util.Arrays.asList;
import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Created by Maciej on 2015-03-20.
 */
public class CreatingStreamsTest {

    @Test
    public void testOf() {
        Stream<Integer> simpleStream = Stream.of(1, 2, 3);

        assertEquals(3, simpleStream.count());
    }

    @Test
    public void testFromCollection() {
        // given
        final List<String> names = asList("Józek", "Stefan", "Zosia");
        // when
        Stream<String> stream = names.stream();
        // then
        assertEquals(3, stream.count());
    }

    @Test
    public void testInfiniteStream() {
        Random r = new Random();
        Stream<Integer> infiniteStream = Stream.generate(() -> r.nextInt());

        infiniteStream.limit(10).collect(Collectors.toList()).forEach(System.out::println);
    }

    @Test
    public void testPrimeNumbers() {
        // given
        IntStream primeStream = IntStream.iterate(2, Primes::next);
        // when
        final List<Integer> numbers = primeStream.limit(10).boxed().collect(Collectors.toList());
        // then
        assertThat(numbers).containsExactly(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
    }

    private static class Primes {
        public static int next(int n) {
            int result = n + 1;
            while (!isPrime(result)) {
                result++;
            }
            return result;
        }

        private static boolean isPrime(int n) {
            return n > 1 && IntStream.rangeClosed(2, (int) sqrt(n)).noneMatch(divisor -> n % divisor == 0);
        }
    }

    @Test
    public void testFibonacciNumbers() {
        // given
        IntStream fibonacciStream = Stream.iterate(
                new int[]{1, 1},
                tab -> new int[]{tab[1], tab[0] + tab[1]})
                .mapToInt(tab -> tab[0]);
        // when
        final List<Integer> numbers = fibonacciStream.limit(10).boxed().collect(Collectors.toList());
        // then
        assertThat(numbers).containsExactly(1, 1, 2, 3, 5, 8, 13, 21, 34, 55);
    }
}
