package com.example.edu.a0817moacn01c_3.Controller;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.example.edu.a0817moacn01c_3.DAO.DAOContenido;
import com.example.edu.a0817moacn01c_3.Model.Contenido;
import com.example.edu.a0817moacn01c_3.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andiy on 30/10/2017.
 */

public class ControllerContenido {

    public List<Contenido> getListaMasrecomendados(){
        DAOContenido daoContenido = new DAOContenido();
        List<Contenido> contenidoList = daoContenido.obtenerListaRecomendadas();
        return contenidoList;
    }
    public List<Contenido> getListaMasvistos(){
        DAOContenido daoContenido = new DAOContenido();
        List<Contenido> contenidoList = daoContenido.obtenerListaMasVistas();
        return contenidoList;
    }
    public List<Contenido> getListaEstrenos(){
        DAOContenido daoContenido = new DAOContenido();
        List<Contenido> contenidoList = daoContenido.obtenerListaEstrenos();
        return contenidoList;
    }

    public List<Contenido> getListaMasRecomendados(String filtro){
        return getLista(filtro, getListaMasrecomendados());
    }

    public List<Contenido> getListaMasVistos(String filtro){
        return getLista(filtro, getListaMasvistos());
    }

    public List<Contenido> getListaEstreno(String filtro){
        return getLista(filtro, getListaEstrenos());
    }

    public List<Contenido> getLista(String filtro, List<Contenido> lista){
        List<Contenido> listaPosta = new ArrayList<>();
        for (Contenido contenido : lista) {
         if(contenido.getTipoContenido().equals(filtro)){
             listaPosta.add(contenido);
         }
        }
        return listaPosta;
    }
    public Integer getColor(Contenido contenido){
        Integer color;
        switch (contenido.getTipoContenido()){
            case Contenido.PELICULA:
                color = R.color.colorPeliculas;
                break;
            case Contenido.SERIE:
                color = R.color.colorSeries;
                break;
            default:
                color = R.color.colorAccent;
                break;
        }

        return color;
    }
}
