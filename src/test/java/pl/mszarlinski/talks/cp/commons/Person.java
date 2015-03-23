package pl.mszarlinski.talks.cp.commons;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Maciej on 2015-03-20.
 */
public class Person {
    private String name;
    private List<Phone> phones = new ArrayList<>();
    private Optional<Address> address = Optional.empty();
    private float salary;

    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<Address> getAddress() {
        return address;
    }

    public void setAddress(Optional<Address> address) {
        this.address = address;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person [" + name + "]";
    }
}
