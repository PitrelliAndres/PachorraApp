package com.example.edu.a0817moacn01c_3.View;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucas on 24/11/2017.
 */

public class AdapterViewPagerOnBoarding extends FragmentStatePagerAdapter {
    private List<Fragment> fragmentList;

    public AdapterViewPagerOnBoarding(FragmentManager fm){
        super(fm);
        fragmentList = new ArrayList<>();

        for (Integer i=0; i<3;i++){
            fragmentList.add(OnboardingFragment.teTiroLasInstrucciones(i));
        }
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
