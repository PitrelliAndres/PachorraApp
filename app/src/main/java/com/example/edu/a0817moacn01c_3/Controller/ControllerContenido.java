package com.example.edu.a0817moacn01c_3.Controller;

import android.content.Context;

import com.example.edu.a0817moacn01c_3.DAO.DAOContenido;
import com.example.edu.a0817moacn01c_3.Model.Contenido;

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
}
