package com.example.android.jindalfresh.app_activities.delivery;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.android.jindalfresh.R;
import com.example.android.jindalfresh.app_activities.payment.PaymentOption;
import com.example.android.jindalfresh.generic.AppData;

import java.util.ArrayList;
import java.util.List;

public class deliveryActivity extends AppCompatActivity {
    List<DeliveryDateModel> date = new ArrayList<>();
    Context context = this;
    int orderSummeryTotalPrice = 0;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        TextView next = (TextView) findViewById(R.id.tv_DDate_next);
        TextView price = (TextView) findViewById(R.id.tv_DDate_Total_Price);
        for (int i = 0; i < AppData.getCartItemHandler().getCartsize(); i++) {
            orderSummeryTotalPrice += AppData.getCartItemHandler().getProducts(i).totalPrice();
        }

        price.setText("Price: " + "" + Integer.toString(orderSummeryTotalPrice) + " Rs");
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PaymentOption.class);
                startActivity(intent);
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.deliveryDate_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        date.add(new DeliveryDateModel("17 Sep 7:00-9:00", "7:00-9:00"));
        date.add(new DeliveryDateModel("17 Sep 9:00-11:00", "9:00-11:00"));
        date.add(new DeliveryDateModel("17 Sep", "11:00-13:00"));
        date.add(new DeliveryDateModel("17 Sep", "17:00-19:00"));
        date.add(new DeliveryDateModel("17 Sep", "19:00-21:00"));
        date.add(new DeliveryDateModel("18 Sep", "7:00-9:00"));
        date.add(new DeliveryDateModel("18 Sep", "9:00-11:00"));
        date.add(new DeliveryDateModel("18 Sep", "11:00-13:00"));
        date.add(new DeliveryDateModel("18 Sep", "17:00-19:00"));
        date.add(new DeliveryDateModel("18 Sep", "19:00-21:00"));


        adapter = new DeliveryDateAdapter(date, context);
        recyclerView.setAdapter(adapter);

    }
}
