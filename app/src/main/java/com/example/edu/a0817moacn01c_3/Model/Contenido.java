package com.example.edu.a0817moacn01c_3.Model;

/**
 * Created by Andy on 26/10/2017.
 */

public class Contenido {
    public static final String PELICULA = "Pelicula";
    public static final String SERIE = "Serie";
    private Integer id;
    private String nombre;
    private Integer imagen;
    private Integer imagenPortada;
    private String genero;
    private String desc;
    private Double puntuacion;
    private String aptoParaPublico;
    private Integer duracion;
    private String tipoContenido;


    public Contenido(Integer id, String nombre, Integer imagen, Integer imagenPortada, String genero, String desc, Double puntuacion, String aptoParaPublico,Integer duracion, String tipoContenido) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.imagenPortada = imagenPortada;
        this.genero = genero;
        this.desc = desc;
        this.puntuacion = puntuacion;
        this.aptoParaPublico = aptoParaPublico;
        this.tipoContenido = tipoContenido;
        this.duracion=duracion;
    }

    public Boolean esPelicula(){
        return this.tipoContenido.equals(Contenido.PELICULA);
    }
    public Boolean esSerie(){
        return this.tipoContenido.equals(Contenido.SERIE);
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getImagen() {
        return imagen;
    }

    public Integer getImagenPortada() {
        return imagenPortada;
    }

    public String getGenero() {
        return genero;
    }

    public String getDesc() {
        return desc;
    }

    public Double getPuntuacion() {
        return puntuacion;
    }

    public String getAptoParaPublico() {
        return aptoParaPublico;
    }

    public Integer getId() {
        return id;
    }

    public String getTipoContenido() {
        return tipoContenido;
    }

    public Integer getDuracion() {
        return duracion;
    }
}


