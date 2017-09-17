package com.example.android.jindalfresh.product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductClient {

    @GET("/api/v1/product/products/")
    Call<List<ProductModel>> fetchProducts();
}
