package com.example.edu.a0817moacn01c_3.View;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.edu.a0817moacn01c_3.Model.Contenido;
import com.example.edu.a0817moacn01c_3.Model.Pelicula;
import com.example.edu.a0817moacn01c_3.R;
import com.example.edu.a0817moacn01c_3.Model.Serie;


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
    private TextView temporadas;
    private TextView episodios;

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
        View view;

        Bundle unBundle = getArguments();
        Contenido unaPeliculaOSerie = new Contenido(unBundle.getInt("id"),
                unBundle.getString("nombre"),
                unBundle.getInt("imagen"),
                unBundle.getInt("imagenPortada"),
                unBundle.getString("genero"),
                unBundle.getString("descripcion"),
                unBundle.getDouble("puntuacion"),
                unBundle.getString("aptoTodoPublico"),
                unBundle.getString("tipo")
        );

        if (unaPeliculaOSerie.esPelicula()) {
            view = inflater.inflate(R.layout.fragment_detallepeliculas, container, false);
            unaPelicula = new Pelicula(unaPeliculaOSerie, unBundle.getString("url"));

            this.imagen = view.findViewById(R.id.imageView_ImagenContenidoPeliculas);
            this.imagenPortada = view.findViewById(R.id.imageview_detalleBackdropPeliculas);
            this.puntuacion = view.findViewById(R.id.textview_detallePuntuacionPeliculas);
            this.genero = view.findViewById(R.id.textview_generoPeliculas);
            this.clasificacion = view.findViewById(R.id.textview_clasificacionPeliculas);
            this.sinopsis = view.findViewById(R.id.textview_descripcionPeliculas);
            mostrarInformacion(unaPelicula);

        } else {
            view = inflater.inflate(R.layout.fragment_detalleseries, container, false);
            unaSerie = new Serie(unaPeliculaOSerie, unBundle.getInt("cantidadTemporada"), unBundle.getInt("cantidadCapitulos"));

            this.imagen = view.findViewById(R.id.imageView_ImagenContenidoSeries);
            this.imagenPortada = view.findViewById(R.id.imageview_detalleBackdropSeries);
            this.puntuacion = view.findViewById(R.id.textview_detallePuntuacionSeries);
            this.clasificacion = view.findViewById(R.id.textview_clasificacionSeries);
            this.genero = view.findViewById(R.id.textview_generoSeries);
            this.sinopsis = view.findViewById(R.id.textview_descripcionSeries);
            this.temporadas = view.findViewById(R.id.textview_temporadasSerie);
            this.episodios = view.findViewById(R.id.textview_episodiosSerie);
            mostrarInformacion(unaSerie);

        }
        return view;
    }

    public void mostrarInformacion(Pelicula pelicula) {
        String generoTexto = pelicula.getGenero().replace(", ", "\r\n");

        //getActivity().setTitle(pelicula.getNombre());
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
        this.genero.setText(generoTexto);
        clasificacion.setText(serie.getAptoParaPublico());
        sinopsis.setText(serie.getDesc());
        this.temporadas.setText("Temporadas " + serie.getCantidadTemporadas().toString());
        this.episodios.setText("Capitulos " + serie.getCantidadCapitulos().toString());

    }


}
