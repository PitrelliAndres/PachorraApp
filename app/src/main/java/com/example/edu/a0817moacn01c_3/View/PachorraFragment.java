package com.example.edu.a0817moacn01c_3.View;


import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.ScrollView;

import com.example.edu.a0817moacn01c_3.Controller.ControllerContenido;
import com.example.edu.a0817moacn01c_3.DAO.DAOFirebaseLista;
import com.example.edu.a0817moacn01c_3.Model.Contenido;
import com.example.edu.a0817moacn01c_3.Model.Pelicula;
import com.example.edu.a0817moacn01c_3.Model.Serie;
import com.example.edu.a0817moacn01c_3.R;
import com.example.edu.a0817moacn01c_3.utils.ResultListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
    private Boolean isLoading = false;
    private ProgressBar progressBar;
    private ScrollView scrollView;


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

        progressBar = (ProgressBar)view.findViewById(R.id.progressBar);
        final RecyclerView unRecyclerView =(RecyclerView) view.findViewById(R.id.recyclerPachorra);
        final GridLayoutManager unLayoutManager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);



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
                    getNewPagePeliculasPop();
                    unRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                        @Override
                        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                            super.onScrolled(recyclerView, dx, dy);

                            if (isLoading) {
                                return;
                            }

                            Integer visibleItemCount  = unLayoutManager.findLastVisibleItemPosition();
                            Integer totalItemCount  = unLayoutManager.getItemCount();
                            if ((visibleItemCount + 4)>= totalItemCount) {
                                getNewPagePeliculasPop();
                            }

                        }
                    });

                    break;
                case "peli-top":
                    controllerContenido = new ControllerContenido(getContext());
                    getNewPagePeliculasRecom();
                    unRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                        @Override
                        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                            super.onScrolled(recyclerView, dx, dy);

                            if (isLoading) {
                                return;
                            }

                            Integer visibleItemCount  = unLayoutManager.findLastVisibleItemPosition();
                            Integer totalItemCount  = unLayoutManager.getItemCount();
                            if ((visibleItemCount + 4)>= totalItemCount) {
                                getNewPagePeliculasRecom();
                            }

                        }
                    });
                   // updatePeliculasUpcoming();
                    break;
                case "serie-topRate":

                    controllerContenido = new ControllerContenido(getContext());
                    updateSeriesTopRated();
                    unRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                        @Override
                        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                            super.onScrolled(recyclerView, dx, dy);

                            if (isLoading) {
                                return;
                            }

                            Integer visibleItemCount  = unLayoutManager.findLastVisibleItemPosition();
                            Integer totalItemCount  = unLayoutManager.getItemCount();
                            if ((visibleItemCount + 4)>= totalItemCount) {
                                updateSeriesTopRated();
                            }

                        }
                    });
                    break;
                case "serie-pop":
                    controllerContenido = new ControllerContenido(getContext());
                    updateSeriesPopulares();
                    unRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                        @Override
                        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                            super.onScrolled(recyclerView, dx, dy);

                            if (isLoading) {
                                return;
                            }

                            Integer visibleItemCount  = unLayoutManager.findLastVisibleItemPosition();
                            Integer totalItemCount  = unLayoutManager.getItemCount();
                            if ((visibleItemCount + 4)>= totalItemCount) {
                                updateSeriesPopulares();
                            }

                        }
                    });
                    break;
                case "mixto":
                    controllerContenido = new ControllerContenido(getContext());
                    updateListaMixta();
                    break;
                case "favoritos":
                    OnboardingFragment onboardingFragment = new OnboardingFragment();
                    if(onboardingFragment.isLogin()){
                    controllerContenido = new ControllerContenido(getContext());
                    updateFirebaseFavoritos();
                    } else {
                        controllerContenido = new ControllerContenido(getContext());
                        unAdapter.setListaContenidos(controllerContenido.getFavoritos());
                    }
                    break;
                case "filtro":
                    controllerContenido = new ControllerContenido(getContext());
                    String genero = bundle.getString("genero");
                    String contenido = bundle.getString("contenido");
                    Integer fecha = bundle.getInt("fecha");
                    unAdapter.setListaContenidos(controllerContenido.getListaFiltrada(genero,contenido,fecha));
                    break;
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


    private void updateFirebaseFavoritos(){
        controllerContenido.getFavoritosFireBase(new ResultListener<List<Contenido>>() {
            @Override
            public void finish(List<Contenido> resultado) {
                unAdapter.setListaContenidos(resultado);
                unAdapter.notifyDataSetChanged();
            }
        });
    }


    private void getNewPagePeliculasPop() {

        if (controllerContenido.isAnyPageAvailable()){
            isLoading = true;
            progressBar.setIndeterminate(true);
            progressBar.setVisibility(View.VISIBLE);
            controllerContenido.getPeliculasPopulares(new ResultListener<List<Pelicula>>() {
                @Override
                public void finish(List<Pelicula> resultado) {
                    List<Contenido> blablub = new ArrayList<>();
                    blablub.addAll(resultado);
                    unAdapter.addPostList(blablub);
                    unAdapter.notifyDataSetChanged();
                    isLoading = false;
                    progressBar.setIndeterminate(false);
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }, getContext());
        }
    }
    public void getNewPagePeliculasRecom() {

        if (controllerContenido.isAnyPageAvailable()){
            isLoading = true;
            progressBar.setIndeterminate(true);
            progressBar.setVisibility(View.VISIBLE);
            controllerContenido.getPeliculasRecomendadas(new ResultListener<List<Pelicula>>() {
                @Override
                public void finish(List<Pelicula> resultado) {
                    List<Contenido> blablub = new ArrayList<>();
                    blablub.addAll(resultado);
                    unAdapter.addPostList(blablub);
                    unAdapter.notifyDataSetChanged();
                    isLoading = false;
                    progressBar.setIndeterminate(false);
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }, getContext());
        }
    }

    private void updateSeriesPopulares(){
        if (controllerContenido.isAnyPageAvailable()){
            isLoading = true;
            progressBar.setIndeterminate(true);
            progressBar.setVisibility(View.VISIBLE);
            controllerContenido.getSeriesPopulares(new ResultListener<List<Serie>>() {
                @Override
                public void finish(List<Serie> resultado) {
                    List<Contenido> blablub = new ArrayList<>();
                    blablub.addAll(resultado);
                    unAdapter.addPostList(blablub);
                    unAdapter.notifyDataSetChanged();
                    isLoading = false;
                    progressBar.setIndeterminate(false);
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }, getContext());
        }
    }
    private void updateSeriesTopRated(){
        if (controllerContenido.isAnyPageAvailable()){
            isLoading = true;
            progressBar.setIndeterminate(true);
            progressBar.setVisibility(View.VISIBLE);
            controllerContenido.getSeriesTopRated(new ResultListener<List<Serie>>() {
                @Override
                public void finish(List<Serie> resultado) {
                    List<Contenido> blablub = new ArrayList<>();
                    blablub.addAll(resultado);
                    unAdapter.addPostList(blablub);
                    unAdapter.notifyDataSetChanged();
                    isLoading = false;
                    progressBar.setIndeterminate(false);
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }, getContext());
        }
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
