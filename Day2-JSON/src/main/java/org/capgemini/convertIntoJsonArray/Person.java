package org.capgemini.convertIntoJsonArray;

public class Person {
    private String name;
    private int age;

    //  Default constructor (needed for Jackson)
    public Person() {}

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //  Getters and Setters (required for serialization)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}

