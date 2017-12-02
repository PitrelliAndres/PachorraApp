package com.example.edu.a0817moacn01c_3.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrador on 26/11/2017.
 */

public class DAODBListaContenido extends DatabaseHelper{
    // para la tabla que une serie o pelicula con un id de lista (relacion muchos a muchos entre listas y contenidos)
    public static final String TABLENAME = "listas_contenidos";
    public static final String IDLISTA = "id_lista";
    public static final String IDITEM = "id_contenido";

    public DAODBListaContenido(Context context) {
        super(context);
    }

    public void sobreescribirLista(String idLista, List<Integer> items){
        SQLiteDatabase db = getWritableDatabase();
        // Borrar todos y agregar los nuevos
        db.delete(TABLENAME, IDLISTA + "='?'", new String[]{idLista});
        for (Integer item : items) {
            ContentValues row = new ContentValues();
            row.put(IDLISTA, idLista);
            row.put(IDITEM, item);
            db.insert(TABLENAME, null, row);
        }
        db.close();
    }

    public void agregarItemALista(String idLista, Integer idItem){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues row = new ContentValues();
        row.put(IDLISTA, idLista);
        row.put(IDITEM, idItem);
        if(yaExiste(idLista, idItem)){
            db.update(TABLENAME,row,IDLISTA+"='"+idLista+"' AND "+IDITEM+"="+idItem+";",null);
        }else {
            db.insert(TABLENAME, null, row);
        }
        db.close();
    }

    public List<Integer> obtenerListaDeContenidosPorID(String idLista){
        List<Integer> listaItems = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT " + IDITEM + " FROM " + TABLENAME + " WHERE " + IDLISTA + "='" + idLista + "';";
        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext()) {
            listaItems.add(cursor.getInt(cursor.getColumnIndex(IDITEM)));
        }
        cursor.close();
        db.close();
        return listaItems;
    }

    public Boolean yaExiste(String listaID, Integer itemID) {
            SQLiteDatabase database = getReadableDatabase();

            String query = "SELECT " + IDLISTA + ", " + IDITEM
                    + " FROM " + TABLENAME
                    + " WHERE " + IDLISTA + "= '" + listaID
                    + "' AND " + IDITEM + " = '" + itemID + "';";

            Cursor result = database.rawQuery(query, null);
            Integer count = result.getCount();
            //      database.close();
            return (count > 0);
    }
}
