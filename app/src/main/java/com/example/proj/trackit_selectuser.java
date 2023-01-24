package com.example.proj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class trackit_selectuser extends AppCompatActivity {
//    private Button mDriver, mCustomer;
    private LinearLayout childbt, parentbt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trackit_selectuser);

        childbt = (LinearLayout) findViewById(R.id.childrelate);
        parentbt = (LinearLayout) findViewById(R.id.parentrelate);
//        mDriver = (Button) findViewById(R.id.driver);
//        mCustomer = (Button) findViewById(R.id.customer);

        childbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(trackit_selectuser.this, trackit_childlogin.class);
                startActivity(intent);
                finish();
                return;
            }
        });

        parentbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(trackit_selectuser.this, trackit_parentlogin.class);
                startActivity(intent);
                finish();
                return;
            }
        });

    }
}
