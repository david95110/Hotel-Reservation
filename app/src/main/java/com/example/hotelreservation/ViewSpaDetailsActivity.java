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

public class ViewSpaDetailsActivity extends AppCompatActivity {

    private EditText room, phone, name, timeEdit, spaService;
    Button showBtn, editBtn,deleteBtn;
    private static DatabaseReference databaseSpa = FirebaseDatabase.getInstance().getReference().child("Spa-Information").child("6");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_spa_details);

        room = (EditText) findViewById(R.id.roomNumberSpa);
        phone = (EditText) findViewById(R.id.phoneNumSpa);
        name = (EditText) findViewById(R.id.cusNameSpa);
        spaService = (EditText) findViewById(R.id.spinnerSpa);
        timeEdit = (EditText) findViewById(R.id.timeSpa);
        showBtn=(Button) findViewById(R.id.showBtnSpa);
        editBtn = (Button) findViewById(R.id.updateBtnSpa);
        deleteBtn = (Button) findViewById(R.id.deleteBtnSpa);

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
//              databaseSpa= FirebaseDatabase.getInstance().getReference().child("Service-Information").child("1");
                databaseSpa.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String newroomNumber = room.getText().toString();
                        String newcustomerName = name.getText().toString();
                        String newphoneNumber = phone.getText().toString();
                        String newserviceType = spaService.getText().toString();
                        String newtime = timeEdit.getText().toString();

                        dataSnapshot.getRef().child("roomNumber").setValue(newroomNumber);
                        dataSnapshot.getRef().child("customerName").setValue(newcustomerName);
                        dataSnapshot.getRef().child("phoneNumber").setValue(newphoneNumber);
                        dataSnapshot.getRef().child("spaType").setValue(newserviceType);
                        dataSnapshot.getRef().child("time").setValue(newtime);

                        Toast.makeText(ViewSpaDetailsActivity.this, "Data Edited", Toast.LENGTH_LONG).show();

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
                deleteData();
            }
        });



    }

    public void showData() {
        databaseSpa.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String roomNumber = dataSnapshot.child("roomNumber").getValue().toString();
                String customerName = dataSnapshot.child("customerName").getValue().toString();
                String phoneNumber = dataSnapshot.child("phoneNumber").getValue().toString();
                String spaType = dataSnapshot.child("spaType").getValue().toString();
                String time = dataSnapshot.child("time").getValue().toString();
                //if(rm.equlsTo()roomNumber){
                room.setText(roomNumber);
                phone.setText(phoneNumber);
                name.setText(customerName);
                spaService.setText(spaType);
                timeEdit.setText(time);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void deleteData() {
        databaseSpa.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                dataSnapshot.getRef().child("roomNumber").setValue("");
                dataSnapshot.getRef().child("customerName").setValue("");
                dataSnapshot.getRef().child("phoneNumber").setValue("");
                dataSnapshot.getRef().child("spaType").setValue("");
                dataSnapshot.getRef().child("time").setValue("");

                Toast.makeText(ViewSpaDetailsActivity.this, "Data Deleted", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


}
