package io.fluent.testlibs.instanceio;

import lombok.Data;

@Data
public class Person {
    private String firstName;
    private String lastName;
    private Address city;
    private Gender gender;
    private int age;
}
