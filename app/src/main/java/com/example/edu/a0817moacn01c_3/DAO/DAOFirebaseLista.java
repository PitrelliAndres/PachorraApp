package com.example.edu.a0817moacn01c_3.DAO;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.edu.a0817moacn01c_3.Model.ContenedorDeContenido;
import com.example.edu.a0817moacn01c_3.Model.ContenedorDeTrailer;
import com.example.edu.a0817moacn01c_3.Model.Contenido;
import com.example.edu.a0817moacn01c_3.Model.Pelicula;
import com.example.edu.a0817moacn01c_3.Model.Trailer;
import com.example.edu.a0817moacn01c_3.utils.HTTPConnectionManager;
import com.example.edu.a0817moacn01c_3.utils.ResultListener;
import com.example.edu.a0817moacn01c_3.utils.TMDBHelper;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ma on 14/12/17.
 */

public class DAOFirebaseLista extends FirebaseHelper{
    Minion unMinion;
    FirebaseDatabase database;
    String uid;
    DatabaseReference myRef;


    public DAOFirebaseLista(){
        database= FirebaseDatabase.getInstance();
        uid= mauth.getCurrentUser().getUid();
        myRef= database.getReference("Users").child(uid).child("Favoritos");
    }

    public void getFavoritosFirebase(ResultListener <List<Contenido>> listener){

        unMinion = new Minion(myRef);
        unMinion.setEscuchadorSeriesControlador(listener);
        unMinion.execute();
    }

    public Boolean agregarFavorito(Contenido contenido) {
        try {

           myRef.push().setValue(contenido);
            return true;
        } catch (Exception e) {
            // TODO: pedir login para mas mejor
            e.printStackTrace();
            return false;
        }
    }

    public class Minion extends AsyncTask<String,Void,List<Contenido>> {
        private ResultListener <List<Contenido>> escuchadorFirebaseFavoritos;
        DatabaseReference myRef;

        public Minion(DatabaseReference myRef){
            this.myRef=myRef;
        }

        public void setEscuchadorSeriesControlador(ResultListener<List<Contenido>> escuchadorFirebaseFavoritos) {
            this.escuchadorFirebaseFavoritos = escuchadorFirebaseFavoritos;
        }

        @Override
        protected List<Contenido> doInBackground(String... strings) {



            final List<Contenido> contenidoList= new ArrayList<Contenido>();
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    for(DataSnapshot child: dataSnapshot.getChildren()){
                        Contenido contenido = child.getValue(Contenido.class);
                        contenidoList.add(contenido);
                    }

                }
                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            // TODO: traer de Firebase
            return contenidoList;

        }
        @Override
        protected void onPostExecute(List<Contenido> trailer) {

            this.escuchadorFirebaseFavoritos.finish(trailer);
        }
    }
}
