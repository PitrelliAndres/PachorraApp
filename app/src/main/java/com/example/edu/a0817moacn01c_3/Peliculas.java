package com.example.edu.a0817moacn01c_3;

/**
 * Created by ma on 17/10/17.
 */

public class Peliculas extends Contenido{
    private Integer duracion;
    private String url;

    public Peliculas(Integer id,String nombre, Integer imagen, Integer imagenPortada, String genero, String desc, Double puntuacion, String aptoParaPublico,String tipoContenido) {
        super(id,nombre, imagen, imagenPortada, genero, desc, puntuacion, aptoParaPublico,tipoContenido);
        this.duracion = 0;
        this.url=null;
    }

    public Peliculas(Integer id,String nombre, Integer imagen, Integer imagenPortada, String genero, String desc, Double puntuacion, String aptoParaPublico, Integer duracion,String url,String tipoContenido) {
        super(id,nombre, imagen, imagenPortada, genero, desc, puntuacion, aptoParaPublico,tipoContenido);
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
