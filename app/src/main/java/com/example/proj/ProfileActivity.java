package com.example.proj;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class ProfileActivity extends AppCompatActivity {
    private TextView occupationTxtView, nameTxtView, workTxtView;
    private TextView emailTxtView, phoneTxtView, videoTxtView, facebookTxtView, twitterTxtView;
    private ImageView userImageView, emailImageView, phoneImageView, videoImageView;
    private ImageView facebookImageView, twitterImageView;
    private final String TAG = this.getClass().getName().toUpperCase();
    private FirebaseDatabase database;
    private DatabaseReference mDatabase;
    private Map<String, String> userMap;
    //private String email;
    TextView fname;
    TextView emailid;
    TextView num;
    DatabaseReference reff;
    private String userid;
    private static final String USERS = "users";
    member member;

    Button logoutBtn;
    TextView userName,userEmail,userId;
    ImageView profileImage;
    private GoogleApiClient googleApiClient;
    private GoogleSignInOptions gso;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_dis);
        //receive data from login screen
        Intent intent = getIntent();
        //email = intent.getStringExtra("email");
        member = new member();
//        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
//        DatabaseReference userRef = rootRef.child(member);
        reff = FirebaseDatabase.getInstance().getReference().child("member");
        Log.v("USERID", reff.getKey());

        fname = findViewById(R.id.f_name);
        emailid = findViewById(R.id.email);
        num = findViewById(R.id.number);

        //google
//        logoutBtn=(Button)findViewById(R.id.logoutBtn);
//        userName=(TextView)findViewById(R.id.name);
//        userEmail=(TextView)findViewById(R.id.email);
//        userId=(TextView)findViewById(R.id.userId);
//        profileImage=(ImageView)findViewById(R.id.profileImage);
//
//        gso =  new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestEmail()
//                .build();
//
//        googleApiClient=new GoogleApiClient.Builder(this)
//                .enableAutoManage(this, (GoogleApiClient.OnConnectionFailedListener) this)
//                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
//                .build();
//
//
//        logoutBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(
//                        new ResultCallback<Status>() {
//                            @Override
//                            public void onResult(Status status) {
//                                if (status.isSuccess()){
//                                    gotoMainActivity();
//                                }else{
//                                    Toast.makeText(getApplicationContext(),"Session not close",Toast.LENGTH_LONG).show();
//                                }
//                            }
//                        });
//            }
//        });



//        occupationTxtView = findViewById(R.id.occupation_textview);
//        nameTxtView = findViewById(R.id.name_textview);
//        workTxtView = findViewById(R.id.workplace_textview);
//        emailTxtView = findViewById(R.id.email_textview);
//        phoneTxtView = findViewById(R.id.phone_textview);
//        videoTxtView = findViewById(R.id.video_textview);
//        facebookTxtView = findViewById(R.id.facebook_textview);
//        twitterTxtView = findViewById(R.id.twitter_textview);

        //userImageView = findViewById(R.id.user_imageview);
//        emailImageView = findViewById(R.id.email_imageview);
//        phoneImageView = findViewById(R.id.phone_imageview);
//        videoImageView = findViewById(R.id.phone_imageview);
//        facebookImageView = findViewById(R.id.facebook_imageview);
//        twitterImageView = findViewById(R.id.twitter_imageview);

        // Read from the database
        reff.addValueEventListener(new ValueEventListener() {
            String f_name, email, number;
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot keyId: dataSnapshot.getChildren()) {
                    if (keyId.child("email").getValue().equals(email)) {
                        f_name = keyId.child("fullName").getValue(String.class);
                        email = keyId.child("profession").getValue(String.class);
                        number = keyId.child("workplace").getValue(String.class);
                        //phone = keyId.child("phone").getValue(String.class);
                        break;
                    }
                }
                fname.setText(f_name);
                emailid.setText(email);
                num.setText(number);

//                occupationTxtView.setText(profession);
//                workTxtView.setText(workplace);
//                phoneTxtView.setText(phone);
//                videoTxtView.setText(phone);
            }


            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });



    }
    @Override
    protected void onStart() {
        super.onStart();
        OptionalPendingResult<GoogleSignInResult> opr= Auth.GoogleSignInApi.silentSignIn(googleApiClient);
        if(opr.isDone()){
            GoogleSignInResult result=opr.get();
            handleSignInResult(result);
        }else{
            opr.setResultCallback(new ResultCallback<GoogleSignInResult>() {
                @Override
                public void onResult(@NonNull GoogleSignInResult googleSignInResult) {
                    handleSignInResult(googleSignInResult);
                }
            });
        }
    }
    private void handleSignInResult(GoogleSignInResult result){
        if(result.isSuccess()){
            GoogleSignInAccount account=result.getSignInAccount();
            userName.setText(account.getDisplayName());
            userEmail.setText(account.getEmail());
            userId.setText(account.getId());
            try{
                Glide.with(this).load(account.getPhotoUrl()).into(profileImage);
            }catch (NullPointerException e){
                Toast.makeText(getApplicationContext(),"image not found",Toast.LENGTH_LONG).show();
            }

        }else{
            gotoMainActivity();
        }
    }
    private void gotoMainActivity(){
        Intent intent=new Intent(this,child_screen.class);
        startActivity(intent);
    }

    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

}
