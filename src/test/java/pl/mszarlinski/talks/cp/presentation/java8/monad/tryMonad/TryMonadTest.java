package pl.mszarlinski.talks.cp.presentation.java8.monad.tryMonad;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Maciej on 2015-03-13.
 */
public class TryMonadTest {

    @Test
    public void testFailure() throws Exception {
        // given
        final Order order = new Order();
        // when
        final String message = saveOrderAndGetMessage(order);
        // then
        assertEquals("error has occurred", message);
    }

    private String saveOrderAndGetMessage(Order order) {
        return trySaveOrder(order)
                .flatMap(id -> "Order successfully saved with id: " + id)
                .onFailure("error has occurred");
    }

    @Test
    public void testSuccess() throws Exception {
        // given
        final Order order = new Order();
        order.orderNumber = "123456";
        // when
        final String message = saveOrderAndGetMessage(order);
        // then
        assertEquals("Order successfully saved with id: 1", message);
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
            return Try.of(saveOrder(order)); // success
        } catch (Exception ex) {
            return new Failure<>(ex);        // failure
        }
    }

    private class Order {

        private long id;

        private String orderNumber;
    }
}
