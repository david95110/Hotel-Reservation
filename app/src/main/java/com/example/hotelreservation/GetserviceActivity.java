package com.example.hotelreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GetserviceActivity extends AppCompatActivity {

    EditText roomNumber;
    EditText phoneNum;
    EditText cusName;
    Spinner serviceType;
    EditText editTime;
    Button confirmBtn;

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
        service= new Service();
        databaseService = FirebaseDatabase.getInstance().getReference().child("Service");

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              service.setRoomNumber(roomNumber.getText().toString().trim());
              service.setPhoneNumber(phoneNum.getText().toString().trim());
              service.setCustomerName(cusName.getText().toString().trim());
              service.setSpinnerser(serviceType.getSelectedItem().toString().trim());
              service.setTime(editTime.getText().toString().trim());

              databaseService.push().setValue(service);
              Toast.makeText(GetserviceActivity.this,"Data insert successfully",Toast.LENGTH_LONG).show();
            }
        });

    }

}
