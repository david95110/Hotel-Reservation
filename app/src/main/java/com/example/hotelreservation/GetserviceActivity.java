package com.example.hotelreservation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
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

public class GetserviceActivity extends AppCompatActivity {

    EditText roomNumber;
    EditText phoneNum;
    EditText cusName;
    Spinner serviceType;
    EditText editTime;
    Button confirmBtn;
    Button veiwBtn;
    long serviceId =0;

    DatabaseReference databaseService;
    Service service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getservice);

        Spinner mySpinner = findViewById(R.id.spinnerService);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(GetserviceActivity.this,
                R.layout.service, getResources().getStringArray(R.array.service));

        myAdapter.setDropDownViewResource(R.layout.service);
        mySpinner.setAdapter(myAdapter);

        roomNumber=(EditText)findViewById(R.id.roomNumberService);
        phoneNum=(EditText)findViewById(R.id.phoneNumService);
        cusName=(EditText)findViewById(R.id.cusNameService);
        serviceType=(Spinner) findViewById(R.id.spinnerService);
        editTime=(EditText)findViewById(R.id.editTimeService);
        confirmBtn=(Button) findViewById(R.id.confirmBtnService);



        databaseService = FirebaseDatabase.getInstance().getReference().child("Service-Information");
        databaseService.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                    serviceId =(dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        confirmBtn.setEnabled(false);

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (roomNumber.length()== 4) {

                    if(phoneNum.length()==10) {


                        service.setRoomNumber(roomNumber.getText().toString().trim());
                        service.setPhoneNumber(phoneNum.getText().toString().trim());
                        service.setCustomerName(cusName.getText().toString().trim());
                        service.setServiceType(serviceType.getSelectedItem().toString().trim());
                        service.setTime(editTime.getText().toString().trim());

                        databaseService.child(String.valueOf(serviceId +1)).setValue(service);
                        Toast.makeText(GetserviceActivity.this, "Data insert successfully", Toast.LENGTH_LONG).show();

                    }Toast.makeText(GetserviceActivity.this, "Enter valid Phone number", Toast.LENGTH_LONG).show();

                }Toast.makeText(GetserviceActivity.this, "Enter valid Room number", Toast.LENGTH_LONG).show();
            }
        });




        veiwBtn = (Button)findViewById(R.id.viewBtnService);
        veiwBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openViewServiceDetails();
            }
        });



        roomNumber.addTextChangedListener(serviceTextWatcher);
        phoneNum.addTextChangedListener(serviceTextWatcher);
        cusName.addTextChangedListener(serviceTextWatcher);
        editTime.addTextChangedListener(serviceTextWatcher);


    }

    private TextWatcher serviceTextWatcher = new TextWatcher() {
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

    public void openViewServiceDetails(){
        Intent intent = new Intent(this, ViewDetailsServiceActivity.class);
        startActivity(intent);
    }


}
