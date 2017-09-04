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
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.android.jindalfresh.R;
import com.example.android.jindalfresh.cart.CartItemHandler;
import com.example.android.jindalfresh.cart.CartItemView;
import com.example.android.jindalfresh.product.Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private static final String urlData = "http://lit-dusk-68336.herokuapp.com/api/v1/product/products/";
    public Button buttonSubmit;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Product> listItems;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        listItems = new ArrayList<>();

        //*******************************************
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading Data....");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, urlData,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        progressDialog.dismiss();
                        try {
                            JSONArray productArray = new JSONArray(s);

                            for (int index = 0; index <= productArray.length(); index++) {
                                JSONObject productObject = productArray.getJSONObject(index);

                                Product productItem = new Product();

                                productItem.setEngName(productObject.getString("name"));
                                productItem.setProductId(productObject.getString("product_id"));
                                productItem.setHindiName(productObject.getString("hindi_name"));
                                productItem.setImageUrl(productObject.getString("image_path"));
                                productItem.setRate(productObject.getInt("rate"));
                                productItem.setUnit(productObject.getString("unit"));
                                productItem.setDefaultQuantity();

                                listItems.add(productItem);
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        adapter = new ProductAdapter(listItems, getContext());
                        recyclerView.setAdapter(adapter);
                        Log.v("XYZ", "Hi" + recyclerView);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        );
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);


        Button btn = (Button) rootView.findViewById(R.id.btn_submit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent in = new Intent(getActivity(), CartItemView.class);
                CartItemHandler cartItemHandler = ProductAdapter.getCartItemHandlerFromAdaptor();
                in.putExtra("cartHandlerObject", cartItemHandler);

                startActivity(in);
            }
        });
        return rootView;
    }


}
