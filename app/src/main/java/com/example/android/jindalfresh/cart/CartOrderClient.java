package com.example.android.jindalfresh.cart;

import com.example.android.jindalfresh.product.Product;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface CartOrderClient {

    @Headers("Accept: application/json")
    @POST("v1/product/userorder/")
    Call<ArrayList<Product>> submitOrder(@Body ArrayList<Product> products);

}
