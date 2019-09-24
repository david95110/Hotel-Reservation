package com.example.hotelreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.service.autofill.Validator;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class GetActivitiesActivity extends AppCompatActivity   {

    EditText roomNumber;
    EditText phoneNum;
    EditText cusName;
    Spinner activityType;
    EditText editTime;
    Button confirmBtn;

    DatabaseReference databaseService;
    Activity activity1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_activity);

        Spinner mySpinner = findViewById(R.id.spinnerActivity);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(GetActivitiesActivity.this,
                R.layout.activity, getResources().getStringArray(R.array.menuActivity));

        myAdapter.setDropDownViewResource(R.layout.activity);
        mySpinner.setAdapter(myAdapter);


        roomNumber=(EditText)findViewById(R.id.roomNumberActivity);
        phoneNum=(EditText)findViewById(R.id.phoneNumActivity);
        cusName=(EditText)findViewById(R.id.cusNameActivity);
        activityType=(Spinner) findViewById(R.id.spinnerActivity);
        editTime=(EditText)findViewById(R.id.timeActivity);
        confirmBtn=(Button) findViewById(R.id.confirmBtnActivity);
        activity1= new Activity();
        databaseService = FirebaseDatabase.getInstance().getReference().child("Activity");

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity1.setRoomNumber(roomNumber.getText().toString().trim());
                activity1.setPhoneNumber(phoneNum.getText().toString().trim());
                activity1.setCustomerName(cusName.getText().toString().trim());
                activity1.setActivity(activityType.getSelectedItem().toString().trim());
                activity1.setTime(editTime.getText().toString().trim());

                databaseService.push().setValue(activity1);
                Toast.makeText(GetActivitiesActivity.this,"Data insert successfully",Toast.LENGTH_LONG).show();
            }
        });



    }


}
