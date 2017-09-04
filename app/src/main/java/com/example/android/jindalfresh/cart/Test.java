package com.example.android.jindalfresh.cart;

import android.app.LauncherActivity;

import java.io.Serializable;

/**
 * Created by Djindal on 04-09-2017.
 */

public class Test implements Serializable {


    private String product_id;
    private int quantity;

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



}
