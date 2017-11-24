package com.example.edu.a0817moacn01c_3.View;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.edu.a0817moacn01c_3.R;

public class ActivityOnBoarding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);

        FragmentManager fragmentManager = getSupportFragmentManager();

        AdapterViewPagerOnBoarding adapterViewPagerOnBoarding= new AdapterViewPagerOnBoarding(fragmentManager);
        viewPager.setAdapter(adapterViewPagerOnBoarding);

    }
    public void irAPantallaPrincipal(View view){
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
        
    }
}
