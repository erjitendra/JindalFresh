package com.example.android.jindalfresh.app_activities.viewOrder;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by Jindal on 9/14/2017.
 */

public interface ViewOrderClient {


    @FormUrlEncoded
    @Headers("Accept: application/json")
    @GET("/api/v1/product/userorder/")
    Call<ViewOrderGetter> getAnswers(@Body ViewOrderGetter viewOrderGetter);
}
