package com.example.edu.a0817moacn01c_3.Model;

import com.example.edu.a0817moacn01c_3.Model.Contenido;

/**
 * Created by Andy on 26/10/2017.
 */

public class Serie extends Contenido {

    private Integer cantidadTemporadas;
    private Integer cantidadCapitulos;

    public Serie(Integer id, String nombre, String sinopsis, String urlafiche, String urlfondo, Double popularidad, String estreno, Integer duracion, String estado, Double puntuacion, Integer cantidadvotos, String tipoContenido, Integer cantidadTemporadas, Integer cantidadCapitulos) {
        super(id, nombre, sinopsis, urlafiche, urlfondo, popularidad, estreno, duracion, estado, puntuacion, cantidadvotos, tipoContenido);
        this.cantidadTemporadas = cantidadTemporadas;
        this.cantidadCapitulos = cantidadCapitulos;
    }

/*    public Serie(Contenido unContenido, Integer unaCantidadTemporadas, Integer unaCantidadCapitulos) {
        this(unContenido.getId(),
                unContenido.getNombre(),
                unContenido.getImagen(),
                unContenido.getImagenPortada(),
                unContenido.getGenero(),
                unContenido.getDesc(),
                unContenido.getPuntuacion(),
                unContenido.getAptoParaPublico(),
                unaCantidadTemporadas,
                unaCantidadCapitulos
        );
    }*/

    public Integer getCantidadTemporadas() {
        return cantidadTemporadas;
    }


    public Integer getCantidadCapitulos() {
        return cantidadCapitulos;
    }
}
