package com.example.edu.a0817moacn01c_3.DAO;

import android.os.AsyncTask;
import android.util.Log;

import com.example.edu.a0817moacn01c_3.Controller.ControllerContenido;
import com.example.edu.a0817moacn01c_3.Model.ContenedorDeContenido;
import com.example.edu.a0817moacn01c_3.Model.ContenedorDePelicula;
import com.example.edu.a0817moacn01c_3.Model.Contenido;
import com.example.edu.a0817moacn01c_3.Model.Pelicula;
import com.example.edu.a0817moacn01c_3.utils.HTTPConnectionManager;
import com.example.edu.a0817moacn01c_3.utils.ResultListener;
import com.example.edu.a0817moacn01c_3.utils.TMDBHelper;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ma on 14/11/17.
 */

public class DAOInternetPelicula {
    private Minion unMinion;


    public void getPeliculasPopulares(ResultListener<List<Pelicula>> listener){

        String url = TMDBHelper.getPopularMovies(TMDBHelper.language_SPANISH,1);
        unMinion = new Minion(url,listener);

        unMinion.execute();
    }
    public void getUltimasPeliculas(ResultListener<List<Pelicula>> listener){
        String url= TMDBHelper.getLastestMovie(TMDBHelper.language_SPANISH,1);
        unMinion= new Minion(url,listener);

        unMinion.execute();
    }
    public void getTopRatedPeliculas(ResultListener<List<Pelicula>> listener){
        String url= TMDBHelper.getTopRatedMovies(TMDBHelper.language_SPANISH);
        unMinion= new Minion(url,listener);

        unMinion.execute();
    }
    public void getUpcomingPeliculas(ResultListener<List<Pelicula>> listener, Integer pageSize){
        String url= TMDBHelper.getUpcomingMovies(TMDBHelper.language_SPANISH,pageSize);
        unMinion= new Minion(url,listener);

        unMinion.execute();
    }
    public void getPostsPaginated(final ResultListener<List<Pelicula>> listener, Integer pageSize) {
        String url= TMDBHelper.getTopRatedMovies(TMDBHelper.language_SPANISH);
        unMinion = new Minion(url,listener);
        unMinion.execute();

    }


    public class Minion extends AsyncTask<String,Void,List<Pelicula>>{
        private ResultListener<List<Pelicula>>escuchadorPeliculasControlador;
        private String url;



        public Minion(String url,ResultListener<List<Pelicula>>escuchadorPeliculasControlador){
            this.url=url;
            this.escuchadorPeliculasControlador=escuchadorPeliculasControlador;


        }



        @Override
        protected List<Pelicula> doInBackground(String... strings) {

            HTTPConnectionManager connectionManager = new HTTPConnectionManager();
            String input;
            ContenedorDePelicula contenedorDePelicula= null;
            try{
                Thread.sleep(2000);
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
