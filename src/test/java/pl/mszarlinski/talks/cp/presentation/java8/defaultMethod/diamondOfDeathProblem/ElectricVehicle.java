package pl.mszarlinski.talks.cp.presentation.java8.defaultMethod.diamondOfDeathProblem;

/**
 * Created by Maciej on 2015-03-13.
 */
public interface ElectricVehicle {
    default void go() {
        System.out.println("go using electricity");
    }
}
