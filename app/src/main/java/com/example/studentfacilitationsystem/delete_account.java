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

public class delete_account extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_account);

        EditText uname;

        Button b = findViewById(R.id.delete);
        uname=findViewById(R.id.username);

        b.setOnClickListener(new View.OnClickListener() {

           @Override
            public void onClick(View v) {
                String name;

                name=uname.getText().toString();

                if(TextUtils.isEmpty(name)){
                    uname.setError("Field is required");
                }


                try{


                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                    Query applesQuery = ref.child("User").orderByChild("uname").equalTo(name);

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