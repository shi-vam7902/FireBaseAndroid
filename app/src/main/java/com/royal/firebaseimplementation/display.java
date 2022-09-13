package com.royal.firebaseimplementation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class display extends AppCompatActivity {

    ListView listView;
    String products[] = {"Product 1","Product 2","Product 3","Product 4","Product 5"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        listView = findViewById(R.id.list_view);
        DataBaseHandler db = new DataBaseHandler(this);
        final ArrayList<ContactModel> contacts = db.getAllRecords();

        MyBaseAdapter myBaseAdapter = new MyBaseAdapter(this,contacts);
        listView.setAdapter(myBaseAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String strfn = contacts.get(i).getFname();
                String strln =  contacts.get(i).getLname();
                String strid = contacts.get(i).getId();

                Log.e("TAG", "onItemClick: "+strfn );
                Intent I = new Intent(display.this,update.class);
                I.putExtra("KEY_Fn",strfn);
                I.putExtra("KEY_Ln",strln);
                I.putExtra("KEY_Id",strid);
                startActivity(I);
                finish();
            }
        });
    }
}