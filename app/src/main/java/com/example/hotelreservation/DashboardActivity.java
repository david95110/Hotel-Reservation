package com.example.hotelreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity {

    private Button resturent;
    private Button spa;
    private Button activity;
    private Button service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        resturent = (Button) findViewById(R.id.resBtn);
        resturent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openResturant();
            }
        });

        service = (Button) findViewById(R.id.serviceBtn);
        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openService();
            }
        });

        activity = (Button) findViewById(R.id.ActBtn);
        activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity();
            }
        });

        spa = (Button) findViewById(R.id.spaBtn);
        spa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSpa();
            }
        });
    }

    public void openResturant(){
        Intent intent = new Intent(this, RestaurantActivity.class);
        startActivity(intent);
    }

    public void openService(){
        Intent intent = new Intent(this,RoomserviceActivity.class);
        startActivity(intent);
    }

    public void openActivity(){
        Intent intent = new Intent(this,ActivitiesActivity.class);
        startActivity(intent);
    }

    public void openSpa(){
        Intent intent = new Intent(this,SpaActivity.class);
        startActivity(intent);
    }



}
