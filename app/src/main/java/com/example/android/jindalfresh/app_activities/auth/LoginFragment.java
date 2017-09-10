package com.example.android.jindalfresh.app_activities.auth;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.jindalfresh.R;
import com.example.android.jindalfresh.cart.CartItemHandler;
import com.example.android.jindalfresh.generic.APIUtility;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginFragment extends Fragment {
    private CartItemHandler cart;

    public LoginFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.login, container, false);

        //cart = (CartItemHandler) getContext().getSerializableExtra("cartObject");
        login();

        return rootView;
    }

    public void login() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(APIUtility.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();
        CustomAuthClient client = retrofit.create(CustomAuthClient.class);

        LoginModel loginModel = new LoginModel();
        loginModel.setUsername("webadmin");
        loginModel.setPassword("test");

        Call<LoginModel> call = client.login(loginModel);

        call.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                Log.v("Mumbai", "SUccess"+response.body());
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                Log.v("Mumbai", "Failed"+t.getMessage());

            }
        });


    }


}
