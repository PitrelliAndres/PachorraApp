package com.example.edu.a0817moacn01c_3.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.edu.a0817moacn01c_3.Model.Pelicula;
import com.example.edu.a0817moacn01c_3.Model.Serie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ma on 13/11/17.
 */

public class DAODBPelicula extends DatabaseHelper {
    public static final String TABLENAME = "peliculas";

    public static final String ID = "id";
    public static final String IMDBID = "imdb_id";
    public static final String TITULOORG = "tituo_original";
    public static final String NOMBRE = "tituo";
    public static final String SINOPSIS = "sinopsis";
    public static final String URLAFICHE = "url_afiche";
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

    public void agregarPelicula(Pelicula unaPelicula) {
        List<Pelicula> listaDeUnaPelicula = new ArrayList<>();
        listaDeUnaPelicula.add(unaPelicula);
        agregarPeliculas(listaDeUnaPelicula);
    }

    public void agregarPeliculas(List<Pelicula> listaPeliculas) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        for (Pelicula unaPelicula : listaPeliculas) {
            Boolean esNueva = !yaExiste(TABLENAME, ID, unaPelicula.getId().toString());
            ContentValues row = new ContentValues();
            row.put(ID, unaPelicula.getId());
            row.put(TITULOORG, unaPelicula.getTituloorg());
            row.put(NOMBRE, unaPelicula.getNombre());
            row.put(SINOPSIS, unaPelicula.getSinopsis());
            row.put(URLAFICHE, unaPelicula.getUrlafiche());
            row.put(URLFONDO, unaPelicula.getUrlfondo());
            row.put(ADULTO, unaPelicula.esAdulto());
            row.put(POPULARIDAD, unaPelicula.getPopularidad());
            row.put(ESTRENO, unaPelicula.getEstreno());
            row.put(DURACION, unaPelicula.getDuracion());
            row.put(ESTADO, unaPelicula.getEstado());
            row.put(LEMA, unaPelicula.getLema());
            row.put(VIDEO, unaPelicula.getVideo());
            row.put(PUNTUACION, unaPelicula.getPuntuacion());
            row.put(CANTIDADVOTOS, unaPelicula.getCantidadvotos());
            row.put(IMDBID, unaPelicula.getImbdid());
            if (esNueva) {
                sqLiteDatabase.insert(TABLENAME, null, row);
            } else {
                sqLiteDatabase.update(TABLENAME, row, ID + "=?", new String[]{unaPelicula.getId().toString()});
            }
        }

        sqLiteDatabase.close();
    }

    public List<Pelicula> obtenerTodasLasPeliculas() {
        List<Pelicula> listaPeliculas = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "SELECT * FROM " + TABLENAME + ";";
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        while (cursor.moveToNext()) {
            listaPeliculas.add(cursorAPelicula(cursor));
        }
        cursor.close();
        sqLiteDatabase.close();

        return listaPeliculas;
    }

    public List<Pelicula> obtenerPeliculasPopulares() {
        return obtenerPeliculasPopulares(null);
    }

    public List<Pelicula> obtenerPeliculasPopulares(Integer limite) {
        String filtroLimite = "";
        if (limite != null) {
            filtroLimite = " LIMIT " + limite.toString();
        }
        List<Pelicula> listaPeliculas = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "SELECT * FROM " + TABLENAME + " ORDER BY " + POPULARIDAD + " DESC" + filtroLimite + ";";
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        while (cursor.moveToNext()) {
            listaPeliculas.add(cursorAPelicula(cursor));
        }
        cursor.close();
        sqLiteDatabase.close();

        return listaPeliculas;
    }

    public List<Pelicula> obtenerPeliculaPorID(List<Integer> listaIDs){
        List<Pelicula> listaPeliculas = new ArrayList<>();
        SQLiteDatabase sqliteDatabase = getReadableDatabase();
        String ids = "";
        for (Integer ID:listaIDs) {
            ids += ID + ",";
        }
        if(ids.length()>0) {
            ids = ids.substring(0, ids.length() - 1);
            String query = "SELECT * FROM " + TABLENAME + " WHERE " + ID + " IN(" + ids + ");";
            Cursor cursor = sqliteDatabase.rawQuery(query, null);
            while (cursor.moveToNext()) {
                listaPeliculas.add(cursorAPelicula(cursor));
            }
        }
        return listaPeliculas;
    }

    public Pelicula obtenerPeliculaPorID(Integer unID) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "SELECT * FROM " + TABLENAME + " WHERE " + ID + "=" + unID + ";";
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        cursor.moveToFirst();
        // Creamos el objeto Serie que vamos a agregar a la lista
        return cursorAPelicula(cursor);
    }

    private Pelicula cursorAPelicula(Cursor cursor) {
        Pelicula unaPelicula = new Pelicula(
                cursor.getInt(cursor.getColumnIndex(ID)),
                cursor.getString(cursor.getColumnIndex(NOMBRE)),
                cursor.getString(cursor.getColumnIndex(SINOPSIS)),
                cursor.getString(cursor.getColumnIndex(URLAFICHE)),
                cursor.getString(cursor.getColumnIndex(URLFONDO)),
                cursor.getDouble(cursor.getColumnIndex(POPULARIDAD)),
                cursor.getString(cursor.getColumnIndex(ESTRENO)),
                cursor.getInt(cursor.getColumnIndex(DURACION)),
                cursor.getString(cursor.getColumnIndex(ESTADO)),
                cursor.getDouble(cursor.getColumnIndex(PUNTUACION)),
                cursor.getInt(cursor.getColumnIndex(CANTIDADVOTOS)),
                cursor.getString(cursor.getColumnIndex(TITULOORG)),
                (cursor.getInt(cursor.getColumnIndex(ADULTO)) == 1),
                cursor.getString(cursor.getColumnIndex(LEMA)),
                cursor.getString(cursor.getColumnIndex(VIDEO)),
                cursor.getString(cursor.getColumnIndex(IMDBID))

        );
        return unaPelicula;
    }

    public List<Pelicula> obtenerPeliculasFiltradas(String genero, Integer fecha) {
        List<Pelicula> lista = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        String query = "SELECT * FROM " + TABLENAME +
                " WHERE " + ESTRENO + " LIKE '%" + fecha.toString() + "%';";

        /*
        String query = "SELECT s.*, g."+DAODBGenero.NAME+" FROM "+TABLENAME+ " s, " + DAODBGenero.TABLENAME + " g " +
                "WHERE g." + DAODBGenero.ID +" = s."+ID +
                " AND g." + DAODBGenero.NAME +" = '"+ genero +"'" +
                " AND s." + ESTRENO + " LIKE '" + fecha.toString() + "%';"
                ;
        */

        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        while (cursor.moveToNext()) {
            lista.add(cursorAPelicula(cursor));
        }
        cursor.close();
        sqLiteDatabase.close();
        Log.d("Query", query);
        return lista;
    }
}

