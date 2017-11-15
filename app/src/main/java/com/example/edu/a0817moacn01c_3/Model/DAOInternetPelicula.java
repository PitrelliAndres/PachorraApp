package com.example.edu.a0817moacn01c_3.Model;

import android.os.AsyncTask;

import com.example.edu.a0817moacn01c_3.utils.ResultListener;

import java.util.List;

/**
 * Created by ma on 14/11/17.
 */

public class DAOInternetPelicula {

    public class Minion extends AsyncTask<String,Void,List<Pelicula>>{
        private ResultListener<List<Pelicula>>escuchadorPeliculasControlador;

        public void setEscuchadorPeliculasControlador(ResultListener<List<Pelicula>> escuchadorPeliculasControlador) {
            this.escuchadorPeliculasControlador = escuchadorPeliculasControlador;
        }

        @Override
        protected List<Pelicula> doInBackground(String... strings) {
            return null;
        }
    }
}
