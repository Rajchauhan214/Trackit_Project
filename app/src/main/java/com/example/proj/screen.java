package com.example.proj;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

//import androidx.appcompat.app.ActionBar;

public class screen extends AppCompatActivity {

    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
//    ActionBar actionBar = null;
DatabaseReference onlineref,currentuserref,counterref;
    //FirebaseRecyclerAdapter<User,listonlineviewholder> adapter;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);
        Button btnLogout;
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
//        Button loc = findViewById(R.id.loc);
        FloatingActionButton loc1 = findViewById(R.id.loc1);
        onlineref = FirebaseDatabase.getInstance().getReference().child("info/connected");
        counterref = FirebaseDatabase.getInstance().getReference("last online");
        currentuserref = FirebaseDatabase.getInstance().getReference("last online")
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid());

        // Get ActionBar
//        actionBar = getSupportActionBar();
//        // Set below attributes to add logo in ActionBar.
//        actionBar.setDisplayShowHomeEnabled(true);
//        actionBar.setDisplayUseLogoEnabled(true);
//       // actionBar.setLogo(R.drawable.icon_tech_32);
//
//        actionBar.setTitle("Dev2Qa.com");
//
//        // When click this button, action bar will be displayed.
//        Button showActionBarButton = (Button)findViewById(R.id.loc);
//        showActionBarButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                actionBar.show();
//            }
//        });

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new homefrag()).commit();
        }


        loc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(screen.this, map.class);
                startActivity(i);
            }
        });

//        loc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(screen.this, map.class);
//                startActivity(i);
//            }
//        });
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_home);
            btnLogout = findViewById(R.id.logout);

//            btnLogout.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    FirebaseAuth.getInstance().signOut();
//                    Intent intToMain = new Intent(screen.this, register.class);
//                    startActivity(intToMain);
//                }
//            });
        }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item2:
                counterref.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                        .setValue(new user(FirebaseAuth.getInstance().getCurrentUser().getEmail(), "online"));
                break;
//            case R.id.logout:
//                currentuserref.removeValue();
//                break;
            case R.id.logout:
                mFirebaseAuth.getInstance().signOut();
                Intent i = new Intent(screen.this,trackit_selectuser.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                        Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                return true;

            case R.id.item3:
                currentuserref.removeValue();
                break;
        }
            return super.onOptionsItemSelected(item);
    }

    //}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.home:
                            selectedFragment = new homefrag();
                            break;
                        case R.id.profile:
                            selectedFragment = new trackit_fragment_profile();
                            break;
                        case R.id.fav:
                            selectedFragment = new fav_frag();
                            break;

                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };


//        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.home:
//                        Toast.makeText(screen.this, "Home", Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.action_favorites:
//                        Toast.makeText(screen.this, "Favorites", Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.action_nearby:
//                        Toast.makeText(screen.this, "Nearby", Toast.LENGTH_SHORT).show();
//                        break;
//                }
//                return true;
//            }
//        });
//
//    }


}
