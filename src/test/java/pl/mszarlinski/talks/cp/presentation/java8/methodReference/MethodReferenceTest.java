package pl.mszarlinski.talks.cp.presentation.java8.methodReference;

import org.junit.Test;
import pl.mszarlinski.talks.cp.commons.Person;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by Maciej on 2015-03-13.
 */
public class MethodReferenceTest {

    @Test
    public void testStaticMethods() {
        Function<String, Integer> ref = Integer::parseInt;
        int i = ref.apply("10");
        System.out.println(i);

        BiFunction<Integer, Integer, Integer> biFunction = Integer::sum;
        int sum = biFunction.apply(3, 6);
        System.out.println(sum);
    }

    @Test
    public void testInstanceMethods() {
        Function<String, Integer> ref = String::length;
        int i = ref.apply("Java");
        System.out.println(i);

        Consumer<String> consumer = System.out::println;
        consumer.accept("Ala ma kota");
    }

    class Calculator {
        int sum(int x, int y) {
            return x + y;
        }
    }

    @Test
    public void testInstanceMethodsOnObject() {
        Calculator c = new Calculator();

        BiFunction<Integer, Integer, Integer> sumFunction = c::sum;
        int sum = sumFunction.apply(1, 5);
        System.out.println(sum);
    }

    @Test
    public void testConstructors() {
        Function<String, Person> createPersonFunction = Person::new;
        Person p = createPersonFunction.apply("Marian");

        System.out.println(p.getName());
    }
}
