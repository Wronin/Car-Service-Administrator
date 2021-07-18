package com.senla.autoservice.model;

import java.util.ArrayList;

public class Organization {

    private String name;
    private String address;
    private ArrayList<Garage> workplaces;

    public Organization(String name, String address) {
        this.name = name;
        this.address = address;
    }
    public Organization() {

    }

    public ArrayList<Garage> getWorkplaces() {
        return workplaces;
    }

    public void setWorkplaces(ArrayList<Garage> workplaces) {
        this.workplaces = workplaces;
    }
}
