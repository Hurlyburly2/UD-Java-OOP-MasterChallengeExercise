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

    public int addToBurger() {
        if (added) {
            System.out.println("You already added " + name);
            return 0;
        } else {
            this.added = true;
            return 1;
        }
    }

    public void outputListItem(int number) {
        if (!isAdded()) {
            System.out.println(" * " + name + " $" + String.format("%.2f", price) + " (" + number + ")");
        }
    }

    public void outputListItem() {
        System.out.println(" * " + name + " $" + String.format("%.2f", price));
    }

    public double pricingAtEnd() {
        if (added) {
            outputListItem();
            return this.price;
        } else {
            return 0;
        }
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
