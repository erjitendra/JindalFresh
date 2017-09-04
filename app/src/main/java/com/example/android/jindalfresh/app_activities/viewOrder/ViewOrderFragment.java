package com.example.android.jindalfresh.app_activities.viewOrder;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.android.jindalfresh.R;
import com.example.android.jindalfresh.product.Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class ViewOrderFragment extends Fragment {
    private static final String urlData = "http://lit-dusk-68336.herokuapp.com/api/v1/product/userorder/";
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;
    private ArrayList<ViewOrderGetter> listItems = new ArrayList<>();

    public ViewOrderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView_order_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //*******************************************
        //test git commands: adding this comment by DJ

        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading Data....");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, urlData,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        progressDialog.dismiss();
                        try {
                            JSONArray OrderArray = new JSONArray(s);

                            for (int index = 0; index <= OrderArray.length(); index++) {
                                JSONObject orderObject = OrderArray.getJSONObject(index);

                                ViewOrderGetter orderItem = new ViewOrderGetter();

                                orderItem.setDate(orderObject.getString("date_time"));
                                orderItem.setToatlPrice(orderObject.getString("total_price"));
                                orderItem.setToatlQuantity(orderObject.getString("total_quantity"));

                                ArrayList<Product> orderedProducts = new ArrayList();


                                try {
                                    JSONArray productArray = orderObject.getJSONArray("products");

                                    for (int productIndex = 0; productIndex <= productArray.length(); productIndex++) {
                                        JSONObject productObject = productArray.getJSONObject(productIndex);

                                        Product productItem = new Product();

                                        productItem.setEngName(productObject.getString("name"));
                                        productItem.setHindiName(productObject.getString("hindi_name"));
                                        productItem.setImageUrl(productObject.getString("image_path"));
                                        productItem.setRate(productObject.getInt("rate"));
                                        productItem.setUnit(productObject.getString("unit"));
                                        productItem.setTotalQuantity(productObject.getInt("quantity"));

                                        orderedProducts.add(productItem);
                                    }

                                    orderItem.setOrderedProducts(orderedProducts);


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                listItems.add(orderItem);
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        adapter = new ViewOrdersAdapter(listItems, getContext());
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

        return rootView;
    }
}
