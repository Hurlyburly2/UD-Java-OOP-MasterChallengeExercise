package com.dsimon;

public class Addition {
    private String name;
    private double price;
    private boolean added;

    public Addition(String name, double price) {
        this.name = name;
        this.price = price;
        this.added = false;
    }

    public void addToBurger() {
        this.added = true;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAdded() {
        return added;
    }
}
