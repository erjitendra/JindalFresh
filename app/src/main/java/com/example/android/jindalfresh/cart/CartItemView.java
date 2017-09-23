package com.example.android.jindalfresh.cart;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.jindalfresh.R;
import com.example.android.jindalfresh.app_activities.delivery.deliveryActivity;
import com.example.android.jindalfresh.generic.AppData;
import com.example.android.jindalfresh.product.ProductModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CartItemView extends AppCompatActivity {
    Context context = this;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_item_recycler_view);

        TextView items = (TextView) findViewById(R.id.cartSummary_total_Items);
        TextView price = (TextView) findViewById(R.id.cartSummary_total_Price);

        AppData.getCartItemHandler().setCartSummaryPriceTextView(price);
        AppData.getCartItemHandler().setCartSummaryTotalItemsTextView(items);

        Button paymentButton = (Button) findViewById(R.id.cartSummary_btn_payment);
        items.setText("Items: " + "" + AppData.getCartItemHandler().getCartsize());

        price.setText("Price: " + "" + Integer.toString(AppData.getCartItemHandler().getCartPrice()) + " Rs");
        paymentButton.setText("Pay " + "" + Integer.toString(AppData.getCartItemHandler().getCartPrice()) + " Rs");

        recyclerView = (RecyclerView) findViewById(R.id.cartItem_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        adapter = new CartItemAdapter(AppData.getCartItemHandler().getCartItems(), context);
        recyclerView.setAdapter(adapter);

        paymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<ProductModel> products = AppData.getCartItemHandler().getCartItems();
                sendNetworkRequest(products);

            }
        });
    }

    private void sendNetworkRequest(ArrayList<ProductModel> products) {

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(AppData.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        CartOrderClient client = retrofit.create(CartOrderClient.class);

        String accessToken = "Bearer " + AppData.getUserModelToken().getAccessToken();
        Call<ArrayList<ProductModel>> call = client.submitOrder(products, accessToken);

        call.enqueue(new Callback<ArrayList<ProductModel>>() {
            @Override
            public void onResponse(Call<ArrayList<ProductModel>> call, retrofit2.Response<ArrayList<ProductModel>> response) {
                Toast.makeText(CartItemView.this, "Successfully ordered", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, deliveryActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<ArrayList<ProductModel>> call, Throwable t) {
                Toast.makeText(CartItemView.this, "Failed, went wrong" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
