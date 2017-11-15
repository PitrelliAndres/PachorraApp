package com.example.edu.a0817moacn01c_3.DAO;

import android.os.AsyncTask;

import com.example.edu.a0817moacn01c_3.Controller.ControllerContenido;
import com.example.edu.a0817moacn01c_3.Model.ContenedorDeContenido;
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

    public void getPeliculasPopulares(ResultListener<List<Contenido>> listener){

        String url = TMDBHelper.getPopularMovies(TMDBHelper.language_SPANISH,1);
        unMinion = new Minion(url);
        unMinion.setEscuchadorPeliculasControlador(listener);
        unMinion.execute();
    }

    public class Minion extends AsyncTask<String,Void,List<Contenido>>{
        private ResultListener<List<Contenido>>escuchadorPeliculasControlador;
        private String url;
       /* HttpURLConnection urlConnection;*/

        public Minion(String url){
            this.url=url;
        }

        public void setEscuchadorPeliculasControlador(ResultListener<List<Contenido>> escuchadorPeliculasControlador) {
            this.escuchadorPeliculasControlador = escuchadorPeliculasControlador;
        }

        @Override
        protected List<Contenido> doInBackground(String... strings) {

            HTTPConnectionManager connectionManager = new HTTPConnectionManager();
            String input = null;
            try{
                input = connectionManager.getRequestString(url);
            } catch (Exception e) {
                e.printStackTrace();
            }

            Gson gson = new Gson();

            ContenedorDeContenido contenedorDeContenido = gson.fromJson(input,ContenedorDeContenido.class);

            return contenedorDeContenido.getContenidos();
            /*List<Pelicula> listaLeidaInternet= new ArrayList<Pelicula>();
            try {
                URL urlFinal= new URL(url);
                urlConnection=(HttpURLConnection) urlFinal.openConnection();
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                JSONArray jsonArray= new JSONArray(url);
               for(int i=0;i<jsonArray.length();i++){
                   JSONObject jsonObject = jsonArray.getJSONObject(i);
                   id= jsonObject.getString("id");
                   nombre= jsonObject.getString("title");
                   sinopsis= jsonObject.getString("overview");
                   urlafiche= jsonObject.getString("poster_path");
                   urlfondo= jsonObject.getString("backdrop_path");
                   popularidad= jsonObject.getString("popularity");
                   estreno= jsonObject.getString("release_date");
                   duracion= jsonObject.getString("runtime");
                   estado= jsonObject.getString("status");
                   puntuacion= jsonObject.getString("vote_average");
                   cantidadvotos= jsonObject.getString("vote_count");
                   imdbid= jsonObject.getString("imdb_id");
                   tituloorg= jsonObject.getString("original_title");
                   adulto= jsonObject.getString("adult");
                   lema= jsonObject.getString("tagline");
                   video= jsonObject.getString("video");

                   Pelicula unaPelicula= new Pelicula(Integer.parseInt(id),nombre,sinopsis,urlafiche,urlfondo,Double.parseDouble(popularidad),estreno,Integer.parseInt(duracion),estado,Double.parseDouble(puntuacion),Integer.parseInt(cantidadvotos),imdbid,tituloorg,adulto,lema,video);
                   listaLeidaInternet.add(unaPelicula);
               }


            } catch (IOException e) {
                e.printStackTrace();

            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                urlConnection.disconnect();
            }


            return listaLeidaInternet;*/

        }
        @Override
        protected void onPostExecute(List<Contenido> postList) {

            this.escuchadorPeliculasControlador.finish(postList);
        }
    }
}
