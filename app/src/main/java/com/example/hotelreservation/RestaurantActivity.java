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

public class RestaurantActivity extends AppCompatActivity {

    private Button B1;
    private CheckBox check1;
    private CheckBox check2;
    private CheckBox check3;
    private CheckBox check4;

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

        Spinner mySpinner1 = findViewById(R.id.spinnerSandwich);

        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<>(RestaurantActivity.this,
                R.layout.menu, getResources().getStringArray(R.array.menuSandwich));

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


        Spinner mySpinner2 = findViewById(R.id.spinnerPancake);

        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<>(RestaurantActivity.this,
                R.layout.menu, getResources().getStringArray(R.array.menuPancake));

        myAdapter2.setDropDownViewResource(R.layout.menu);
        mySpinner2.setAdapter(myAdapter2);

        check2 = (CheckBox) findViewById(R.id.checkBox2);
        check2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check1.isChecked()){
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_LONG).show();
                }
            }
        });


        Spinner mySpinner3 = findViewById(R.id.spinnerPasta);

        ArrayAdapter<String> myAdapter3 = new ArrayAdapter<>(RestaurantActivity.this,
                R.layout.menu, getResources().getStringArray(R.array.menuPasta));

        myAdapter3.setDropDownViewResource(R.layout.menu);
        mySpinner3.setAdapter(myAdapter3);

        check3 = (CheckBox) findViewById(R.id.checkBox3);
        check3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check1.isChecked()){
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_LONG).show();
                }
            }
        });


        Spinner mySpinner4 = findViewById(R.id.spinnerTraditional);

        ArrayAdapter<String> myAdapter4 = new ArrayAdapter<>(RestaurantActivity.this,
                R.layout.menu, getResources().getStringArray(R.array.menuTaraditional));

        myAdapter4.setDropDownViewResource(R.layout.menu);
        mySpinner4.setAdapter(myAdapter4);

        check4 = (CheckBox) findViewById(R.id.checkBox4);
        check4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check1.isChecked()){
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_LONG).show();
                }
            }
        });



        B1 = (Button)findViewById(R.id.breakfastBtn1);
        B1.setOnClickListener(new View.OnClickListener(){
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
