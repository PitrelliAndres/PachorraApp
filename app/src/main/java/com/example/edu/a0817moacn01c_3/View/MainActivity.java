package com.example.edu.a0817moacn01c_3.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.edu.a0817moacn01c_3.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void irAPachorra(View view){
        Intent unIntent= new Intent(this,PachorraActivity.class);
        startActivity(unIntent);

    }
}
