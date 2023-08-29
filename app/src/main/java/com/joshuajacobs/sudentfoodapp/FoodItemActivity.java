package com.joshuajacobs.sudentfoodapp;

public class FoodItemActivity {
    private String foodName;
    private int imageResourceId;
    private double foodPrice;

    public FoodItemActivity(String name, int imageResourceId, double price) {
        this.foodName = name;
        this.imageResourceId = imageResourceId;
        this.foodPrice = price;
    }

    public String getName() {
        return foodName;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public double getPrice() {
        return foodPrice;
    }

    public void setName(String name) {
        this.foodName = name;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public void setPrice(double price) {
        this.foodPrice = price;
    }
}
