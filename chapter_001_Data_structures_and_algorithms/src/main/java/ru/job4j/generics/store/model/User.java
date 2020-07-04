package ru.job4j.generics.store.model;

public class User extends Base {
    private String firstName;
    private String lastName;
    private int age;

    public User(String id, String firstName, String lastName, int age) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
