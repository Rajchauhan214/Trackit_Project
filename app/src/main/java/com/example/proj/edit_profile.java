package com.example.proj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class edit_profile extends AppCompatActivity {

    String userID;
    TextView f_name,email,number;
    Button btn_back;
    DatabaseReference reff;
    FirebaseAuth mAuth;
    member member;

     FirebaseAuth firebaseAuth;
     FirebaseDatabase firebaseDatabase;
     FirebaseStorage firebaseStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        f_name = (TextView)findViewById(R.id.tv_f_name);
        email = (TextView)findViewById(R.id.tv_email);
        number = (TextView)findViewById(R.id.tv_number);
        btn_back = (Button) findViewById(R.id.btn_back);
        member = new member();
        mAuth = FirebaseAuth.getInstance();
        userID = Objects.requireNonNull(mAuth.getCurrentUser()).getUid();
        userID = mAuth.getCurrentUser().getUid();
        reff = FirebaseDatabase.getInstance().getReference().child("member").child("Users").child("Customers").child(userID);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();

        reff.addValueEventListener(new ValueEventListener() {

//            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(@NotNull DataSnapshot dataSnapshot) {
                member userProfile = dataSnapshot.getValue(member.class);
                f_name.setText(" " + userProfile.getF_name());
                email.setText(" " + userProfile.getEmail());
                number.setText(" " + userProfile.getNumber());
            }

            @Override
            public void onCancelled(@NotNull DatabaseError databaseError) {
                Toast.makeText(edit_profile.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(edit_profile.this, profile.class);
                startActivity(i);
            }
        });

    }


}
