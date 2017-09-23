package com.example.android.jindalfresh.app_activities.payment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.android.jindalfresh.R;
import com.example.android.jindalfresh.generic.AppData;

public class PaymentOption extends AppCompatActivity {
    TextView payment_option_Delivery_Date;
    TextView payment_option_price;
    int orderSummeryTotalPrice = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_option);
        payment_option_Delivery_Date = (TextView) findViewById(R.id.pay_opt_tv_delivery_date);
        payment_option_price = (TextView) findViewById(R.id.pay_opt_tv_price);
        payment_option_Delivery_Date.setText("Delivery Date:" + "     " + AppData.getCartItemHandler().getDeliveryDate());
        for (int i = 0; i < AppData.getCartItemHandler().getCartsize(); i++) {
            orderSummeryTotalPrice += AppData.getCartItemHandler().getProducts(i).totalPrice();
        }
        payment_option_price.setText("Price: " + "" + Integer.toString(orderSummeryTotalPrice) + " Rs");

    }
}
