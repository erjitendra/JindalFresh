package com.example.android.jindalfresh.product;

import com.example.android.jindalfresh.generic.AppData;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class ProductModel implements Serializable {

    @SerializedName("quantity_intervals")
    private PackSizeInterval packSizeIntervals;

    @SerializedName("name")
    private String engName;
    @SerializedName("hindi_name")
    private String hindiName;

    @SerializedName("quantity")
    private int totalQuantity;
    @SerializedName("image_path")
    private String imageUrl;
    @SerializedName("unit")
    private String unit;
    @SerializedName("product_id")
    private String productId;

    private Integer rateOfSelectedPackSize;

    public ProductModel() {

    }

    public PackSizeInterval getPackSizeIntervals() {
        return packSizeIntervals;
    }

    public void setPackSizeIntervals(PackSizeInterval packSizeIntervals) {
        this.packSizeIntervals = packSizeIntervals;
    }

    public Integer getRateOfSelectedPackSize() {
        return rateOfSelectedPackSize;
    }

    public void setRateOfSelectedPackSize(Integer rateOfSelectedPackSize) {
        this.rateOfSelectedPackSize = rateOfSelectedPackSize;
    }

    public void setDefaultSelectedPackSize() {
        this.rateOfSelectedPackSize = packSizeIntervals.getPackSizeRates().get(0);
    }


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

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int quantityValue) {
        this.totalQuantity = quantityValue;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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


    // ======================Custom methods======================================

    public void setDefaultQuantity() {
        this.totalQuantity = 0;
    }

    public String getCompleteImageUrl() {
        return AppData.BASE_URL + imageUrl;
    }


    public void doIncrement() {
        totalQuantity += 1;
    }

    public int totalPrice() {

        if (totalQuantity == 0) {
            return rateOfSelectedPackSize;
        }

        return totalQuantity * rateOfSelectedPackSize;
    }

    public void doDecrement() {
        if (totalQuantity > 0) {
            totalQuantity -= 1;
        }
    }


}

