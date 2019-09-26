package com.example.hotelreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;

public class ViewDetailsFitnessActivity extends AppCompatActivity {

    EditText room,phone,name,timeEdit,service;
    Button showBtn,editBtn;
    DatabaseReference database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details_fitness);
    }
}
