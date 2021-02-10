package com.example.hajjapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

import java.util.ArrayList;

public class LoginPage extends AppCompatActivity {

    String Result="";

    EditText t1,t2;
    String name="",pass="";

    Button b1;
    Boolean flag2=false;

    ArrayList<Traveler> travelers=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        t1=(EditText)findViewById(R.id.edtName);
        t2=(EditText)findViewById(R.id.edtPass);
        b1=(Button)findViewById(R.id.btnSignup);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean flag=false;
                name = t1.getText().toString();
                pass = t2.getText().toString();
                if(!name.equals("")&&!pass.equals(""))
                {
                    if(name.equals("Admin") && pass.equals("admin"))
                    {
                        flag2=true;
                        Intent intent = new Intent(LoginPage.this, AdminPage.class);

                        startActivity(intent);
                    }
                }else
                {
                    Toast.makeText(LoginPage.this,"Fill The Fields", Toast.LENGTH_SHORT).show();
                }

                if(flag2==true &&!name.equals("")&&!pass.equals(""))
                {
                    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference().child("Data");
                    databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for(DataSnapshot data:snapshot.getChildren())
                            {
                                travelers.add(new Traveler(data.child("UserName").getValue().toString(),data.child("Pass").getValue().toString()));
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                    for(int i=0;i<travelers.size();i++)
                    {

                        if(travelers.get(i).getName().equals(name) && travelers.get(i).getPass().equals(pass))
                        {

                            flag=true;

                            break;
                        }
                    }
                    if(flag==true)
                        Toast.makeText(LoginPage.this,"Login Successfully", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(LoginPage.this,"incorrect User Name Or Password", Toast.LENGTH_SHORT).show();

                }
                else

                {
                    Toast.makeText(LoginPage.this,"Fill The Fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}