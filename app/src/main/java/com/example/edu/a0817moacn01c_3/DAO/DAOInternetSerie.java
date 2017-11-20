package com.example.edu.a0817moacn01c_3.DAO;

import android.os.AsyncTask;
import android.util.Log;

import com.example.edu.a0817moacn01c_3.Model.ContenedorDePelicula;
import com.example.edu.a0817moacn01c_3.Model.ContenedorDeSerie;
import com.example.edu.a0817moacn01c_3.Model.Pelicula;
import com.example.edu.a0817moacn01c_3.Model.Serie;
import com.example.edu.a0817moacn01c_3.utils.HTTPConnectionManager;
import com.example.edu.a0817moacn01c_3.utils.ResultListener;
import com.example.edu.a0817moacn01c_3.utils.TMDBHelper;
import com.google.gson.Gson;

import java.net.HttpURLConnection;
import java.util.List;

/**
 * Created by ma on 14/11/17.
 */

public class DAOInternetSerie {
    private Minion unMinion;

    public void getSeriesPopulares(ResultListener<List<Serie>> listener){

        String url = TMDBHelper.getTVPopular(TMDBHelper.language_SPANISH,1);
        unMinion = new Minion(url);
        unMinion.setEscuchadorSeriesControlador(listener);
        unMinion.execute();
    }
    public void getSeriesTopRate(ResultListener<List<Serie>> listener){

        String url = TMDBHelper.getTVTopRated(TMDBHelper.language_SPANISH,1);
        unMinion = new Minion(url);
        unMinion.setEscuchadorSeriesControlador(listener);
        unMinion.execute();
    }
    public void getTVAiringToday(ResultListener<List<Serie>> listener){

        String url = TMDBHelper.getTVAiringToday(TMDBHelper.language_SPANISH,1);
        unMinion = new Minion(url);
        unMinion.setEscuchadorSeriesControlador(listener);
        unMinion.execute();
    }


    public class Minion extends AsyncTask<String,Void,List<Serie>>{
        private ResultListener<List<Serie>>escuchadorSeriesControlador;
        private String url;
        HttpURLConnection urlConnection;

        public Minion(String url){
            this.url=url;
        }

        public void setEscuchadorSeriesControlador(ResultListener<List<Serie>> escuchadorSeriesControlador) {
            this.escuchadorSeriesControlador = escuchadorSeriesControlador;
        }

        @Override
        protected List<Serie> doInBackground(String... strings) {

            HTTPConnectionManager connectionManager = new HTTPConnectionManager();
            String input = null;
            try{
                input = connectionManager.getRequestString(url);
                Log.v("[G3] fetching URL", url);
                Log.v("[G3] input", input);
            } catch (Exception e) {
                e.printStackTrace();
            }

            Gson gson = new Gson();

            ContenedorDeSerie contenedorDeSerie = gson.fromJson(input,ContenedorDeSerie.class);

            return contenedorDeSerie.getContenidos();

        }
        @Override
        protected void onPostExecute(List<Serie> listaSeries) {

            this.escuchadorSeriesControlador.finish(listaSeries);
        }
    }
}
