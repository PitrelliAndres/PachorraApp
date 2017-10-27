package com.example.edu.a0817moacn01c_3;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PachorraFragment extends Fragment implements PeliculasRecyclerAdapter.ContenidoClickeable {
    private List<Contenido> listaPeliculasRecomendadas;
    private List<Contenido> listaPeliculasMasVistas;
    private List<Contenido> listaPeliculasEstrenos;
    private PeliculasRecyclerAdapter unAdapter;
    private NotificadorDatos escuchadorPelicula;
    private PeliculasRecyclerAdapter unAdapter2;
    private PeliculasRecyclerAdapter unAdapter3;
    private TextView tituloRecomendadas;
    private TextView tituloMasvistas;
    private TextView tituloEstrenos;

    public PachorraFragment()
    // Required empty public constructor
    {
    }

    public void onAttach(Context context){
        super.onAttach(context);
        escuchadorPelicula = (NotificadorDatos)context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pachorra, container, false);
        //Busco los Recyclers
        RecyclerView unRecyclerView= view.findViewById(R.id.recyclerPachorra1);
        RecyclerView unRecyclerView2= view.findViewById(R.id.recyclerPachorra2);
        RecyclerView unRecyclerView3= view.findViewById(R.id.recyclerPachorra3);
        //constrain
        RecyclerView.LayoutManager unLayoutManager = new GridLayoutManager(getContext(),1,GridLayoutManager.HORIZONTAL,false);
        RecyclerView.LayoutManager unLayoutManager2 = new GridLayoutManager(getContext(),1,GridLayoutManager.HORIZONTAL,false);
        RecyclerView.LayoutManager unLayoutManager3 = new GridLayoutManager(getContext(),1,GridLayoutManager.HORIZONTAL,false);
        //Seteo los titulos de las 3 secciones
        tituloRecomendadas = view.findViewById(R.id.textView_tituloLista1);
        tituloMasvistas = view.findViewById(R.id.textView_tituloLista2);
        tituloEstrenos = view.findViewById(R.id.textView_tituloLista3);
        tituloRecomendadas.setText("Recomendados por Amigos");
        tituloMasvistas.setText("Los mas vistos");
        tituloEstrenos.setText("Estrenos");

        unRecyclerView.setLayoutManager(unLayoutManager);
        unRecyclerView2.setLayoutManager(unLayoutManager2);
        unRecyclerView3.setLayoutManager(unLayoutManager3);
        //Cargo las 3 listas
        CargarContenido cargarContenido = new CargarContenido();

        listaPeliculasRecomendadas= cargarContenido.cargarPeliculasRecomendadasAmigos();
        listaPeliculasMasVistas= cargarContenido.cargarPeliculasMasVistas();
        listaPeliculasEstrenos= cargarContenido.cargarPeliculasEstrenos();

        unRecyclerView.setHasFixedSize(true);
        unRecyclerView2.setHasFixedSize(true);
        unRecyclerView3.setHasFixedSize(true);

        unAdapter = new PeliculasRecyclerAdapter(listaPeliculasRecomendadas,getContext(),this,1);
        unAdapter2 = new PeliculasRecyclerAdapter(listaPeliculasMasVistas,getContext(),this,2);
        unAdapter3= new PeliculasRecyclerAdapter(listaPeliculasEstrenos,getContext(),this,3);
        //Le seteo el adaptador al recycler
        unRecyclerView.setAdapter(unAdapter);
        unRecyclerView2.setAdapter(unAdapter2);
        unRecyclerView3.setAdapter(unAdapter3);

        return view;
    }


    @Override
    //metodo para comunicar el recycler con el activity mediante el fragment
    public void mandarSeleccion(Integer position,Integer nroListaContenido) {
        escuchadorPelicula.mandarDatos(position,nroListaContenido);
    }

    public interface NotificadorDatos{
        public void mandarDatos(Integer position,Integer nroListaContenido);
        //public void mandarDatos(String nombre, Integer imagen, Integer precio, String desc,Context unContexto);
    }
}
