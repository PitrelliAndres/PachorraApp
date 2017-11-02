package com.example.edu.a0817moacn01c_3.DAO;

import android.content.Context;
import android.content.res.AssetManager;

import com.example.edu.a0817moacn01c_3.Model.ContenedorDeContenido;
import com.example.edu.a0817moacn01c_3.Model.Contenido;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by Andiy on 30/10/2017.
 */

public class DAOContenido {
    public List<Contenido> getListaDeContenidoFromArchivo(Context context){
        ContenedorDeContenido contenedorDeContenido = null;
        try {
            AssetManager manager = context.getAssets();
            InputStream productsJson = null;
            productsJson = manager.open("listadeproductos.json");
            BufferedReader bufferReaderIn = new BufferedReader(new InputStreamReader(productsJson));

            Gson gson = new Gson();
            contenedorDeContenido = gson.fromJson(bufferReaderIn, ContenedorDeContenido.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return contenedorDeContenido.getContenidos();
    }
}
