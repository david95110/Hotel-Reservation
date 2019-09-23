package com.example.hotelreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class GetLunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_lunch);

        Spinner mySpinner = findViewById(R.id.spinner22);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(GetLunchActivity.this,
                R.layout.menu, getResources().getStringArray(R.array.menuLunch));

        myAdapter.setDropDownViewResource(R.layout.menu);
        mySpinner.setAdapter(myAdapter);

    }
}
