package com.example.android.jindalfresh.app_activities.settings;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.jindalfresh.R;
import com.example.android.jindalfresh.cart.CartItemHandler;

public class SettingFragment extends Fragment {
    private CartItemHandler cart;

    public SettingFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_setting, container, false);

        //cart = (CartItemHandler) getContext().getSerializableExtra("cartObject");




        return rootView;
    }


}
