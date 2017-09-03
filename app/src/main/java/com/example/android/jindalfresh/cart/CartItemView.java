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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.android.jindalfresh.R;
import com.example.android.jindalfresh.app_activities.MainActivity;

import java.util.HashMap;
import java.util.Map;

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

                StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(context,response,Toast.LENGTH_LONG).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(context,error.toString(),Toast.LENGTH_LONG).show();
                            }
                        }){
                    @Override
                    protected Map<String,String> getParams(){
                        Map<String,String> params = new HashMap<String, String>();
                        params.put("total_price",Integer.toString(orderSummeryTotalPrice));
                        params.put("total_quantity",Integer.toString(cartItemHandler.getCartsize()));
                        return params;
                    }

                };

                RequestQueue requestQueue = Volley.newRequestQueue(context);
                requestQueue.add(stringRequest);




















//                Intent in = new Intent(context, MainActivity.class);
//                Toast.makeText(context, "Order Successful", Toast.LENGTH_LONG).show();
//                startActivity(in);
//                fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                fragmentTransaction.add(R.id.cartItem_parent_LL, new HomeFragment());
//                fragmentTransaction.commit();


            }
        });
    }
}
