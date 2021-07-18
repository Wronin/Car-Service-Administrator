package com.senla.autoservice.model;

public class Master extends Human {

    private String position;
    private int salary;
    private int free;

    public Master(String name, String position, int salary, int free) {
        super(name);
        this.position = position;
        this.salary = salary;
        this.free = free;
    }

    public Master(String name, String lastName, int phoneNumber, String address, String position, int salary, int free) {
        super(name, lastName, phoneNumber, address);
        this.position = position;
        this.salary = salary;
        this.free = free;
    }

    public int getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    public int getFree() {
        return free;
    }

    public void setFree(int free) {
        this.free = free;
    }

    @Override
    public String toString() {
        return "Master{" +
                "position='" + position + '\'' +
                ", salary=" + salary +
                ", free=" + free +
                '}';
    }
}
