package com.royal.firebaseimplementation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_start , btn_stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        btn_start = findViewById(R.id.btn_start);
        btn_stop = findViewById(R.id.btn_stop);

        btn_start.setOnClickListener(this);
        btn_stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_start)
        {
            Intent i = new Intent(ServiceActivity.this,Myservice.class);
            startService(i);
        }else if(id == R.id.btn_stop){
            Intent i = new Intent(ServiceActivity.this,Myservice.class);
            stopService(i);
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}