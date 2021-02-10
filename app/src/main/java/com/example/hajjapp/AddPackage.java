package com.example.hajjapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddPackage extends AppCompatActivity {

    EditText edtPackageId;
    EditText edtDays;
    EditText edtDaysInMakkah;
    EditText edtDaysInMadinah;
    EditText edtStartDate;
    EditText edtEndDate;
    EditText edtPackageType;
    EditText edtPrice;
    RadioButton rdbTransport;
    RadioButton rdbFood;
    Button btnAdd;
    Map<String,Object> data=new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_package);

        edtPackageId=findViewById(R.id.edtPackageID);
        edtDays=findViewById(R.id.edtDays);
        edtDaysInMakkah=findViewById(R.id.edtDaysInMakkah);
        edtDaysInMadinah=findViewById(R.id.edtDaysInMadinah);
        edtStartDate=findViewById(R.id.edtStartDate);
        edtEndDate=findViewById(R.id.edtEndDate);
        edtPackageType=findViewById(R.id.edtPackageType);
        edtPrice=findViewById(R.id.edtPrice);
        rdbTransport=findViewById(R.id.rdbTransport);
        rdbFood=findViewById(R.id.rdbFood);
        btnAdd=findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=edtPackageId.getText().toString();
                String days=edtDays.getText().toString();
                String daysInMakkah=edtDaysInMakkah.getText().toString();
                String daysInMadinah=edtDaysInMadinah.getText().toString();
                String startDate=edtStartDate.getText().toString();
                String endDate=edtEndDate.getText().toString();
                String type=edtPackageType.getText().toString();
                String price=edtPrice.getText().toString();
                String transport="0";
                String food="0";

                if(rdbTransport.isChecked())
                    transport="1";
                if(rdbFood.isChecked())
                    food="1";
                if(id.equals("") || days.equals("") || daysInMakkah.equals("") || daysInMadinah.equals("") || startDate.equals("") || endDate.equals("") || type.equals("") || price.equals("") )
                {
                    Toast.makeText(AddPackage.this,"Fill The Form Correctly", Toast.LENGTH_SHORT).show();
                }else
                {
                    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference();
                    data.put("ID",id);
                    data.put("Days",days);
                    data.put("DaysInMakkah",daysInMakkah);
                    data.put("DaysInMadinah",daysInMadinah);
                    data.put("StartDate",startDate);
                    data.put("EndDate",endDate);
                    data.put("Type",type);
                    data.put("Price",price);
                    data.put("Transport",transport);
                    data.put("Food",food);
                    databaseReference.child("Packages").child(id).updateChildren(data).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(AddPackage.this,"Data Added", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });


    }
}