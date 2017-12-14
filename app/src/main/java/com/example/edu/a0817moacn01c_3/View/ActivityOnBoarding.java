package com.example.edu.a0817moacn01c_3.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.edu.a0817moacn01c_3.R;
import com.rd.PageIndicatorView;
import com.rd.draw.data.Orientation;

public class ActivityOnBoarding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        ViewPager viewPager = (ViewPager)findViewById(R.id.viewPagerOnboarding);

        FragmentManager fragmentManager = getSupportFragmentManager();

        AdapterViewPagerOnBoarding adapterViewPagerOnBoarding= new AdapterViewPagerOnBoarding(fragmentManager);
        viewPager.setAdapter(adapterViewPagerOnBoarding);
        PageIndicatorView pageIndicatorView = (PageIndicatorView) findViewById(R.id.pageIndicatorView);
        pageIndicatorView.setViewPager(viewPager);
        pageIndicatorView.setCount(3);
        pageIndicatorView.setOrientation(Orientation.HORIZONTAL);
        pageIndicatorView.setUnselectedColor(R.color.colorTransparenteWhite);
        pageIndicatorView.setAutoVisibility(true);
    }
    public void irAPantallaPrincipal(View view){
        Intent intent= new Intent(this,MainActivity.class);
        Bundle unBundle = new Bundle();
        unBundle.putBoolean(MainActivity.VIOONBOARDING, true);
        intent.putExtras(unBundle);
        startActivity(intent);
        
    }


}

