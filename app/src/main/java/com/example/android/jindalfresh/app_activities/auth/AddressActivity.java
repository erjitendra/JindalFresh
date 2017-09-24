package com.example.android.jindalfresh.app_activities.auth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.jindalfresh.R;

public class AddressActivity extends AppCompatActivity {

    Context context = this;

    private SignUpModel signUpDataHolder;

    private EditText editTextAddress1;
    private EditText editTextAddress2;
    private EditText editTextStreet;
    private EditText editTextLandmark;
    private EditText editTextDistrict;
    private EditText editTextCity;
    private EditText editTextState;
    private EditText editTextPincode;

    private Button buttonContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        editTextAddress1 = (EditText) findViewById(R.id.address_EditText_addresss_1);
        editTextAddress2 = (EditText) findViewById(R.id.address_EditText_addresss_2);
        editTextStreet = (EditText) findViewById(R.id.address_EditText_street);
        editTextLandmark = (EditText) findViewById(R.id.address_EditText_landmark);
        editTextDistrict = (EditText) findViewById(R.id.address_EditText_district);
        editTextCity = (EditText) findViewById(R.id.address_EditText_city);
        editTextState = (EditText) findViewById(R.id.address_EditText_state);
        editTextPincode = (EditText) findViewById(R.id.address_EditText_pincode);

        buttonContinue = (Button) findViewById(R.id.address_button_continue);

        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                signUpDataHolder = (SignUpModel) getIntent().getSerializableExtra("signUpDataHolder");

                signUpDataHolder.setAddress_one(editTextAddress1.getText().toString());
                signUpDataHolder.setAddress_two(editTextAddress2.getText().toString());
                signUpDataHolder.setStreet(editTextStreet.getText().toString());
                signUpDataHolder.setLandmark(editTextLandmark.getText().toString());
                signUpDataHolder.setDistrict(editTextDistrict.getText().toString());
                signUpDataHolder.setCity(editTextCity.getText().toString());
                signUpDataHolder.setState(editTextState.getText().toString());
                signUpDataHolder.setPincode(editTextPincode.getText().toString());


                Intent intent = new Intent(context, RegistrationActivity.class);
                intent.putExtra("signUpDataHolder", signUpDataHolder);
                startActivity(intent);
            }
        });
    }
}
