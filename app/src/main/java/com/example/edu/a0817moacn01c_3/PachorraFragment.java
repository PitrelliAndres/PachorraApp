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

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PachorraFragment extends Fragment implements PeliculasRecyclerAdapter.ClickieablePeliRecomendada{
    private List<Peliculas> listaPeliculasRecomendadas;
    private List<Peliculas> listaPeliculasMasVistas;
    private List<Peliculas> listaPeliculasEstrenos;
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
        cargarPeliculasRecomendadasAmigos();
        cargarPeliculasMasVistas();
        cargarPeliculasEstrenos();

        unRecyclerView.setHasFixedSize(true);
        unRecyclerView2.setHasFixedSize(true);
        unRecyclerView3.setHasFixedSize(true);

        unAdapter2 = new PeliculasRecyclerAdapter(listaPeliculasMasVistas,getContext(),this);
        unAdapter = new PeliculasRecyclerAdapter(listaPeliculasRecomendadas,getContext(),this);
        unAdapter3= new PeliculasRecyclerAdapter(listaPeliculasEstrenos,getContext(),this);
        //Le seteo el adaptador al recycler
        unRecyclerView.setAdapter(unAdapter);
        unRecyclerView2.setAdapter(unAdapter2);
        unRecyclerView3.setAdapter(unAdapter3);

        return view;
    }
    private void cargarPeliculasRecomendadasAmigos(){
        listaPeliculasRecomendadas = new ArrayList<>();
        String descArmaMortal = "Una pareja de policías tiene como misión proteger a un individuo que va a testificar en contra de una organización de traficantes de droga. Las cosas se complican cuando uno de ellos decide iniciar la investigación por su cuenta sin comunicarlo a la comisaría. Una pareja de policías tiene como misión proteger a un individuo que va a testificar en contra de una organización de traficantes de droga. Las cosas se complican cuando uno de ellos decide iniciar la investigación por su cuenta sin comunicarlo a la comisaría. Una pareja de policías tiene como misión proteger a un individuo que va a testificar en contra de una organización de traficantes de droga. Las cosas se complican cuando uno de ellos decide iniciar la investigación por su cuenta sin comunicarlo a la comisaría. Una pareja de policías tiene como misión proteger a un individuo que va a testificar en contra de una organización de traficantes de droga. Las cosas se complican cuando uno de ellos decide iniciar la investigación por su cuenta sin comunicarlo a la comisaría. Una pareja de policías tiene como misión proteger a un individuo que va a testificar en contra de una organización de traficantes de droga. Las cosas se complican cuando uno de ellos decide iniciar la investigación por su cuenta sin comunicarlo a la comisaría.";
        listaPeliculasRecomendadas.add(new Peliculas("Arma Mortal",R.drawable.arma_mortal,R.drawable.arma_mortal,"accion",descArmaMortal,10.0,"ATP"));
        listaPeliculasRecomendadas.add(new Peliculas("Derek",R.drawable.derek,R.drawable.derek_backdrop,"Mockumentary","desc",9.5,"ATP"));
        listaPeliculasRecomendadas.add(new Peliculas("avatar",R.drawable.avatar,R.drawable.avatar,"accion","desc",6.0,"ATP"));
        listaPeliculasRecomendadas.add(new Peliculas("El Dia De La Marmota",R.drawable.el_dia_de_la_marmota,R.drawable.dia_de_la_marmota_backdrop,"accion","desc",8.0,"ATP"));
        listaPeliculasRecomendadas.add(new Peliculas("El Senor De Los_Anillos",R.drawable.el_senor_de_los_anillos,R.drawable.el_senor_de_los_anillos,"accion","desc",10.0,"ATP"));
        listaPeliculasRecomendadas.add(new Peliculas("Forrest Gump",R.drawable.forrest_gump,R.drawable.forrest_gump,"accion","desc",10.0,"ATP"));
        listaPeliculasRecomendadas.add(new Peliculas("Indiana Jones",R.drawable.indiana_jones,R.drawable.indiana_jones,"accion","desc",10.0,"ATP"));
    }
    private void cargarPeliculasMasVistas(){
        listaPeliculasMasVistas = new ArrayList<>();
        listaPeliculasMasVistas.add(new Peliculas("Logan",R.drawable.logan,R.drawable.loganback,"Accion","desc",10.0,"ATP"));
        listaPeliculasMasVistas.add(new Peliculas("Spider man: Homecoming",R.drawable.spidermanhomecoming,R.drawable.spidermanhomecomingBack,"Ciencia Ficción","desc",8.0,"ATP"));
        listaPeliculasMasVistas.add(new Peliculas("It",R.drawable.it,R.drawable.itback,"Terror","desc",7.0,"+16"));
        listaPeliculasMasVistas.add(new Peliculas("Mi Villano Favorito 3",R.drawable.mivillanofavorito,R.drawable.mivillanofavoritoback,"Comedia","desc",8.0,"ATP"));
        listaPeliculasMasVistas.add(new Peliculas("La Bella Y La Bestia",R.drawable.labellaylabestia,R.drawable.labellaylabestiaback,"Infantil","desc",9.0,"ATP"));
        listaPeliculasMasVistas.add(new Peliculas("Guardianes de la galaxia 2",R.drawable.guardianesdelagalaxia2,R.drawable.guardianesdelagalaxiaback,"Ciencia ficcion","desc",9.0,"ATP"));
        listaPeliculasMasVistas.add(new Peliculas("Rapidos y Furiosos 8",R.drawable.rapidoyfurioso,R.drawable.rapidoyfuriosoback,"Accion","desc",6.0,"ATP"));
    }
    private void cargarPeliculasEstrenos(){
        listaPeliculasEstrenos = new ArrayList<>();
        listaPeliculasEstrenos.add(new Peliculas("Blade Runner ",R.drawable.BladeRunner,R.drawable.BladeRunnerBack,"ciencia ficcion","desc",9.0,"ATP"));
        listaPeliculasEstrenos.add(new Peliculas("El Muñeco De Nieve",R.drawable.Elmuñecodenieve,R.drawable.ElmuñecodenieveBack,"drama","desc",5.0,"ATP"));
        listaPeliculasEstrenos.add(new Peliculas("El Ultimo Traje",R.drawable.Elultimotraje,R.drawable.ElultimotrajeBack,"drama","desc",8.0,"ATP"));
        listaPeliculasEstrenos.add(new Peliculas("La Cabaña",R.drawable.Lacabaña,R.drawable.lacabalaback,"drama","desc",8.0,"ATP"));
        listaPeliculasEstrenos.add(new Peliculas("Anabelle 2",R.drawable.anabelle,R.drawable.anabellebackground,"Terror","desc",6.0,"+16"));
        listaPeliculasEstrenos.add(new Peliculas("Mal Genio",R.drawable.malgenio,R.drawable.malgenioback,"Comedia","desc",8.0,"ATP"));
        listaPeliculasEstrenos.add(new Peliculas("La Llamada",R.drawable.lallamada,R.drawable.lallamadaback,"Comedia Musical","desc",7.0,"ATP"));
    }

    @Override
    //metodo para comunicar el recycler con el activity mediante el fragment
    public void mandarSeleccion(Peliculas unaPelicula) {

        escuchadorPelicula.mandarDatos(unaPelicula.getNombre(),unaPelicula.getImagen(),unaPelicula.getImagenPortada(),unaPelicula.getGenero(),unaPelicula.getDesc(),unaPelicula.getPuntuacion(),unaPelicula.getAptoParaPublico());
    }

    public interface NotificadorDatos{
        public void mandarDatos(String nombre, Integer imagen,Integer imagenPortada, String genero, String desc,Double puntuacion,String aptoTodoPublico);
        //public void mandarDatos(String nombre, Integer imagen, Integer precio, String desc,Context unContexto);
    }
}
