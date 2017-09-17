package com.example.android.jindalfresh.cart;

import android.widget.TextView;

import com.example.android.jindalfresh.product.ProductModel;

import java.io.Serializable;
import java.util.ArrayList;

public class CartItemHandler implements Serializable {
    TextView cartSummaryTextView;
    private ArrayList<ProductModel> cartItems = new ArrayList<ProductModel>();
    
    public void setText_view(TextView cartSummaryTextView) {
        this.cartSummaryTextView = cartSummaryTextView;
        updateCartSummaryText();
    }

    public ProductModel getProducts(int position) {
        return cartItems.get(position);
    }

    public void setProducts(ProductModel Products) {

        cartItems.add(Products);
        updateCartSummaryText();

    }

    public int getCartsize() {

        return cartItems.size();
    }

    public boolean CheckProductInCart(ProductModel aproduct) {
        return cartItems.contains(aproduct);
    }

    public ArrayList<ProductModel> getCartItems() {
        return cartItems;
    }


    public void updateCartSummaryText(){
        cartSummaryTextView.setText(Integer.toString(getCartsize()));

    }
}