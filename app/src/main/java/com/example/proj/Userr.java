package com.example.proj;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Userr {
	public String username;
	public String email;

	public Userr() {
		// Default constructor required for calls to DataSnapshot.getValue(User.class)
	}

	public Userr(String username, String email) {
		this.username = username;
		this.email = email;
	}
}