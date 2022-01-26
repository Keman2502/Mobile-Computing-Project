package com.example.studentfacilitationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

                name = uname.getText().toString().trim();
                pwd = pass.getText().toString().trim();
                rollid = roll.getText().toString().trim();
                d = dpt.getText().toString().trim();
                phno = ph.getText().toString().trim();

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
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("user");
                    showAllUserData(v);
                    Intent intent = getIntent();
                    name = intent.getStringExtra(uname.toString());
                    pwd = intent.getStringExtra(pass.toString());
                    rollid = intent.getStringExtra(roll.toString());
                    phno = intent.getStringExtra(ph.toString());
                    d = intent.getStringExtra(dpt.toString());
                    reference.child("userId").child("uname").setValue(name);
                    reference.child("userId").child("pwd").setValue(pwd);
                    reference.child("userId").child("roll").setValue(rollid);
                    reference.child("userId").child("dpt").setValue(d);
                    reference.child("userId").child("phone").setValue(phno);

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