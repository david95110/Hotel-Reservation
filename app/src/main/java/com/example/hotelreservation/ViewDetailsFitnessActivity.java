package com.example.hotelreservation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ViewDetailsFitnessActivity extends AppCompatActivity {

    private EditText room, phone, name, timeEdit, activityService;
    Button showBtn, editBtn,deleteBtn;
    private static DatabaseReference databaseActivity = FirebaseDatabase.getInstance().getReference().child("Activity-Information").child("2");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details_fitness);

        room = (EditText) findViewById(R.id.roomNumberActivity);
        phone = (EditText) findViewById(R.id.phoneNumActivity);
        name = (EditText) findViewById(R.id.cusNameActivity);
        activityService = (EditText) findViewById(R.id.spinnerActivity);
        timeEdit = (EditText) findViewById(R.id.editTimeActivity);
        showBtn=(Button) findViewById(R.id.showBtnActivity);
        editBtn = (Button) findViewById(R.id.updateBtnActivity);
        deleteBtn = (Button) findViewById(R.id.deleteBtnActivity);

        showData();

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showData();

            }
        });

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//              databaseActivity= FirebaseDatabase.getInstance().getReference().child("Service-Information").child("1");
                databaseActivity.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String newroomNumber = room.getText().toString();
                        String newcustomerName = name.getText().toString();
                        String newphoneNumber = phone.getText().toString();
                        String newserviceType = activityService.getText().toString();
                        String newtime = timeEdit.getText().toString();

                        dataSnapshot.getRef().child("roomNumber").setValue(newroomNumber);
                        dataSnapshot.getRef().child("customerName").setValue(newcustomerName);
                        dataSnapshot.getRef().child("phoneNumber").setValue(newphoneNumber);
                        dataSnapshot.getRef().child("activity").setValue(newserviceType);
                        dataSnapshot.getRef().child("time").setValue(newtime);

                        Toast.makeText(ViewDetailsFitnessActivity.this, "Data Edited", Toast.LENGTH_LONG).show();

                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });


    }

    public void showData() {
        databaseActivity.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String roomNumber = dataSnapshot.child("roomNumber").getValue().toString();
                String customerName = dataSnapshot.child("customerName").getValue().toString();
                String phoneNumber = dataSnapshot.child("phoneNumber").getValue().toString();
                String activity = dataSnapshot.child("activity").getValue().toString();
                String time = dataSnapshot.child("time").getValue().toString();
                //if(rm.equlsTo()roomNumber){
                room.setText(roomNumber);
                phone.setText(phoneNumber);
                name.setText(customerName);
                activityService.setText(activity);
                timeEdit.setText(time);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
