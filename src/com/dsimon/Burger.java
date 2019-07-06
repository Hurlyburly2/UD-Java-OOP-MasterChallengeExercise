package com.dsimon;

import java.util.Scanner;

public class Burger {
    private String name;
    private double price;
    private String roll;
    private String meat;
    private int toppings;
    private int maxToppings;
    private Lettuce lettuce = new Lettuce();
    private Tomato tomato = new Tomato();
    private Cheese cheese = new Cheese();
    private Onion onion = new Onion();
    private Bacon bacon = new Bacon();
    private Mushroom mushroom = new Mushroom();

    private int getToppings() {
        Scanner scanner = new Scanner(System.in);

        while (this.toppings < this.maxToppings) {
            System.out.println("Select a topping (" + this.toppings + "/" + this.maxToppings + "):");
            int counter = 1;
            System.out.println(" * Done (0)");
            this.lettuce.outputListItem(1);
            this.tomato.outputListItem(2);
            this.cheese.outputListItem(3);
            this.onion.outputListItem(4);
            this.bacon.outputListItem(5);
            this.mushroom.outputListItem(6);

            boolean hasNextInt = scanner.hasNextInt();
            if (hasNextInt) {
                int selection = scanner.nextInt();

                switch (selection) {
                    case 0:
                        scanner.close();
                        return -1;
                    case 1:
                        this.toppings += this.lettuce.addToBurger();
                        break;
                    case 2:
                        this.toppings += this.tomato.addToBurger();
                        break;
                    case 3:
                        this.toppings += this.cheese.addToBurger();
                        break;
                    case 4:
                        this.toppings += this.onion.addToBurger();
                        break;
                    case 5:
                        this.toppings += this.bacon.addToBurger();
                        break;
                    case 6:
                        this.toppings += this.mushroom.addToBurger();
                        break;
                    default:
                        System.out.println("Invalid Input");
                }
            } else {
                System.out.println("Invalid Input");
            }
            scanner.nextLine();
        }
        scanner.close();
        return -1;
    }

    public Burger(String name, double price, String roll, String meat, int maxToppings) {
        this.name = name;
        this.price = price;
        this.roll = roll;
        this.meat = meat;
        this.toppings = 0;
        this.maxToppings = maxToppings;

        getToppings();
    }

    public double priceBurger() {
        double totalPrice = this.price;

        System.out.println("\n\nThe price for your " + this.meat + " " + this.name + " on a " + this.roll + " roll is:\n" +
                            " * Burger: $" + String.format("%.2f", this.price));
        totalPrice += this.lettuce.pricingAtEnd();
        totalPrice += this.tomato.pricingAtEnd();
        totalPrice += this.cheese.pricingAtEnd();
        totalPrice += this.onion.pricingAtEnd();
        totalPrice += this.bacon.pricingAtEnd();
        totalPrice += this.mushroom.pricingAtEnd();
        return totalPrice;
    }

    public void getTotalPrice() {
        double price = priceBurger();
        System.out.println("Your total price was: $" + String.format("%.2f", price));
    }
}
