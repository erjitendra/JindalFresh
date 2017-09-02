package com.example.android.jindalfresh.cart;

import com.example.android.jindalfresh.product.Product;

import java.io.Serializable;
import java.util.ArrayList;

public class CartItemHandler implements Serializable {
    private ArrayList<Product> cartItems = new ArrayList<Product>();

    public Product getProducts(int position) {
        return cartItems.get(position);
    }

    public void setProducts(Product Products) {
        cartItems.add(Products);
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
}