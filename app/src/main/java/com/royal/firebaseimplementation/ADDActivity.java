package com.royal.firebaseimplementation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ADDActivity extends AppCompatActivity {




    Button btn_Dis;
    Button btn_Add;
    EditText edtfn,edtln;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addactivity);

        btn_Dis = findViewById(R.id.btn_dis);
        btn_Add = findViewById(R.id.btn_add);
        edtfn = findViewById(R.id.edt_fn);
        edtln = findViewById(R.id.edt_ln);

    }
}