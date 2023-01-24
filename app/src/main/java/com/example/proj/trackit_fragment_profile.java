package com.example.proj;



import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.google.firebase.auth.FirebaseAuth;


public class trackit_fragment_profile extends Fragment {
    // AppCompatActivity context;
    FragmentActivity context = getActivity();
    Button btn,mSettings;
    ImageView img1;
    LinearLayout set,log;



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.trackit_fragment_profile, container, false);


        LinearLayout set = (LinearLayout) view.findViewById(R.id.profile);
        //ImageView img1 = (ImageView) view.findViewById(R.id.settings);
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), profile.class);
                startActivity(intent);
                // First go to container class-Activity

            }
        });

        LinearLayout log = (LinearLayout) view.findViewById(R.id.logout);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getActivity(), trackit_childlogin.class);
                startActivity(intent);
                return;
            }
        });
        return view;
    }
}