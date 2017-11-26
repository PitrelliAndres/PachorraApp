package com.example.edu.a0817moacn01c_3.View;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.edu.a0817moacn01c_3.R;

public class MainActivity extends AppCompatActivity {
    public static final String CONFIGURACION = "configuraciones";
    public static final String PRIMERAVEZ = "primera vez";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences settings = getSharedPreferences(CONFIGURACION, 0);
        Boolean primeraVez = settings.getBoolean(PRIMERAVEZ, true);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(PRIMERAVEZ, false);
        editor.commit();
        if (primeraVez == true) {
            irAOnBoarding();
        }

    }
    public void irAOnBoarding(){
        Intent unItent = new Intent(this, ActivityOnBoarding.class);
        startActivity(unItent);
    }
    public void irAPachorra(View view) {
        Intent unIntent = new Intent(this, PachorraActivity.class);
        startActivity(unIntent);

    }
}
