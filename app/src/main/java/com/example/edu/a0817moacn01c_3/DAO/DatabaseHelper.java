package com.example.edu.a0817moacn01c_3.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ma on 13/11/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASENAME="pachoDB";
    private static final Integer DATABASEVERSION = 2;
    SQLiteDatabase db;

    public DatabaseHelper(Context context) {
        super(context, DATABASENAME, null, DATABASEVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        List<String> tablasACrear = new ArrayList<>();
        tablasACrear.add("CREATE TABLE " + DAODBPelicula.TABLENAME + " ("
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
                + DAODBPelicula.CANTIDADVOTOS + " INTEGER)");

        tablasACrear.add("CREATE TABLE " + DAODBGenero.TABLENAME + " ("
                + DAODBGenero.ID + " INTEGER PRIMARY KEY, "
                + DAODBGenero.NAME + "TEXT NOT NULL)");

        tablasACrear.add("CREATE TABLE " + DAODBSerie.TABLENAME + " ("
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
                + DAODBSerie.POPULARIDAD + " REAL)");

        tablasACrear.add("CREATE TABLE " + DAODBLista.TABLENAME + " ("
                + DAODBLista.ID + " TEXT PRIMARY KEY, "
                + DAODBLista.NOMBRE + " TEXT, "
                + DAODBLista.TIPOCONTENIDO + " TEXT NOT NULL)");

         tablasACrear.add("CREATE TABLE " + DAODBListaContenido.TABLENAME + " ("
                 + DAODBListaContenido.IDLISTA + " TEXT, "
                 + DAODBListaContenido.IDITEM  + " INTEGER NOT NULL,"
                 + " PRIMARY KEY (" + DAODBListaContenido.IDLISTA + ", " + DAODBListaContenido.IDITEM + ")"
                 + ")");

        iniciarTablasBD(tablasACrear);

    }

    private void iniciarTablasBD(List<String> lista){
        for (String crearTable : lista) {
            db.execSQL(crearTable);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public Boolean yaExiste(String nombreTabla, String nombreCampoID, String valorID){
       SQLiteDatabase database = getReadableDatabase();

        String query = "SELECT " + nombreCampoID
                + " FROM " + nombreTabla
                + " WHERE " + nombreCampoID + "= '" + valorID + "';";

        Cursor result;

        Integer count = null;
        try {
            result = database.rawQuery(query, null);
            count = result.getCount();
        } catch (Exception e) {
            e.printStackTrace();
            count = 0;
        }
        finally {
            //      database.close();
            return (count > 0);
        }
    }

}
