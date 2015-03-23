package pl.mszarlinski.talks.cp.presentation.java8.monad.trivialMonad;

import java.util.function.Function;

/**
 * Created by Maciej on 2015-03-15.
 */
public class Trivial<T> {
    private T value;

    private Trivial(T value) {
        this.value = value;
    }

    public <R> R flatMap(Function<T, R> function) {
        return function.apply(value);
    }

    public static <T> Trivial<T> of(T value) {
        return new Trivial<T>(value);
    }
}
