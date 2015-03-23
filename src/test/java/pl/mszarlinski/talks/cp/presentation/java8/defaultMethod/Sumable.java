package pl.mszarlinski.talks.cp.presentation.java8.defaultMethod;

import java.util.Iterator;

/**
 * Created by Maciej on 2015-03-13.
 */
public interface Sumable {
    Iterator<Integer> iterator(); // implicitly public abstract

    // inherit behaviour, not state

    default int sum() { // implicitly public
        final Iterator<Integer> iterator = iterator();
        int accumulator = 0;
        while (iterator.hasNext()) {
            accumulator += iterator.next();
        }
        return accumulator;
    }

    // static function in interface

    static boolean isPositive(Sumable s) { // implicitly public
        return s.sum() > 0;
    }
}
