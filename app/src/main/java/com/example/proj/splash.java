package com.example.proj;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class splash extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 5000;
    private TextView tv1,tv2;
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //tv1 = (TextView) findViewById(R.id.tv1);
        //tv2 = (TextView) findViewById(R.id.tv2);
//        iv = (ImageView) findViewById(R.id.iv);
//        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mytransition);
////        tv1.startAnimation(myanim);
//       // tv2.startAnimation(myanim);
//        iv.startAnimation(myanim);
//        final Intent i = new Intent(this, mainhome.class);
//        Thread timer = new Thread(){
//            public void run(){
//                try{
//                    sleep(8000);
//                } catch(InterruptedException e) {
//                    e.printStackTrace();
//                }
//                finally {
//                    startActivity(i);
//                    finish();
//                }
//            }
//        };
//        timer.start();
        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(splash.this,mainhome.class);
                splash.this.startActivity(mainIntent);
                splash.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

}
