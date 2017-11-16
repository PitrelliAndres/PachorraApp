package com.example.edu.a0817moacn01c_3.View;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.edu.a0817moacn01c_3.Controller.ControllerContenido;
import com.example.edu.a0817moacn01c_3.Model.Contenido;
import com.example.edu.a0817moacn01c_3.R;
import com.example.edu.a0817moacn01c_3.utils.ResultListener;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PachorraFragment extends Fragment implements PeliculasRecyclerAdapter.ContenidoClickeable {
    private List<Contenido> listaPeliculasRecomendadasMixto;
    private List<Contenido> listaPeliculasMasVistasMixto;
    private List<Contenido> listaPeliculasEstrenosMixto;
    private List<Contenido> listaPeliculasRecomendadasPeliculas;
    private List<Contenido> listaPeliculasMasVistasPeliculas;
    private List<Contenido> listaPeliculasEstrenosPeliculas;
    private List<Contenido> listaPeliculasRecomendadasSeries;
    private List<Contenido> listaPeliculasMasVistasSeries;
    private List<Contenido> listaPeliculasEstrenosSeries;
    private PeliculasRecyclerAdapter unAdapter;
    private NotificadorDatos escuchadorPelicula;
    private PeliculasRecyclerAdapter unAdapter2;
    private PeliculasRecyclerAdapter unAdapter3;
    private TextView tituloRecomendadas;
    private TextView tituloMasvistas;
    private TextView tituloEstrenos;
    private ControllerContenido controllerContenido;


    public PachorraFragment()
    // Required empty public constructor
    {
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        escuchadorPelicula = (NotificadorDatos) context;
    }


    public static PachorraFragment dameListasRecycler(Integer nroContenido) {
        PachorraFragment pachorraFragment = new PachorraFragment();
        Bundle unBundle = new Bundle();


        unBundle.putInt("nrocontenido", nroContenido);
        pachorraFragment.setArguments(unBundle);
        return pachorraFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pachorra, container, false);

        Bundle bundle = getArguments();
        RecyclerView unRecyclerView = view.findViewById(R.id.recyclerPachorra1);
        RecyclerView unRecyclerView2 = view.findViewById(R.id.recyclerPachorra2);
        RecyclerView unRecyclerView3 = view.findViewById(R.id.recyclerPachorra3);
        GridLayoutManager unLayoutManager = new GridLayoutManager(getContext(), 1, GridLayoutManager.HORIZONTAL, false);
        RecyclerView.LayoutManager unLayoutManager2 = new GridLayoutManager(getContext(), 1, GridLayoutManager.HORIZONTAL, false);
        RecyclerView.LayoutManager unLayoutManager3 = new GridLayoutManager(getContext(), 1, GridLayoutManager.HORIZONTAL, false);

        tituloRecomendadas = view.findViewById(R.id.textView_tituloLista1);
        tituloMasvistas = view.findViewById(R.id.textView_tituloLista2);
        tituloEstrenos = view.findViewById(R.id.textView_tituloLista3);
        tituloRecomendadas.setText("Recomendados por Amigos");
        tituloMasvistas.setText("Los mas vistos");
        tituloEstrenos.setText("Estrenos");

        // 1: Recycler
        unRecyclerView.setLayoutManager(unLayoutManager);
        /*unRecyclerView2.setLayoutManager(unLayoutManager2);
        unRecyclerView3.setLayoutManager(unLayoutManager3);*/

        unRecyclerView.setHasFixedSize(true);
        /*unRecyclerView2.setHasFixedSize(true);
        unRecyclerView3.setHasFixedSize(true);*/



/*        Integer nroContenido = bundle.getInt("nrocontenido");

        ControllerContenido controllerContenido = new ControllerContenido();
        listaPeliculasRecomendadasMixto = controllerContenido.getListaMasrecomendados();
        listaPeliculasMasVistasMixto = controllerContenido.getListaMasvistos();
        listaPeliculasEstrenosMixto = controllerContenido.getListaEstrenos();


        listaPeliculasRecomendadasPeliculas=controllerContenido.getListaMasRecomendados(Contenido.PELICULA);
        listaPeliculasMasVistasPeliculas=controllerContenido.getListaMasVistos(Contenido.PELICULA);
        listaPeliculasEstrenosPeliculas=controllerContenido.getListaEstreno(Contenido.PELICULA);

        listaPeliculasRecomendadasSeries=controllerContenido.getListaMasRecomendados(Contenido.SERIE);
        listaPeliculasMasVistasSeries=controllerContenido.getListaMasVistos(Contenido.SERIE);
        listaPeliculasEstrenosSeries=controllerContenido.getListaEstreno(Contenido.SERIE);

        switch (nroContenido) {
            case 1:
                unAdapter = new PeliculasRecyclerAdapter(listaPeliculasRecomendadasPeliculas, getContext(), this, 4);
                unAdapter2 = new PeliculasRecyclerAdapter(listaPeliculasMasVistasPeliculas, getContext(), this, 5);
                unAdapter3 = new PeliculasRecyclerAdapter(listaPeliculasEstrenosPeliculas, getContext(), this, 6);

                unRecyclerView.setAdapter(unAdapter);
                unRecyclerView2.setAdapter(unAdapter2);
                unRecyclerView3.setAdapter(unAdapter3);
                break;
            case 2:

                unAdapter = new PeliculasRecyclerAdapter(listaPeliculasRecomendadasMixto, getContext(), this, 1);
                unAdapter2 = new PeliculasRecyclerAdapter(listaPeliculasMasVistasMixto, getContext(), this, 2);
                unAdapter3 = new PeliculasRecyclerAdapter(listaPeliculasEstrenosMixto, getContext(), this, 3);
                //Le seteo el adaptador al recycler
                unRecyclerView.setAdapter(unAdapter);
                unRecyclerView2.setAdapter(unAdapter2);
                unRecyclerView3.setAdapter(unAdapter3);

                break;
            case 3:
                unAdapter = new PeliculasRecyclerAdapter(listaPeliculasRecomendadasSeries, getContext(), this, 7);
                unAdapter2 = new PeliculasRecyclerAdapter(listaPeliculasMasVistasSeries, getContext(), this, 8);
                unAdapter3 = new PeliculasRecyclerAdapter(listaPeliculasEstrenosSeries, getContext(), this, 9);

                unRecyclerView.setAdapter(unAdapter);
                unRecyclerView2.setAdapter(unAdapter2);
                unRecyclerView3.setAdapter(unAdapter3);
        }*/

        // 2: Adapter
        unAdapter = new PeliculasRecyclerAdapter(getContext());

        // 3: Adapter con recycler
        unRecyclerView.setAdapter(unAdapter);
        unRecyclerView.setLayoutManager(unLayoutManager);
        controllerContenido = new ControllerContenido(getContext());
        update();

        return view;

    }


    @Override
    //metodo para comunicar el recycler con el activity mediante el fragment
    public void mandarSeleccion(Integer position, Integer nroListaContenido) {
        escuchadorPelicula.mandarDatos(position, nroListaContenido);
    }

    public interface NotificadorDatos {
        public void mandarDatos(Integer position, Integer nroListaContenido);
   }

    private void update() {

        controllerContenido.getPeliculasPopulares(new ResultListener<List<Contenido>>() {
            @Override
            public void finish(List<Contenido> resultado) {

                unAdapter.setListaContenidos(resultado);

                unAdapter.notifyDataSetChanged();

            }
        }, getContext());

    }
}
