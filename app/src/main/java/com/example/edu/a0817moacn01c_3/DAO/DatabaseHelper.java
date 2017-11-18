package com.example.edu.a0817moacn01c_3.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ma on 13/11/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASENAME="pachoDB";
    private static final Integer DATABASEVERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASENAME, null, DATABASEVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTablePeliculas = "CREATE TABLE " + DAODBPelicula.TABLENAME + " ("
                + DAODBPelicula.ID + " INTEGER PRIMARY KEY,"
                + DAODBPelicula.IMDBID + " TEXT, "
                + DAODBPelicula.TITULOORG + " TEXT, "
                + DAODBPelicula.NOMBRE + " TEXT, "
                + DAODBPelicula.SINOPSIS + " TEXT, "
                + DAODBPelicula.URLAFICHE + " TEXT, "
                + DAODBPelicula.URLFONDO + " TEXT, "
                + DAODBPelicula.ADULTO + " INTEGER, "
                + DAODBPelicula.POPULARIDAD + " REAL, "
                + DAODBPelicula.ESTRENO + " TEXT, "
                + DAODBPelicula.DURACION + " INTEGER, "
                + DAODBPelicula.ESTADO + " TEXT, "
                + DAODBPelicula.LEMA + " TEXT, "
                + DAODBPelicula.VIDEO + " TEXT, "
                + DAODBPelicula.PUNTUACION + " REAL, "
                + DAODBPelicula.CANTIDADVOTOS + " INTEGER)";

        String createTableGeneros = "CREATE TABLE " + DAODBGenero.TABLENAME + " ("
                + DAODBGenero.ID + " INTEGER PRIMARY KEY, "
                + DAODBGenero.NAME + "TEXT NOT NULL)";

        String createTableSeries = "CREATE TABLE " + DAODBSerie.TABLENAME + " ("
                + DAODBSerie.ID + " INTEGER PRIMARY KEY, "
                + DAODBSerie.NOMBRE + " TEXT, "
                + DAODBSerie.FECHAESTRENO + " TEXT, "
                + DAODBSerie.URLAFICHE + " TEXT, "
                + DAODBSerie.URLFONDO + " TEXT, "
                + DAODBSerie.ESTADO + " TEXT, "
                + DAODBSerie.TYPE + " TEXT, "
                + DAODBSerie.NROSEASONS + " INTEGER, "
                + DAODBSerie.NROEPISODES + " INTEGER, "
                + DAODBSerie.DURACION + " INTEGER, "
                + DAODBSerie.PUNTUACION + " REAL, "
                + DAODBSerie.CANTIDADVOTOS + " INTEGER, "
                + DAODBSerie.CANALTV + " TEXT, "
                + DAODBSerie.SINOPSIS + " TEXT, "
                + DAODBSerie.POPULARIDAD + " REAL)";

        db.execSQL(createTablePeliculas);
        db.execSQL(createTableSeries);
        db.execSQL(createTableGeneros);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
