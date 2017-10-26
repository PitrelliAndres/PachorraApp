package com.example.edu.a0817moacn01c_3;

/**
 * Created by ma on 17/10/17.
 */

public class Peliculas extends Contenido{
    private Integer duracion;
    private String url;

    public Peliculas(String nombre, Integer imagen, Integer imagenPortada, String genero, String desc, Double puntuacion, String aptoParaPublico, Integer duracion,String url) {
        super(nombre, imagen, imagenPortada, genero, desc, puntuacion, aptoParaPublico);
        this.duracion = duracion;
        this.url=url;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public String getUrl() {
        return url;
    }
}
