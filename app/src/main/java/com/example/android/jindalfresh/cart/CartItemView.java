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

import com.example.android.jindalfresh.R;
import com.example.android.jindalfresh.app_activities.delivery.deliveryActivity;
import com.example.android.jindalfresh.generic.AppData;

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
        paymentButton.setText("Continue");

        recyclerView = (RecyclerView) findViewById(R.id.cartItem_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        adapter = new CartItemAdapter(AppData.getCartItemHandler().getCartItems(), context);
        recyclerView.setAdapter(adapter);

        paymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, deliveryActivity.class);
                startActivity(intent);

            }
        });
    }


}
