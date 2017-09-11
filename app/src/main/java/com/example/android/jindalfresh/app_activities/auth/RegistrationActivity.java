package com.example.android.jindalfresh.app_activities.auth;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.android.jindalfresh.R;
import com.example.android.jindalfresh.generic.AppData;
import com.example.android.jindalfresh.product.Product;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Button SignupButton = (Button) findViewById(R.id.button_signup_signup);

        SignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<Product> products = AppData.getCartItemHandler().getCartItems();
                sendNetworkRequest(products);


            }
        });
    }

    private void sendNetworkRequest(ArrayList<Product> products) {

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://lit-dusk-68336.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        CustomAuthClient client = retrofit.create(CustomAuthClient.class);

        Call<ArrayList<Product>> call = client.register(products);

    }
}
