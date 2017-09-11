package com.example.android.jindalfresh.app_activities.auth;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.jindalfresh.R;
import com.example.android.jindalfresh.generic.AppData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistrationActivity extends AppCompatActivity {
    private EditText editTextFirstName;
    private EditText editTextLastName;
    private EditText editTextEmail;
    private EditText editTextPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Button SignupButton = (Button) findViewById(R.id.button_signup_signup);
        editTextFirstName = (EditText) findViewById(R.id.editText_signup_first_name);
        editTextLastName = (EditText) findViewById(R.id.editText_signup_last_name);
        editTextEmail = (EditText) findViewById(R.id.editText_signup_email);
        editTextPassword = (EditText) findViewById(R.id.editText_signup_password);



        SignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SignUpModel signUpDataHolder = new SignUpModel();

                signUpDataHolder.setFirstName(editTextFirstName.getText().toString());
                signUpDataHolder.setLastName(editTextLastName.getText().toString());
                signUpDataHolder.setEmail(editTextEmail.getText().toString());
                signUpDataHolder.setPassword(editTextPassword.getText().toString());

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
                Toast.makeText(RegistrationActivity.this, "Successful" + response.body(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<SignUpModel> call, Throwable t) {

                Toast.makeText(RegistrationActivity.this, "Failed, went wrong" + t.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });

    }
}
