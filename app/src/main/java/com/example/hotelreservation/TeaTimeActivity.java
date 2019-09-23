package com.example.hotelreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class TeaTimeActivity extends AppCompatActivity {

    private Button T1;
    private Button T2;
    private Button T3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tea_time);

        Spinner mySpinner = findViewById(R.id.spinner1);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(TeaTimeActivity.this,
                R.layout.spinner, getResources().getStringArray(R.array.tea));

        myAdapter.setDropDownViewResource(R.layout.spinner);
        mySpinner.setAdapter(myAdapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 2){
                    startActivity(new Intent(TeaTimeActivity.this,LunchActivity.class));
                }else if(i == 3){
                    startActivity(new Intent(TeaTimeActivity.this,DinnerActivity.class));
                }else if(i == 1){
                    startActivity(new Intent(TeaTimeActivity.this,RestaurantActivity.class));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        T1 = (Button)findViewById(R.id.dinnerBtn1);
        T1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openGetTea();
            }
        });

        T2 = (Button)findViewById(R.id.dinnerBtn2);
        T2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openGetTea();
            }
        });

        T3 = (Button)findViewById(R.id.dinnerBtn3);
        T3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openGetTea();
            }
        });

    }

    public void openGetTea(){
        Intent intent = new Intent(this,GetTeaActivity.class);
        startActivity(intent);
    }
}
