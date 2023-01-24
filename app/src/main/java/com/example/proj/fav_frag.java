package com.example.proj;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.firebase.database.annotations.Nullable;

public class fav_frag extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.activity_fav_frag, container, false);

        View view = inflater.inflate(R.layout.activity_fav_frag, container, false);

        TextView txt = (TextView) view.findViewById(R.id.chat);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ChatActivity.class);
                startActivity(intent);
            }
        });


//    public void goTo(View v)
//    {
//        Intent intent = new Intent(getActivity(), ChatActivity.class);
//        startActivity(intent);
//    }

        return view;
    }
}
