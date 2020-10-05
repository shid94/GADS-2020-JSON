package com.richard.myapplication4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class WelcomeScreen extends AppCompatActivity {
    private  static int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent LearnersIntent = new Intent(WelcomeScreen.this,MainActivity.class);

                startActivity(LearnersIntent);
                finish();

            }
        }, SPLASH_TIME_OUT);


    }
}
