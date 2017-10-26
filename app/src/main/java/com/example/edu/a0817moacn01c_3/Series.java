package com.example.edu.a0817moacn01c_3;

/**
 * Created by Andy on 26/10/2017.
 */

public class Series extends Contenido{

    private Integer cantidadTemporada;
    private Integer duracionEpisodio;
    private Integer cantidadCapitulos;

    public Series(Integer id,String nombre, Integer imagen, Integer imagenPortada, String genero, String desc, Double puntuacion, String aptoParaPublico, Integer cantidadTemporada, Integer duracionEpisodio, Integer cantidadCapitulos,String tipo) {
        super(id,nombre, imagen, imagenPortada, genero, desc, puntuacion, aptoParaPublico,tipo);
        this.cantidadTemporada = cantidadTemporada;
        this.duracionEpisodio = duracionEpisodio;
        this.cantidadCapitulos = cantidadCapitulos;
    }

    public Integer getCantidadTemporada() {
        return cantidadTemporada;
    }

    public Integer getDuracionEpisodio() {
        return duracionEpisodio;
    }

    public Integer getCantidadCapitulos() {
        return cantidadCapitulos;
    }
}
