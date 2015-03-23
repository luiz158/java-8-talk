package pl.mszarlinski.talks.cp.presentation.java8.defaultMethod.diamondOfDeathProblem;

/**
 * Created by Maciej on 2015-03-13.
 */
public class Hybrid implements GasolineVehicle, ElectricVehicle {

    // ambiguous inherited method must be overriden

    @Override
    public void go() {
        GasolineVehicle.super.go(); // new syntax - referring to super class
    }
}
