package pl.mszarlinski.talks.cp.presentation.java8.monad.tryMonad;

import java.util.function.Function;

/**
 * Created by Maciej on 2015-03-13.
 */
public class Success<T> implements Try<T> {

    private T value;

    public Success(T value) {
        this.value = value;
    }

    @Override
    public T get() {
        return value;
    }

    @Override
    public <R> Try<R> flatMap(Function<? super T, ? extends R> f) {
        try {
            return Try.of(f.apply(value));
        } catch (Throwable t) {
            return new Failure(t);
        }
    }

    @Override
    public T onFailure(T o) {
        return value;
    }
}
