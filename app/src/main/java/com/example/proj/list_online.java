//package com.example.proj;
//
//import android.annotation.SuppressLint;
//import android.os.Build;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.Menu;
//import android.view.MenuInflater;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.RequiresApi;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.Toolbar;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.firebase.ui.auth.data.model.User;
//import com.firebase.ui.database.FirebaseRecyclerAdapter;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//
//public class list_online extends AppCompatActivity {
//
//    DatabaseReference onlineref,currentuserref,counterref;
//    FirebaseRecyclerAdapter<User,listonlineviewholder> adapter;
//
//    RecyclerView listonline;
//    RecyclerView.LayoutManager layoutManager;
//
//    @Override
//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_list_online);
//        listonline = (RecyclerView) findViewById(R.id.listonline);
//        listonline.setHasFixedSize(true);
//        layoutManager = new LinearLayoutManager(this);
//        listonline.setLayoutManager(layoutManager);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setTitle("PROJECT");
//        setSupportActionBar(toolbar);
//
//        onlineref = FirebaseDatabase.getInstance().getReference().child("info/connected");
//        counterref = FirebaseDatabase.getInstance().getReference("last online");
//        currentuserref = FirebaseDatabase.getInstance().getReference("last online")
//        .child(FirebaseAuth.getInstance().getCurrentUser().getUid());
//        setupSystem();
//       // updatelist();
//    }
//
////    private void updatelist() {
////        adapter = new FirebaseRecyclerAdapter<user, listonlineviewholder>(
////                user.class,
////                R.layout.user_layout,
////                listonlineviewholder.class,
////                counterref
////        ) {
////            @SuppressLint("RestrictedApi")
////
////            protected void onBindViewHolder(@NonNull listonlineviewholder holder, int position, @NonNull User model) {
////                holder.txtemail.setText(model.getEmail());
////            }
////
////            @NonNull
////            @Override
////            public listonlineviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
////                return null;
////            }
////        };
////    }
//
//    @SuppressLint("RestrictedApi")
////    private void updatelist() {
////        adapter = new FirebaseRecyclerAdapter<user, listonlineviewholder>(user.class, R.layout.user_layout, listonlineviewholder.class, counterref)
////
//////                user.class,
//////                R.layout.user_layout,
//////                listonlineviewholder.class,
//////                counterref
////         {
////            @NonNull
////            @Override
////            public listonlineviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
////                return null;
////            }
////
////            @Override
////            protected void onBindViewHolder(@NonNull listonlineviewholder holder, int position, @NonNull user model) {
////                holder.txtemail.setText(model.getEmail());
////            }
////
//////            @SuppressLint("RestrictedApi")
//////            protected void onBindViewHolder(@NonNull listonlineviewholder userholder, int position, @NonNull User model) {
//////                userholder.txtemail.setText(model.getEmail());
//////
//////            }
////        };
////        adapter.notifyDataSetChanged();
////        listonline.setAdapter(adapter);
////    };
////            @Override
////            public listonlineviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
////                return null;
////            }
//
//
//
//
//        private void setupSystem () {
//            onlineref.addValueEventListener(new ValueEventListener() {
//                @SuppressLint("RestrictedApi")
//                @Override
//                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                    if (dataSnapshot.getValue(Boolean.class)) {
//                        currentuserref.onDisconnect().removeValue();
//                        counterref.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
//                                .setValue(new user(FirebaseAuth.getInstance().getCurrentUser().getEmail(), "online"));
//                        adapter.notifyDataSetChanged();
//                    }
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                }
//            });
//            counterref.addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
//                        user user = postSnapshot.getValue(user.class);
//                        Log.d("LOG", "" + user.getEmail() + " is " + user.getStatus());
//
//                    }
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                }
//            });
//        }
//
//        @Override
//        public boolean onCreateOptionsMenu (Menu menu){
//            MenuInflater inflater = getMenuInflater();
//            inflater.inflate(R.menu.main_menu, menu);
//            return true;
//        }
//
////    @Override
////    public boolean onOptionsItemSelected(MenuItem item) {
////        switch (item.getItemId()){
////            case R.id.item1:
////                counterref.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
////                        .setValue(new user(FirebaseAuth.getInstance().getCurrentUser().getEmail(), "online"));
////                break;
////            case R.id.item2:
////                currentuserref.removeValue();
////                break;
////        }
////            return super.onOptionsItemSelected(item);
////    }
//}
//
