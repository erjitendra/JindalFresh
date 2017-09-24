package com.example.android.jindalfresh.app_activities.auth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.jindalfresh.R;
import com.example.android.jindalfresh.generic.AppData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistrationActivity extends AppCompatActivity {
    Context context = this;
    private EditText editTextFirstName;
    private EditText editTextLastName;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView editTextAddress;
    private TextView editTextPhoneNumber;
    private TextView editTextPhoneNumber2;

    private SignUpModel signUpDataHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Button SignupButton = (Button) findViewById(R.id.button_signup_signup);
        Button LoginButton = (Button) findViewById(R.id.button_signup_login);

        editTextFirstName = (EditText) findViewById(R.id.editText_signup_first_name);
        editTextLastName = (EditText) findViewById(R.id.editText_signup_last_name);
        editTextEmail = (EditText) findViewById(R.id.editText_signup_email);
        editTextPassword = (EditText) findViewById(R.id.editText_signup_password);
        editTextPhoneNumber = (EditText) findViewById(R.id.editText_signup_phonenumber);
        editTextPhoneNumber2 = (EditText) findViewById(R.id.editText_signup_phonenumber_2);
        editTextAddress = (TextView) findViewById(R.id.editText_signup_address);

        editTextAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpDataHolder = new SignUpModel();

                signUpDataHolder.setFirstName(editTextFirstName.getText().toString());
                signUpDataHolder.setLastName(editTextLastName.getText().toString());
                signUpDataHolder.setEmail(editTextEmail.getText().toString());
                signUpDataHolder.setPassword(editTextPassword.getText().toString());
                signUpDataHolder.setPhonenumber(editTextPhoneNumber.getText().toString());
                signUpDataHolder.setPhonenumber_two(editTextPhoneNumber2.getText().toString());

                Intent intent = new Intent(context, AddressActivity.class);
                intent.putExtra("signUpDataHolder", signUpDataHolder);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();

        if (intent.hasExtra("signUpDataHolder")) {
            signUpDataHolder = (SignUpModel) getIntent().getSerializableExtra("signUpDataHolder");

            editTextFirstName.setText(signUpDataHolder.getFirstName());
            editTextLastName.setText(signUpDataHolder.getLastName());
            editTextEmail.setText(signUpDataHolder.getEmail());
            editTextPassword.setText(signUpDataHolder.getPassword());
            editTextPhoneNumber.setText(signUpDataHolder.getPhonenumber());
            editTextPhoneNumber2.setText(signUpDataHolder.getPhonenumber_two());

            editTextAddress.setText(signUpDataHolder.getFullAddress());


        }

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LoginActivity.class);
                startActivity(intent);
            }
        });

        SignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendNetworkRequest(signUpDataHolder);


            }
        });
    }

    private void sendNetworkRequest(SignUpModel signUpDataHolder) {

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(AppData.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        CustomAuthClient client = retrofit.create(CustomAuthClient.class);

        Call<SignUpModel> call = client.register(signUpDataHolder);

        call.enqueue(new Callback<SignUpModel>() {
            @Override
            public void onResponse(Call<SignUpModel> call, Response<SignUpModel> response) {
                Toast.makeText(RegistrationActivity.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, LoginActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<SignUpModel> call, Throwable t) {

                Toast.makeText(RegistrationActivity.this, "Failed, went wrong" + t.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });

    }
}
