package com.example.edu.a0817moacn01c_3.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.edu.a0817moacn01c_3.Model.Pelicula;

import java.util.List;

/**
 * Created by ma on 13/11/17.
 */

public class DAODBPelicula extends DatabaseHelper {
    public static final String TABLENAME = "peliculas";

    +public static final String ID = "id";
    public static final String IMDBID = "imdb_id";
    public static final String TITULOORG = "tituo_original";
    +public static final String NOMBRE = "tituo";
    +public static final String SINOPSIS = "sinopsis";
    +public static final String URLAFICHE = "url_afiche";
    +public static final String URLFONDO = "url_fondo";
    public static final String ADULTO = "adulto";
    +public static final String POPULARIDAD = "popularidad";
    +public static final String ESTRENO = "fecha_estreno";
    +public static final String DURACION = "duracion";
    +public static final String ESTADO = "estado";
    public static final String LEMA = "tagline";
    public static final String VIDEO = "video";
    +public static final String PUNTUACION = "votos_promedio";
    +public static final String CANTIDADVOTOS = "votos_cantidad";

    public DAODBPelicula(Context context) {
        super(context);
    }

    public void agregarPelicula(Pelicula unaPelicula){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues row = new ContentValues();

        row.put(ID, unaPelicula.getId());
                row.put(IMDBID, unaPelicula
                        row.put(TITULOORG,
                                row.put(NOMBRE,
                                        row.put(SINOPSIS,
                                                row.put(URLAFICHE,
                                                        row.put(URLFONDO,
                                                                row.put(ADULTO,
                                                                        row.put(POPULARIDAD,
                                                                                row.put(ESTRENO,
                                                                                        row.put(DURACION,
                                                                                                row.put(ESTADO,
                                                                                                        row.put(LEMA,
                                                                                                                row.put(VIDEO,
                                                                                                                        row.put(PUNTUACION,
                                                                                                                                row.put(CANTIDADVOTOS,

        sqLiteDatabase.insert(TABLENAME, null, row);
        sqLiteDatabase.close();
    }
    public void agregarPeliculas(){}
    public List<Pelicula> obtenerTodasLasPeliculas(){}
}
