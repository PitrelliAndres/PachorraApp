package com.example.edu.a0817moacn01c_3.DAO;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by ma on 14/12/17.
 */

public class FirebaseHelper {
    protected FirebaseAuth mauth;

    public FirebaseHelper() {
        mauth = FirebaseAuth.getInstance();
    }

    public void login(){

    }

    public void logout(){
        mauth.signOut();
    }
}
