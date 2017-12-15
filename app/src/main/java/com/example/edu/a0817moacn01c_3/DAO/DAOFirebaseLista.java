package com.example.edu.a0817moacn01c_3.DAO;

import android.content.Context;

import com.example.edu.a0817moacn01c_3.Model.Contenido;
import com.example.edu.a0817moacn01c_3.Model.Pelicula;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ma on 14/12/17.
 */

public class DAOFirebaseLista extends FirebaseHelper{

    public Boolean agregarFavorito(Contenido contenido) {
        try {
            String uid = mauth.getCurrentUser().getUid();
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Users").child(uid).child("Favoritos");
            myRef.push().setValue(contenido);
            return true;
        } catch (Exception e) {
            // TODO: pedir login para mas mejor
            e.printStackTrace();
            return false;
        }
    }

    public List<Pelicula> getPeliculasFavoritas(){
        List<Pelicula> favoritos = new ArrayList<>();
        // TODO: traer de Firebase
        return favoritos;
    }

}
