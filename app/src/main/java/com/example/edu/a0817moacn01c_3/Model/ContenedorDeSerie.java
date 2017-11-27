package com.example.edu.a0817moacn01c_3.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Andiy on 30/10/2017.
 */

public class ContenedorDeSerie {
    @SerializedName("results")
    List<Serie> contenidos;
    private String idLista;
    private String nombreLista;

    public ContenedorDeSerie(List<Serie> contenidos) {
        this.contenidos = contenidos;
    }

    public ContenedorDeSerie(List<Serie> contenidos, String idLista, String nombreLista) {
        this.contenidos = contenidos;
        this.idLista = idLista;
        this.nombreLista = nombreLista;
    }

    public List<Serie> getContenidos(){
        return contenidos;
    }
    public void setContenidos(List<Serie> listaContenidos) {
        this.contenidos = listaContenidos;
    }
}
