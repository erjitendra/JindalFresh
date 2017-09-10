package com.example.android.jindalfresh.generic;

import com.example.android.jindalfresh.cart.CartItemHandler;

public class AppData {

    public static void initiateAppData() {
        setCartItemHanlder(new CartItemHandler());
    }

    public static CartItemHandler cartItemHandler;

    public static CartItemHandler getCartItemHandler() {
        return cartItemHandler;
    }

    public static void setCartItemHanlder(CartItemHandler cartItemHandler) {
        AppData.cartItemHandler = cartItemHandler;
    }


}
