package com.example.android.jindalfresh.app_activities.auth;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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

public class LoginActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button LoginButton = (Button) findViewById(R.id.button_login_login);

        editTextEmail = (EditText) findViewById(R.id.editText_login_email);
        editTextPassword = (EditText) findViewById(R.id.editText_login_password);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginModel LoginDataHolder = new LoginModel();

                LoginDataHolder.setEmail(editTextEmail.getText().toString());
                LoginDataHolder.setPassword(editTextPassword.getText().toString());

                sendNetworkRequest(LoginDataHolder);
            }
        });


    }

    private void sendNetworkRequest(LoginModel LoginDataHolder) {

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(AppData.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        CustomAuthClient client = retrofit.create(CustomAuthClient.class);

        Log.v("Mumbai", LoginDataHolder.getEmail());
        Log.v("Mumbai", LoginDataHolder.getPassword());
        Log.v("Mumbai", LoginDataHolder.getCLIENT_ID());
        Log.v("Mumbai", LoginDataHolder.getCLIENT_SECRET());
        Log.v("Mumbai", LoginDataHolder.getGRANT_TYPE());

        Call<UserTokenModel> call = client.createToken(
                LoginDataHolder.getEmail(),
                LoginDataHolder.getPassword(),
                LoginDataHolder.getCLIENT_ID(),
                LoginDataHolder.getCLIENT_SECRET(),
                LoginDataHolder.getGRANT_TYPE()
                );

        call.enqueue(new Callback<UserTokenModel>() {
            @Override
            public void onResponse(Call<UserTokenModel> call, Response<UserTokenModel> response) {

                UserTokenModel userTokenModel = response.body();

                AppData.setUserModelToken(userTokenModel);

                Toast.makeText(LoginActivity.this, "Successful" + userTokenModel.getAccessToken(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<UserTokenModel> call, Throwable t) {

                Toast.makeText(LoginActivity.this, "Failed, went wrong" + t.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });


    }
}
