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
        updateCartQuantityNumberText();
    }

    public ProductModel getProducts(int position) {
        return cartItems.get(position);
    }

    public void setProducts(ProductModel Products) {

        cartItems.add(Products);
        updateCartQuantityNumberText();

    }

    public void removeProducts(ProductModel Products) {

        cartItems.remove(Products);
        updateCartQuantityNumberText();

    }

    public int getCartsize() {

        return cartItems.size();
    }

    public int getCartPrice() {
        int orderSummeryTotalPrice = 0;
        for (int i = 0; i < getCartsize(); i++) {
            orderSummeryTotalPrice += getProducts(i).totalPrice();
        }
        return orderSummeryTotalPrice;
    }

    public boolean CheckProductInCart(ProductModel aproduct) {
        return cartItems.contains(aproduct);
    }

    public ArrayList<ProductModel> getCartItems() {
        return cartItems;
    }


    public void updateCartQuantityNumberText() {
        cartSummaryTextView.setText(Integer.toString(getCartsize()));

    }
}