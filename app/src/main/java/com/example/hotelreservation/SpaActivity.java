package com.example.hotelreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SpaActivity extends AppCompatActivity {

    private Button GetSpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spa);

        GetSpa = (Button) findViewById(R.id.getSpaBtn);
        GetSpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGetSpa();
            }
        });
    }

    public void openGetSpa(){
        Intent intent = new Intent(this, GetSpaActivity.class);
        startActivity(intent);
    }
}
