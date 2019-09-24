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

public class TeaTimeActivity extends AppCompatActivity {

    private Button T1;
    private CheckBox check1;
    private CheckBox check2;
    private CheckBox check3;


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

        Spinner mySpinner1 = findViewById(R.id.spinnerCake);

        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<>(TeaTimeActivity.this,
                R.layout.menu, getResources().getStringArray(R.array.menuCake));

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

        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<>(TeaTimeActivity.this,
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

        ArrayAdapter<String> myAdapter3 = new ArrayAdapter<>(TeaTimeActivity.this,
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


        T1 = (Button)findViewById(R.id.teaBtn1);
        T1.setOnClickListener(new View.OnClickListener(){
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
