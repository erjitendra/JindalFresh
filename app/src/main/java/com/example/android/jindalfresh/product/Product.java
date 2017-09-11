package com.example.android.jindalfresh.product;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;


public class Product implements Serializable {

    @SerializedName("name")
    private String engName;

    private ArrayList<Integer> qunatityInterval;

    @SerializedName("hindi_name")
    private String hindiName;

    @SerializedName("rate")
    private int rate;
    private int quantityIntervalValue = 1;


    @SerializedName("quantity")
    private int totalQuantity;

    @SerializedName("image_path")
    private String imageUrl;

    @SerializedName("unit")
    private String unit;

    @SerializedName("product_id")
    private String productId;

    public ArrayList<Integer> getQunatityInterval() {
        return qunatityInterval;
    }

    public void setQunatityInterval(ArrayList<Integer> qunatityInterval) {
        this.qunatityInterval = qunatityInterval;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }


    public int getQuantityIntervalValue() {
        return quantityIntervalValue;
    }

    public void setQuantityIntervalValue(int quantityIntervalValue) {
        this.quantityIntervalValue = quantityIntervalValue;
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
        if (totalQuantity > 0) {
        totalQuantity -= 1;
        }
    }

    public void multiplyWithQuantityInterval(int selectedQuantityInterval) {
        totalQuantity = selectedQuantityInterval * totalQuantity;
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

