package com.example.edu.a0817moacn01c_3.DAO;

import android.content.Context;

/**
 * Created by ma on 13/11/17.
 */

public class DAODBSerie extends DatabaseHelper{
    public static final String TABLENAME="series";

    public static final String ID="id";
    public static final String NOMBRE="nombre";
    public static final String FECHAESTRENO="fecha_estreno";
    public static final String URLAFICHE="urlAfiche";
    public static final String URLFONDO="urlFondo";
    public static final String ESTADO="status";
    public static final String TYPE="type";
    public static final String NROSEASONS="nroSeasons";
    public static final String NROEPISODES="nroEpisodes";
    public static final String DURACION = "duracion";
    public static final String PUNTUACION = "promediopuntuacion";
    public static final String CANTIDADVOTOS = "cantidadVotos";
    public static final String CANALTV="canaltv";
    public static final String SINOPSIS = "sinopsis";
    public static final String POPULARIDAD= "popularidad";

    public DAODBSerie(Context context) {
        super(context);
    }

}
