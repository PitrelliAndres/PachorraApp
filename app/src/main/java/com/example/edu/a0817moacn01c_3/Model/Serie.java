package com.example.edu.a0817moacn01c_3.Model;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Andy on 26/10/2017.
 */

public class Serie extends Contenido implements Serializable{
    private String type;
    @SerializedName("number_of_seasons") private Integer nroSeasons;
    @SerializedName("number_of_episodes") private Integer nroEpisodios;
    @SerializedName("networks") private String canalTV;

    public Serie(){
        super.setTipoContenido(Contenido.SERIE);
        tipoContenido = Contenido.SERIE;
    }

    public Serie(Integer id, String nombre, String sinopsis, String urlafiche, String urlfondo, Double popularidad, String estreno, Integer duracion, String estado, Double puntuacion, Integer cantidadvotos, String type, Integer cantidadTemporadas, Integer cantidadCapitulos, String canalTV) {
        super(id, nombre, sinopsis, urlafiche, urlfondo, popularidad, estreno, duracion, estado, puntuacion, cantidadvotos, Contenido.SERIE);
        this.type = type;
        this.nroSeasons = cantidadTemporadas;
        this.nroEpisodios = cantidadCapitulos;
        this.canalTV = canalTV;
        super.setTipoContenido(Contenido.SERIE);
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
        super.setTipoContenido(Contenido.SERIE);
    }

    public String getType() {
        return type;
    }

    public String getCanalTV() {
        return canalTV;
    }

    public Integer getNroSeasons() {
        if(nroSeasons == null){
            return 3;
        }
        return nroSeasons;
    }

    public Integer getNroEpisodios() {
        if(nroEpisodios == null){
            return 10;
        }
        return nroEpisodios;
    }

    @Override
    public Boolean esSerie() {
        return true;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "type='" + type + '\'' +
                ", nroSeasons=" + nroSeasons +
                ", nroEpisodios=" + nroEpisodios +
                ", canalTV='" + canalTV + '\'' +
                "} " + super.toString();
    }
}
