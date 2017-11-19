package com.example.edu.a0817moacn01c_3.Model;

import android.util.Log;

import com.example.edu.a0817moacn01c_3.Model.Contenido;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ma on 17/10/17.
 */

public class Pelicula extends Contenido {
    @SerializedName("original_title")
    private String tituloorg;
    @SerializedName("tagline")
    private String lema;
    @SerializedName("video")
    private String video;
    @SerializedName("imdb_id")
    private String imbdid;


    public Pelicula(){
        super.setTipoContenido(Contenido.PELICULA);
        Log.v("Un valor",Contenido.PELICULA);
    }

    public Pelicula(Integer id, String nombre, String sinopsis, String urlafiche, String urlfondo, Double popularidad, String estreno, Integer duracion, String estado, Double puntuacion, Integer cantidadvotos, Boolean adulto,String imbdid) {
        super(id, nombre, sinopsis, urlafiche, urlfondo, popularidad, estreno, duracion, estado, puntuacion, cantidadvotos, Contenido.PELICULA,adulto);
        super.setTipoContenido(Contenido.PELICULA);
        this.imbdid=imbdid;
    }

    public Pelicula(Integer id, String nombre, String sinopsis, String urlafiche, String urlfondo, Double popularidad, String estreno, Integer duracion, String estado, Double puntuacion, Integer cantidadvotos, String tituloorg, Boolean adulto, String lema, String video,String imbdid) {
        super(id, nombre, sinopsis, urlafiche, urlfondo, popularidad, estreno, duracion, estado, puntuacion, cantidadvotos, Contenido.PELICULA,adulto);
        this.tituloorg = tituloorg;
        this.lema = lema;
        this.video = video;
        super.setTipoContenido(Contenido.PELICULA);
        this.imbdid=imbdid;
    }

    public Pelicula(Contenido unContenido, String tituloOriginal, boolean esParaAdultos, String lema, String video,String imbdid) {
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
                tituloOriginal, esParaAdultos, lema, video,imbdid
        );
        super.setTipoContenido(Contenido.PELICULA);
    }

    public String getImbdid() {
        return imbdid;
    }

    public String getTituloorg() {
        return tituloorg;
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
                ", tituloorg='" + tituloorg + '\'' +
                ", lema='" + lema + '\'' +
                ", video='" + video + '\'' +
                "} " + super.toString();
    }
}
