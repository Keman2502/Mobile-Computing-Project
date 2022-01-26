package com.example.studentfacilitationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class portalnew extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portalnew);
        Button add_course =  findViewById(R.id.acourse);
        add_course.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(portalnew.this, add_course.class));
            }


        });

        Button drop_course =  findViewById(R.id.dcourse);
        drop_course.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(portalnew.this, drop_course.class));
            }


        });
//
        Button upd_acc =  findViewById(R.id.signup);
        upd_acc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(portalnew.this, update_account.class));
            }


        });
//
        Button drop_acc =  findViewById(R.id.delete);
        drop_acc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(portalnew.this, delete_account.class));
            }


        });
//
        Button ann =  findViewById(R.id.signup);
        ann.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(portalnew.this, announcements.class));
            }


        });
//
        Button q =  findViewById(R.id.login);
        q.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(portalnew.this, quiz.class));
            }


        });
    }
}