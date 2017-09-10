package com.example.android.jindalfresh.cart;

import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.jindalfresh.generic.AppData;
import com.example.android.jindalfresh.product.Product;

import java.io.Serializable;
import java.util.ArrayList;

public class CartItemHandler implements Serializable {
    TextView cartSummaryTextView;
    public void setText_view(TextView cartSummaryTextView) {
        this.cartSummaryTextView = cartSummaryTextView;
        updateCartSummaryText();
    }
    
    private ArrayList<Product> cartItems = new ArrayList<Product>();

    public Product getProducts(int position) {
        return cartItems.get(position);
    }

    public void setProducts(Product Products) {

        cartItems.add(Products);
        updateCartSummaryText();

    }

    public int getCartsize() {

        return cartItems.size();
    }

    public boolean CheckProductInCart(Product aproduct) {
        return cartItems.contains(aproduct);
    }

    public ArrayList<Product> getCartItems() {
        return cartItems;
    }


    public void updateCartSummaryText(){
        cartSummaryTextView.setText(Integer.toString(getCartsize()));

    }
}