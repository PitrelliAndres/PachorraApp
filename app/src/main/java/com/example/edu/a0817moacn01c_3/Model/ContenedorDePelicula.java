package com.example.edu.a0817moacn01c_3.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Andiy on 30/10/2017.
 */

public class ContenedorDePelicula {
    @SerializedName("results")
    List<Pelicula> contenidos;


    public List<Pelicula> getContenidos(){
        for (Pelicula unaPelicula : contenidos) {
            unaPelicula.setTipoContenido(Contenido.PELICULA);
        }
        return contenidos;
    }

    public void setContenidos(List<Pelicula> listaContenidos) {
        this.contenidos = listaContenidos;
    }
}
