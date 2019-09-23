package com.example.hotelreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class GetTeaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_tea);

        Spinner mySpinner = findViewById(R.id.spinner23);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(GetTeaActivity.this,
                R.layout.menu, getResources().getStringArray(R.array.menuTea));

        myAdapter.setDropDownViewResource(R.layout.menu);
        mySpinner.setAdapter(myAdapter);

    }
}
