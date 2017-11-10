package com.example.edu.a0817moacn01c_3.View;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.edu.a0817moacn01c_3.Model.Contenido;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andiy on 09/11/2017.
 */

public class AdaptadorPachorraViewPager extends FragmentStatePagerAdapter{
    private List<Fragment> fragmentList;


    public AdaptadorPachorraViewPager(FragmentManager fm) {
        super(fm);

        fragmentList = new ArrayList<>();


        for (Integer i=1;i<4;i++){

            fragmentList.add(PachorraFragment.dameListasRecycler(i));
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
