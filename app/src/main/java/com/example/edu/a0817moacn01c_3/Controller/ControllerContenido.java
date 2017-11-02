package com.example.edu.a0817moacn01c_3.Controller;

import android.content.Context;

import com.example.edu.a0817moacn01c_3.DAO.DAOContenido;
import com.example.edu.a0817moacn01c_3.Model.Contenido;

import java.util.List;

/**
 * Created by Andiy on 30/10/2017.
 */

public class ControllerContenido {

    public List<Contenido> getListDeProductos(Context context){
        DAOContenido daoContenido = new DAOContenido();
        List<Contenido> contenidoList = daoContenido.getListaDeContenidoFromArchivo(context);
        return contenidoList;
    }
}
