package com.example.android.jindalfresh;


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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment {
    private static final String urlData = "http://lit-dusk-68336.herokuapp.com/api/v1/product/products/";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Rec_ListItem> listItems;


    public SettingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_setting, container, false);
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
                                Rec_ListItem listItem = new Rec_ListItem(
                                        productObject.getString("name"),
                                        productObject.getString("hindi_name"),
                                        "http://lit-dusk-68336.herokuapp.com" + productObject.getString("image_path"));
                                listItems.add(listItem);
                                Log.v("PQR", "Hi" + productObject.getString("image_path"));


                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        adapter = new Myadapter_Rec(listItems, getContext());
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
