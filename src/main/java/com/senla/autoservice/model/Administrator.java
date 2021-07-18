package com.senla.autoservice.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Administrator extends Human {

    private String position;
    private int salary;
    private ArrayList<Order> orders;
    private Calendar calendar = new GregorianCalendar();

    public Administrator(String name, String position, int salary) {
        super(name);
        this.position = position;
        this.salary = salary;
    }

}
