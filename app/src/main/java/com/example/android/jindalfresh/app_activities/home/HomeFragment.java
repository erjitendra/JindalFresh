package com.example.android.jindalfresh.app_activities.home;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.jindalfresh.R;
import com.example.android.jindalfresh.app_activities.auth.LoginActivity;
import com.example.android.jindalfresh.cart.CartItemView;
import com.example.android.jindalfresh.generic.AppData;
import com.example.android.jindalfresh.product.ProductClient;
import com.example.android.jindalfresh.product.ProductModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class HomeFragment extends Fragment {
    List<ProductModel> products = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;


    public HomeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading Data....");
        //progressDialog;
        progressDialog.setIndeterminate(true);
        progressDialog.show();
//        progressDialog.setContentView(R.layout.progress_screen);



        RelativeLayout cartCheckout = (RelativeLayout) rootView.findViewById(R.id.cart_checkout);
        TextView cartItems_No_display = (TextView) rootView.findViewById(R.id.cart_items_no_display);
        AppData.getCartItemHandler().setText_view(cartItems_No_display);

        cartCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AppData.getUserModelToken().hasToken()) {
                    Log.v("Mumbai", AppData.getUserModelToken().getAccessToken());
                    Intent in = new Intent(getActivity(), CartItemView.class);
                    startActivity(in);
                } else {
                    Intent in = new Intent(getActivity(), LoginActivity.class);
                    startActivity(in);
                }
            }

        });


        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(AppData.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        ProductClient client = retrofit.create(ProductClient.class);
        Call<List<ProductModel>> call = client.fetchProducts();

        call.enqueue(new Callback<List<ProductModel>>() {
            @Override
            public void onResponse(Call<List<ProductModel>> call, retrofit2.Response<List<ProductModel>> response) {
                progressDialog.dismiss();
                products = response.body();
                Log.v("Pune", "" + products);
                adapter = new ProductAdapter(products, getContext());
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<ProductModel>> call, Throwable t) {

                Toast.makeText(getContext(), "Sorry, Product listing failed", Toast.LENGTH_SHORT).show();

            }
        });

        return rootView;
    }


}
