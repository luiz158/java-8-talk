package pl.mszarlinski.talks.cp.presentation.java7.stringInSwitch;

import org.junit.Test;

/**
 * Created by Maciej on 2015-03-13.
 */
public class SwitchTest {
    @Test
    public void test1() {
        String language = "Java";

        switch (language) {
            case "Pascal":
                System.out.println("Imperative");
                break;
            case "Java":
                System.out.println("Object oriented");
                break;
            case "Scala":
                System.out.println("Functional");
                break;
            default:
                System.out.println("Unknown language!");
        }
    }
}
