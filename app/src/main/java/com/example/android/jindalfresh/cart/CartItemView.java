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

public class CartItemView extends AppCompatActivity {
    Context context = this;
    FragmentTransaction fragmentTransaction;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private CartItemHandler cartItemHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_item_recycler_view);


        cartItemHandler = (CartItemHandler) getIntent().getSerializableExtra("cartHandlerObject");


        TextView items = (TextView) findViewById(R.id.cartSummary_total_Items);
        TextView price = (TextView) findViewById(R.id.cartSummary_total_Price);
        Button paymentButton = (Button) findViewById(R.id.cartSummary_btn_payment);
        items.setText("Items: " + "" + cartItemHandler.getCartsize());

        int orderSummeryTotalPrice = 0;

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
                Intent in = new Intent(context, MainActivity.class);
                Toast.makeText(context, "Order Successful", Toast.LENGTH_LONG).show();
                startActivity(in);
//                fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                fragmentTransaction.add(R.id.cartItem_parent_LL, new HomeFragment());
//                fragmentTransaction.commit();


            }
        });
    }
}
