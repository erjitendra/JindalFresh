package com.example.android.jindalfresh.app_activities.viewOrder;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.android.jindalfresh.R;
import com.example.android.jindalfresh.product.ProductModel;

import java.util.ArrayList;

public class OrderDetailView extends AppCompatActivity {
    Context context = this;
    int orderSummeryTotalPrice = 0;
    ArrayList<ProductModel> orderedProducts;
    private ViewOrderGetter orderItem;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_detail_recycler_view);

        orderItem = (ViewOrderGetter) getIntent().getSerializableExtra("orderItem");
        orderedProducts = orderItem.getOrderedProducts();

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
