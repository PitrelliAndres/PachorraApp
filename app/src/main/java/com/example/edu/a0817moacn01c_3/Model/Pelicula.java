package com.example.edu.a0817moacn01c_3.Model;

import com.example.edu.a0817moacn01c_3.Model.Contenido;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ma on 17/10/17.
 */

public class Pelicula extends Contenido {
    @SerializedName("imdb_id")
    private String imdbid;
    @SerializedName("original_title")
    private String tituloorg;
    @SerializedName("adult")
    private Boolean adulto;
    @SerializedName("tagline")
    private String lema;
    @SerializedName("video")
    private String video;


    public Pelicula(){
        super.setTipoContenido(Contenido.PELICULA);
    }

    public Pelicula(Integer id, String nombre, String sinopsis, String urlafiche, String urlfondo, Double popularidad, String estreno, Integer duracion, String estado, Double puntuacion, Integer cantidadvotos) {
        super(id, nombre, sinopsis, urlafiche, urlfondo, popularidad, estreno, duracion, estado, puntuacion, cantidadvotos, Contenido.PELICULA);
        super.setTipoContenido(Contenido.PELICULA);
    }

    public Pelicula(Integer id, String nombre, String sinopsis, String urlafiche, String urlfondo, Double popularidad, String estreno, Integer duracion, String estado, Double puntuacion, Integer cantidadvotos, String imdbid, String tituloorg, Boolean adulto, String lema, String video) {
        super(id, nombre, sinopsis, urlafiche, urlfondo, popularidad, estreno, duracion, estado, puntuacion, cantidadvotos, Contenido.PELICULA);
        this.imdbid = imdbid;
        this.tituloorg = tituloorg;
        this.adulto = adulto;
        this.lema = lema;
        this.video = video;
        super.setTipoContenido(Contenido.PELICULA);
    }

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
        super.setTipoContenido(Contenido.PELICULA);
    }

    public void setImdbid(String imdbid) {
        this.imdbid = imdbid;
    }

    public String getImdbid() {
        if(imdbid == null){
            return "";
        }
        return imdbid;
    }

    public String getTituloorg() {
        return tituloorg;
    }

    public Boolean getAdulto() {
        if(adulto == null){adulto = false;}
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

    public String getAptoParaPublico() {
        String aptoPara = "";
        if (esAdulto()==true){
            aptoPara = "18+";
        }else{
            aptoPara = "ATP";
        }
        return aptoPara;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "imdbid='" + imdbid + '\'' +
                ", tituloorg='" + tituloorg + '\'' +
                ", adulto=" + adulto +
                ", lema='" + lema + '\'' +
                ", video='" + video + '\'' +
                "} " + super.toString();
    }
}
