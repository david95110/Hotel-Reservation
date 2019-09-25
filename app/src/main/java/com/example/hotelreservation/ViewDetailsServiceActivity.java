package com.example.hotelreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ViewDetailsServiceActivity extends AppCompatActivity {

    EditText room,phone,name,time;
    Spinner service;
    Button confirmBtn;
    DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details_service);

        room=(EditText)findViewById(R.id.roomNumberService);
        phone=(EditText)findViewById(R.id.phoneNumService);
        name=(EditText)findViewById(R.id.cusNameService);
        service=(Spinner)findViewById(R.id.spinnerService);
        time=(EditText)findViewById(R.id.editTimeService);
        confirmBtn=(Button)findViewById(R.id.confirmBtnService);

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database= FirebaseDatabase.getInstance().getReference();
            }
        });
    }
}
