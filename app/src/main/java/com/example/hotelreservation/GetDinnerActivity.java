package com.example.hotelreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class GetDinnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_dinner);

        Spinner mySpinner = findViewById(R.id.spinner24);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(GetDinnerActivity.this,
                R.layout.menu, getResources().getStringArray(R.array.menuDinner));

        myAdapter.setDropDownViewResource(R.layout.menu);
        mySpinner.setAdapter(myAdapter);
    }
}
