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
    private Pelicula unaPelicula;
    private Serie unaSerie;
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

    public static DetalleFragment dameDetalleFragment(Contenido unContenido) {
        DetalleFragment detalleFragment = new DetalleFragment();

        Bundle unBundle = new Bundle();
        unBundle.putInt("id", unContenido.getId());
        unBundle.putString("nombre", unContenido.getNombre());
        unBundle.putInt("imagen", unContenido.getImagen());
        unBundle.putInt("imagenPortada", unContenido.getImagenPortada());
        unBundle.putString("genero", unContenido.getGenero());
        unBundle.putDouble("puntuacion", unContenido.getPuntuacion());
        unBundle.putString("descripcion", unContenido.getDesc());
        unBundle.putString("aptoTodoPublico", unContenido.getAptoParaPublico());
        unBundle.putInt("duracion", unContenido.getDuracion());
        unBundle.putString("tipo", unContenido.getTipoContenido());

        if (unContenido.getTipoContenido().equals(Contenido.PELICULA)) {
            Pelicula unapelicula = (Pelicula) unContenido;
            unBundle.putString("url", unapelicula.getUrl());
        } else {
            Serie unaSerie = (Serie) unContenido;
            unBundle.putInt("cantidadTemporada", unaSerie.getCantidadTemporadas());
            unBundle.putInt("cantidadCapitulos", unaSerie.getCantidadCapitulos());
        }
        detalleFragment.setArguments(unBundle);
        return detalleFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = null;

        Bundle unBundle = getArguments();
        Contenido unaPeliculaOSerie = new Contenido(unBundle.getInt("id"),
                unBundle.getString("nombre"),
                unBundle.getInt("imagen"),
                unBundle.getInt("imagenPortada"),
                unBundle.getString("genero"),
                unBundle.getString("descripcion"),
                unBundle.getDouble("puntuacion"),
                unBundle.getString("aptoTodoPublico"),
                unBundle.getInt("duracion"),
                unBundle.getString("tipo")
        );
        if (unaPeliculaOSerie.esPelicula()) {
            view = inflater.inflate(R.layout.fragment_detallepeliculas, container, false);
            unaPelicula = new Pelicula(unaPeliculaOSerie, unBundle.getString("url"));

            this.imagen = view.findViewById(R.id.imageView_ImagenContenido);
            this.imagenPortada = view.findViewById(R.id.imageview_detalleBackdrop);
            this.puntuacion = view.findViewById(R.id.textview_detallePuntuacion);
            this.genero = view.findViewById(R.id.textview_genero);
            this.clasificacion = view.findViewById(R.id.textview_clasificacion);
            this.sinopsis = view.findViewById(R.id.textview_descripcion);
            mostrarInformacion(unaPelicula);

        } else {
            view = inflater.inflate(R.layout.fragment_detalleseries, container, false);
            unaSerie = new Serie(unaPeliculaOSerie, unBundle.getInt("cantidadTemporada"), unBundle.getInt("cantidadCapitulos"));

            this.imagen = view.findViewById(R.id.imageView_ImagenContenido);
            this.imagenPortada = view.findViewById(R.id.imageview_detalleBackdrop);
            this.puntuacion = view.findViewById(R.id.textview_detallePuntuacion);
            this.genero = view.findViewById(R.id.textview_genero);
            this.clasificacion = view.findViewById(R.id.textview_clasificacion);
            this.sinopsis = view.findViewById(R.id.textview_descripcion);
            mostrarInformacion(unaSerie);

        }
        return view;
    }

    public void mostrarInformacion(Pelicula pelicula) {
        String generoTexto = pelicula.getGenero().replace(", ", "\r\n");

        getActivity().setTitle(pelicula.getNombre());
        imagen.setImageResource(pelicula.getImagen());
        imagenPortada.setImageResource(pelicula.getImagenPortada());
        puntuacion.setText(pelicula.getPuntuacion().toString());
        //ano.setText(unaPelicula.getAno());
        genero.setText(generoTexto);
        clasificacion.setText(pelicula.getAptoParaPublico());
        sinopsis.setText(pelicula.getDesc());

    }

    public void mostrarInformacion(Serie serie) {
        String generoTexto = serie.getGenero().replace(", ", "\r\n");

        getActivity().setTitle(serie.getNombre());
        imagen.setImageResource(serie.getImagen());
        imagenPortada.setImageResource(serie.getImagenPortada());
        puntuacion.setText(serie.getPuntuacion().toString());
        //ano.setText(unaPelicula.getAno());
        genero.setText(generoTexto);
        clasificacion.setText(serie.getAptoParaPublico());
        sinopsis.setText(serie.getDesc());

    }


}
