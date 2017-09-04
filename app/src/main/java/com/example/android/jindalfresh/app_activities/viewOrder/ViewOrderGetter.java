package com.example.android.jindalfresh.app_activities.viewOrder;

import com.example.android.jindalfresh.product.Product;

import java.io.Serializable;
import java.util.ArrayList;

public class ViewOrderGetter implements Serializable {

    ArrayList<Product> orderedProducts;
    private String ToatlQuantity;
    private String ToatlPrice;
    private String Date;

    public ArrayList<Product> getOrderedProducts() {
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
