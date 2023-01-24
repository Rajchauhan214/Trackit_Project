package com.example.proj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class clogin extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
//    private EditText emailId, password;
//    Button btnSignIn;
    TextView tx1;
    int counter = 3;
    //private DatabaseReference mDatabase;

    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

   private EditText mEmail, mPassword, cpassword;
    private Button mLogin, mRegistration;
    private EditText emailId, password;
    Button btnSignIn;
    TextView tvSignUp;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;

    SignInButton signInButton;
    private GoogleApiClient googleApiClient;
    TextView textView;
    private static final int RC_SIGN_IN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clogin);

        mAuth = FirebaseAuth.getInstance();
        mEmail = (EditText) findViewById(R.id.c_email);
        mPassword = (EditText) findViewById(R.id.c_password);
        cpassword = (EditText) findViewById(R.id.cpassword);
        tvSignUp = (TextView) findViewById(R.id.to_signup);

        mLogin = (Button) findViewById(R.id.c_login);
        mRegistration = (Button) findViewById(R.id.registration);
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = mEmail.getText().toString();
                final String password = mPassword.getText().toString();

                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(clogin.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful()){
                            Toast.makeText(clogin.this, "sign in error", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {

                            String user_id = mAuth.getCurrentUser().getUid();
                            DatabaseReference current_user_db = FirebaseDatabase.getInstance().getReference().child("Users").child("Drivers").child(user_id);
                            current_user_db.setValue(true);

                        }
                    }
                });
                Intent i = new Intent(clogin.this, child_screen.class);
                startActivity(i);

            }
        });

        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if(user!=null){
                    Intent intent = new Intent(clogin.this, child_screen.class);
                    startActivity(intent);
                    finish();
                    return;
                }
            }
        };

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intSignUp = new Intent(clogin.this, ChildActivity.class);
                startActivity(intSignUp);
            }
        });

//        mDatabase = FirebaseDatabase.getInstance().getReference();
////        mAuth = FirebaseAuth.getInstance();
//        mFirebaseAuth = FirebaseAuth.getInstance();
//        emailId = findViewById(R.id.editText);
//        password = findViewById(R.id.editText2);
//        btnSignIn = findViewById(R.id.button2);
//        tvSignUp = findViewById(R.id.textView);
//
//        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
//                if( mFirebaseUser != null ){
//                    Toast.makeText(clogin.this,"You are logged in",Toast.LENGTH_SHORT).show();
//                    Intent i = new Intent(clogin.this,screen.class);
//                    startActivity(i);
//                }
//                else{
//                    Toast.makeText(clogin.this,"Please Login",Toast.LENGTH_SHORT).show();
//                }
//            }
//        };
//
//        btnSignIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String email = emailId.getText().toString();
//                String pwd = password.getText().toString();
//                if(email.isEmpty()){
//                    emailId.setError("Please enter email id");
//                    emailId.requestFocus();
//                }
//                else  if(pwd.isEmpty()){
//                    password.setError("Please enter your password");
//                    password.requestFocus();
//                }
//                else  if(email.isEmpty() && pwd.isEmpty()){
//                    Toast.makeText(clogin.this,"Fields Are Empty!",Toast.LENGTH_SHORT).show();
//                }
//                else  if(!(email.isEmpty() && pwd.isEmpty())){
//                    mFirebaseAuth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(clogin.this, new OnCompleteListener<AuthResult>() {
//                        @Override
//                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            if(!task.isSuccessful()){
//                                Toast.makeText(clogin.this,"Login Error, Please Login Again",Toast.LENGTH_SHORT).show();
//                            }
//                            else{
//                                Intent intToHome = new Intent(clogin.this,logout.class);
//                                startActivity(intToHome);
//                            }
//                        }
//                    });
//                }
//                else{
//                    Toast.makeText(clogin.this,"Error Occurred!",Toast.LENGTH_SHORT).show();
//
//                }
//
//            }
//        });
//
//        tvSignUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intSignUp = new Intent(clogin.this, ChildActivity.class);
//                startActivity(intSignUp);
//            }
//        });
//    }
//
//    private boolean validateForm() {
//        boolean result = true;
//        if (TextUtils.isEmpty(emailId.getText().toString())) {
//            emailId.setError("Required");
//            result = false;
//        } else {
//            emailId.setError(null);
//        }
//
//        if (TextUtils.isEmpty(password.getText().toString())) {
//            password.setError("Required");
//            result = false;
//        } else {
//            password.setError(null);
//        }
//
//        return result;
//    }
//    private void writeNewUser(String userId, String name, String email) {
//        user user = new user(name, email);
//
//        mDatabase.child("user").child(userId).setValue(user);
//    }
//    // [END basic_write]
//
////    @Override
////    public void onClick(View v) {
////        int i = v.getId();
////        if (i == R.id.btnSignIn) {
////            signIn();
////        } else if (i == R.id.buttonSignUp) {
////            signUp();
////        }
////    }
//
////    @Override
////    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
////        if (requestCode == )
////    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
//    }

        GoogleSignInOptions gso =  new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        googleApiClient=new GoogleApiClient.Builder(this)
                .enableAutoManage(this,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();



        signInButton=(SignInButton)findViewById(R.id.sign_in_button);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(intent,RC_SIGN_IN);
            }
        });

    }
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RC_SIGN_IN){
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }
    private void handleSignInResult(GoogleSignInResult result){
        if(result.isSuccess()){
            gotoProfile();
        }else{
            Toast.makeText(getApplicationContext(),"Sign in cancel",Toast.LENGTH_LONG).show();
        }
    }
    private void gotoProfile(){
        Intent intent=new Intent(clogin.this,ProfileActivity.class);
        startActivity(intent);
    }
}
