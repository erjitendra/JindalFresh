package com.example.android.jindalfresh;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ProductResponseHandler {


    public String getProductJsonData(String url) {

        ApiUtil apiUtil = new ApiUtil();
        String response = ApiUtil.getResponse(url);

        Log.v("ABCDE", response);

        return response;

    }

    public ArrayList<Product> getProductArray(String productJsonData) {
        ArrayList<Product> resultProductArray = new ArrayList<>();

        try {
            JSONArray productArray = new JSONArray(productJsonData);


            // If there are results in the features array
            if (productArray.length() > 0) {

                for (int index = 0; index <= productArray.length(); index++) {
                    JSONObject productObject = productArray.getJSONObject(index);
                    Product product = new Product();

                    product.setProductEnglishName(productObject.getString("name"));
                    product.setProductHindiName(productObject.getString("hindi_name"));
                    product.setProductImageUrl(productObject.getString("image_path"));
                    product.setProductRate(productObject.getString("rate"));
                    product.setProductUnit(productObject.getString("unit"));

                    resultProductArray.add(product);
                }


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return resultProductArray;

    }

}
