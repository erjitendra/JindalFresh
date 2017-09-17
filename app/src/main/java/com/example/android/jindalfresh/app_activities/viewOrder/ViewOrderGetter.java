package com.example.android.jindalfresh.app_activities.viewOrder;

import com.example.android.jindalfresh.product.ProductModel;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class ViewOrderGetter implements Serializable {

    @SerializedName("products")
    ArrayList<ProductModel> orderedProducts = new ArrayList<>();

    @SerializedName("total_quantity")
    private String ToatlQuantity;

    @SerializedName("total_price")
    private String ToatlPrice;

    @SerializedName("date_time")
    private String Date;

    public ArrayList<ProductModel> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(ArrayList orderedProducts) {
        this.orderedProducts = orderedProducts;
    }


    public String getToatlQuantity() {
        return ToatlQuantity;
    }

    public void setToatlQuantity(String toatlQuantity) {
        ToatlQuantity = toatlQuantity;
    }

    public String getToatlPrice() {
        return ToatlPrice;
    }

    public void setToatlPrice(String toatlPrice) {
        ToatlPrice = toatlPrice;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
