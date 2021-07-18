package com.senla.autoservice.model;

public class Garage {
    private String address;
    private int numberPlace;
    private Order order;

    public Garage(String address, int numberPlace, Order order) {
        this.address = address;
        this.numberPlace = numberPlace;
        this.order = order;
    }
    public Garage() {

    }

    public String getAddress() {
        return address;
    }

    public int getNumberPlace() {
        return numberPlace;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
