package com.example.android.jindalfresh.generic;

import com.example.android.jindalfresh.cart.CartItemHandler;

public class AppData {

    //=============================APP Constants===============================
    public static String BASE_URL = "http://lit-dusk-68336.herokuapp.com";
    //=========================================================================

    public static CartItemHandler cartItemHandler;

    public static void initiateAppData() {
        setCartItemHanlder(new CartItemHandler());
    }

    public static CartItemHandler getCartItemHandler() {
        return cartItemHandler;
    }

    public static void setCartItemHanlder(CartItemHandler cartItemHandler) {
        AppData.cartItemHandler = cartItemHandler;
    }


}
