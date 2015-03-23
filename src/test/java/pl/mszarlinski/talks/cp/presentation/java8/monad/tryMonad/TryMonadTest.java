package pl.mszarlinski.talks.cp.presentation.java8.monad.tryMonad;

import org.junit.Test;

/**
 * Created by Maciej on 2015-03-13.
 */
public class TryMonadTest {

    @Test
    public void test1() throws Exception {
        final Order order = new Order();

        final String message = trySaveOrder(order)
                .flatMap(id -> "Order successfully saved with id: " + id)
                .recoverWith("error has occurred");

        System.out.println(message);
    }

    @Test
    public void test2() throws Exception {
        final Order order = new Order();
        order.orderNumber = "123456";

        final String message = trySaveOrder(order)
                .flatMap(id -> "Order successfully saved with id: " + id)
                .recoverWith("error has occurred");

        System.out.println(message);
    }

    private Long saveOrder(Order order) {
        if (order.orderNumber == null) {
            throw new IllegalArgumentException("Order does not have a number");
        }

        System.out.println("Saving order...");
        return 1L;
    }


    private Try<Long> trySaveOrder(Order order) {
        try {
            return Try.of(saveOrder(order));
        } catch (Exception ex) {
            return new Failure<Long>(ex);
        }
    }

    private class Order {
        private long id;
        private String orderNumber;
    }
}
