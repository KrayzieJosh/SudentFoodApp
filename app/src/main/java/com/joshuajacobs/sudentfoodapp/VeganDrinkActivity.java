package com.joshuajacobs.sudentfoodapp;

public class VeganDrinkActivity {
    private String vDrinkName; // Changed variable name
    private int drinkImageResourceId;
    private double vDrinkPrice; // Changed variable name

    public VeganDrinkActivity(String vDrinkName, int drinkImageResourceId, double vDrinkPrice) {
        this.vDrinkName = vDrinkName;
        this.drinkImageResourceId = drinkImageResourceId;
        this.vDrinkPrice = vDrinkPrice;
    }

    public String getVDrinkName() {
        return vDrinkName;
    }

    public int getDrinkImageResourceId() {
        return drinkImageResourceId;
    }

    public double getVDrinkPrice() {
        return vDrinkPrice;
    }

    public void setVDrinkName(String vDrinkName) {
        this.vDrinkName = vDrinkName;
    }

    public void setDrinkImageResourceId(int drinkImageResourceId) {
        this.drinkImageResourceId = drinkImageResourceId;
    }

    public void setVDrinkPrice(double vDrinkPrice) {
        this.vDrinkPrice = vDrinkPrice;
    }
}

