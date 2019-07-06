package com.dsimon;

import java.util.Scanner;

public class Burger {
    private String name;
    private double price;
    private String roll;
    private String meat;
    private int toppings;
    private int maxToppings;
    private Addition lettuce = new Lettuce();
    private Addition tomato = new Tomato();
    private Addition cheese = new Cheese();
    private Addition onion = new Onion();

    private int getToppings() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(lettuce.getClass());
        while (toppings < maxToppings) {
            System.out.println("Select a topping (" + toppings + "/" + maxToppings + "):");
            int counter = 1;
            System.out.println(" * Done (0)");
            if (!this.lettuce.isAdded()) {
                System.out.println(" * " + lettuce.getName() + " $" + String.format("%.2f", lettuce.getPrice()) + " (1)");
            }
            if (!this.tomato.isAdded()) {
                System.out.println(" * " + tomato.getName() + " $" + String.format("%.2f", tomato.getPrice()) + " (2)");
            }
            if (!this.cheese.isAdded()) {
                System.out.println(" * " + cheese.getName() + " $" + String.format("%.2f", cheese.getPrice()) + " (3)");
            }
            if (!this.onion.isAdded()) {
                System.out.println(" * " + onion.getName() + " $" + String.format("%.2f", onion.getPrice()) + " (4)");
            }

            boolean hasNextInt = scanner.hasNextInt();
            if (hasNextInt) {
                int selection = scanner.nextInt();

                switch (selection) {
                    case 0:
                        scanner.close();
                        return -1;
                    case 1:
                        if (!this.lettuce.isAdded()) {
                            toppings++;
                        } else {
                            System.out.println("You already added " + lettuce.getName());
                        }
                        this.lettuce.addToBurger();
                        break;
                    case 2:
                        if (!this.tomato.isAdded()) {
                            toppings++;
                        } else {
                            System.out.println("You already added " + tomato.getName());
                        }
                        this.tomato.addToBurger();
                        break;
                    case 3:
                        if (!this.cheese.isAdded()) {
                            toppings++;
                        } else {
                            System.out.println("You already added " + cheese.getName());
                        }
                        this.cheese.addToBurger();
                        break;
                    case 4:
                        if (!this.onion.isAdded()) {
                            toppings++;
                        } else {
                            System.out.println("You already added " + onion.getName());
                        }
                        this.onion.addToBurger();
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

    public Burger() {
        this.name = "Regular Burger";
        this.price = 9.00;
        this.roll = "Sesame";
        this.meat = "Ground Beef";
        this.toppings = 0;
        this.maxToppings = 4;

        getToppings();
    }

    public void priceBurger() {
        double totalPrice = price;

        System.out.println("\n\nThe price for your " + meat + " " + name + " on a " + roll + " roll is:\n" +
                            " * Burger: $" + String.format("%.2f", price));
        if (lettuce.isAdded()) {
            System.out.println(" * " + lettuce.getName() + " $" + String.format("%.2f", lettuce.getPrice()));
            totalPrice += lettuce.getPrice();
        }
        if (tomato.isAdded()) {
            System.out.println(" * " + tomato.getName() + " $" + String.format("%.2f", tomato.getPrice()));
            totalPrice += tomato.getPrice();
        }
        if (cheese.isAdded()) {
            System.out.println(" * " + cheese.getName() + " $" + String.format("%.2f", cheese.getPrice()));
            totalPrice += cheese.getPrice();
        }
        if (onion.isAdded()) {
            System.out.println(" * " + onion.getName() + " $" + String.format("%.2f", onion.getPrice()));
            totalPrice += onion.getPrice();
        }
        System.out.println("\nYour total price was: $" + String.format("%.2f", totalPrice));
    }
}
