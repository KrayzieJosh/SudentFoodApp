package com.joshuajacobs.sudentfoodapp;

public class FadeelsFoodItem {
    private String itemName;
    private int itemImageResourceId;
    private double itemPrice;

    public FadeelsFoodItem(String name, int imageResourceId, double price) {
        this.itemName = name;
        this.itemImageResourceId = imageResourceId;
        this.itemPrice = price;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemImageResourceId() {
        return itemImageResourceId;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemName(String name) {
        this.itemName = name;
    }

    public void setItemImageResourceId(int imageResourceId) {
        this.itemImageResourceId = imageResourceId;
    }

    public void setItemPrice(double price) {
        this.itemPrice = price;
    }
}
