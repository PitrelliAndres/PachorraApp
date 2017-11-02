package com.example.edu.a0817moacn01c_3.Model;

import com.example.edu.a0817moacn01c_3.Model.Contenido;

/**
 * Created by ma on 17/10/17.
 */

public class Pelicula extends Contenido {
    private String url;

    public Pelicula(Integer id, String nombre, Integer imagen, Integer imagenPortada, String genero, String desc, Double puntuacion, String aptoParaPublico, Integer duracion) {
        super(id, nombre, imagen, imagenPortada, genero, desc, puntuacion, aptoParaPublico, duracion, Contenido.PELICULA);

        this.url = null;
    }

    public Pelicula(Integer id, String nombre, Integer imagen, Integer imagenPortada, String genero, String desc, Double puntuacion, String aptoParaPublico, Integer duracion, String url) {
        super(id, nombre, imagen, imagenPortada, genero, desc, puntuacion, aptoParaPublico, duracion, Contenido.PELICULA);
        this.url = url;
    }

    public Pelicula(Contenido unContenido, String unaUrl) {
        this(unContenido.getId(),
                unContenido.getNombre(),
                unContenido.getImagen(),
                unContenido.getImagenPortada(),
                unContenido.getGenero(),
                unContenido.getDesc(),
                unContenido.getPuntuacion(),
                unContenido.getAptoParaPublico(),
                unContenido.getDuracion(),
                unaUrl);
    }


    public String getUrl() {
        return url;
    }
}
