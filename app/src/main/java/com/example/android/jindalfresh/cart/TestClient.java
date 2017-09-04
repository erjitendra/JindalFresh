package com.example.android.jindalfresh.cart;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface TestClient {

    @Headers("Accept: application/json")
    @POST("v1/product/userorder/")
    Call<Test> createTest(@Body Test test);

}
