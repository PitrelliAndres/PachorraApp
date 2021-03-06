package com.example.edu.a0817moacn01c_3.View;


import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.edu.a0817moacn01c_3.Controller.ControllerContenido;
import com.example.edu.a0817moacn01c_3.Model.Contenido;
import com.example.edu.a0817moacn01c_3.Model.Pelicula;
import com.example.edu.a0817moacn01c_3.Model.Trailer;
import com.example.edu.a0817moacn01c_3.R;
import com.example.edu.a0817moacn01c_3.Model.Serie;
import com.example.edu.a0817moacn01c_3.utils.ResultListener;
import com.example.edu.a0817moacn01c_3.utils.TMDBHelper;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetalleFragment extends Fragment {
    private static final String TAG = "Detalle Fragment";
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
    private Button verTrailer;
    public Trailer trailer;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private AppBarLayout appBarLayout;
    private Toolbar toolbarPachorra;


    public static final String TIPOCONTENIDO = "tipo de contenido";
    public static final String ID = "id";
    public static final String NOMBRE = "titulo";
    public static final String SINOPSIS = "sinopsis";
    public static final String URLAFICHE = "url_afiche";
    public static final String URLFONDO = "url_fondo";
    public static final String POPULARIDAD = "popularidad";
    public static final String ESTRENO = "fecha_estreno";
    public static final String DURACION = "duracion";
    public static final String ESTADO = "estado";
    public static final String PUNTUACION = "votos_promedio";
    public static final String CANTIDADVOTOS = "votos_cantidad";

    // Atributos adicionales Pelicula
    public static final String IMDBID = "imdb_id";
    public static final String TITULOORG = "tituo_original";
    public static final String ADULTO = "adulto";
    public static final String LEMA = "tagline";
    public static final String VIDEO = "video";

    // Atributos adicionales Serie
    public static final String TYPE = "type";
    public static final String NROSEASONS = "nroSeasons";
    public static final String NROEPISODES = "nroEpisodes";
    public static final String CANALTV = "canaltv";


    public DetalleFragment() {
        // Required empty public constructor

        // Required empty public constructor
    }

    public static DetalleFragment dameDetalleFragment(Contenido unContenido) {
        DetalleFragment detalleFragment = new DetalleFragment();

        Bundle unBundle = new Bundle();
        unBundle.putInt(ID, unContenido.getId());
        unBundle.putString(NOMBRE, unContenido.getNombre());
        unBundle.putString(URLAFICHE, unContenido.getUrlafiche());
        unBundle.putString(URLFONDO, unContenido.getUrlfondo());
        unBundle.putDouble(PUNTUACION, unContenido.getPuntuacion());
        unBundle.putString(SINOPSIS, unContenido.getSinopsis());
        unBundle.putString(ESTRENO, unContenido.getEstreno());
        unBundle.putDouble(POPULARIDAD, unContenido.getPopularidad());
        unBundle.putString(ESTADO, unContenido.getEstado());
        unBundle.putInt(CANTIDADVOTOS, unContenido.getCantidadvotos());
        unBundle.putString(TYPE, unContenido.getTipoContenido());
        if (unContenido.getTipoContenido().equals(Contenido.PELICULA)) {
            Pelicula unapelicula = (Pelicula) unContenido;
            unBundle.putBoolean(ADULTO, unapelicula.getAdulto());
        } else {
            Serie unaSerie = (Serie) unContenido;
            unBundle.putInt(NROSEASONS, unaSerie.getNroSeasons());
            unBundle.putInt(NROEPISODES, unaSerie.getNroEpisodios());
        }
        detalleFragment.setArguments(unBundle);
        return detalleFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view;

        Bundle unBundle = getArguments();
        Contenido unaPeliculaOSerie = new Contenido(
                unBundle.getInt(ID),
                unBundle.getString(NOMBRE),
                unBundle.getString(SINOPSIS),
                unBundle.getString(URLAFICHE),
                unBundle.getString(URLFONDO),
                unBundle.getDouble(POPULARIDAD),
                unBundle.getString(ESTRENO),
                unBundle.getInt(DURACION),
                unBundle.getString(ESTADO),
                unBundle.getDouble(PUNTUACION),
                unBundle.getInt(CANTIDADVOTOS),
                unBundle.getString(TIPOCONTENIDO)
        );


        if (unBundle.get(ADULTO) != null) {
            view = inflater.inflate(R.layout.fragment_detallepeliculas, container, false);

            unaPelicula = new Pelicula(unaPeliculaOSerie,

                    unBundle.getString(TITULOORG),
                    unBundle.getBoolean(ADULTO),
                    unBundle.getString(LEMA),
                    unBundle.getString(VIDEO),
                    unBundle.getString(IMDBID)
            );

            this.imagen =(ImageView) view.findViewById(R.id.imageView_ImagenContenidoPeliculas);
            this.imagenPortada =(ImageView) view.findViewById(R.id.imageview_detalleBackdropPeliculas);
            this.puntuacion =(TextView) view.findViewById(R.id.textview_detallePuntuacionPeliculas);
            this.genero =(TextView) view.findViewById(R.id.textview_generoPeliculas);
            this.clasificacion =(TextView) view.findViewById(R.id.textview_clasificacionPeliculas);
            this.sinopsis =(TextView) view.findViewById(R.id.textview_descripcionPeliculas);
            this.verTrailer = (Button)view.findViewById(R.id.button_verTrailer);
            verTrailer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    watchYoutubeVideo(getContext(),trailer);
                }
            });
            collapsingToolbarLayout = view.findViewById(R.id.colpasingDetallesPelicula);
            appBarLayout = view.findViewById(R.id.appbar_detallePelicula);
            toolbarPachorra = (Toolbar) view.findViewById(R.id.toolbar_detallePelicula);


            mostrarInformacion(unaPelicula);
            cargarTitulo(unaPelicula.getNombre());

        } else {
            view = inflater.inflate(R.layout.fragment_detalleseries, container, false);
            // Construir un objeto Serie con un constructor que recibe un objeto Contenido + los atributos adicionales de una Serie
            unaSerie = new Serie(unaPeliculaOSerie,
                    unBundle.getString(TYPE),
                    unBundle.getInt(NROSEASONS),
                    unBundle.getInt(NROEPISODES),
                    unBundle.getString(CANALTV)
            );

            this.imagen =(ImageView) view.findViewById(R.id.imageView_ImagenContenidoSeries);
            this.imagenPortada = (ImageView)view.findViewById(R.id.imageview_detalleBackdropSeries);
            this.puntuacion = (TextView)view.findViewById(R.id.textview_detallePuntuacionSeries);
            this.clasificacion =(TextView) view.findViewById(R.id.textview_clasificacionSeries);
            this.genero =(TextView) view.findViewById(R.id.textview_generoSeries);
            this.sinopsis =(TextView) view.findViewById(R.id.textview_descripcionSeries);
            this.temporadas =(TextView) view.findViewById(R.id.textview_temporadasSerie);
            this.episodios = (TextView)view.findViewById(R.id.textview_episodiosSerie);

        toolbarPachorra = (Toolbar) view.findViewById(R.id.toolbar_detalleSerie);
        collapsingToolbarLayout = view.findViewById(R.id.colpasingDetallesSerie);
        appBarLayout = view.findViewById(R.id.appbar_detalleSerie);

            mostrarInformacion(unaSerie);
        cargarTitulo(unaSerie.getNombre());
        }



        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbarPachorra);
       
        //actionBarPachorra.setDisplayHomeAsUpEnabled(true);
        return view;
    }
    public void cargarTitulo(final String titulo){
        collapsingToolbarLayout.setTitle(titulo);
        collapsingToolbarLayout.setExpandedTitleMarginStart(240);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    //imagenPortada.animate().alpha(0);
                    //collapsingToolbarLayout.setTitle(titulo);
                    isShow = true;
                } else if(isShow) {
                    /*layout.setPivot(0);
                    layout.animate().scaleY(scaleFactor).setDuration(500);*/
                    //collapsingToolbarLayout.setTitle(titulo);
                    collapsingToolbarLayout.setExpandedTitleMarginStart(240);
                    isShow = false;
                }
            }
        });
    }

    public void mostrarInformacion(Pelicula pelicula) {
        String imagenAfiche;
        String imagenFondo;
        // TODO: objeto Pelicula con Generos
        imagenAfiche = TMDBHelper.getImagePoster(TMDBHelper.IMAGE_SIZE_W300, pelicula.getUrlafiche());
        imagenFondo = TMDBHelper.getImagePoster(TMDBHelper.IMAGE_SIZE_W780, pelicula.getUrlfondo());
        Glide.with(getContext()).load(imagenAfiche).into(imagen);
        Glide.with(getContext()).load(imagenFondo).into(imagenPortada);

        ControllerContenido controllerContenido = new ControllerContenido(getContext());
        controllerContenido.getTrailer(new ResultListener<Trailer>() {
            @Override
            public void finish(Trailer resultado) {
                trailer = resultado;
                toggleVerTrailer();
            }
        },pelicula.getId().toString());

        puntuacion.setText(pelicula.getPuntuacion().toString());
        //ano.setText(unaPelicula.getAno());
        genero.setText("Genero");
        clasificacion.setText(pelicula.getAptoParaPublico());
        sinopsis.setText(pelicula.getSinopsis());
       toggleVerTrailer();
    }

    public void mostrarInformacion(Serie serie) {
        String imagenAfiche;
        String imagenFondo;

        // TODO: objeto Pelicula con Generos
        imagenAfiche = TMDBHelper.getImagePoster(TMDBHelper.IMAGE_SIZE_W300, serie.getUrlafiche());
        imagenFondo = TMDBHelper.getImagePoster(TMDBHelper.IMAGE_SIZE_W780, serie.getUrlfondo());
        Glide.with(getContext()).load(imagenAfiche).into(imagen);
        Glide.with(getContext()).load(imagenFondo).into(imagenPortada);
        puntuacion.setText(serie.getPuntuacion().toString());
        //ano.setText(unaPelicula.getAno());
        this.genero.setText("Genero");

        sinopsis.setText(serie.getSinopsis());
        this.temporadas.setText("S" + serie.getNroSeasons().toString());
        this.episodios.setText("E" + serie.getNroEpisodios().toString());

    }
    public void toggleVerTrailer(){
        if(trailer != null) {
            this.verTrailer.setVisibility(View.VISIBLE);
        }else{
            this.verTrailer.setVisibility(View.GONE);
        }
    }
    public static void watchYoutubeVideo(Context context, Trailer trailer){
        String id = trailer.getId();
        String key = trailer.getKey();
        //Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(id));
        Intent webIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.youtube.com/watch?v=" + key));
        try {
            context.startActivity(appIntent);
            Log.d(TAG, "watchYoutubeVideo: "+id);
        } catch (ActivityNotFoundException ex) {
            context.startActivity(webIntent);
            Log.d(TAG, "watchYoutubeVideo: "+key);
        }
    }
}
