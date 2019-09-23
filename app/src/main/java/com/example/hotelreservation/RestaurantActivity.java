package com.example.hotelreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class RestaurantActivity extends AppCompatActivity {

    private Button B1;
    private Button B2;
    private Button B3;
    private Button B4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resturent);

        Spinner mySpinner = findViewById(R.id.spinner1);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(RestaurantActivity.this,
                R.layout.spinner, getResources().getStringArray(R.array.names));

        myAdapter.setDropDownViewResource(R.layout.spinner);
        mySpinner.setAdapter(myAdapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 1){
                    startActivity(new Intent(RestaurantActivity.this,LunchActivity.class));
                } else if(i == 2){
                    startActivity(new Intent(RestaurantActivity.this,TeaTimeActivity.class));
                }else if(i == 3){
                    startActivity(new Intent(RestaurantActivity.this,DinnerActivity.class));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        B1 = (Button)findViewById(R.id.breakfastBtn1);
        B1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openGetmenu();
            }
        });

        B2 = (Button)findViewById(R.id.dinnerBtn2);
        B2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openGetmenu();
            }
        });

        B3 = (Button)findViewById(R.id.dinnerBtn3);
        B3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openGetmenu();
            }
        });

        B4 = (Button)findViewById(R.id.breakfastBtn4);
        B4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openGetmenu();
            }
        });
    }

    public void openGetmenu(){
        Intent intent = new Intent(this,GetMenuActivity.class);
        startActivity(intent);
    }

}
