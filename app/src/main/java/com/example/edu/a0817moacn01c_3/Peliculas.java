package com.example.edu.a0817moacn01c_3;

/**
 * Created by ma on 17/10/17.
 */

public class Peliculas extends Contenido{
    private String url;

    public Peliculas(Integer id,String nombre, Integer imagen, Integer imagenPortada, String genero, String desc, Double puntuacion, String aptoParaPublico,Integer duracion,String tipoContenido) {
        super(id,nombre, imagen, imagenPortada, genero, desc, puntuacion, aptoParaPublico,duracion,tipoContenido);

        this.url=null;
    }

    public Peliculas(Integer id,String nombre, Integer imagen, Integer imagenPortada, String genero, String desc, Double puntuacion, String aptoParaPublico, Integer duracion,String url,String tipoContenido) {
        super(id,nombre, imagen, imagenPortada, genero, desc, puntuacion, aptoParaPublico,duracion,tipoContenido);

        this.url=url;
    }


    public String getUrl() {
        return url;
    }
}
