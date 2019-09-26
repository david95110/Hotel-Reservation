package com.example.hotelreservation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class ViewDetailsServiceActivity extends AppCompatActivity {

    private EditText room, phone, name, timeEdit, service;
    Button showBtn, editBtn;
    private static DatabaseReference database = FirebaseDatabase.getInstance().getReference().child("Service-Information").child("1");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details_service);

        room = (EditText) findViewById(R.id.roomNumberService);
        phone = (EditText) findViewById(R.id.phoneNumService);
        name = (EditText) findViewById(R.id.cusNameService);
        service = (EditText) findViewById(R.id.serviceTypeValue);
        timeEdit = (EditText) findViewById(R.id.editTimeService);
        showBtn = (Button) findViewById(R.id.showBtnService);
        editBtn = (Button) findViewById(R.id.updateBtnService);
        Button deleteBtn = (Button) findViewById(R.id.deleteBtnService);


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
//              database= FirebaseDatabase.getInstance().getReference().child("Service-Information").child("1");
                database.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String newroomNumber = room.getText().toString();
                        String newcustomerName = name.getText().toString();
                        String newphoneNumber = phone.getText().toString();
                        String newserviceType = service.getText().toString();
                        String newtime = timeEdit.getText().toString();

                        dataSnapshot.getRef().child("roomNumber").setValue(newroomNumber);
                        dataSnapshot.getRef().child("customerName").setValue(newcustomerName);
                        dataSnapshot.getRef().child("phoneNumber").setValue(newphoneNumber);
                        dataSnapshot.getRef().child("serviceType").setValue(newserviceType);
                        dataSnapshot.getRef().child("time").setValue(newtime);

                        Toast.makeText(ViewDetailsServiceActivity.this, "Data Edited", Toast.LENGTH_LONG).show();

                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                deleteData();
            }
        });
//        editBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                database= FirebaseDatabase.getInstance().getReference().child("Service-Information").child("1");
//
//                String enterPhoneNumber=phone.getText().toString();
//                String enterName=name.getText().toString();
//                String enterService=service.getText().toString();
//                String enterTime=timeEdit.getText().toString();
////                String ste = room.getText().toString();
////                dataSnapshot.getRef().child("roomNumber").setValue(ste);
//
//                editData(enterPhoneNumber,enterName,enterService,enterTime);
//
//            }
//        });
    }

    private void editData(final String strPhone, String strName, String strService, final String strTime) {

        Query editQuery = database.orderByChild("phone").equalTo(strPhone);
        editQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot edtData : dataSnapshot.getChildren()) {
                    edtData.getRef().child("Service-Information").setValue(strTime);
                    dataSnapshot.getRef().child("roomNumber").setValue(strPhone);
                }
                Toast.makeText(ViewDetailsServiceActivity.this, "Data Edited", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void showData() {
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String roomNumber = dataSnapshot.child("roomNumber").getValue().toString();
                String customerName = dataSnapshot.child("customerName").getValue().toString();
                String phoneNumber = dataSnapshot.child("phoneNumber").getValue().toString();
                String serviceType = dataSnapshot.child("serviceType").getValue().toString();
                String time = dataSnapshot.child("time").getValue().toString();
                //if(rm.equlsTo()roomNumber){
                    room.setText(roomNumber);
                    phone.setText(phoneNumber);
                    name.setText(customerName);
                    service.setText(serviceType);
                    timeEdit.setText(time);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    public void deleteData() {
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                dataSnapshot.getRef().child("roomNumber").setValue("");
                dataSnapshot.getRef().child("customerName").setValue("");
                dataSnapshot.getRef().child("phoneNumber").setValue("");
                dataSnapshot.getRef().child("serviceType").setValue("");
                dataSnapshot.getRef().child("time").setValue("");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
