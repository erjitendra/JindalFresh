package com.example.android.jindalfresh.cart;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.jindalfresh.R;
import com.example.android.jindalfresh.app_activities.MainActivity;
import com.example.android.jindalfresh.generic.AppData;
import com.example.android.jindalfresh.product.ProductModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CartItemView extends AppCompatActivity {
    Context context = this;
    FragmentTransaction fragmentTransaction;
    int orderSummeryTotalPrice = 0;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_item_recycler_view);


//        cartItemHandler = (CartItemHandler) getIntent().getSerializableExtra("cartHandlerObject");

        TextView items = (TextView) findViewById(R.id.cartSummary_total_Items);
        TextView price = (TextView) findViewById(R.id.cartSummary_total_Price);
        Button paymentButton = (Button) findViewById(R.id.cartSummary_btn_payment);
        items.setText("Items: " + "" + AppData.getCartItemHandler().getCartsize());


        for (int i = 0; i < AppData.getCartItemHandler().getCartsize(); i++) {
            orderSummeryTotalPrice += AppData.getCartItemHandler().getProducts(i).totalPrice();
        }

        price.setText("Price: " + "" + Integer.toString(orderSummeryTotalPrice) + " Rs");
        paymentButton.setText("Pay " + "" + Integer.toString(orderSummeryTotalPrice) + " Rs");

        recyclerView = (RecyclerView) findViewById(R.id.cartItem_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        adapter = new CartItemAdapter(AppData.getCartItemHandler().getCartItems(), context);
        recyclerView.setAdapter(adapter);


        paymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String REGISTER_URL = "http://lit-dusk-68336.herokuapp.com/api/v1/product/userorder/";

                ArrayList<ProductModel> products = AppData.getCartItemHandler().getCartItems();
                sendNetworkRequest(products);


            }
        });
    }

    private void sendNetworkRequest(ArrayList<ProductModel> products) {

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://lit-dusk-68336.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        CartOrderClient client = retrofit.create(CartOrderClient.class);

//        String accessToken = "Bearer " + AppData.getUserModelToken().getAccessToken();
        String accessToken = "Bearer " + AppData.getUserModelToken().getAccessToken();

        Call<ArrayList<ProductModel>> call = client.submitOrder(products, accessToken);

        call.enqueue(new Callback<ArrayList<ProductModel>>() {
            @Override
            public void onResponse(Call<ArrayList<ProductModel>> call, retrofit2.Response<ArrayList<ProductModel>> response) {

                Toast.makeText(CartItemView.this, "Successful" + response.body(), Toast.LENGTH_SHORT).show();

//                Toast.makeText(CartItemView.this, "Order was successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);


            }

            @Override
            public void onFailure(Call<ArrayList<ProductModel>> call, Throwable t) {

                Toast.makeText(CartItemView.this, "Failed, went wrong" + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}
