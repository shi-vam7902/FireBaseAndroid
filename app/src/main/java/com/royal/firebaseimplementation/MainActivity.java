package com.royal.firebaseimplementation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        GifImageView gifImageView = findViewById(R.id.gif);
        gifImageView.setGifImageResource(R.drawable.giphy);
        long time = 3000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, ServiceActivity.class);
                startActivity(i);
                finish();
            }
        },time);
    }
}