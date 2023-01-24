package com.example.proj;

public class user {
    //private String email,status;

    public String username;
    public String email;
//    private String email;
//    public String pass;

    public user() {

    }

    public user(String username, String email) {
        this.username = username;
        this.email = email;
     //   this.pass = status;
    }

    public String getEmail() {
        return email;
    }

//    public String getStatus() {
//        return pass;
//    }

}
