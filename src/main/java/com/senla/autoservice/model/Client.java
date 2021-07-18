package com.senla.autoservice.model;

public class Client extends Human {

    private String problem;

    public Client(String name, String problem) {
        super(name);
        this.problem = problem;
    }

    @Override
    public String toString() {
        return "Client{" +
                "problem='" + problem + '\'' +
                '}';
    }
}
