package com.example.hajjapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp_Page extends AppCompatActivity {

    EditText t1,t2,t3,t4,t5,t6,t7,t8;
    Button b1;
    String fname="",lname="",email="",name="",pass="",cpass="",dob="",contact="";
    private ProgressDialog pDialog;
    String Result="";
    Map<String,Object> data=new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up__page);
        t1=(EditText)findViewById(R.id.edtName);//fname
        t2=(EditText)findViewById(R.id.editText3);//lname
        t3=(EditText)findViewById(R.id.editText4);//email
        t4=(EditText)findViewById(R.id.editText5);//name
        t5=(EditText)findViewById(R.id.editText7);//password
        t6=(EditText)findViewById(R.id.editText8);//cpass
        t7=(EditText)findViewById(R.id.editText9);//dob
        t8=(EditText)findViewById(R.id.editText10);//number
        b1=(Button)findViewById(R.id.btnLogin);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fname=t1.getText().toString();
                lname=t2.getText().toString();
                email=t3.getText().toString();
                name=t4.getText().toString();
                pass=t5.getText().toString();
                cpass=t6.getText().toString();
                dob=t7.getText().toString();
                contact=t8.getText().toString();
                if(!isEmailValid(t3.getText().toString()))
                {
                    Toast.makeText(SignUp_Page.this,"Email Address is not valid", Toast.LENGTH_SHORT).show();
                }else if(!fname.equals("")&&!lname.equals("")&&!email.equals("")&&!name.equals("")&&!pass.equals("")&&!cpass.equals("")&&!dob.equals("")&&!contact.equals("")&&pass.equals(cpass))
                {
                    DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference();
                    data.put("FName",fname);
                    data.put("LName",lname);
                    data.put("Email",email);
                    data.put("UserName",name);
                    data.put("Pass",pass);
                    data.put("DateOfBirth",dob);
                    data.put("ContectNo",contact);

                    databaseReference.child("Data").child(contact).updateChildren(data).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(SignUp_Page.this,"Data Added", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else
                {

                    Toast.makeText(SignUp_Page.this,"Fill The Form Correctly", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }


    public static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}