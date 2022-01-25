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

public class delete_account extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_account);

        EditText uname,pass,roll,ph,dpt;
        Button b = findViewById(R.id.delete);
        uname=findViewById(R.id.username);
        pass=findViewById(R.id.pwd);
        roll=findViewById(R.id.rollid);
        ph=findViewById(R.id.phno);
        dpt=findViewById(R.id.dpt);
        b.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                String name,pwd,rollid,d,phno;
                name=uname.getText().toString().trim();
                pwd=pass.getText().toString().trim();
                rollid=roll.getText().toString().trim();
                d=dpt.getText().toString().trim();
                phno=ph.getText().toString().trim();

                user u =new user(name,pwd,rollid,d,phno);
                if(TextUtils.isEmpty(name)){
                    uname.setError("Field is required");
                }
                if(TextUtils.isEmpty(pwd)){
                    pass.setError("Field is required");
                }
                if(TextUtils.isEmpty(rollid)){
                    roll.setError("Field is required");
                }
                if(TextUtils.isEmpty(d)){
                    dpt.setError("Field is required");
                }
                if(TextUtils.isEmpty(phno)){
                    ph.setError("Field is required");
                }

                try{
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("user").child("userId");
                    reference.removeValue();
                    Toast.makeText(getApplicationContext(), "Successfully account deleted!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(delete_account.this, MainActivity.class));
                }
                catch(Exception e){
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "UNSUCCESSFUL", Toast.LENGTH_LONG).show();
                    //Toast.makeText(getApplicationContext(), "Deletion Unsuccessful", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(), portal.class));
                }


            }


        });
    }
}