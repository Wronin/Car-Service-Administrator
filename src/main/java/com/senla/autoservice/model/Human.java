package com.senla.autoservice.model;

public class Human {
    private String name;
    private String lastName;
    private int phoneNumber;
    private String address;

    public Human(String name, String lastName, int phoneNumber, String address) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Human() {}

    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }
}
