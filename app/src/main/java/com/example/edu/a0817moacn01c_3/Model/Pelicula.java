package com.example.edu.a0817moacn01c_3.Model;

import com.example.edu.a0817moacn01c_3.Model.Contenido;

/**
 * Created by ma on 17/10/17.
 */

public class Pelicula extends Contenido {

    private String imdbid;
    private String tituloorg = "tituo_original";
    private String adulto = "adulto";
    private String lema = "tagline";
    private String video = "video";

    public String getImdbid() {
        return imdbid;
    }

    public String getTituloorg() {
        return tituloorg;
    }

    public String getAdulto() {
        return adulto;
    }

    public String getLema() {
        return lema;
    }

    public String getVideo() {
        return video;
    }

    public Boolean tieneVideo(){
        if(getVideo()=="false"||getVideo()=="0"){
            return false;
        }
        return true;
    }

    public Boolean esAdulto(){
        if(getVideo()=="true"||getVideo()=="1"){
            return true;
        }
        return false;
    }

    public Pelicula(Integer id, String nombre, String sinopsis, String urlafiche, String urlfondo, Double popularidad, String estreno, Integer duracion, String estado, Double puntuacion, Integer cantidadvotos) {
        super(id, nombre, sinopsis, urlafiche, urlfondo, popularidad, estreno, duracion, estado, puntuacion, cantidadvotos, Contenido.PELICULA);
    }
}
