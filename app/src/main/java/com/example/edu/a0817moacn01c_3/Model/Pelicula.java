package com.example.edu.a0817moacn01c_3.Model;

import com.example.edu.a0817moacn01c_3.Model.Contenido;

/**
 * Created by ma on 17/10/17.
 */

public class Pelicula extends Contenido {

    private String imdbid;
    private String tituloorg;
    private Boolean adulto;
    private String lema;
    private String video;


    public Pelicula(Contenido unContenido, String imdbid, String tituloOriginal, boolean esParaAdultos, String lema, String video) {
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
                imdbid, tituloOriginal, esParaAdultos, lema, video
        );
    }

    public String getImdbid() {
        return imdbid;
    }

    public String getTituloorg() {
        return tituloorg;
    }

    public Boolean getAdulto() {
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

    public Pelicula(){
        this.tipoContenido = Contenido.PELICULA;
    }

    public Pelicula(Integer id, String nombre, String sinopsis, String urlafiche, String urlfondo, Double popularidad, String estreno, Integer duracion, String estado, Double puntuacion, Integer cantidadvotos) {
        super(id, nombre, sinopsis, urlafiche, urlfondo, popularidad, estreno, duracion, estado, puntuacion, cantidadvotos, Contenido.PELICULA);
    }

    public Pelicula(Integer id, String nombre, String sinopsis, String urlafiche, String urlfondo, Double popularidad, String estreno, Integer duracion, String estado, Double puntuacion, Integer cantidadvotos, String imdbid, String tituloorg, Boolean adulto, String lema, String video) {
        super(id, nombre, sinopsis, urlafiche, urlfondo, popularidad, estreno, duracion, estado, puntuacion, cantidadvotos, Contenido.PELICULA);
        this.imdbid = imdbid;
        this.tituloorg = tituloorg;
        this.adulto = adulto;
        this.lema = lema;
        this.video = video;
    }

    public String getAptoParaPublico() {
        String aptoPara = "";
        if (esAdulto()==true){
            aptoPara = "18+";
        }else{
            aptoPara = "ATP";
        }
        return aptoPara;
    }
}
