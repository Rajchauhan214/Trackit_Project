package com.example.proj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class pass extends AppCompatActivity {
    TextView fname,email,number;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass);
        back = (Button)findViewById(R.id.back);
        fname = (TextView)findViewById(R.id.fname);
        email = (TextView)findViewById(R.id.email);
        number = (TextView)findViewById(R.id.number);

        fname.setText(demo.message);
        email.setText(demo.message2);
        number.setText(demo.message3);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pass.this, profile.class);
                startActivity(intent);
                finish();
                return;
            }
        });
    }
}
