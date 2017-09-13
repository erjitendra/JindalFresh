package com.example.android.jindalfresh.app_activities.auth;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.jindalfresh.Database.JFContract;
import com.example.android.jindalfresh.Database.JFDbhelper;
import com.example.android.jindalfresh.R;
import com.example.android.jindalfresh.generic.AppData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    private JFDbhelper mDbHelper;

    private EditText editTextEmail;
    private EditText editTextPassword;
    private UserTokenModel userTokenModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button LoginButton = (Button) findViewById(R.id.button_login_login);

        editTextEmail = (EditText) findViewById(R.id.editText_login_email);
        editTextPassword = (EditText) findViewById(R.id.editText_login_password);
        mDbHelper = new JFDbhelper(this);
        displayDatabaseInfo();

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginModel LoginDataHolder = new LoginModel();

                LoginDataHolder.setEmail(editTextEmail.getText().toString());
                LoginDataHolder.setPassword(editTextPassword.getText().toString());

                sendNetworkRequest(LoginDataHolder);

                //Toast.makeText(LoginActivity.this, "Successful" + userTokenModel.getAccessToken(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void displayDatabaseInfo() {
        // To access our database, we instantiate our subclass of SQLiteOpenHelper
        // and pass the context, which is the current activity.


        // Create and/or open a database to read from it
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Perform this raw SQL query "SELECT * FROM pets"
        // to get a Cursor that contains all rows from the pets table.
        Cursor cursor = db.rawQuery("SELECT * FROM " + JFContract.JFEntry.TABLE_NAME, null);
        try {
            //Toast.makeText(LoginActivity.this, "Number of rows in  database table: " + cursor.getCount() , Toast.LENGTH_SHORT).show();
            //Toast.makeText(LoginActivity.this, "Bearer " + AppData.getUserModelToken().getAccessToken() , Toast.LENGTH_SHORT).show();

            // Display the number of rows in the Cursor (which reflects the number of rows in the
            // pets table in the database).
//            TextView displayView = (TextView) findViewById(R.id.text_view_pet);
//            displayView.setText("Number of rows in pets database table: " + cursor.getCount());
        } finally {
            // Always close the cursor when you're done reading from it. This releases all its
            // resources and makes it invalid.
            cursor.close();
        }
    }

    private void insertTokenInDb() {
        // Gets the database in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a ContentValues object where column names are the keys,
        // and Toto's pet attributes are the values.
        ContentValues values = new ContentValues();
        values.put(JFContract.JFEntry.COLUMN_TOKEN_NO, userTokenModel.getAccessToken());


        // Insert a new row for Toto in the database, returning the ID of that new row.
        // The first argument for db.insert() is the pets table name.
        // The second argument provides the name of a column in which the framework
        // can insert NULL in the event that the ContentValues is empty (if
        // this is set to "null", then the framework will not insert a row when
        // there are no values).
        // The third argument is the ContentValues object containing the info for Toto.
        long newRowId = db.insert(JFContract.JFEntry.TABLE_NAME, null, values);
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

                userTokenModel = response.body();

                AppData.setUserModelToken(userTokenModel);

                insertTokenInDb();
                Toast.makeText(LoginActivity.this, "Successful" + userTokenModel.getAccessToken(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<UserTokenModel> call, Throwable t) {

                Toast.makeText(LoginActivity.this, "Failed, went wrong" + t.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });


    }
}
