package com.example.edu.a0817moacn01c_3.DAO;

import android.content.Context;

/**
 * Created by ma on 13/11/17.
 */

public class DAODBPelicula extends DatabaseHelper {
    public static final String TABLENAME = "peliculas";
    public static final String ID = "id";
    public static final String IMDBID = "imdb_id";
    public static final String TITULOORIGINAL = "tituo_original";
    public static final String SINOPSIS = "sinopsis";
    public static final String URLIMAGEN = "afiche_url";

    public DAODBPelicula(Context context) {
        super(context);
    }
}
