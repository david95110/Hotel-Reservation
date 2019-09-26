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


public class GetSpaActivity extends AppCompatActivity {

    EditText roomNumber;
    EditText phoneNum;
    EditText cusName;
    Spinner spaType;
    EditText editTime;
    Button confirmBtn;
    Button viewBtn;
    long spaId =0;
    DatabaseReference databaseSpa;
    Spa spaactivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_spa);

        viewBtn = (Button)findViewById(R.id.viewBtnSpa);
        viewBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openViewSpaDetails();
            }
        });

        Spinner mySpinner = findViewById(R.id.spinnerSpa);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(GetSpaActivity.this,
                R.layout.spa, getResources().getStringArray(R.array.menuSpa));

        myAdapter.setDropDownViewResource(R.layout.spa);
        mySpinner.setAdapter(myAdapter);

        databaseSpa= FirebaseDatabase.getInstance().getReference().child("Spa-Information");

        roomNumber=(EditText)findViewById(R.id.roomNumberSpa);
        phoneNum=(EditText)findViewById(R.id.phoneNumSpa);
        cusName=(EditText)findViewById(R.id.cusNameSpa);
        spaType=(Spinner) findViewById(R.id.spinnerSpa);
        editTime=(EditText)findViewById(R.id.timeSpa);
        confirmBtn=(Button)findViewById(R.id.confirmBtnSpa);

        spaactivity= new Spa();

        databaseSpa.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                    spaId =(dataSnapshot.getChildrenCount());
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

                        spaactivity.setRoomNumber(roomNumber.getText().toString().trim());
                        spaactivity.setPhoneNumber(phoneNum.getText().toString().trim());
                        spaactivity.setCustomerName(cusName.getText().toString().trim());
                        spaactivity.setSpaType(spaType.getSelectedItem().toString().trim());
                        spaactivity.setTime(editTime.getText().toString().trim());

                        databaseSpa.child(String.valueOf(spaId+1)).setValue(spaactivity);
                        Toast.makeText(GetSpaActivity.this, "Data insert successfully", Toast.LENGTH_LONG).show();

                    }
                    else {
                        Toast.makeText(GetSpaActivity.this, "Enter valid Phone number", Toast.LENGTH_LONG).show();
                    }

                }else {
                    Toast.makeText(GetSpaActivity.this, "Enter valid Room number", Toast.LENGTH_LONG).show();

                }
            }
        });

        roomNumber.addTextChangedListener(spaTextWatcher);
        phoneNum.addTextChangedListener(spaTextWatcher);
        cusName.addTextChangedListener(spaTextWatcher);
        editTime.addTextChangedListener(spaTextWatcher);



    }

    private TextWatcher spaTextWatcher = new TextWatcher() {
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

    public void openViewSpaDetails(){
        Intent intent = new Intent(this, ViewSpaDetailsActivity.class);
        startActivity(intent);
    }
}
