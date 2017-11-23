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
    private ActionBar aBar;
    private Bundle bundle;
    public static final String TIPOCONTENIDO= "key";
    private  String nroContenido;

    public PachorraFragment()
    // Required empty public constructor
    {
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        escuchadorPelicula = (NotificadorDatos) context;
    }


    public static PachorraFragment damePachorraFragment(String tipo) {
        Bundle topBundle = new Bundle();
        topBundle.putString("key",tipo);
        PachorraFragment pachorraFragment = new PachorraFragment();
        pachorraFragment.setArguments(topBundle);

        return pachorraFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pachorra, container, false);
        

        RecyclerView unRecyclerView = view.findViewById(R.id.recyclerPachorra);
        GridLayoutManager unLayoutManager = new GridLayoutManager(getContext(), 3, GridLayoutManager.VERTICAL, false);


        unRecyclerView.setLayoutManager(unLayoutManager);
        unAdapter = new PeliculasRecyclerAdapter(new ArrayList<Contenido>(), getContext(), this);
        // 3: Adapter con recycler
        unRecyclerView.setAdapter(unAdapter);
        controllerContenido = new ControllerContenido(getContext());
        updatePeliculas();


      unRecyclerView.setHasFixedSize(true);
           bundle = getArguments();
           nroContenido = bundle.getString(TIPOCONTENIDO);
            switch (nroContenido) {
                case "peli-recom":
                    unAdapter = new PeliculasRecyclerAdapter(new ArrayList<Contenido>(), getContext(), this);
                    // 3: Adapter con recycler
                    unRecyclerView.setAdapter(unAdapter);
                    controllerContenido = new ControllerContenido(getContext());
                    updatePeliculas();
                    break;
                case "peli-top":
                    unAdapter = new PeliculasRecyclerAdapter(new ArrayList<Contenido>(), getContext(), this);
                    // 3: Adapter con recycler
                    unRecyclerView.setAdapter(unAdapter);
                    controllerContenido = new ControllerContenido(getContext());
                   // viewpagerContenido(viewPager);
                   // tabs.setupWithViewPager(viewPager);
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

}
