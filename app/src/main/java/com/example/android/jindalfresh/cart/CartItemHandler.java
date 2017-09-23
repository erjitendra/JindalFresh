package com.example.android.jindalfresh.cart;

import android.widget.TextView;

import com.example.android.jindalfresh.product.ProductModel;

import java.io.Serializable;
import java.util.ArrayList;

public class CartItemHandler implements Serializable {
    TextView cartQuantityNumberTextView;
    TextView cartSummaryPriceTextView;
    TextView cartSummaryTotalItemsTextView;
    String deliveryDate;
    private ArrayList<ProductModel> cartItems = new ArrayList<ProductModel>();

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setCartQuantityNumberTextView(TextView cartQuantityNumberTextView) {
        this.cartQuantityNumberTextView = cartQuantityNumberTextView;
        updateCartQuantityNumberText();
    }

    public void setCartSummaryPriceTextView(TextView cartSummaryPriceTextView) {
        this.cartSummaryPriceTextView = cartSummaryPriceTextView;
        updateCartSummaryPriceNumberText();
    }

    public void setCartSummaryTotalItemsTextView(TextView cartSummaryTotalItemsTextView) {
        this.cartSummaryTotalItemsTextView = cartSummaryTotalItemsTextView;
        updateCartSummaryTotalItemNumberText();
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

    public void refreshCartTextViews() {
        updateCartQuantityNumberText();
        updateCartSummaryTotalItemNumberText();
        updateCartSummaryPriceNumberText();
    }


    public void updateCartQuantityNumberText() {
        cartQuantityNumberTextView.setText(Integer.toString(getCartsize()));
    }

    public void updateCartSummaryTotalItemNumberText() {
        cartSummaryTotalItemsTextView.setText(Integer.toString(getCartsize()));
    }

    public void updateCartSummaryPriceNumberText() {
        cartSummaryPriceTextView.setText(Integer.toString(getCartPrice()));
    }
}