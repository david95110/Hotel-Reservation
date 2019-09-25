package com.example.hotelreservation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class GetActivitiesActivity extends AppCompatActivity   {

    EditText roomNumber;
    EditText phoneNum;
    EditText cusName;
    Spinner activityType;
    EditText editTime;
    Button confirmBtn;
    Button viewBtn;
    long activityId=0;

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
        databaseService.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                    activityId =(dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        confirmBtn.setEnabled(false);

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (roomNumber.length() == 4) {


                    if (phoneNum.length() == 10) {

                        activity1.setRoomNumber(roomNumber.getText().toString().trim());
                        activity1.setPhoneNumber(phoneNum.getText().toString().trim());
                        activity1.setCustomerName(cusName.getText().toString().trim());
                        activity1.setActivity(activityType.getSelectedItem().toString().trim());
                        activity1.setTime(editTime.getText().toString().trim());

                        databaseService.child(String.valueOf(activityId+1)).setValue(activity1);
                        Toast.makeText(GetActivitiesActivity.this, "Data insert successfully", Toast.LENGTH_LONG).show();

                    }Toast.makeText(GetActivitiesActivity.this, "Enter valid Phone number", Toast.LENGTH_LONG).show();

                }Toast.makeText(GetActivitiesActivity.this,"Enter valid Room number",Toast.LENGTH_LONG).show();
            }
        });



        viewBtn = (Button)findViewById(R.id.viewBtnActivity);
        viewBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openViewActivityDetails();
            }
        });

        roomNumber.addTextChangedListener(activityTextWatcher);
        phoneNum.addTextChangedListener(activityTextWatcher);
        cusName.addTextChangedListener(activityTextWatcher);
        editTime.addTextChangedListener(activityTextWatcher);

    }

    public void openViewActivityDetails(){
        Intent intent = new Intent(this, ViewDetailsFitnessActivity.class);
        startActivity(intent);
    }

    private TextWatcher activityTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String roomInput = roomNumber.getText().toString().trim();
            String phoneInput = phoneNum.getText().toString().trim();
            String nameInput =cusName.getText().toString().trim();
            String timeIput = editTime.getText().toString().trim();

            confirmBtn.setEnabled(!roomInput.isEmpty() && !phoneInput.isEmpty() && !nameInput.isEmpty() && !timeIput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

}
