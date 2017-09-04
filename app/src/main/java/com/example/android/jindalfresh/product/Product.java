package com.example.android.jindalfresh.product;

import android.app.LauncherActivity;

import java.io.Serializable;


public class Product extends LauncherActivity.ListItem implements Serializable {
    private String engName;
    private String hindiName;
    private int rate;
    private int totalQuantity;
    private String imageUrl;
    private String unit;
    private String productId;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }



    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int quantityValue) {
        this.totalQuantity = quantityValue;
    }

    public void setDefaultQuantity() {
        this.totalQuantity = 1;
    }

    public void doIncrement() {
        totalQuantity += 1;
    }

    public int totalPrice() {
        return totalQuantity * rate;
    }

    public void doDecrement() {
        totalQuantity -= 1;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = "http://lit-dusk-68336.herokuapp.com" + imageUrl;
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public String getHindiName() {
        return hindiName;
    }

    public void setHindiName(String hindiName) {
        this.hindiName = hindiName;
    }
}

