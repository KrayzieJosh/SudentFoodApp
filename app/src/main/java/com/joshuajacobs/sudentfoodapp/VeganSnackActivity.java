package com.joshuajacobs.sudentfoodapp;

public class VeganSnackActivity {
    private String snackName;
    private int snackImageResourceId;
    private double snackPrice;

    public VeganSnackActivity(String snackName, int snackImageResourceId, double snackPrice) {
        this.snackName = snackName;
        this.snackImageResourceId = snackImageResourceId;
        this.snackPrice = snackPrice;
    }

    public String getSnackName() {
        return snackName;
    }

    public int getSnackImageResourceId() {
        return snackImageResourceId;
    }

    public double getSnackPrice() {
        return snackPrice;
    }

    public void setSnackName(String snackName) {
        this.snackName = snackName;
    }

    public void setSnackImageResourceId(int snackImageResourceId) {
        this.snackImageResourceId = snackImageResourceId;
    }

    public void setSnackPrice(double snackPrice) {
        this.snackPrice = snackPrice;
    }
}
