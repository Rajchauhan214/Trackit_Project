//package com.example.proj;
//
//
//
//
//
//
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//
//public class register extends AppCompatActivity {
//    EditText emailId, password, cpass;
//    Button btnSignUp;
//    TextView tvSignIn;
//    FirebaseAuth mFirebaseAuth;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        mFirebaseAuth = FirebaseAuth.getInstance();
//        emailId = findViewById(R.id.editText);
//        password = findViewById(R.id.editText2);
//        cpass = findViewById(R.id.editText3);
//        btnSignUp = findViewById(R.id.button2);
//        tvSignIn = findViewById(R.id.textView);
//        btnSignUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String email = emailId.getText().toString();
//                String pwd = password.getText().toString();
//                String cp = cpass.getText().toString();
//                if(email.isEmpty()){
//                    emailId.setError("Please enter email id");
//                    emailId.requestFocus();
//                }
//                else  if(pwd.isEmpty()){
//                    password.setError("Please enter your password");
//                    password.requestFocus();
//                }
//                else  if(email.isEmpty() && pwd.isEmpty()){
//                    Toast.makeText(register.this,"Fields Are Empty!",Toast.LENGTH_SHORT).show();
//                }
//                else if(!cp.equals(pwd)) {
//                    Toast.makeText(register.this,"Re-enter password",Toast.LENGTH_LONG).show();
//                }
//
//                else  if(!(email.isEmpty() && pwd.isEmpty())){
//                    mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(register.this, new OnCompleteListener<AuthResult>() {
//                        @Override
//                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            if(!task.isSuccessful()){
//                                Toast.makeText(register.this,"SignUp Unsuccessful, Please Try Again",Toast.LENGTH_SHORT).show();
//                            }
//                            else {
//
//                                startActivity(new Intent(register.this,screen.class));
//                            }
//                        }
//                    });
//                }
//                else{
//                    Toast.makeText(register.this,"Error Occurred!",Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });
//
//        tvSignIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(register.this,LoginActivity.class);
//                startActivity(i);
//            }
//        });
//    }
//
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
