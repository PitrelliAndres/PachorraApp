package com.example.edu.a0817moacn01c_3.View;


import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.edu.a0817moacn01c_3.Controller.ControllerContenido;
import com.example.edu.a0817moacn01c_3.Model.Contenido;
import com.example.edu.a0817moacn01c_3.Model.Pelicula;
import com.example.edu.a0817moacn01c_3.Model.Serie;
import com.example.edu.a0817moacn01c_3.R;
import com.example.edu.a0817moacn01c_3.utils.ResultListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PachorraFragment extends Fragment implements PeliculasRecyclerAdapter.ContenidoClickeable {
    private PeliculasRecyclerAdapter unAdapter;
    private NotificadorDatos escuchadorPelicula;
    private PeliculasRecyclerAdapter unAdapter2;
    private PeliculasRecyclerAdapter unAdapter3;
    private ControllerContenido controllerContenido;
    private ViewPager vPager;
    private AdaptadorFragmentsViewPager tAdapter;
    private ActionBar aBar;
    private Bundle bundle;
    public static final String NROTIPOCONTENIDO= "nrotipoContenido";
    private boolean yaCargounaVez= false;
    private  Integer nroContenido;

    public PachorraFragment()
    // Required empty public constructor
    {
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        escuchadorPelicula = (NotificadorDatos) context;
    }


/*    public static PachorraFragment dameListasRecycler(Integer nroContenido) {
        PachorraFragment pachorraFragment = new PachorraFragment();
        Bundle unBundle = new Bundle();


        unBundle.putInt("nrocontenido", nroContenido);
        pachorraFragment.setArguments(unBundle);
        return pachorraFragment;
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pachorra, container, false);
        
        ViewPager viewPager= (ViewPager)view.findViewById(R.id.viewpager);
        TabLayout tabs= (TabLayout) view.findViewById(R.id.result_tabs);
        RecyclerView unRecyclerView = view.findViewById(R.id.recyclerPachorra);
        GridLayoutManager unLayoutManager = new GridLayoutManager(getContext(), 3, GridLayoutManager.VERTICAL, false);

        tAdapter = new AdaptadorFragmentsViewPager(getFragmentManager());
        unRecyclerView.setLayoutManager(unLayoutManager);

        //unRecyclerView3.setLayoutManager(unLayoutManager3);

        unRecyclerView.setHasFixedSize(true);
            bundle = getArguments();
           nroContenido = bundle.getInt(NROTIPOCONTENIDO);
            switch (nroContenido) {
                case 0:
                    unAdapter = new PeliculasRecyclerAdapter(new ArrayList<Contenido>(), getContext(), this);
                    // 3: Adapter con recycler
                    unRecyclerView.setAdapter(unAdapter);
                    controllerContenido = new ControllerContenido(getContext());
                    viewpagerContenido(viewPager);
                    tabs.setupWithViewPager(viewPager);
                    updatePeliculas();
                    break;
                case 1:
                    unAdapter = new PeliculasRecyclerAdapter(new ArrayList<Contenido>(), getContext(), this);
                    // 3: Adapter con recycler
                    unRecyclerView.setAdapter(unAdapter);
                    controllerContenido = new ControllerContenido(getContext());
                    viewpagerContenido(viewPager);
                    tabs.setupWithViewPager(viewPager);
                    updateSeries();

                case 2:
                    unAdapter = new PeliculasRecyclerAdapter(new ArrayList<Contenido>(), getContext(), this);
                    // 3: Adapter con recycler
                    unRecyclerView.setAdapter(unAdapter);
                    controllerContenido = new ControllerContenido(getContext());
                    viewpagerContenido(viewPager);
                    tabs.setupWithViewPager(viewPager);
                    updateSeries();

            }

        return view;

    }


    @Override
    //metodo para comunicar el recycler con el activity mediante el fragment
    public void mandarSeleccion(Integer position, List<Contenido> listaContenidoClickeada) {
        escuchadorPelicula.mandarDatos(position, listaContenidoClickeada);
    }

    public interface NotificadorDatos {
        public void mandarDatos(Integer position, List<Contenido> listaContenidoClickeada);
   }

    private void updatePeliculas() {

        controllerContenido.getPeliculasPopulares(new ResultListener<List<Pelicula>>() {
            @Override
            public void finish(List<Pelicula> resultado) {

                List<Contenido> blablub = new ArrayList<>();
                blablub.addAll(resultado);

                unAdapter.setListaContenidos(blablub);
                unAdapter.notifyDataSetChanged();

            }
        });
/*        controllerContenido.getUpcomingPeliculas(new ResultListener<List<Pelicula>>() {
            @Override
            public void finish(List<Pelicula> resultado) {

                List<Contenido> blablub = new ArrayList<>();
                blablub.addAll(resultado);

                unAdapter2.setListaContenidos(blablub);
                unAdapter2.notifyDataSetChanged();

            }
        });*/

    }
    private void updateSeries(){
        controllerContenido.getSeriesPopulares(new ResultListener<List<Serie>>() {
            @Override
            public void finish(List<Serie> resultado) {
                List<Contenido>blablud= new ArrayList<>();
                blablud.addAll(resultado);
                unAdapter.setListaContenidos(blablud);
                unAdapter.notifyDataSetChanged();

            }
        });
/*        controllerContenido.getSeriesTopRate(new ResultListener<List<Serie>>() {
            @Override
            public void finish(List<Serie> resultado) {
                List<Contenido>blablud= new ArrayList<>();
                blablud.addAll(resultado);
                unAdapter2.setListaContenidos(blablud);
                unAdapter2.notifyDataSetChanged();

            }
        });
        controllerContenido.getTVAiringToday(new ResultListener<List<Serie>>() {
            @Override
            public void finish(List<Serie> resultado) {
                List<Contenido>blablud= new ArrayList<>();
                blablud.addAll(resultado);
                unAdapter3.setListaContenidos(blablud);
                unAdapter3.notifyDataSetChanged();

            }
        });*/
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
    private void viewpagerContenido(ViewPager viewPager) {


        AdaptadorFragmentsViewPager adapter = new AdaptadorFragmentsViewPager(getChildFragmentManager());
        adapter.addFragment(new PachorraFragment(), "Recomendados");
        adapter.addFragment(new PachorraFragment(), "Top Rate");

        viewPager.setAdapter(adapter);



    }
    private void viewpagerMixto(ViewPager viewPager) {


        AdaptadorFragmentsViewPager adapter = new AdaptadorFragmentsViewPager(getChildFragmentManager());
        adapter.addFragment(new PachorraFragment(), "Recomendado del Dia");


        viewPager.setAdapter(adapter);



    }
}
