package com.example.hotelreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ResturentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resturent);

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(ResturentActivity.this,
                R.layout.spinner, getResources().getStringArray(R.array.names));

        myAdapter.setDropDownViewResource(R.layout.spinner);
        mySpinner.setAdapter(myAdapter);
    }
}
