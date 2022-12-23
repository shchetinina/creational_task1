package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @ParameterizedTest
    @CsvSource({
            "Александр, Рыхлов, , false",
            "Александр, Рыхлов, Сосновка, true",
    })
    void createPersonWithoutAge(String name, String lastname, String address, boolean hasAddress){
        Person person = new Person(name, lastname);
        person.setAddress(address);

        assertEquals(name, person.getName());
        assertEquals(lastname, person.getLastName());
        assertFalse(person.hasAge());
        assertEquals(-1, person.getAge());
        assertEquals(hasAddress, person.hasAddress());
    }

    @ParameterizedTest
    @CsvSource({
            "23, true",
            "-100, false",
            "0, true"
    })
    void createPersonWithAge(int age, boolean hasAge){
        String name = "Александр";
        String lastname = "Рыхлов";
        Person person = new Person(name, lastname, age);

        assertEquals(hasAge, person.hasAge());
        assertEquals(age >= 0 ? age : -1, person.getAge());
    }

    @Test
    void createChild(){
        String lastname = "Васечкин";
        String address = "Новгород";
        Person parent = new Person("Андрей", lastname, 44);
        parent.setAddress(address);

        Person child = parent.newChildBuilder().build();

        assertEquals(parent.getLastName(), child.getLastName());
        assertEquals(0, child.getAge());
        assertNull(child.getName());
        assertEquals(parent.getAddress(), child.getAddress());
    }
}