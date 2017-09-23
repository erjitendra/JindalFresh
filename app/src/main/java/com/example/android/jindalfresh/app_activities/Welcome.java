package com.example.android.jindalfresh.app_activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.jindalfresh.R;
import com.example.android.jindalfresh.app_activities.auth.LoginActivity;
import com.example.android.jindalfresh.app_activities.auth.RegistrationActivity;

public class Welcome extends AppCompatActivity {
    private TextView welcome_login;
    private TextView welcome_signup;
    private TextView welcome_skip;
    private ImageView welcome_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        welcome_login = (TextView) findViewById(R.id.welcome_tv_login);
        welcome_signup = (TextView) findViewById(R.id.welcome_tv_sign_up);
        welcome_skip = (TextView) findViewById(R.id.welcome_tv_skip);
        welcome_logo = (ImageView) findViewById(R.id.welcome_img_jf_logo);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splash_transition);
        welcome_logo.startAnimation(animation);


        welcome_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Welcome.this, LoginActivity.class);
                startActivity(i);
            }
        });
        welcome_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Welcome.this, RegistrationActivity.class);
                startActivity(i);
            }
        });
        welcome_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Welcome.this, MainActivity.class);
                startActivity(i);
            }
        });


    }
}
