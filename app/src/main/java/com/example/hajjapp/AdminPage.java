package com.example.hajjapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AdminPage extends AppCompatActivity {

    Button btnAddPackage, btnAllPackage,btnTravelers;
    TextView tvLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);
        btnAddPackage=findViewById(R.id.btnAddPackage);
        btnAllPackage=findViewById(R.id.btnAllPackage);
        btnTravelers=findViewById(R.id.btntravel);
        tvLogout=findViewById(R.id.tvLogout);

        btnAddPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminPage.this, AddPackage.class);

                startActivity(intent);
            }
        });
        btnAllPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AdminPage.this,"All Packages", Toast.LENGTH_SHORT).show();
            }
        });
        btnTravelers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AdminPage.this,"Travelers", Toast.LENGTH_SHORT).show();
            }
        });

     /*   tvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }); */
    }
}