package com.example.edu.a0817moacn01c_3.View;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.edu.a0817moacn01c_3.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AppBarFragment extends Fragment {

    private AdaptadorFragmentsViewPager tAdapter;
    public AppBarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_app_bar, container, false);
        tAdapter = new AdaptadorFragmentsViewPager(getFragmentManager());
        ViewPager viewPager= (ViewPager)view.findViewById(R.id.viewpager);
        TabLayout tabs= (TabLayout) view.findViewById(R.id.result_tabs);
        viewpagerPelicula(viewPager);
        tabs.setupWithViewPager(viewPager);

         return view;
    }


    static class AdaptadorFragmentsViewPager extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public AdaptadorFragmentsViewPager(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
    private void viewpagerPelicula(ViewPager viewPager) {

        AdaptadorFragmentsViewPager adapter = new AdaptadorFragmentsViewPager(getChildFragmentManager());


        adapter.addFragment(PachorraFragment.damePachorraFragment("peli-top"), "Top Rate Peliculas");
        adapter.addFragment(PachorraFragment.damePachorraFragment("peli-recom"), "Peliculas Recomendadas");
        viewPager.setAdapter(adapter);

    }
    private void viewpagerSerie(ViewPager viewPager) {

        AdaptadorFragmentsViewPager adapter = new AdaptadorFragmentsViewPager(getChildFragmentManager());


        adapter.addFragment(PachorraFragment.damePachorraFragment("serie-top"), "Top Rate Series");
        adapter.addFragment(PachorraFragment.damePachorraFragment("serie-recom"), "Series Recomendadas");
        viewPager.setAdapter(adapter);

    }
    private void viewpagerMixto(ViewPager viewPager) {

        AdaptadorFragmentsViewPager adapter = new AdaptadorFragmentsViewPager(getChildFragmentManager());
        adapter.addFragment(new AppBarFragment(), "Recomendado del Dia");

        viewPager.setAdapter(adapter);

    }

}
