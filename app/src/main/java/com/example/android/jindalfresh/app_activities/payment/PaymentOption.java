package com.example.android.jindalfresh.app_activities.payment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.jindalfresh.R;
import com.example.android.jindalfresh.app_activities.MainActivity;
import com.example.android.jindalfresh.cart.CartOrderClient;
import com.example.android.jindalfresh.generic.AppData;
import com.example.android.jindalfresh.product.ProductModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PaymentOption extends AppCompatActivity {
    TextView payment_option_Delivery_Date;
    TextView payment_option_price;
    TextView payment_option_tv_home_link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_option);

        payment_option_Delivery_Date = (TextView) findViewById(R.id.pay_opt_tv_delivery_date);
        payment_option_price = (TextView) findViewById(R.id.pay_opt_tv_price);
        payment_option_Delivery_Date.setText("Delivery Date:" + "     " + AppData.getCartItemHandler().getDeliveryDate());
        payment_option_price.setText("Price: " + "" + Integer.toString(AppData.getCartItemHandler().getCartPrice()) + " Rs");

        payment_option_tv_home_link = (TextView) findViewById(R.id.pay_opt_tv_home_link);
        payment_option_tv_home_link.setText("Pay " + "" + Integer.toString(AppData.getCartItemHandler().getCartPrice()) + " Rs");
        payment_option_tv_home_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<ProductModel> products = AppData.getCartItemHandler().getCartItems();
                sendNetworkRequest(products);
            }
        });


    }

    private void sendNetworkRequest(ArrayList<ProductModel> products) {

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(AppData.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        CartOrderClient client = retrofit.create(CartOrderClient.class);

        String accessToken = "Bearer " + AppData.getUserModelToken().getAccessToken();
        Call<ArrayList<ProductModel>> call = client.submitOrder(products, accessToken);

        call.enqueue(new Callback<ArrayList<ProductModel>>() {
            @Override
            public void onResponse(Call<ArrayList<ProductModel>> call, retrofit2.Response<ArrayList<ProductModel>> response) {
                Toast.makeText(PaymentOption.this, "Successfully ordered", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(PaymentOption.this, MainActivity.class);
                startActivity(intent);

            }

            @Override
            public void onFailure(Call<ArrayList<ProductModel>> call, Throwable t) {
                Toast.makeText(PaymentOption.this, "Failed, went wrong" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
