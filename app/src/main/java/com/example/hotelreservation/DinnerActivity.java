package com.example.hotelreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class DinnerActivity extends AppCompatActivity {

    private Button D1;
    private Button D2;
    private Button D3;
    private Button D4;

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

        D1 = (Button)findViewById(R.id.dinnerBtn1);
        D1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openGetDinner();
            }
        });

        D2 = (Button)findViewById(R.id.dinnerBtn2);
        D2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openGetDinner();
            }
        });

        D3 = (Button)findViewById(R.id.dinnerBtn3);
        D3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openGetDinner();
            }
        });

        D4 = (Button)findViewById(R.id.dinnerBtn3);
        D4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openGetDinner();
            }
        });
    }

    public void openGetDinner(){
        Intent intent = new Intent(this,GetDinnerActivity.class);
        startActivity(intent);
    }
}
