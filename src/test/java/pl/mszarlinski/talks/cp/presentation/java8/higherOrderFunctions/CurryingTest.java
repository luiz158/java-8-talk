package pl.mszarlinski.talks.cp.presentation.java8.higherOrderFunctions;

import org.junit.Test;

import java.util.function.Function;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maciej on 2015-03-18.
 */
public class CurryingTest {

    @Test
    public void shouldReturnFunction() throws Exception {
        // given
        Function<Integer, Function<Integer, Integer>> adder = offset -> n -> n + offset;
        Function<Integer, Integer> incrementator = adder.apply(1);
        // when
        int result = incrementator.apply(10);
        // then
        assertEquals(11, result);
    }
}
