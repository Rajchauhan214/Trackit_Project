package com.example.proj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class mainhome extends AppCompatActivity {

    Button mSignInButton,btn_skip;
    Button mSignUpButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainhome);
        mSignInButton = findViewById(R.id.sign_in);
        mSignUpButton = findViewById(R.id.sign_up);
        btn_skip = findViewById(R.id.skip);

    }
//    mSignInButton.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            Intent i = new Intent(mainhome.this,LoginActivity.class);
//            startActivity(i);
//        }
//    });
    public void signin(View v)
    {
        Intent intent=new Intent(mainhome.this,ParentActivity.class);
        startActivity(intent);

    }

    public void signup(View v)
    {
        Intent intent=new Intent(mainhome.this,ChildActivity.class);
        startActivity(intent);

    }

    public void skip(View v)
    {
        Intent intent=new Intent(mainhome.this,profile.class);
        startActivity(intent);

    }


    }

