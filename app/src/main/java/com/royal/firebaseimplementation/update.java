package com.royal.firebaseimplementation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class update extends AppCompatActivity {
    EditText edtfn, edtLn;
    Button btnUpdate;
     Button btnDelete;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        btnUpdate.findViewById(R.id.btn_up);
        btnDelete.findViewById(R.id.btn_dis);

        firebaseDatabase = FirebaseDatabase.getInstance("https://fir-implementation-c5c5f-default-rtdb.firebaseio.com/");
        databaseReference = firebaseDatabase.getReference("people");

        Intent i = getIntent();
        String strfn = edtfn.getText().toString();
        String strln = edtLn.getText().toString();
        final String strid = i.getStringExtra("KEY_Id");
        edtfn.setText(strfn);
        edtLn.setText(strln);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strfn = edtfn.getText().toString();
                String strln = edtLn.getText().toString();
                PeopleModel peopleModel = new PeopleModel();
                peopleModel.setId(strid);
                peopleModel.setFn(strfn);
                peopleModel.setLn(strln);

                databaseReference.child(strid).setValue(peopleModel);

                Intent I = new Intent(update.this,display.class);
                startActivity(I);
                finish();

            }

        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child(strid).removeValue();
                Intent I = new Intent(update.this,display.class);
                startActivity(I);
                finish();
            }
        });
    }
}