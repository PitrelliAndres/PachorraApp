package com.example.edu.a0817moacn01c_3.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Andy on 26/10/2017.
 */

public class Contenido {
    public static final String PELICULA = "Pelicula";
    public static final String SERIE = "Serie";


    private Integer id;
    @SerializedName("title") private String nombre;
    @SerializedName("overview") private String sinopsis;
    @SerializedName("poster_path") private String urlafiche;
    @SerializedName("backdrop_path") private String urlfondo;
    @SerializedName("popularity") private Double popularidad;
    @SerializedName("release_date") private String estreno;
    private String year;
    @SerializedName("runtime") private Integer duracion;
    @SerializedName("status") private String estado;
    @SerializedName("vote_average") private Double puntuacion;
    @SerializedName("vote_count")private Integer cantidadvotos;
    private String tipoContenido;

    public Contenido() {
    }

    public Contenido(Integer id, String nombre, String sinopsis, String urlafiche, String urlfondo, Double popularidad, String estreno, Integer duracion, String estado, Double puntuacion, Integer cantidadvotos, String tipoContenido) {
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
        this.year = estreno.substring(0,3);
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
        return this.tipoContenido.equals(Contenido.PELICULA);
    }
    public Boolean esSerie(){
        return this.tipoContenido.equals(Contenido.SERIE);
    }
    public String getTipoContenido() {
        return tipoContenido;
    }

}


