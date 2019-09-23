package com.example.hotelreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class LunchActivity extends AppCompatActivity {

    private Button L1;
    private Button L2;
    private Button L3;
    private Button L4;
    private Button L5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch);

        Spinner mySpinner = findViewById(R.id.spinner1);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(LunchActivity.this,
                R.layout.spinner, getResources().getStringArray(R.array.lunch));

        myAdapter.setDropDownViewResource(R.layout.spinner);
        mySpinner.setAdapter(myAdapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 2){
                    startActivity(new Intent(LunchActivity.this,TeaTimeActivity.class));
                }else if(i == 3){
                    startActivity(new Intent(LunchActivity.this,DinnerActivity.class));
                }else if(i == 1){
                    startActivity(new Intent(LunchActivity.this,RestaurantActivity.class));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        L1 = (Button)findViewById(R.id.lunchBtn1);
        L1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openGetLunch();
            }
        });

        L2 = (Button)findViewById(R.id.lunchBtn2);
        L2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openGetLunch();
            }
        });

        L3 = (Button)findViewById(R.id.lunchBtn3);
        L3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openGetLunch();
            }
        });

        L4 = (Button)findViewById(R.id.dinnerBtn4);
        L4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openGetLunch();
            }
        });

        L5 = (Button)findViewById(R.id.lunchBtn5);
        L5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openGetLunch();
            }
        });

    }

    public void openGetLunch(){
        Intent intent = new Intent(this,GetLunchActivity.class);
        startActivity(intent);
    }
}
