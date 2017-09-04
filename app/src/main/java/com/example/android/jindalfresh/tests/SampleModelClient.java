package com.example.android.jindalfresh.tests;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface SampleModelClient {

    @Headers("Accept: application/json")
    @POST("v1/product/userorder/")
    Call<ArrayList<SampleModel>> createTest(@Body ArrayList<SampleModel> tests);

    @Headers("Accept: application/json")
    @GET("v1/product/products/")
    Call<ArrayList<SampleModel>> getTest();

}
