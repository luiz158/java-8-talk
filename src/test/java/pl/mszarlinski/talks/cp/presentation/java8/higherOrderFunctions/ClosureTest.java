package pl.mszarlinski.talks.cp.presentation.java8.higherOrderFunctions;

import org.junit.Test;

import java.util.concurrent.Callable;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by Maciej on 2015-03-18.
 */
public class ClosureTest {

    @Test
    public void shouldAccessOuterScope() throws Exception {
        // given
        int ten = 10; // effectively final
        // when
        Callable<Integer> multiplier = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return  2 * ten;
            }
        };

        // then
        assertThat(multiplier.call()).isEqualTo(20);
    }
}
