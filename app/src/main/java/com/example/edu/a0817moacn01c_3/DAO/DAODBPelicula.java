package com.example.edu.a0817moacn01c_3.DAO;

import android.content.Context;

/**
 * Created by ma on 13/11/17.
 */

public class DAODBPelicula extends DatabaseHelper {
    public static final String TABLENAME = "peliculas";

    public static final String ID = "id";
    public static final String IMDBID = "imdb_id";
    public static final String TITULOORG = "tituo_original";
    public static final String TITULO = "tituo";
    public static final String SINOPSIS = "sinopsis";
    public static final String URLIMAGEN = "url_afiche";
    public static final String URLFONDO = "url_fondo";
    public static final String ADULTO = "adulto";
    public static final String POPULARIDAD = "popularidad";
    public static final String ESTRENO = "fecha_estreno";
    public static final String DURACION = "duracion";
    public static final String ESTADO = "estado";
    public static final String LEMA = "tagline";
    public static final String VIDEO = "video";
    public static final String PUNTUACION = "votos_promedio";
    public static final String CANTIDADVOTOS = "votos_cantidad";

    public DAODBPelicula(Context context) {
        super(context);
    }
}
