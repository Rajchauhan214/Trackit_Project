package com.example.proj;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

public class trackit_seall_parent extends AppCompatActivity {
ViewFlipper v_flipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trackit_seall_parent);


                int images[] = {R.drawable.nav_menu_header_bg, R.drawable.images3, R.drawable.compass1};
        v_flipper = findViewById(R.id.v_flipper);


        for (int image: images){
            flipperImages((image));
        }

    }



    public void flipperImages(int image){

        ImageView imageView = new ImageView (this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);


        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setInAnimation(this, android.R.anim.slide_out_right);
    }
    }

