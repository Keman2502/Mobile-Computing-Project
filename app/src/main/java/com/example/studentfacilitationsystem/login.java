package com.example.studentfacilitationsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class login extends AppCompatActivity {

    FirebaseAuth auth;
    boolean isEmailValid, isPasswordValid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        EditText uname,pass;
        Button b = findViewById(R.id.login);
        uname=findViewById(R.id.username);
        pass=findViewById(R.id.pwd);
        auth = FirebaseAuth.getInstance();

        b.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                if (uname.getText().toString().matches("")) {
                    uname.setError("Field is required");
                    isEmailValid = false;
                } else if (!Patterns.EMAIL_ADDRESS.matcher(uname.getText().toString()).matches()) {
                    uname.setError("Invalid email");
                    isEmailValid = false;
                } else  {
                    isEmailValid = true;
                }

                // Check for a valid password.
                if (pass.getText().toString().matches("")) {
                    pass.setError("Field is required");
                    isPasswordValid = false;
                } else if (pass.getText().length() < 6) {
                    pass.setError("Password must be atleast 6 charachters");
                    isPasswordValid = false;
                } else  {
                    isPasswordValid = true;

                }

                if (isEmailValid  && isPasswordValid) {
                    String u, phone, r, p, d;
                    u = uname.getText().toString();
                    p = pass.getText().toString();

                    ///user USER = new user(uname.getText().toString(), pass.getText().toString());
                    auth.signInWithEmailAndPassword(

                            uname.getText().toString(), pass.getText().toString()
                    ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(login.this, portal.class);
                                startActivity(intent);

                            }else {
                                // If sign in fails, display a message to the user.
                                Log.w("TAG", "createUserWithEmail:failure", task.getException());
                                Intent intent = new Intent(login.this, signup.class);
                                startActivity(intent);

                            }
                        }


                    });

                }

            }



        });
}}