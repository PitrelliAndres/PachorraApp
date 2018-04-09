package com.example.edu.a0817moacn01c_3.DAO;

import android.os.AsyncTask;
import android.util.Log;

import com.example.edu.a0817moacn01c_3.Model.ContenedorDePelicula;
import com.example.edu.a0817moacn01c_3.Model.Pelicula;
import com.example.edu.a0817moacn01c_3.utils.HTTPConnectionManager;
import com.example.edu.a0817moacn01c_3.utils.ResultListener;
import com.example.edu.a0817moacn01c_3.utils.TMDBHelper;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Andiy on 26/03/2018.
 */

public class DAOInternetGeneroPelicula {
    private Minion unMinion;
    private ContenedorDePelicula contenedorDePelicula;
    public void getPeliculasporGenero(ResultListener<List<Pelicula>> listener, String genero){
        String url = TMDBHelper.getMoviesByGenre(genero,1,TMDBHelper.language_SPANISH);
        unMinion = new Minion(url);
        unMinion.setEscuchadorPeliculasControlador(listener);
        unMinion.execute();


    }

    public class Minion extends AsyncTask<String,Void,List<Pelicula>> {
        private ResultListener<List<Pelicula>>escuchadorPeliculasControlador;
        private String url;

        public Minion(String url){
            this.url=url;
        }

        public void setEscuchadorPeliculasControlador(ResultListener<List<Pelicula>> escuchadorPeliculasControlador) {
            this.escuchadorPeliculasControlador = escuchadorPeliculasControlador;
        }

        @Override
        protected List<Pelicula> doInBackground(String... strings) {

            HTTPConnectionManager connectionManager = new HTTPConnectionManager();
            String input = null;
            try{
                input = connectionManager.getRequestString(url);
                Log.v("[G3] fetching URL", url);
                Log.v("[G3] input", input);
                Gson gson = new Gson();
                contenedorDePelicula = gson.fromJson(input,ContenedorDePelicula.class);
            } catch (Exception e) {
                e.printStackTrace();
            }





            return contenedorDePelicula.getContenidos();

        }
        @Override
        protected void onPostExecute(List<Pelicula> listaPeliculas) {

            this.escuchadorPeliculasControlador.finish(listaPeliculas);
        }
    }
}
