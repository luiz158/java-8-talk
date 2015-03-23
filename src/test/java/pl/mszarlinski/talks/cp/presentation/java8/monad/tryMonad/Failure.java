package pl.mszarlinski.talks.cp.presentation.java8.monad.tryMonad;

import java.util.function.Function;

/**
 * Created by Maciej on 2015-03-13.
 */
public class Failure<T> implements Try<T> {

    private Throwable fault;

    public Failure(Throwable fault) {
        this.fault = fault;
    }

    @Override
    public T get() throws Throwable {
        throw fault;
    }

    @Override
    public Failure<T> flatMap(Function f) {
        return new Failure(fault);
    }

    @Override
    public T recoverWith(T o) {
        return o;
    }
}
