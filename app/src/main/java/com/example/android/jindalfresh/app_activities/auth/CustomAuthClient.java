package com.example.android.jindalfresh.app_activities.auth;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface CustomAuthClient {

    @Headers("Accept: application/json")
    @POST("/api/v1/auth/register/")
    Call<SignUpModel> register(@Body SignUpModel signUpModel);

    @FormUrlEncoded
    @Headers("Accept: application/json")
    @POST("/api/v1/auth/oauth2/token/")
    Call<UserTokenModel> createToken(@Field("username") String email,
                                     @Field("password") String password,
                                     @Field("client_id") String clientId,
                                     @Field("client_secret") String clientSecret,
                                     @Field("grant_type") String grantType
                                     );
}
