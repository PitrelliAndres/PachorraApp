package com.example.edu.a0817moacn01c_3;

/**
 * Created by ma on 17/10/17.
 */

public class Peliculas {
    private String nombre;
    private Integer imagen;
    private Integer imagenPortada;
    private String genero;
    private String desc;
    private Integer puntuacion;
    private String aptoParaPublico;

    public Peliculas(String nombre, Integer imagen, String genero, String desc,Integer puntuacion,String aptoParaPublico,Integer imagenPortada) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.genero = genero;
        this.desc = desc;
        this.puntuacion=puntuacion;
        this.aptoParaPublico=aptoParaPublico;
        this.imagenPortada=imagenPortada;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getImagen() {
        return imagen;
    }

    public String getGenero() {
        return genero;
    }

    public String getDesc() {
        return desc;
    }

    public Integer getImagenPortada() {
        return imagenPortada;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public String getAptoParaPublico() {
        return aptoParaPublico;
    }
}
