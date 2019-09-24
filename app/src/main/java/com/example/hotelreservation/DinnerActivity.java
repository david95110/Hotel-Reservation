package com.example.hotelreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

public class DinnerActivity extends AppCompatActivity {

    private Button D1;
    private CheckBox check1;
    private CheckBox check2;
    private CheckBox check3;
    private CheckBox check4;

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


        Spinner mySpinner1 = findViewById(R.id.spinnerPasta);

        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<>(DinnerActivity.this,
                R.layout.menu, getResources().getStringArray(R.array.menuPasta));

        myAdapter1.setDropDownViewResource(R.layout.menu);
        mySpinner1.setAdapter(myAdapter1);

        check1 = (CheckBox) findViewById(R.id.checkBox1);
        check1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check1.isChecked()){
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_LONG).show();
                }
            }
        });


        Spinner mySpinner2 = findViewById(R.id.spinnerBurger);

        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<>(DinnerActivity.this,
                R.layout.menu, getResources().getStringArray(R.array.menuBurger));

        myAdapter2.setDropDownViewResource(R.layout.menu);
        mySpinner2.setAdapter(myAdapter1);

        check2 = (CheckBox) findViewById(R.id.checkBox2);
        check2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check1.isChecked()){
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_LONG).show();
                }
            }
        });


        Spinner mySpinner3 = findViewById(R.id.spinnerPizza);

        ArrayAdapter<String> myAdapter3 = new ArrayAdapter<>(DinnerActivity.this,
                R.layout.menu, getResources().getStringArray(R.array.menuPizza));

        myAdapter3.setDropDownViewResource(R.layout.menu);
        mySpinner3.setAdapter(myAdapter1);

        check3 = (CheckBox) findViewById(R.id.checkBox3);
        check3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check1.isChecked()){
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_LONG).show();
                }
            }
        });


        Spinner mySpinner4 = findViewById(R.id.spinnerSea);

        ArrayAdapter<String> myAdapter4 = new ArrayAdapter<>(DinnerActivity.this,
                R.layout.menu, getResources().getStringArray(R.array.menuSea));

        myAdapter4.setDropDownViewResource(R.layout.menu);
        mySpinner4.setAdapter(myAdapter1);

        check4 = (CheckBox) findViewById(R.id.checkBox4);
        check4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check1.isChecked()){
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_LONG).show();
                }
            }
        });


        D1 = (Button)findViewById(R.id.dinnerBtn1);
        D1.setOnClickListener(new View.OnClickListener(){
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
