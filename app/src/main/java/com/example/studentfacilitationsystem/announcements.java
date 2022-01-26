package com.example.studentfacilitationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class announcements extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_account);
        TextView text1,text2;
        String ann1,ann2;
        Button b = findViewById(R.id.ok);
        text1 = findViewById(R.id.t1);
        text2 = findViewById(R.id.t2);
        String t_1="Quiz is going to held on Tuesday. Do come properly prepared. No retake will be taken.";
        String t_2="Recruitment drive for Arbisoft is on Friday and the one day recruitment drive for Devsinc is on Saturday.";
        text1.setText(t_1);
        text2.setText(t_2);
        

        b.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), portal.class));

            }




        });


    }



}