package pl.mszarlinski.talks.cp.presentation.java8.stream;

import java.util.stream.IntStream;

import static java.lang.Math.sqrt;

/**
 * Created by Maciej on 2015-03-20.
 */
public class Primes {

    public static int next(int n) {
        int result = n + 1;
        while(!isPrime(result)) {
            result++;
        }
        return result;
    }

    private static boolean isPrime(int n) {
        return n > 1 && IntStream.rangeClosed(2, (int) sqrt(n)).noneMatch(divisor -> n % divisor == 0);
    }
}
