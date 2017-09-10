package com.example.android.jindalfresh.app_activities.auth;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Djindal on 05-09-2017.
 */

public interface CustomAuthClient {

    @Headers("Accept: application/json")
    @POST("v1/product/userorder/")
    Call<LoginModel> login(@Body LoginModel loginModel);
}
