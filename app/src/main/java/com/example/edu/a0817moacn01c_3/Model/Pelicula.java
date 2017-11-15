package com.example.edu.a0817moacn01c_3.Model;

import com.example.edu.a0817moacn01c_3.Model.Contenido;

/**
 * Created by ma on 17/10/17.
 */

public class Pelicula extends Contenido {

    private String imdbid;
    private String tituloorg;
    private String adulto;
    private String lema;
    private String video;

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

    public Pelicula(){}

    public Pelicula(Integer id, String nombre, String sinopsis, String urlafiche, String urlfondo, Double popularidad, String estreno, Integer duracion, String estado, Double puntuacion, Integer cantidadvotos) {
        super(id, nombre, sinopsis, urlafiche, urlfondo, popularidad, estreno, duracion, estado, puntuacion, cantidadvotos, Contenido.PELICULA);
    }

    public Pelicula(Integer id, String nombre, String sinopsis, String urlafiche, String urlfondo, Double popularidad, String estreno, Integer duracion, String estado, Double puntuacion, Integer cantidadvotos, String imdbid, String tituloorg, String adulto, String lema, String video) {
        super(id, nombre, sinopsis, urlafiche, urlfondo, popularidad, estreno, duracion, estado, puntuacion, cantidadvotos, Contenido.PELICULA);
        this.imdbid = imdbid;
        this.tituloorg = tituloorg;
        this.adulto = adulto;
        this.lema = lema;
        this.video = video;
    }
}
