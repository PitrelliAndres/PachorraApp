package com.example.edu.a0817moacn01c_3.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.edu.a0817moacn01c_3.Model.Pelicula;
import com.example.edu.a0817moacn01c_3.Model.Serie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ma on 13/11/17.
 */

public class DAODBSerie extends DatabaseHelper {
    public static final String TABLENAME = "series";

    public static final String ID = "id";
    public static final String NOMBRE = "nombre";
    public static final String FECHAESTRENO = "fecha_estreno";
    public static final String URLAFICHE = "urlAfiche";
    public static final String URLFONDO = "urlFondo";
    public static final String ESTADO = "status";
    public static final String TYPE = "type";
    public static final String NROSEASONS = "nroSeasons";
    public static final String NROEPISODES = "nroEpisodes";
    public static final String DURACION = "duracion";
    public static final String PUNTUACION = "promediopuntuacion";
    public static final String CANTIDADVOTOS = "cantidadVotos";
    public static final String CANALTV = "canaltv";
    public static final String SINOPSIS = "sinopsis";
    public static final String POPULARIDAD = "popularidad";

    public DAODBSerie(Context context) {
        super(context);
    }

    public void agregarSerie(Serie unaSerie) {
        List<Serie> listaDeUnaSerie = new ArrayList<>();
        listaDeUnaSerie.add(unaSerie);
        agregarSeries(listaDeUnaSerie);
    }

    public void agregarSeries(List<Serie> listaSeries) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        for (Serie unaSerie : listaSeries) {
            Boolean esNueva = !yaExiste(TABLENAME, ID, unaSerie.getId().toString());
            ContentValues row = new ContentValues();
            row.put(ID, unaSerie.getId());
            row.put(NOMBRE, unaSerie.getNombre());
            row.put(FECHAESTRENO, unaSerie.getEstreno());
            row.put(URLAFICHE, unaSerie.getUrlafiche());
            row.put(URLFONDO, unaSerie.getUrlfondo());
            row.put(ESTADO, unaSerie.getEstado());
            row.put(TYPE, unaSerie.getType());
            row.put(NROSEASONS, unaSerie.getNroSeasons());
            row.put(NROEPISODES, unaSerie.getNroEpisodios());
            row.put(DURACION, unaSerie.getDuracion());
            row.put(PUNTUACION, unaSerie.getPuntuacion());
            row.put(CANTIDADVOTOS, unaSerie.getCantidadvotos());
            row.put(CANALTV, unaSerie.getCanalTV());
            row.put(SINOPSIS, unaSerie.getSinopsis());
            row.put(POPULARIDAD, unaSerie.getPopularidad());
            sqLiteDatabase.insert(TABLENAME, null, row);
            if (esNueva) {
                sqLiteDatabase.insert(TABLENAME, null, row);
            } else {
                sqLiteDatabase.update(TABLENAME, row, ID + "=?", new String[]{unaSerie.getId().toString()});
            }
        }

        sqLiteDatabase.close();
    }

    public List<Serie> obtenerTodasLasSeries() {
        List<Serie> listaSeries = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "SELECT * FROM " + TABLENAME + ";";
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        while (cursor.moveToNext()) {
            // Creamos el objeto Serie que vamos a agregar a la lista

            listaSeries.add(cursorASerie(cursor));
        }
        cursor.close();
        sqLiteDatabase.close();
        return listaSeries;
    }

    public List<Serie> obtenerSeriesPopulares() {
        return obtenerSeriesPopulares(null);
    }

    public List<Serie> obtenerSeriesPopulares(Integer limite) {
        String filtroLimite = "";
        if (limite != null) {
            filtroLimite = " LIMIT " + limite.toString();
        }
        List<Serie> listaSeries = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "SELECT * FROM " + TABLENAME + " ORDER BY " + POPULARIDAD + " DESC" + filtroLimite + ";";
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        while (cursor.moveToNext()) {
            // Creamos el objeto Serie que vamos a agregar a la lista
            listaSeries.add(cursorASerie(cursor));
        }
        cursor.close();
        sqLiteDatabase.close();
        return listaSeries;
    }

    public Serie obtenerSeriePorID(Integer unID) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "SELECT * FROM " + TABLENAME + " WHERE " + ID + "=" + unID + ";";
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        cursor.moveToFirst();
        // Creamos el objeto Serie que vamos a agregar a la lista
        return cursorASerie(cursor);
    }

    public List<Serie> obtenerSeriesFiltradas(String genero, String tipoContenido, Integer fecha) {
        List<Serie> listaSeries = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        String query = "SELECT * FROM "+TABLENAME+
                " WHERE " + FECHAESTRENO + " LIKE '%" + fecha.toString() + "%';"
                ;
        /*
        String query = "SELECT s.*, g."+DAODBGeneroSerie.NAME+" FROM "+TABLENAME+ " s, " + DAODBGeneroSerie.TABLENAME + " g " +
                "WHERE g." + DAODBGeneroSerie.ID +" = s."+ID +
                " AND g." + DAODBGeneroSerie.NAME +" = '"+ genero +"'" +
                " AND s." + FECHAESTRENO + " LIKE '" + fecha.toString() + "%';"
                ;
        */
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        while (cursor.moveToNext()) {
            // Creamos el objeto Serie que vamos a agregar a la lista
            listaSeries.add(cursorASerie(cursor));
        }
        cursor.close();
        sqLiteDatabase.close();
        Log.d("Query",query);
        return listaSeries;
    }


    public Serie cursorASerie(Cursor cursor) {
        Serie unaSerie = new Serie(
                cursor.getInt(cursor.getColumnIndex(ID)),
                cursor.getString(cursor.getColumnIndex(NOMBRE)),
                cursor.getString(cursor.getColumnIndex(SINOPSIS)),
                cursor.getString(cursor.getColumnIndex(URLAFICHE)),
                cursor.getString(cursor.getColumnIndex(URLFONDO)),
                cursor.getDouble(cursor.getColumnIndex(POPULARIDAD)),
                cursor.getString(cursor.getColumnIndex(FECHAESTRENO)),
                cursor.getInt(cursor.getColumnIndex(DURACION)),
                cursor.getString(cursor.getColumnIndex(ESTADO)),
                cursor.getDouble(cursor.getColumnIndex(PUNTUACION)),
                cursor.getInt(cursor.getColumnIndex(CANTIDADVOTOS)),
                cursor.getString(cursor.getColumnIndex(TYPE)),
                cursor.getInt(cursor.getColumnIndex(NROSEASONS)),
                cursor.getInt(cursor.getColumnIndex(NROEPISODES)),
                cursor.getString(cursor.getColumnIndex(CANALTV))
        );
        return unaSerie;
    }
}
