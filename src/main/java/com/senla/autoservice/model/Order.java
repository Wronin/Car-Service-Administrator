package com.senla.autoservice.model;

import java.util.Date;

public class Order {
    private Client client;
    private Date time;
    private Date date;
    private Date newDate;
    private State state;
    private Master master;
    private int price;

    public Order(Client client, Date time, Date date, Date newDate, State state, Master master, int price) {
        this.client = client;
        this.time = time;
        this.date = date;
        this.newDate = newDate;
        this.state = state;
        this.master = master;
        this.price = price;
    }
    public Order() {
        this.state = State.CREATED;
    }

    public Date getDate() {
        return date;
    }

    public Date getNewDate() {
        return newDate;
    }

    public Master getMaster() {
        return master;
    }

    public Client getClient() {
        return client;
    }

    public Date getTime() {
        return time;
    }

    public State getState() {
        return state;
    }

    public int getPrice() {
        return price;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setNewDate (Date newDate) {
        this.newDate = newDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "problem='" + client.toString() + '\'' +
                ", time=" + time +
                ", date=" + date +
                ", newDate=" + newDate +
                ", state='" + state + '\'' +
                ", master=" + master +
                ", price=" + price +
                '}';
    }
}

