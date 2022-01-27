package com.example.studentfacilitationsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {
    private FirebaseAuth auth;
    //TextInputLayout nameError, emailError, phoneError, passError;
    boolean  isEmailValid, isPhoneValid, isPasswordValid,isRollValid,isDptValid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        EditText uname,pass,roll,ph,dpt;
        Button b = findViewById(R.id.register);
        uname=findViewById(R.id.username);
        pass=findViewById(R.id.pwd);
        roll=findViewById(R.id.rollid);
        ph=findViewById(R.id.phno);
        dpt=findViewById(R.id.dpt);

        auth = FirebaseAuth.getInstance();

        b.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                // Check for a valid email address.
                if (uname.getText().toString().isEmpty()) {
                    uname.setError("Field is required");
                    isEmailValid = false;
                } else if (!Patterns.EMAIL_ADDRESS.matcher(uname.getText().toString()).matches()) {
                    uname.setError("Invalid email");
                    isEmailValid = false;
                } else  {
                    isEmailValid = true;
                }

                // Check for a valid phone number.
                if (ph.getText().toString().isEmpty()) {
                    ph.setError("Field is required");
                    isPhoneValid = false;
                } else  {
                    isPhoneValid = true;

                }

                if (roll.getText().toString().isEmpty()) {
                    roll.setError("Field is required");
                    isRollValid = false;
                } else  {
                    isRollValid = true;

                }

                if (dpt.getText().toString().isEmpty()) {
                    dpt.setError("Field is required");
                    isDptValid = false;
                } else  {
                    isDptValid = true;

                }

                // Check for a valid password.
                if (pass.getText().toString().isEmpty()) {
                    pass.setError("Field is required");
                    isPasswordValid = false;
                } else if (pass.getText().length() < 6) {
                    pass.setError("Password must be atleast 6 charachters");
                    isPasswordValid = false;
                } else  {
                    isPasswordValid = true;

                }

                if (isEmailValid && isRollValid && isDptValid && isPhoneValid && isPasswordValid) {
                    String u,phone,r,p,d;
                    u = uname.getText().toString().trim();
                    phone = ph.getText().toString().trim();
                    p = pass.getText().toString().trim();
                    r = roll.getText().toString().trim();
                    d = dpt.getText().toString().trim();

                    user USER =new user(u,p,r,d,phone);
                    try{
                        auth.createUserWithEmailAndPassword(
                                uname.getText().toString(),
                                pass.getText().toString()).
                                addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if(task.isSuccessful()){
                                            user User = new user(
                                                    uname.getText().toString(),
                                                    pass.getText().toString(),
                                                    roll.getText().toString(),
                                                    dpt.getText().toString(),
                                                    ph.getText().toString()
                                            );
                                            String id = task.getResult().getUser().getUid();
                                            FirebaseDatabase db = FirebaseDatabase.getInstance();
                                            DatabaseReference dbr = db.getReference();
                                            dbr.child("User").child(id).setValue(User);
                                        }
                                    }
                                });
                        Toast.makeText(getApplicationContext(), "Successfully registered!", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(signup.this, login.class));
                    }
                    catch(Exception e1) {
                        e1.printStackTrace();
                        Toast.makeText(getApplicationContext(), "UNSUCCESSFUL", Toast.LENGTH_LONG).show();

                    }
                }


















//                String name,pwd,rollid,d,phno;
//                name=uname.getText().toString().trim();
//                pwd=pass.getText().toString().trim();
//                rollid=roll.getText().toString().trim();
//                d=dpt.getText().toString().trim();
//                phno=ph.getText().toString().trim();
//
//                user u =new user(name,pwd,rollid,d,phno);
//                if(TextUtils.isEmpty(name)){
//                    uname.setError("Field is required");
                     // isNameValid = false;
//                }
//                if(TextUtils.isEmpty(pwd)){
//                    pass.setError("Field is required");
//                }
//                if(TextUtils.isEmpty(rollid)){
//                    roll.setError("Field is required");
//                }
//                if(TextUtils.isEmpty(d)){
//                    dpt.setError("Field is required");
//                }
//                if(TextUtils.isEmpty(phno)){
//                    ph.setError("Field is required");
//                }
//                if(uname !=null && pass !=null && roll !=null && ph !=null && dpt !=null ){
//                    try{
//                        FirebaseDatabase db = FirebaseDatabase.getInstance();
//                        DatabaseReference dbr = db.getReference();
//                        dbr.child("user").push().setValue(u);
//                        Toast.makeText(getApplicationContext(), "Successfully registered!", Toast.LENGTH_LONG).show();
//                        startActivity(new Intent(signup.this, login.class));
//                    }
//                    catch(Exception e){
//                        e.printStackTrace();
//                        Toast.makeText(getApplicationContext(), "UNSUCCESSFUL", Toast.LENGTH_LONG).show();
//                        startActivity(new Intent(signup.this, MainActivity.class));
//                    }
//                }
//                else{
//                    Toast.makeText(getApplicationContext(), "Enter Required Fields", Toast.LENGTH_LONG).show();
//                }



            }


        });




    }

    }






    //////////////////////////////////////////////







//package com.example.semesterproject;
//
//        import android.content.Intent;
//        import android.util.Patterns;
//        import android.os.Bundle;
//        import android.view.View;
//        import android.widget.Button;
//        import android.widget.TextView;
//        import android.widget.Toast;
//        import android.widget.EditText;
//
//        import androidx.annotation.NonNull;
//        import androidx.appcompat.app.AppCompatActivity;
//
//        import com.google.android.gms.tasks.OnCompleteListener;
//        import com.google.android.gms.tasks.Task;
//        import com.google.android.material.textfield.TextInputLayout;
//        import com.google.firebase.auth.AuthResult;
//        import com.google.firebase.auth.FirebaseAuth;
//        import com.google.firebase.database.DatabaseReference;
//        import com.google.firebase.database.FirebaseDatabase;
//
//public class RegisterActivity extends AppCompatActivity {
//
//    EditText name, email, phone, password;
//    Button register;
//    TextView login;
//    boolean isNameValid, isEmailValid, isPhoneValid, isPasswordValid;
//    TextInputLayout nameError, emailError, phoneError, passError;
//    private FirebaseAuth auth;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_register);
//
//        name = (EditText) findViewById(R.id.name);
//        email = (EditText) findViewById(R.id.email);
//        phone = (EditText) findViewById(R.id.phone);
//        password = (EditText) findViewById(R.id.password);
//        login = (TextView) findViewById(R.id.login);
//        register = (Button) findViewById(R.id.register);
//        nameError = (TextInputLayout) findViewById(R.id.nameError);
//        emailError = (TextInputLayout) findViewById(R.id.emailError);
//        phoneError = (TextInputLayout) findViewById(R.id.phoneError);
//        passError = (TextInputLayout) findViewById(R.id.passError);
//        auth = FirebaseAuth.getInstance();
//
//        register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (name.getText().toString().isEmpty()) {
//                    nameError.setError(getResources().getString(R.string.name_error));
//                    isNameValid = false;
//                } else  {
//                    isNameValid = true;
//                    nameError.setErrorEnabled(false);
//                }
//
//                // Check for a valid email address.
//                if (email.getText().toString().isEmpty()) {
//                    emailError.setError(getResources().getString(R.string.email_error));
//                    isEmailValid = false;
//                } else if (!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {
//                    emailError.setError(getResources().getString(R.string.error_invalid_email));
//                    isEmailValid = false;
//                } else  {
//                    isEmailValid = true;
//                    emailError.setErrorEnabled(false);
//                }
//
//                // Check for a valid phone number.
//                if (phone.getText().toString().isEmpty()) {
//                    phoneError.setError(getResources().getString(R.string.phone_error));
//                    isPhoneValid = false;
//                } else  {
//                    isPhoneValid = true;
//                    phoneError.setErrorEnabled(false);
//                }
//
//                // Check for a valid password.
//                if (password.getText().toString().isEmpty()) {
//                    passError.setError(getResources().getString(R.string.password_error));
//                    isPasswordValid = false;
//                } else if (password.getText().length() < 6) {
//                    passError.setError(getResources().getString(R.string.error_invalid_password));
//                    isPasswordValid = false;
//                } else  {
//                    isPasswordValid = true;
//                    passError.setErrorEnabled(false);
//                }
//
//                if (isNameValid && isEmailValid && isPhoneValid && isPasswordValid) {
//                    String n,e,ph,p;
//                    n = name.getText().toString().trim();
//                    e = email.getText().toString().trim();
//                    ph = phone.getText().toString().trim();
//                    p = password.getText().toString().trim();
//
//                    user USER =new user(n,e,ph,p);
//                    try{
//                        auth.createUserWithEmailAndPassword(
//                                email.getText().toString(),
//                                password.getText().toString()).
//                                addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                                    @Override
//                                    public void onComplete(@NonNull Task<AuthResult> task) {
//                                        if(task.isSuccessful()){
//                                            user User = new user(
//                                                    name.getText().toString(),
//                                                    email.getText().toString(),
//                                                    phone.getText().toString(),
//                                                    password.getText().toString()
//                                            );
//                                            String id = task.getResult().getUser().getUid();
//                                            FirebaseDatabase db = FirebaseDatabase.getInstance();
//                                            DatabaseReference dbr = db.getReference();
//                                            dbr.child("Users").child(id).setValue(User);
//                                        }
//                                    }
//                                });
//                        Toast.makeText(getApplicationContext(), "Successfully registered!", Toast.LENGTH_LONG).show();
//                        startActivity(new Intent(RegisterActivity.this, Login.class));
//                    }
//                    catch(Exception e1) {
//                        e1.printStackTrace();
//                        Toast.makeText(getApplicationContext(), "UNSUCCESSFUL", Toast.LENGTH_LONG).show();
//                        startActivity(new Intent(RegisterActivity.this, RegisterActivity.class));
//                    }
//                }
//
//            }
//        });
//
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // redirect to LoginActivity
//                Intent intent = new Intent(getApplicationContext(), Login.class);
//                startActivity(intent);
//            }
//        });
//    }
//
//}






