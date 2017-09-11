package com.example.android.jindalfresh.generic;

import com.example.android.jindalfresh.app_activities.auth.UserTokenModel;
import com.example.android.jindalfresh.cart.CartItemHandler;

public class AppData {

    //=============================APP Constants===============================
    public static String BASE_URL = "http://lit-dusk-68336.herokuapp.com";

    //AUTH
    public static String CLIENT_ID = "1iNIgULGGwyBSVgveWDYGM9R15cHw76ciny1vV0q";
    public static String CLIENT_SECRET = "3WDCGYCjvOhNGZzmpWQSXvw6ouoxo6EHqajxJlzawjnHS3IKYMHPSy7GVmza4t3HVcvf7jkKzs75PLQiop4w4IgWF1j30rcmIVgne2UoHfsOhTl2YSA9761Dktgaw4cr";
    public static String GRANT_TYPE = "password";

    public static UserTokenModel userModelToken;

    public static UserTokenModel getUserModelToken() {
        return userModelToken;
    }

    public static void setUserModelToken(UserTokenModel userModelToken) {
        AppData.userModelToken = userModelToken;
    }

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
