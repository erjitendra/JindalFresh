package com.example.android.jindalfresh.app_activities.viewOrder;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface OrderClient {

    @GET("/api/v1/product/userorder/")
    Call<List<ViewOrderGetter>> getOrders(@Header("Authorization") String accessToken);
}

