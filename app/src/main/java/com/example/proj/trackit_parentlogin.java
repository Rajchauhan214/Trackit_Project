package com.example.proj;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class trackit_parentlogin extends BaseActivity implements View.OnClickListener {
	private EditText mEmailField, mPasswordField;
	private FirebaseAuth mAuth;
	LinearLayout childloginc;
	LinearLayout gobackp1;
	Button parentregisterp;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.trackit_parentlogin);

		mEmailField = findViewById(R.id.field_email);
		mPasswordField = findViewById(R.id.field_password);
		gobackp1 = findViewById(R.id.backlog1);
		findViewById(R.id.button_sign_in).setOnClickListener(this);
		findViewById(R.id.parent_registerp).setOnClickListener(this);
		parentregisterp = findViewById((R.id.parent_registerp));
		childloginc = findViewById(R.id.child_login);



		mAuth = FirebaseAuth.getInstance();
		gobackp1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(trackit_parentlogin.this, trackit_childlogin.class);
				startActivity(intent);
				finish();
				return;
			}
		});

		parentregisterp.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(trackit_parentlogin.this,trackit_parentregister.class);
				startActivity(intent);
				finish();
				return;
			}
		});
		childloginc.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(trackit_parentlogin.this, trackit_childlogin.class);
				startActivity(intent);
				finish();
				return;
			}
		});


	}

	@Override
	public void onStart() {
		super.onStart();
		if (mAuth.getCurrentUser() != null) {
			onAuthSuccess(mAuth.getCurrentUser());
		}
	}

	private void onAuthSuccess(FirebaseUser firebaseUser) {
		String email = firebaseUser.getEmail();
		String username = email;
		if (email != null && email.contains("@")) {
			username = email.split("@")[0];
		}

		user user = new user(username, email);
		DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
		mDatabase.child("Users").child(firebaseUser.getUid()).setValue(user);

		startActivity(new Intent(this, parent_screen.class));
		finish();
	}

	private void signIn() {
		String email = mEmailField.getText().toString().trim();
		String password = mPasswordField.getText().toString().trim();

		if (validateForm(email, password)) {
			showProgressDialog();
			mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
				@Override
				public void onComplete(@NonNull Task<AuthResult> task) {
					hideProgressDialog();
					if (task.isSuccessful()) {
						onAuthSuccess(task.getResult().getUser());
					} else {
						Toast.makeText(trackit_parentlogin.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
					}
				}
			});
		}
	}

//	private void signUp() {
//		String email = mEmailField.getText().toString().trim();
//		String password = mPasswordField.getText().toString().trim();
//
//		if (validateForm(email, password)) {
//			showProgressDialog();
//			mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//				@Override
//				public void onComplete(@NonNull Task<AuthResult> task) {
//					hideProgressDialog();
//					if (task.isSuccessful()) {
//						onAuthSuccess(task.getResult().getUser());
//					} else {
//						Toast.makeText(SignInActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//					}
//				}
//			});
//		}
//	}

	private boolean validateForm(String email, String password) {
		if (TextUtils.isEmpty(email)) {
			mEmailField.setError(getString(R.string.required));
			return false;
		} else if (TextUtils.isEmpty(password)) {
			mPasswordField.setError(getString(R.string.required));
			return false;
		} else {
			mEmailField.setError(null);
			mPasswordField.setError(null);
			return true;
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.button_sign_in:
				signIn();
				break;
			case R.id.button_sign_up:
//				signUp();
				break;
		}
	}
}