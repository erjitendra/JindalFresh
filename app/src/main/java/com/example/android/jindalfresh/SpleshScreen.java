package com.example.android.jindalfresh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.android.jindalfresh.app_activities.MainActivity;
import com.example.android.jindalfresh.app_activities.Welcome;
import com.example.android.jindalfresh.generic.AppData;

public class SpleshScreen extends Activity {
    private static int SPLASH_TIME_OUT = 4000;
    private ImageView imageLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splesh_screen);

        AppData.initiateAppData(this);

        imageLogo = (ImageView) findViewById(R.id.img_jf_logo);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splash_transition);
        imageLogo.startAnimation(animation);

        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                if (AppData.getUserModelToken().hasToken()) {
                    Intent i = new Intent(SpleshScreen.this, MainActivity.class);
                    startActivity(i);
                } else {
                    Intent i = new Intent(SpleshScreen.this, Welcome.class);
                    startActivity(i);
                }
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}