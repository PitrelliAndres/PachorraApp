package com.example.edu.a0817moacn01c_3.View;


import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.edu.a0817moacn01c_3.Controller.ControllerContenido;
import com.example.edu.a0817moacn01c_3.Model.Contenido;
import com.example.edu.a0817moacn01c_3.Model.Pelicula;
import com.example.edu.a0817moacn01c_3.Model.Serie;
import com.example.edu.a0817moacn01c_3.R;
import com.example.edu.a0817moacn01c_3.utils.ResultListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PachorraFragment extends Fragment implements PeliculasRecyclerAdapter.ContenidoClickeable {
    private PeliculasRecyclerAdapter unAdapter;
    private NotificadorDatos escuchadorPelicula;
    private ControllerContenido controllerContenido;
    private Bundle bundle;
    public static final String TIPOCONTENIDO= "key";
    private  String nombreContenido;

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
        topBundle.putString(TIPOCONTENIDO,tipo);
        PachorraFragment pachorraFragment = new PachorraFragment();
        pachorraFragment.setArguments(topBundle);

        return pachorraFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pachorra, container, false);
        

        RecyclerView unRecyclerView =(RecyclerView) view.findViewById(R.id.recyclerPachorra);
        GridLayoutManager unLayoutManager = new GridLayoutManager(getContext(), 3, GridLayoutManager.VERTICAL, false);


        unRecyclerView.setLayoutManager(unLayoutManager);
        unRecyclerView.setHasFixedSize(true);
        // 3: Adapter con recycler
        unAdapter = new PeliculasRecyclerAdapter(new ArrayList<Contenido>(), getContext(), this);
        unRecyclerView.setAdapter(unAdapter);
        // 3: Adapter con recycler
           bundle = getArguments();
           nombreContenido = bundle.getString(TIPOCONTENIDO);
            switch (nombreContenido) {
                case "peli-recom":

                    controllerContenido = new ControllerContenido(getContext());
                    updatePeliculasPopulares();
                    break;
                case "peli-top":

                    controllerContenido = new ControllerContenido(getContext());
                    updatePeliculasUpcoming();
                    break;
                case "serie-topRate":

                    controllerContenido = new ControllerContenido(getContext());
                    updateSeriesTopRated();
                    break;
                case "serie-pop":
                    controllerContenido = new ControllerContenido(getContext());
                    updateSeriesPopulares();
                    break;
                case "mixto":
                    controllerContenido = new ControllerContenido(getContext());
                    updateListaMixta();
                    break;
                case "favoritos":
                    controllerContenido = new ControllerContenido(getContext());
                    updateSeriesPopulares();
                case "filtro":
                    controllerContenido = new ControllerContenido(getContext());

                    String genero = bundle.getString("genero");
                    String contenido = bundle.getString("contenido");
                    Integer fecha = bundle.getInt("fecha");
                    unAdapter.setListaContenidos(controllerContenido.getListaFiltrada(genero,contenido,fecha));
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




    private void updatePeliculasPopulares() {

        controllerContenido.getPeliculasPopulares(new ResultListener<List<Pelicula>>() {
            @Override
            public void finish(List<Pelicula> resultado) {

                List<Contenido> blablub = new ArrayList<>();
                blablub.addAll(resultado);

                unAdapter.setListaContenidos(blablub);
                unAdapter.notifyDataSetChanged();

            }
        });
    }
    private void updatePeliculasUpcoming(){
     controllerContenido.getUpcomingPeliculas(new ResultListener<List<Pelicula>>() {
            @Override
            public void finish(List<Pelicula> resultado) {

                List<Contenido> blablub = new ArrayList<>();
                blablub.addAll(resultado);

                unAdapter.setListaContenidos(blablub);
                unAdapter.notifyDataSetChanged();

            }
        });

    }
    private void updateSeriesPopulares(){
        controllerContenido.getSeriesPopulares(new ResultListener<List<Serie>>() {
            @Override
            public void finish(List<Serie> resultado) {
                List<Contenido>blablud= new ArrayList<>();
                blablud.addAll(resultado);
                unAdapter.setListaContenidos(blablud);
                unAdapter.notifyDataSetChanged();

            }
        });
    }
    private void updateSeriesTopRated(){
       controllerContenido.getSeriesTopRated(new ResultListener<List<Serie>>() {
            @Override
            public void finish(List<Serie> resultado) {
                List<Contenido>blablud= new ArrayList<>();
                blablud.addAll(resultado);
                unAdapter.setListaContenidos(blablud);
                unAdapter.notifyDataSetChanged();

            }
        });
        }
    private void updateSeriesTVAiringToday(){
        controllerContenido.getTVAiringToday(new ResultListener<List<Serie>>() {
            @Override
            public void finish(List<Serie> resultado) {
                List<Contenido>blablud= new ArrayList<>();
                blablud.addAll(resultado);
                unAdapter.setListaContenidos(blablud);
                unAdapter.notifyDataSetChanged();

            }
        });
    }

    private void updateListaMixta() {
        unAdapter.setListaContenidos(controllerContenido.getListaMixta());
        unAdapter.notifyDataSetChanged();
    }

}
