package org.capgemini.ConvertListOfJavaObject;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
    @JsonProperty("name")
    private String name;

    @JsonProperty("age")
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters (needed for Jackson)
    public String getName() { return name; }
    public int getAge() { return age; }
}

