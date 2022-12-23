package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PersonBuilderTest {
    @Test
    void createPerson(){
        String lastname = "Павлов";
        String name = "Алексей";
        int age = 34;
        String address = "Хабаровск";
        Person person = new PersonBuilder()
                .setLastName(lastname)
                .setName(name)
                .setAge(age)
                .setAddress(address)
                .build();

        assertEquals(lastname, person.getLastName());
        assertEquals(name, person.getName());
        assertEquals(age, person.getAge());
        assertEquals(address, person.getAddress());
    }

    @ParameterizedTest
    @CsvSource({
            "-2",
            "130"
    })
    void checkExceptionWhenSetIncorrectAge(int age){
        assertThrows(IllegalStateException.class, () -> new PersonBuilder().setAge(age));
    }

    @Test
    void checkExceptionWhenSetIncorrectNames(){
        assertThrows(IllegalStateException.class, () -> new PersonBuilder().setName(null));
        assertThrows(IllegalStateException.class, () -> new PersonBuilder().setName(""));
        assertThrows(IllegalStateException.class, () -> new PersonBuilder().setLastName(null));
        assertThrows(IllegalStateException.class, () -> new PersonBuilder().setLastName(""));
    }

    @Test
    void createPersonWithoutData(){
        assertThrows(IllegalStateException.class, () -> new PersonBuilder().build());
        assertThrows(IllegalStateException.class, () -> new PersonBuilder().setName("Name").build());
        assertThrows(IllegalStateException.class, () -> new PersonBuilder().setName("Name").setLastName("").build());
        assertThrows(IllegalStateException.class, () -> new PersonBuilder().setLastName("Lastname").build());
        assertThrows(IllegalStateException.class, () -> new PersonBuilder().setLastName("Lastname").setName("").build());
        assertDoesNotThrow(() -> new PersonBuilder().setName("Name").setLastName("Lastname").build());
    }
}