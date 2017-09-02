package com.example.android.jindalfresh.product;

import android.app.LauncherActivity;


public class Product extends LauncherActivity.ListItem {
    private String engName;
    private String hindiName;
    private int totalQuantity;
    private String imageUrl;

    private int initialQuantity = 1;

    public Product(String engName, String hindiName, String imageUrl) {

        this.engName = engName;
        this.hindiName = hindiName;
        this.imageUrl = imageUrl;
        setTotalQuantity(initialQuantity);
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int quantityValue) {
        this.totalQuantity = quantityValue;
    }

    public void doIncrement() {
        totalQuantity += 1;
    }

//    public int totalPrice() {
//        return totalQuantity*
//    }

    public void doDecrement() {
        totalQuantity -= 1;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getEngName() {
        return engName;
    }

    public String getHindiName() {
        return hindiName;
    }
}

