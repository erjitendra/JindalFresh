package com.example.android.jindalfresh.cart;

import com.example.android.jindalfresh.product.ProductModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface CartOrderClient {

    @Headers("Accept: application/json")
    @POST("/api/v1/product/userorder/")
    Call<ArrayList<ProductModel>> submitOrder(@Body ArrayList<ProductModel> products,

                                              @Header("Authorization") String accessToken);

}
