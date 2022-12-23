package org.example;

public class Person {
    private String name;
    private String lastName;
    private int age;
    private String address;

    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        this.age = -1;
    }

    public Person(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = setAge(age);
    }

    private int setAge(int age) {
        return age >= 0 ? age : -1;
    }

    public boolean hasAge(){
        return age != -1;
    }

    public void happyBirthDay(){
        if (hasAge()) age++;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean hasAddress(){
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    PersonBuilder newChildBuilder(){
        return new PersonBuilder()
                .setLastName(this.lastName)
                .setAge(0)
                .setAddress(address);
    }

    @Override
    public String toString() {
        return lastName + " " + name + " (" + age + ")" + " из " + address;
    }
}
