package com.example.edu.a0817moacn01c_3.DAO;

import android.os.AsyncTask;
import android.util.Log;

import com.example.edu.a0817moacn01c_3.Model.ContenedorDeSerie;
import com.example.edu.a0817moacn01c_3.Model.Serie;
import com.example.edu.a0817moacn01c_3.Model.Trailer;
import com.example.edu.a0817moacn01c_3.utils.HTTPConnectionManager;
import com.example.edu.a0817moacn01c_3.utils.ResultListener;
import com.example.edu.a0817moacn01c_3.utils.TMDBHelper;
import com.google.gson.Gson;

import java.net.HttpURLConnection;
import java.util.List;

/**
 * Created by ma on 13/12/17.
 */

public class DAOInternetTrailer {
    private Minion unMinion;
    public void getTrailerPelicula(ResultListener <Trailer> listener,String id){

        String url = TMDBHelper.getTrailerURL(id,TMDBHelper.language_SPANISH);
        unMinion = new DAOInternetTrailer.Minion(url);
        unMinion.setEscuchadorSeriesControlador(listener);
        unMinion.execute();
    }

    public class Minion extends AsyncTask<String,Void,Trailer>  {
        private ResultListener <Trailer>  escuchadorSeriesControlador;
        private String url;

        public Minion(String url){
            this.url=url;
        }

        public void setEscuchadorSeriesControlador(ResultListener<Trailer>  escuchadorSeriesControlador) {
            this.escuchadorSeriesControlador = escuchadorSeriesControlador;
        }

        @Override
        protected Trailer doInBackground(String... strings) {

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


            Trailer trailer = gson.fromJson(input,Trailer.class);

            return trailer;

        }
        @Override
        protected void onPostExecute(Trailer trailer) {

            this.escuchadorSeriesControlador.finish(trailer);
        }
    }
}
