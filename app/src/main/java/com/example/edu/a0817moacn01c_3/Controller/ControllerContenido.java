package com.example.edu.a0817moacn01c_3.Controller;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.edu.a0817moacn01c_3.DAO.DAODBLista;
import com.example.edu.a0817moacn01c_3.DAO.DAODBListaContenido;
import com.example.edu.a0817moacn01c_3.DAO.DAODBPelicula;
import com.example.edu.a0817moacn01c_3.DAO.DAODBSerie;
import com.example.edu.a0817moacn01c_3.DAO.DAOInternetPelicula;
import com.example.edu.a0817moacn01c_3.DAO.DAOInternetSerie;
import com.example.edu.a0817moacn01c_3.DAO.DatabaseHelper;
import com.example.edu.a0817moacn01c_3.Model.Contenido;
import com.example.edu.a0817moacn01c_3.Model.Lista;
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
            List<Pelicula> listaPeliculas = daodbPelicula.obtenerPeliculasPopulares();
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
        }else{
            // estamos offline vamos directo a base de datos
            DAODBPelicula daodbPelicula = new DAODBPelicula(context);
            List<Pelicula> listaPeliculas = daodbPelicula.obtenerTodasLasPeliculas();
            Collections.shuffle(listaPeliculas);
            listenerDeLaView.finish(listaPeliculas);
        }
    }
    public void getSeriesPopulares(final ResultListener<List<Serie>> listenerDeLaView){
        if(HTTPConnectionManager.isNetworkingOnline(context)) {
            ResultListener<List<Serie>> escuchadorDelControlador = new ResultListener<List<Serie>>() {
                @Override
                public void finish(List<Serie> resultado) {
                    DAODBSerie daodbSerie = new DAODBSerie(context);
                    daodbSerie.agregarSeries(resultado);
                    listenerDeLaView.finish(resultado);
                }
            };
            daoInternetSerie.getSeriesPopulares(escuchadorDelControlador);
        }else{
            // offline
            DAODBSerie daodbSerie = new DAODBSerie(context);
            List<Serie> listaSeries = daodbSerie.obtenerTodasLasSeries();
            listenerDeLaView.finish(listaSeries);
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
        }else{
            // offline
            DAODBSerie daodbSerie = new DAODBSerie(context);
            List<Serie> listaSeries = daodbSerie.obtenerTodasLasSeries();
            Collections.shuffle(listaSeries);
            listenerDeLaView.finish(listaSeries);
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
        }else{
            // offline
            DAODBSerie daodbSerie = new DAODBSerie(context);
            List<Serie> listaSeries = daodbSerie.obtenerTodasLasSeries();
            Collections.shuffle(listaSeries);
            listenerDeLaView.finish(listaSeries);
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
        List<Serie> listaSeriesPopulares = daodbSerie.obtenerSeriesPopulares(10);
        List<Pelicula> listaPeliculasPopulares = daodbPelicula.obtenerPeliculasPopulares(10);
        List<Contenido> listaMista = new ArrayList<>();
        listaMista.addAll(listaPeliculasPopulares);
        listaMista.addAll(listaSeriesPopulares);
        Collections.shuffle(listaMista);
        return listaMista;
    }

    public void agregarFavoritos (Contenido contenido,Context contexto){
        DAODBLista daodbLista = new DAODBLista(contexto);
        DAODBListaContenido daodbListaContenido = new DAODBListaContenido(contexto);
        String favoritos;
        switch(contenido.getTipoContenido()){
            case Contenido.PELICULA:
                favoritos = Lista.FAVORITOSPELICULA;
                break;
            case Contenido.SERIE:
                favoritos = Lista.FAVORITOSSERIE;
                break;
            default:
                return;
        }
        daodbLista.crearLista(favoritos,"Favoritos",contenido.getTipoContenido());
        daodbListaContenido.agregarItemALista(favoritos,contenido.getId());
        System.out.println("Se agrego a favoritos " + contenido.getId() + contenido.getTipoContenido()+contenido.getNombre());
        Toast.makeText(contexto, "¡Listo!, tu " + contenido.getTipoContenido() + " '" + contenido.getNombre()+"' se agrego a favoritos.", Toast.LENGTH_SHORT).show();
    }

    public List<Serie> getSeriesFavoritas(){
        List<Integer> listaIDs = getLista(Lista.FAVORITOSSERIE);
        DAODBSerie daodbSerie = new DAODBSerie(context);
        return daodbSerie.obtenerSeriePorID(listaIDs);
    }
    public List<Pelicula> getPeliculasFavoritas(){
        List<Integer> listaIDs = getLista(Lista.FAVORITOSPELICULA);
        DAODBPelicula daodbPelicula = new DAODBPelicula(context);
        return daodbPelicula.obtenerPeliculaPorID(listaIDs);
    }
    public List<Contenido> getFavoritos(){
        List<Contenido> listaFavoritos = new ArrayList<>();
        listaFavoritos.addAll(getSeriesFavoritas());
        listaFavoritos.addAll(getPeliculasFavoritas());
        return listaFavoritos;
    }

    public List<Integer> getLista(String idLista){
        //consultar DAO DB Lista Contenidos por los IDs que estan en una lista
        DAODBListaContenido daodbListaContenido = new DAODBListaContenido(context);
        return daodbListaContenido.obtenerListaDeContenidosPorID(idLista);
    }

    public List<Contenido> getListaFiltrada(String genero,String tipoContenido, Integer fecha){
        List<Contenido> blablub = new ArrayList<>();
        List<Serie> listaSeries = new ArrayList<>();
        List<Pelicula> listaPeliculas = new ArrayList<>();
        DAODBSerie daodbSerie = new DAODBSerie(context);
        DAODBPelicula daodbPelicula = new DAODBPelicula(context);
        switch (tipoContenido){
            case Contenido.SERIE:
                listaSeries = daodbSerie.obtenerSeriesFiltradas(genero, fecha);
                blablub.addAll(listaSeries);
                break;
            case Contenido.PELICULA:
                listaPeliculas = daodbPelicula.obtenerPeliculasFiltradas(genero, fecha);
                blablub.addAll(listaPeliculas);
                break;
            default:
                listaSeries = daodbSerie.obtenerSeriesFiltradas(genero, fecha);
                listaPeliculas = daodbPelicula.obtenerPeliculasFiltradas(genero, fecha);
                blablub.addAll(listaSeries);
                blablub.addAll(listaPeliculas);
                break;
        }
        return blablub;
    }

    public String[] getGenerosNombres() {
        List<String> lista = new ArrayList<>();
        lista.add("Acción");
        lista.add("Aventura");
        lista.add("Documental");
        lista.add("Romance");
        lista.add("Ciencia ficción");
        lista.add("Western");
        return lista.toArray(new String[lista.size()]);
    }

    public String[] getTiposDeContenido() {
        List<String>tiposDeContenido = new ArrayList<>();
        tiposDeContenido.add(Contenido.PELICULA);
        tiposDeContenido.add(Contenido.SERIE);
        return tiposDeContenido.toArray(new String[tiposDeContenido.size()]);
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


