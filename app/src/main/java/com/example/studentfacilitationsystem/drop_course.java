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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class drop_course extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drop_course);
        EditText cname;

        Button b = findViewById(R.id.drop);
        cname=findViewById(R.id.coursename);

        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String name;

                name=cname.getText().toString();

                if(TextUtils.isEmpty(name)){
                    cname.setError("Field is required");
                }


                try{


                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                    Query applesQuery = ref.child("course").orderByChild("name").equalTo(name);

                    applesQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for (DataSnapshot appleSnapshot: dataSnapshot.getChildren()) {
                                appleSnapshot.getRef().removeValue();
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Log.e("TAG", "onCancelled", databaseError.toException());
                        }
                    });




                    //String id = task.getResult().getUser().getUid();
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("User").child("UserId");
                    reference.removeValue();
                    Toast.makeText(getApplicationContext(), "Successfully Course deleted!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(drop_course.this, MainActivity.class));
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