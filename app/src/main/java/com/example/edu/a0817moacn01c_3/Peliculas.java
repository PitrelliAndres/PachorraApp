package com.example.edu.a0817moacn01c_3;

/**
 * Created by ma on 17/10/17.
 */

public class Peliculas {
    private String nombre;
    private Integer imagen;
    private String genero;
    private String desc;

    public Peliculas(String nombre, Integer imagen, String genero, String desc) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.genero = genero;
        this.desc = desc;
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
}
