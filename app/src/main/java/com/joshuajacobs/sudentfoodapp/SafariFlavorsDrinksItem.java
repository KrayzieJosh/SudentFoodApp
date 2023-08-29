package com.joshuajacobs.sudentfoodapp;

public class SafariFlavorsDrinksItem {
    private String itemName;
    private double itemPrice;

    public SafariFlavorsDrinksItem(String name, double price) {
        this.itemName = name;
        this.itemPrice = price;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemName(String name) {
        this.itemName = name;
    }

    public void setItemPrice(double price) {
        this.itemPrice = price;
    }
}
