package pl.mszarlinski.talks.cp.presentation.java8.monad.tryMonad;

import java.util.function.Function;

/**
 * Created by Maciej on 2015-03-13.
 */
public interface Try<T> {

    // MONAD METHODS

    static <T> Try<T> of(T value) {
        return new Success<T>(value);
    }
    <R> Try<R> flatMap(Function<? super T, ? extends R> f); // reduction of nested Try

    // OPERATIONS

    T get() throws Throwable; // exit from monad
    T recoverWith(T o);
}
