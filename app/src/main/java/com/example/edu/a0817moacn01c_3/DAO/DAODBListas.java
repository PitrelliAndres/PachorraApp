package com.example.edu.a0817moacn01c_3.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.edu.a0817moacn01c_3.Model.ContenedorDePelicula;
import com.example.edu.a0817moacn01c_3.Model.ContenedorDeSerie;
import com.example.edu.a0817moacn01c_3.Model.Contenido;
import com.example.edu.a0817moacn01c_3.Model.Lista;

/**
 * Created by Administrador on 26/11/2017.
 */

public class DAODBListas<T> extends DatabaseHelper {
    public static final String TABLENAME = "listas";

    public static final String ID = "id";
    public static final String NOMBRE = "nombre";
    public static final String TIPOCONTENIDO = "tipo_de_items";

    public DAODBListas(Context context) {
        super(context);
    }

    public void crearLista(String idLista, String nombre, String tipoContenido) {
        if (yaExiste(TABLENAME, ID, idLista)){ return; }
        SQLiteDatabase db = getWritableDatabase();
        ContentValues row = new ContentValues();
        row.put(ID, idLista);
        row.put(NOMBRE, nombre);
        row.put(TIPOCONTENIDO, tipoContenido);
        db.insert(TABLENAME, null, row);
        db.close();
    }

    public Lista obtenerListaPorID(String idLista){
        Lista lista;
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT " + NOMBRE + ", " + TIPOCONTENIDO + " FROM " + TABLENAME + " WHERE " + ID + "='" + idLista + "';";
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        lista = new Lista(idLista,
                cursor.getString(cursor.getColumnIndex(NOMBRE)),
                cursor.getString(cursor.getColumnIndex(TIPOCONTENIDO))
                );
        db.close();
        return lista;
    }



}
