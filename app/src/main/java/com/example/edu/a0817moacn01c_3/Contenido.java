package com.example.edu.a0817moacn01c_3;

/**
 * Created by Andy on 26/10/2017.
 */

public class Contenido {
    private String nombre;
    private Integer imagen;
    private Integer imagenPortada;
    private String genero;
    private String desc;
    private Double puntuacion;
    private String aptoParaPublico;
    private String tipoContenido;


    public Contenido(String nombre, Integer imagen, Integer imagenPortada, String genero, String desc, Double puntuacion, String aptoParaPublico) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.imagenPortada = imagenPortada;
        this.genero = genero;
        this.desc = desc;
        this.puntuacion = puntuacion;
        this.aptoParaPublico = aptoParaPublico;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getImagen() {
        return imagen;
    }

    public Integer getImagenPortada() {
        return imagenPortada;
    }

    public String getGenero() {
        return genero;
    }

    public String getDesc() {
        return desc;
    }

    public Double getPuntuacion() {
        return puntuacion;
    }

    public String getAptoParaPublico() {
        return aptoParaPublico;
    }
}
