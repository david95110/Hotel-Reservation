package com.example.hotelreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class DinnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinner);

        Spinner mySpinner = findViewById(R.id.spinner1);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(DinnerActivity.this,
                R.layout.spinner, getResources().getStringArray(R.array.dinner));

        myAdapter.setDropDownViewResource(R.layout.spinner);
        mySpinner.setAdapter(myAdapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 2){
                    startActivity(new Intent(DinnerActivity.this,LunchActivity.class));
                }else if(i == 3){
                    startActivity(new Intent(DinnerActivity.this,TeaTimeActivity.class));
                }else if(i == 1){
                    startActivity(new Intent(DinnerActivity.this,RestaurantActivity.class));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
