package com.example.edu.a0817moacn01c_3.Model;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Andy on 26/10/2017.
 */
//todo contenido fhgghchvcgfgjhg
public class Contenido implements Serializable{
    public static final String PELICULA = "Pelicula";
    public static final String SERIE = "Serie";


    private Integer id;
    @SerializedName(value = "title", alternate={"name"}) private String nombre;
    @SerializedName(value = "overview", alternate = {"description"}) private String sinopsis;
    @SerializedName("poster_path") private String urlafiche;
    @SerializedName("backdrop_path") private String urlfondo;
    @SerializedName("popularity") private Double popularidad;
    @SerializedName(value = "release_date", alternate = {"first_air_date"}) private String estreno;
    private String year;
    @SerializedName(value = "runtime", alternate = {"episode_run_time"}) private Integer duracion;
    @SerializedName("status") private String estado;
    @SerializedName("vote_average") private Double puntuacion;
    @SerializedName("vote_count")private Integer cantidadvotos;
    protected String tipoContenido;


    public Contenido() {
    }

    public Contenido(Integer id, String nombre, String sinopsis, String urlafiche, String urlfondo, Double popularidad, String estreno, Integer duracion, String estado, Double puntuacion, Integer cantidadvotos, String tipoContenido) {
        if(estreno.equals("")){estreno = "0000-00-00";}
        this.id = id;
        this.nombre = nombre;
        this.sinopsis = sinopsis;
        this.urlafiche = urlafiche;
        this.urlfondo = urlfondo;
        this.popularidad = popularidad;
        this.estreno = estreno;
        this.duracion = duracion;
        this.estado = estado;
        this.puntuacion = puntuacion;
        this.cantidadvotos = cantidadvotos;
        if(estreno==null){this.year = "0";}else{this.year = this.estreno.substring(0,4);}
        this.tipoContenido = tipoContenido;

    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public String getUrlafiche() {
        return urlafiche;
    }

    public String getUrlfondo() {
        return urlfondo;
    }

    public Double getPopularidad() {
        return popularidad;
    }

    public String getEstreno() {
        return estreno;
    }

    public String getYear() {
        return year;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public String getEstado() {
        return estado;
    }

    public Double getPuntuacion() {
        return puntuacion;
    }

    public Integer getCantidadvotos() {
        return cantidadvotos;
    }

    public Boolean esPelicula(){
        return false;
    }


    public Boolean esSerie(){
        return false;
    }
    public String getTipoContenido() {
        return tipoContenido;
    }

    public void setTipoContenido(String tipoContenido) {
        this.tipoContenido = tipoContenido;
    }

    @Override
    public String toString() {
        return "Contenido{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", sinopsis='" + sinopsis + '\'' +
                ", urlafiche='" + urlafiche + '\'' +
                ", urlfondo='" + urlfondo + '\'' +
                ", popularidad=" + popularidad +
                ", estreno='" + estreno + '\'' +
                ", year='" + year + '\'' +
                ", duracion=" + duracion +
                ", estado='" + estado + '\'' +
                ", puntuacion=" + puntuacion +
                ", cantidadvotos=" + cantidadvotos +
                ", tipoContenido='" + tipoContenido + '\'' +
                '}';
    }
}


