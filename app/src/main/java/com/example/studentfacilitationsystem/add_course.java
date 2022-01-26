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

public class add_course extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        EditText cname,roll,tname,dpt;
        Button b = findViewById(R.id.add);
        cname=findViewById(R.id.coursename);
        roll=findViewById(R.id.rollid);
        dpt=findViewById(R.id.dpt);
        tname=findViewById(R.id.tchr);

        b.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                String name,rollid,d,tchr;
                name=cname.getText().toString().trim();
                rollid=roll.getText().toString().trim();
                d=dpt.getText().toString().trim();
                tchr=tname.getText().toString().trim();

                course c =new course(name,rollid,tchr,d);

                if(TextUtils.isEmpty(name)){
                    cname.setError("Field is required");
                }
                if(TextUtils.isEmpty(rollid)){
                    roll.setError("Field is required");
                }
                if(TextUtils.isEmpty(d)){
                    dpt.setError("Field is required");
                }
                if(TextUtils.isEmpty(tchr)){
                    tname.setError("Field is required");
                }



                try{
                    FirebaseDatabase db = FirebaseDatabase.getInstance();
                    DatabaseReference dbr = db.getReference();
                    dbr.child("course").push().setValue(c);
                    Toast.makeText(getApplicationContext(), "Successfully added!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(add_course.this, portal.class));}
                catch(Exception e){
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "UNSUCCESSFUL", Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(), "Successfully registered!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(add_course.this, portal.class));
                }


            }


        });
    }
}