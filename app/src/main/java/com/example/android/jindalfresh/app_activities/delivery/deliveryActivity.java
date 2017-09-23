package com.example.android.jindalfresh.app_activities.delivery;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.android.jindalfresh.R;
import com.example.android.jindalfresh.app_activities.payment.PaymentOption;
import com.example.android.jindalfresh.generic.AppData;

import java.util.ArrayList;

public class deliveryActivity extends AppCompatActivity {
    //    List<DeliveryDateModel> date = new ArrayList<>();
    Context context = this;
    int orderSummeryTotalPrice = 0;
    ArrayList<String> date = new ArrayList<String>();
    private Spinner spinnerView;
    private ArrayAdapter<String> spinnerDateAdapter;

    //    private RecyclerView.Adapter adapter;
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
//
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

        spinnerView = (Spinner) findViewById(R.id.deliveryDate_spinnerView);

        date.add("17 Sep 7:00-9:00");
        date.add("18 Sep 7:00-9:00");
        date.add("19 Sep 7:00-9:00");
        date.add("20 Sep 7:00-9:00");
        date.add("21 Sep 7:00-9:00");
        date.add("22 Sep 7:00-9:00");
        date.add("23 Sep 7:00-9:00");


        spinnerDateAdapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, date);
        spinnerDateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerView.setAdapter(spinnerDateAdapter);
        spinnerView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AppData.getCartItemHandler().setDeliveryDate((String) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }



}
