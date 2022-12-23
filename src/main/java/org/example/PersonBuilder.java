package org.example;

public class PersonBuilder {
    private String name;
    private String lastName;
    private int age;
    private String address;
    public Person build(){
        if (name == null || name.isBlank() || lastName == null || lastName.isBlank())
            throw new IllegalStateException("You didn't fill name or lastname");
        Person person = new Person(name, lastName, age);
        person.setAddress(address);
        return person;
    }

    public PersonBuilder setName(String name) {
        if (name == null || name.isBlank()) throw new IllegalStateException("You didn't fill name");
        this.name = name;
        return this;
    }

    public PersonBuilder setLastName(String lastName) {
        if (lastName == null || lastName.isBlank()) throw new IllegalStateException("You didn't fill lastname");
        this.lastName = lastName;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0 || age > 125) throw new IllegalStateException("You wrote incorrect age");
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }
}
