package com.joshuajacobs.sudentfoodapp;

public class VeganItemActivity {
    private String veganFoodName;
    private int veganImageResourceId;
    private double veganFoodPrice;

    public VeganItemActivity(String name, int imageResourceId, double price) {
        this.veganFoodName = name;
        this.veganImageResourceId = imageResourceId;
        this.veganFoodPrice = price;
    }

    public String getVeganName() {
        return veganFoodName;
    }

    public int getVeganImageResourceId() {
        return veganImageResourceId;
    }

    public double getVeganPrice() {
        return veganFoodPrice;
    }

    public void setVeganName(String name) {
        this.veganFoodName = name;
    }

    public void setVeganImageResourceId(int imageResourceId) {
        this.veganImageResourceId = imageResourceId;
    }

    public void setVeganPrice(double price) {
        this.veganFoodPrice = price;
    }
}
