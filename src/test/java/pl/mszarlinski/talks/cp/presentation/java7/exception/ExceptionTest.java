package pl.mszarlinski.talks.cp.presentation.java7.exception;

import org.junit.Test;

/**
 * Created by Maciej on 2015-03-13.
 */
public class ExceptionTest {
    @Test
    public void testManyExceptionsHandling() {
        try {
            foo();
        } catch (IllegalArgumentException | IllegalStateException | NullPointerException ex) {
            System.err.println(ex);
        }

        // will NOT compile

//        catch (Exception | IllegalStateException ex) {
//
//        }
    }

    private void foo() {
        throw new IllegalArgumentException("sample exception");
    }

    @Test
    public void testThrowOriginalException() throws InterruptedException {
        try {
            bar();
        } catch (Exception ex) {
            throw ex; // InterruptedException will be thrown
        }

    }

    private void bar() throws InterruptedException {
    }
}
