package com.example.studentfacilitationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class update_account extends AppCompatActivity {


    EditText uname,pass,roll,ph,dpt;
    String name,pwd,rollid,d,phno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_account);

        Button b = findViewById(R.id.update);
        uname = findViewById(R.id.username);
        pass = findViewById(R.id.pwd);
        roll = findViewById(R.id.rollid);
        ph = findViewById(R.id.phno);
        dpt = findViewById(R.id.dpt);
        b.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {

                name = uname.getText().toString();
                pwd = pass.getText().toString();
                rollid = roll.getText().toString();
                d = dpt.getText().toString();
                phno = ph.getText().toString();

                user u = new user(name, pwd, rollid, d, phno);
                if (TextUtils.isEmpty(name)) {
                    uname.setError("Field is required");
                }
                if (TextUtils.isEmpty(pwd)) {
                    pass.setError("Field is required");
                }
                if (TextUtils.isEmpty(rollid)) {
                    roll.setError("Field is required");
                }
                if (TextUtils.isEmpty(d)) {
                    dpt.setError("Field is required");
                }
                if (TextUtils.isEmpty(phno)) {
                    ph.setError("Field is required");
                }

                try {



                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("User");

                   String currentuser = FirebaseAuth.getInstance().getCurrentUser().toString();

                    Log.e("update id user", currentuser);
//                    Firebase firebase = new Firebase("your database link/myDb");
                    reference.child(currentuser).child("uname").setValue(name);
                    reference.child(currentuser).child("pwd").setValue(pwd);
                    reference.child(currentuser).child("roll").setValue(rollid);
                    reference.child(currentuser).child("dpt").setValue(d);
                    reference.child(currentuser).child("phone").setValue(phno);


//                    showAllUserData(v);
//                    Intent intent = getIntent();
//                    name = intent.getStringExtra(uname.toString());
//                    pwd = intent.getStringExtra(pass.toString());
//                    rollid = intent.getStringExtra(roll.toString());
//                    phno = intent.getStringExtra(ph.toString());
//                    d = intent.getStringExtra(dpt.toString());
//                    reference.child("UserId").child("uname").setValue(name);
//                    reference.child("UserId").child("pwd").setValue(pwd);
//                    reference.child("UserId").child("roll").setValue(rollid);
//                    reference.child("UserId").child("dpt").setValue(d);
//                    reference.child("UserId").child("phone").setValue(phno);

                    Toast.makeText(getApplicationContext(), "Successfully registered!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(update_account.this, portal.class));
                 }catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "UNSUCCESSFUL", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(update_account.this, MainActivity.class));
                }


            }




        });


    }
    private void showAllUserData(View v) {
        Intent intent = getIntent();
        name = intent.getStringExtra(uname.toString());
        pwd = intent.getStringExtra(pass.toString());
        rollid = intent.getStringExtra(roll.toString());
        phno = intent.getStringExtra(ph.toString());
        d = intent.getStringExtra(dpt.toString());

        uname.setText((name));
        pass.setText((pwd));
        roll.setText((rollid));
        ph.setText((phno));
        dpt.setText((d));
    }


}