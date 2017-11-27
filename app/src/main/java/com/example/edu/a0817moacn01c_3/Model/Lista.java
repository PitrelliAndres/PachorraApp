package com.example.edu.a0817moacn01c_3.Model;

/**
 * Created by Administrador on 27/11/2017.
 */

public class Lista {
    private String idLista;
    private String nombreLista;
    private String tipoContenido;

    public Lista(String idLista, String nombreLista, String tipoContenido) {
        this.idLista = idLista;
        this.nombreLista = nombreLista;
        this.tipoContenido = tipoContenido;
    }

    public String getIdLista() {
        return idLista;
    }

    public String getNombreLista() {
        return nombreLista;
    }

    public String getTipoContenido() {
        return tipoContenido;
    }
}
