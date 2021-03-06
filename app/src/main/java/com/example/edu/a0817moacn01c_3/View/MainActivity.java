package com.example.edu.a0817moacn01c_3.View;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.edu.a0817moacn01c_3.R;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity{
    public static final String CONFIGURACION = "configuraciones";
    public static final String PRIMERAVEZ = "primera vez";
    public static final String VIOONBOARDING = "vio onBoarding";
    private static final String TAG = "MainActivity";
    private FirebaseAuth mAuth;
    private Boolean vioOnBoarding = false;
    private Bundle unBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent unIntent = getIntent();
        if(unIntent.hasExtra(VIOONBOARDING)) {
            this.unBundle = unIntent.getExtras();
            vioOnBoarding = unBundle.getBoolean(VIOONBOARDING, false);
        }
        SharedPreferences settings = getSharedPreferences(CONFIGURACION, 0);
        Boolean primeraVez = settings.getBoolean(PRIMERAVEZ, true);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(PRIMERAVEZ, false);
        editor.commit();
        if (primeraVez == true && vioOnBoarding==false) {
            irAOnBoarding();
        }

        // verificar si no esta logeado (tanto en FB como en Firebase)
        mAuth = FirebaseAuth.getInstance();
        mAuth.getCurrentUser();
        // si no lo está hacer el registro anonimo de Firebase

    }
    public void irAOnBoarding(){
        vioOnBoarding = true;
        Log.i(TAG, "irAOnBoarding");
        Intent unItent = new Intent(this, ActivityOnBoarding.class);
        startActivity(unItent);
    }
    public void irAPachorra(View view) {
        Log.i(TAG, "irAPachorra");
        Intent unIntent = new Intent(this, PachorraActivity.class);
        startActivity(unIntent);

    }

}
