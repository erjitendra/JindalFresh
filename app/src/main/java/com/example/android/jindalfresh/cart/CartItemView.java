package com.example.android.jindalfresh.cart;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.android.jindalfresh.R;
import com.example.android.jindalfresh.app_activities.MainActivity;
import com.example.android.jindalfresh.product.Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CartItemView extends AppCompatActivity {
    Context context = this;
    FragmentTransaction fragmentTransaction;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private CartItemHandler cartItemHandler;
    int orderSummeryTotalPrice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_item_recycler_view);


        cartItemHandler = (CartItemHandler) getIntent().getSerializableExtra("cartHandlerObject");


        TextView items = (TextView) findViewById(R.id.cartSummary_total_Items);
        TextView price = (TextView) findViewById(R.id.cartSummary_total_Price);
        Button paymentButton = (Button) findViewById(R.id.cartSummary_btn_payment);
        items.setText("Items: " + "" + cartItemHandler.getCartsize());


        for (int i = 0; i < cartItemHandler.getCartsize(); i++) {
            orderSummeryTotalPrice += cartItemHandler.getProducts(i).totalPrice();
        }

        price.setText("Price: " + "" + Integer.toString(orderSummeryTotalPrice) + " Rs");
        paymentButton.setText("Pay " + "" + Integer.toString(orderSummeryTotalPrice) + " Rs");

        recyclerView = (RecyclerView) findViewById(R.id.cartItem_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        adapter = new CartItemAdapter(cartItemHandler.getCartItems(), context);
        recyclerView.setAdapter(adapter);


        paymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String REGISTER_URL = "http://lit-dusk-68336.herokuapp.com/api/v1/product/userorder/";

                ArrayList<Product> products = cartItemHandler.getCartItems();
                sendNetworkRequest(products);




            }
        });
    }

    private void sendNetworkRequest(ArrayList<Product> products) {

        //create retrofit instance

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://lit-dusk-68336.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        Log.v("Mumbai", "In send request");


        Test test = new Test();
        test.setName("test_name");

                //get cliengt and call object for request
        TestClient client = retrofit.create(TestClient.class);
        Log.v("Mumbai", "before submit order"+client);
        Call<Test> call = client.createTest(test);

        Log.v("Mumbai", "after submit order");
        call.enqueue(new Callback<Test>() {
            @Override
            public void onResponse(Call<Test> call, retrofit2.Response<Test> response) {

                Toast.makeText(CartItemView.this, "Successful"+response.body(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Test> call, Throwable t) {
                Log.v("Mumbai","Failed"+t.getMessage());

                Toast.makeText(CartItemView.this, "Failed"+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });






















//        //get cliengt and call object for request
//        CartOrderClient client = retrofit.create(CartOrderClient.class);
//        Log.v("Mumbai", "before submit order"+client);
//        Log.v("Mumbai", "before submit order"+products);
//        Log.v("Mumbai", "before submit order"+products.get(0).getEngName());
//        Call<ArrayList<Product>> call = client.submitOrder(products);
//
//        Log.v("Mumbai", "after submit order");
//        call.enqueue(new Callback<ArrayList<Product>>() {
//            @Override
//            public void onResponse(Call<ArrayList<Product>> call, retrofit2.Response<ArrayList<Product>> response) {
//
//                Toast.makeText(CartItemView.this, "Successful", Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<Product>> call, Throwable t) {
//
//                Toast.makeText(CartItemView.this, "Failed, went wrong !!", Toast.LENGTH_SHORT).show();
//
//            }
//        });


    }
}
