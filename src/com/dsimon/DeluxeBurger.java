package com.dsimon;

public class DeluxeBurger extends Burger {
    private Chips chips = new Chips();
    private Drink drink = new Drink();

    public DeluxeBurger() {
        super("Deluxe Burger", 9.00, "Sesame", "Beef", 4);
        chips.addToBurger();
        drink.addToBurger();
    }

    @Override
    public void getTotalPrice() {
        double price = priceBurger();
        System.out.println("Your burger's price was: $" + String.format("%.2f", price));

        System.out.println("Sides:");
        price += this.chips.pricingAtEnd();
        price += this.drink.pricingAtEnd();
        System.out.println("Your Total: " + String.format("%.2f", price));
    }
}
