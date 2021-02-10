package com.example.hajjapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login_Signup_Page extends AppCompatActivity {

    Button btnLogin;
    Button btnSingup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__signup__page);

        btnLogin=(Button)findViewById(R.id.btnLogin);
        btnSingup=(Button)findViewById(R.id.btnSignup);
        final Bundle bd=getIntent().getExtras();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //signup
                Intent intent = new Intent(Login_Signup_Page.this, LoginPage.class);

                startActivity(intent);
            }
        });
        btnSingup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //login
                Intent intent = new Intent(Login_Signup_Page.this, SignUp_Page.class);

                startActivity(intent);
            }
        });
    }
}