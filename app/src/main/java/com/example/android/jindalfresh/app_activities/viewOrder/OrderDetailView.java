package com.example.android.jindalfresh.app_activities.viewOrder;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.jindalfresh.R;
import com.example.android.jindalfresh.cart.CartItemAdapter;
import com.example.android.jindalfresh.cart.CartItemHandler;
import com.example.android.jindalfresh.product.Product;

import java.util.ArrayList;

import static com.example.android.jindalfresh.R.id.recyclerView;

public class OrderDetailView extends AppCompatActivity {
    Context context = this;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    ViewOrderGetter orderItem;
    int orderSummeryTotalPrice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_detail_recycler_view);

        orderItem = (ViewOrderGetter) getIntent().getSerializableExtra("orderItem");
        ArrayList<Product> orderedProducts = orderItem.getOrderedProducts();

        recyclerView = (RecyclerView) findViewById(R.id.orderDetail_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));


        TextView items = (TextView) findViewById(R.id.orderDetail_total_Items);
        TextView price = (TextView) findViewById(R.id.orderDetail_total_Price);



        items.setText("Items: " + "" + orderedProducts.size());

        for (int i = 0; i < orderedProducts.size(); i++) {
            orderSummeryTotalPrice += orderedProducts.get(i).totalPrice();
        }
        price.setText("Price: " + "" + Integer.toString(orderSummeryTotalPrice) + " Rs");

        adapter = new OrderDetailViewAdapter(orderedProducts, context);
        recyclerView.setAdapter(adapter);
    }
}
