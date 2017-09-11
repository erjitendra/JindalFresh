package com.example.android.jindalfresh.app_activities.auth;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.jindalfresh.R;
import com.example.android.jindalfresh.cart.CartItemHandler;

public class LoginFragment extends Fragment {
    private CartItemHandler cart;

    public LoginFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.login, container, false);

        return rootView;
    }


}
