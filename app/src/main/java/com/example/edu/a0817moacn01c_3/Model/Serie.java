package com.example.edu.a0817moacn01c_3.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Andy on 26/10/2017.
 */

public class Serie extends Contenido {
    private String type;
    @SerializedName("number_of_seasons") private Integer nroSeasons;
    @SerializedName("number_of_episodes") private Integer nroEpisodios;
    @SerializedName("networks") private String canalTV;

    public Serie(){
        this.tipoContenido = Contenido.SERIE;
    }

    public Serie(Integer id, String nombre, String sinopsis, String urlafiche, String urlfondo, Double popularidad, String estreno, Integer duracion, String estado, Double puntuacion, Integer cantidadvotos, String type, Integer cantidadTemporadas, Integer cantidadCapitulos, String canalTV) {
        super(id, nombre, sinopsis, urlafiche, urlfondo, popularidad, estreno, duracion, estado, puntuacion, cantidadvotos, Contenido.SERIE);
        this.type = type;
        this.nroSeasons = cantidadTemporadas;
        this.nroEpisodios = cantidadCapitulos;
        this.canalTV = canalTV;
    }

    public Serie(Contenido unContenido, String type, Integer nroSeasons, Integer nroEpisodes, String canalTV) {
        this(
                unContenido.getId(),
                unContenido.getNombre(),
                unContenido.getSinopsis(),
                unContenido.getUrlafiche(),
                unContenido.getUrlfondo(),
                unContenido.getPopularidad(),
                unContenido.getEstreno(),
                unContenido.getDuracion(),
                unContenido.getEstado(),
                unContenido.getPuntuacion(),
                unContenido.getCantidadvotos(),
                type, nroSeasons, nroEpisodes, canalTV
        );
    }

    public String getType() {
        return type;
    }

    public String getCanalTV() {
        return canalTV;
    }

    public Integer getNroSeasons() {
        return nroSeasons;
    }


    public Integer getNroEpisodios() {
        return nroEpisodios;
    }
}
