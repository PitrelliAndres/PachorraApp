package com.example.edu.a0817moacn01c_3.View;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.edu.a0817moacn01c_3.Model.Contenido;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andiy on 22/10/2017.
 */

    public class AdaptadorDetallesViewPager extends FragmentStatePagerAdapter {
        private List<Fragment> fragmentList;


    public AdaptadorDetallesViewPager(FragmentManager fm,List<Contenido> listaContenido) {
        super(fm);

        fragmentList = new ArrayList<>();


        for (Contenido unContenido:listaContenido) {

            fragmentList.add(DetalleFragment.dameDetalleFragment(unContenido));
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
