package com.example.android.jindalfresh.app_activities.viewOrder;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_detail_recycler_view);

        recyclerView = (RecyclerView) findViewById(R.id.orderDetail_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        orderItem = (ViewOrderGetter) getIntent().getSerializableExtra("orderItem");

        ArrayList<Product> orderedProducts = orderItem.getOrderedProducts();

        Log.v("Mumbai", "in order detail view"+ orderedProducts.size());
        adapter = new OrderDetailViewAdapter(orderedProducts, context);
        recyclerView.setAdapter(adapter);
    }
}
