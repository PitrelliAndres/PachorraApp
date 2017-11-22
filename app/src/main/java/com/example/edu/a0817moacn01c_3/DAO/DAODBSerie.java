package com.example.edu.a0817moacn01c_3.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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
        }

        sqLiteDatabase.close();
    }

}
