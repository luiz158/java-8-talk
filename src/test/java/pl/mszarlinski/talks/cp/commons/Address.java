package pl.mszarlinski.talks.cp.commons;

import java.util.Optional;

/**
 * Created by Maciej on 2015-03-20.
 */
public class Address {
    private Optional<String> street;

    public Optional<String> getStreet() {
        return street;
    }

    public void setStreet(Optional<String> street) {
        this.street = street;
    }
}
