package com.joshuajacobs.sudentfoodapp;

public class SafariFlavorsSnacksItem {
    private String itemName;
    private double itemPrice;
    private int itemImageResourceId;

    public SafariFlavorsSnacksItem(String name, double price, int imageResourceId) {
        this.itemName = name;
        this.itemPrice = price;
        this.itemImageResourceId = imageResourceId;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public int getItemImageResourceId() {
        return itemImageResourceId;
    }

    public void setItemName(String name) {
        this.itemName = name;
    }

    public void setItemPrice(double price) {
        this.itemPrice = price;
    }

    public void setItemImageResourceId(int imageResourceId) {
        this.itemImageResourceId = imageResourceId;
    }
}
