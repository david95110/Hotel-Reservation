package com.example.hotelreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivitiesActivity extends AppCompatActivity {

    private Button GetActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);

        GetActivity = (Button) findViewById(R.id.getActivitiesBtn);
        GetActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGetActivity();
            }
        });
    }

    public void openGetActivity(){
        Intent intent = new Intent(this, GetActivitiesActivity.class);
        startActivity(intent);
    }
}
