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
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.android.jindalfresh.R;

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

                                ViewOrderGetter productItem = new ViewOrderGetter();

                                productItem.setDate(productObject.getString("date_time"));
                                productItem.setToatlPrice(productObject.getString("total_price"));
                                productItem.setToatlQuantity(productObject.getString("total_quantity"));

                                listItems.add(productItem);
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
