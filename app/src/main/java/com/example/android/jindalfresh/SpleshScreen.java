package com.example.android.jindalfresh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.android.jindalfresh.app_activities.MainActivity;

public class SpleshScreen extends Activity {
    private static int SPLASH_TIME_OUT = 3000;
    private ImageView imageLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splesh_screen);
        imageLogo = (ImageView) findViewById(R.id.img_jf_logo);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splash_transition);
        imageLogo.startAnimation(animation);

        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SpleshScreen.this, MainActivity.class);
                startActivity(i);


                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}