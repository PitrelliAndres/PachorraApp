package com.example.edu.a0817moacn01c_3;

/**
 * Created by Andy on 26/10/2017.
 */

public class Series extends Contenido{

    private Integer cantidadTemporada;
    private Integer cantidadCapitulos;

    public Series(Integer id,String nombre, Integer imagen, Integer imagenPortada, String genero, String desc, Double puntuacion, String aptoParaPublico, Integer cantidadTemporada, Integer cantidadCapitulos,Integer duracion,String tipo) {
        super(id,nombre, imagen, imagenPortada, genero, desc, puntuacion, aptoParaPublico,duracion,tipo);
        this.cantidadTemporada = cantidadTemporada;

        this.cantidadCapitulos = cantidadCapitulos;
    }

    public Integer getCantidadTemporada() {
        return cantidadTemporada;
    }



    public Integer getCantidadCapitulos() {
        return cantidadCapitulos;
    }
}
