package com.example.intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class LoadingSreen extends AppCompatActivity {
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_sreen);
        handler = new Handler();
        handler.post(myRunnable);
    }
    private Runnable myRunnable = new Runnable() {
        @Override
        public void run() {
            //Do Something
            startActivity(new Intent(LoadingSreen.this, WelcomeActivity.class));
            handler.postDelayed(this, 5000);
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        handler.removeCallbacks(myRunnable);
    }
}