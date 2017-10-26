package com.example.edu.a0817moacn01c_3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetalleFragment extends Fragment {
    private Peliculas pelicula;
    private ImageView imagen;
    private ImageView imagenPortada;
    private TextView puntuacion;
    private TextView ano;
    private TextView genero;
    private TextView clasificacion;
    private TextView sinopsis;


    public DetalleFragment() {
        // Required empty public constructor

        // Required empty public constructor
    }
    public static DetalleFragment dameDetalleFragment(Contenido unContenido){
        DetalleFragment detalleFragment = new DetalleFragment();

        Bundle unBundle= new Bundle();
        unBundle.putInt("id",unContenido.getId());
        unBundle.putString("nombre",unContenido.getNombre());
        unBundle.putInt("imagen",unContenido.getImagen());
        unBundle.putInt("imagenPortada",unContenido.getImagenPortada());
        unBundle.putString("genero",unContenido.getGenero());
        unBundle.putDouble("puntuacion",unContenido.getPuntuacion());
        unBundle.putString("descripcion",unContenido.getDesc());
        unBundle.putString("aptoTodoPublico",unContenido.getAptoParaPublico());
        unBundle.putInt("duracion", unContenido.);
        unBundle.putString("tipo",unContenido.getTipoContenido());

        if(unContenido.getTipoContenido()=="Pelicula"){
            Peliculas unapelicula= (Peliculas)unContenido;
            unBundle.putString("tipo",unapelicula.getUrl());
        } else {
            Series unaSerie= (Series)unContenido;
            unBundle.putInt("cantidadTemporada", unaSerie.getCantidadTemporada());
            unBundle.putInt("cantidadEpisodios", unaSerie.getCantidadCapitulos());
        }
        detalleFragment.setArguments(unBundle);
        return detalleFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment


        Bundle unBundle = getArguments();
        if(unBundle.getString("tipo")=="Peliculas"){
            View view = inflater.inflate(R.layout.fragment_detalle, container, false);
        pelicula = new Peliculas(
                unBundle.getInt("id"),
                unBundle.getString("nombre"),
                unBundle.getInt("imagen"),
                unBundle.getInt("imagenPortada"),
                unBundle.getString("genero"),
                unBundle.getString("descripcion"),
                unBundle.getDouble("puntuacion"),
                unBundle.getString("aptoTodoPublico"),
                unBundle.getInt("duracion"),
                unBundle.getString("url"),
                unBundle.getString("tipo")

        );
            this.imagen = view.findViewById(R.id.imageView_ImagenContenido);
            this.imagenPortada = view.findViewById(R.id.imageview_detalleBackdrop);
            this.puntuacion = view.findViewById(R.id.textview_detallePuntuacion);
            //this.ano =
            this.genero = view.findViewById(R.id.textview_genero);
            this.clasificacion = view.findViewById(R.id.textview_clasificacion);
            this.sinopsis = view.findViewById(R.id.textview_descripcion);
            mostrarInformacion();
            return view;
        } else {
            View view = inflater.inflate(R.layout.fragment_detalle, container, false);
        }


        mostrarInformacion();



        return view;


    }

    public void mostrarInformacion(){
        String generoTexto = pelicula.getGenero().replace(",","\r\n");

        getActivity().setTitle(pelicula.getNombre());
        imagen.setImageResource(pelicula.getImagen());
        imagenPortada.setImageResource(pelicula.getImagenPortada());
        puntuacion.setText(pelicula.getPuntuacion().toString());
        //ano.setText(pelicula.getAno());
        genero.setText(generoTexto);
        clasificacion.setText(pelicula.getAptoParaPublico());
        sinopsis.setText(pelicula.getDesc());

    }



}
