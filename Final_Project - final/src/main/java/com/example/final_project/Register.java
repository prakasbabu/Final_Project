package com.example.final_project;

public class Register {
    protected String email;
    protected String name;
    protected int age;
    protected String password;

    public Register() {
        super();

    }

    public Register(String email, String name, int age, String password) {
        this.email = email;
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }

}
