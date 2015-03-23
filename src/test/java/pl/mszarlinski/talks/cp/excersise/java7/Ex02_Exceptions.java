package pl.mszarlinski.talks.cp.excersise.java7;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Created by Maciej on 2015-03-18.
 */
public class Ex02_Exceptions {

    private ReflectionUtil reflectionUtil = new ReflectionUtil();

    /**
     * TODO: Rewrite code of ReflectionUtil using multiple exceptions handling.
     */
    @Test
    public void shouldCatchExceptions() {
        // given
        Consultant consultant = new Consultant("Zdzisław");
        // when
        reflectionUtil.setField(consultant, "name", "Józef");
        // then
        assertEquals("Józef", consultant.whatsYourName());
    }
}
