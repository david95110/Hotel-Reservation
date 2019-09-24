package com.example.hotelreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RoomserviceActivity extends AppCompatActivity {

    private Button GetService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roomservice);

        GetService = (Button) findViewById(R.id.getServiceBtn);
        GetService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGetservice();
            }
        });
    }

    public void openGetservice(){
        Intent intent = new Intent(this,GetserviceActivity.class);
        startActivity(intent);
    }
}
