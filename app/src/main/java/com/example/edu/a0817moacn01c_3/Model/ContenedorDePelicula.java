package com.example.edu.a0817moacn01c_3.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Andiy on 30/10/2017.
 */

public class ContenedorDePelicula {
    @SerializedName("results")
    private List<Pelicula> contenidos;
    private String idLista;
    private String nombreLista;

    public ContenedorDePelicula(List<Pelicula> contenidos) {
        this.contenidos = contenidos;
    }

    public ContenedorDePelicula(List<Pelicula> contenidos, String idLista, String nombreLista) {
        this.contenidos = contenidos;
        this.idLista = idLista;
        this.nombreLista = nombreLista;
    }

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
