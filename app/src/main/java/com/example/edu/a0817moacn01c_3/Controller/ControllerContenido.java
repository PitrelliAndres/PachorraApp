package com.example.edu.a0817moacn01c_3.Controller;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.ContextMenu;

import com.example.edu.a0817moacn01c_3.DAO.DAOContenido;
import com.example.edu.a0817moacn01c_3.DAO.DAODBPelicula;
import com.example.edu.a0817moacn01c_3.DAO.DAODBSerie;
import com.example.edu.a0817moacn01c_3.DAO.DAOInternetPelicula;
import com.example.edu.a0817moacn01c_3.DAO.DAOInternetSerie;
import com.example.edu.a0817moacn01c_3.DAO.DatabaseHelper;
import com.example.edu.a0817moacn01c_3.Model.Contenido;
import com.example.edu.a0817moacn01c_3.Model.Pelicula;
import com.example.edu.a0817moacn01c_3.Model.Serie;
import com.example.edu.a0817moacn01c_3.R;
import com.example.edu.a0817moacn01c_3.utils.HTTPConnectionManager;
import com.example.edu.a0817moacn01c_3.utils.ResultListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Andiy on 30/10/2017.
 */

public class ControllerContenido {
    private Context context;
    private DatabaseHelper databaseHelper;
    private DAOInternetPelicula daoInternetPelicula = new DAOInternetPelicula();
    private DAOInternetSerie daoInternetSerie = new DAOInternetSerie();

    public ControllerContenido() {
    }

    public ControllerContenido(Context context) {
        this.context = context;
    }

    public void getPeliculasPopulares(final ResultListener<List<Pelicula>> listenerDeLaView){
        if(HTTPConnectionManager.isNetworkingOnline(context)) {

            ResultListener<List<Pelicula>> escuchadorDelControlador = new ResultListener<List<Pelicula>>() {
                @Override
                public void finish(List<Pelicula> resultado) {
                    //databaseHelper = new DatabaseHelper(context);
                    DAODBPelicula daodbPelicula = new DAODBPelicula(context);
                    daodbPelicula.agregarPeliculas(resultado);
                    listenerDeLaView.finish(resultado);
                }
            };
            daoInternetPelicula.getPeliculasPopulares(escuchadorDelControlador);
        }else{
            // estamos offline vamos directo a base de datos
            DAODBPelicula daodbPelicula = new DAODBPelicula(context);
            List<Pelicula> listaPeliculas = daodbPelicula.obtenerTodasLasPeliculas();
            listenerDeLaView.finish(listaPeliculas);
        }
    }
    public void getUltimasPeliculas(final ResultListener<List<Pelicula>> listenerDeLaView){
        if(HTTPConnectionManager.isNetworkingOnline(context)) {
            ResultListener<List<Pelicula>> escuchadorDelControlador = new ResultListener<List<Pelicula>>() {
                @Override
                public void finish(List<Pelicula> resultado) {
                    listenerDeLaView.finish(resultado);
                }
            };
            daoInternetPelicula.getUltimasPeliculas(escuchadorDelControlador);
        }
    }
    public void getTopRatedPeliculas(final ResultListener<List<Pelicula>> listenerDeLaView){
        if(HTTPConnectionManager.isNetworkingOnline(context)) {
            ResultListener<List<Pelicula>> escuchadorDelControlador = new ResultListener<List<Pelicula>>() {
                @Override
                public void finish(List<Pelicula> resultado) {
                    listenerDeLaView.finish(resultado);
                }
            };
            daoInternetPelicula.getTopRatedPeliculas(escuchadorDelControlador);
        }
    }
    public void getUpcomingPeliculas(final ResultListener<List<Pelicula>> listenerDeLaView){
        if(HTTPConnectionManager.isNetworkingOnline(context)) {
            ResultListener<List<Pelicula>> escuchadorDelControlador = new ResultListener<List<Pelicula>>() {
                @Override
                public void finish(List<Pelicula> resultado) {
                    listenerDeLaView.finish(resultado);
                }
            };
            daoInternetPelicula.getUpcomingPeliculas(escuchadorDelControlador);
        }
    }
    public void getSeriesPopulares(final ResultListener<List<Serie>> listenerDeLaView){
        if(HTTPConnectionManager.isNetworkingOnline(context)) {
            ResultListener<List<Serie>> escuchadorDelControlador = new ResultListener<List<Serie>>() {
                @Override
                public void finish(List<Serie> resultado) {
                    listenerDeLaView.finish(resultado);
                }
            };
            daoInternetSerie.getSeriesPopulares(escuchadorDelControlador);
        }
    }
    public void getSeriesTopRated(final ResultListener<List<Serie>> listenerDeLaView){
        if(HTTPConnectionManager.isNetworkingOnline(context)) {
            ResultListener<List<Serie>> escuchadorDelControlador = new ResultListener<List<Serie>>() {
                @Override
                public void finish(List<Serie> resultado) {
                    listenerDeLaView.finish(resultado);
                }
            };
            daoInternetSerie.getSeriesTopRate(escuchadorDelControlador);
        }
    }
    public void getTVAiringToday(final ResultListener<List<Serie>> listenerDeLaView){
        if(HTTPConnectionManager.isNetworkingOnline(context)) {
            ResultListener<List<Serie>> escuchadorDelControlador = new ResultListener<List<Serie>>() {
                @Override
                public void finish(List<Serie> resultado) {
                    listenerDeLaView.finish(resultado);
                }
            };
            daoInternetSerie.getTVAiringToday(escuchadorDelControlador);
        }
    }
    public void getSerie(Integer unID, final ResultListener<Serie> listenerDeLaView){
        if(HTTPConnectionManager.isNetworkingOnline(context)) {
            ResultListener<Serie> escuchadorDelControlador = new ResultListener<Serie>() {
                @Override
                public void finish(Serie resultado) {
                    listenerDeLaView.finish(resultado);
                }
            };
        }else{
            // estamos offline vamos directo a base de datos
            DAODBSerie daodbSerie = new DAODBSerie(context);
            Serie unaSerie = daodbSerie.obtenerSeriePorID(unID);
            listenerDeLaView.finish(unaSerie);
        }
    }
    public void getPelicula(Integer id){}
    public List<Contenido> getListaMixta(){
        DAODBSerie daodbSerie = new DAODBSerie(context);
        DAODBPelicula daodbPelicula = new DAODBPelicula(context);
        List<Serie> listaSeriesPopulares = daodbSerie.obtenerSeriesPopulares();
        List<Pelicula> listaPeliculasPopulares = daodbPelicula.obtenerPeliculasPopulares();
        List<Contenido> listaMista = new ArrayList<>();
        listaMista.addAll(listaPeliculasPopulares);
        listaMista.addAll(listaSeriesPopulares);
        Collections.shuffle(listaMista);
        return listaMista;
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





    /*    public List<Contenido> getListaMasrecomendados(){
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
*/

