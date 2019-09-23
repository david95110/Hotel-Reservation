package com.example.hotelreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class GetMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_menu);

        Spinner mySpinner = findViewById(R.id.spinner2);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(GetMenuActivity.this,
                R.layout.menu, getResources().getStringArray(R.array.menuBreak));

        myAdapter.setDropDownViewResource(R.layout.menu);
        mySpinner.setAdapter(myAdapter);



    }
}
