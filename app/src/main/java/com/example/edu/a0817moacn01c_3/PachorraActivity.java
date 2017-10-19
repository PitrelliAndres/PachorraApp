package com.example.edu.a0817moacn01c_3;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PachorraActivity extends AppCompatActivity implements PachorraFragment.NotificadorDatos {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pachorra);
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        PachorraFragment mainFragment = new PachorraFragment();

        fragmentTransaction.replace(R.id.contenedorDeFragments, mainFragment);

        fragmentTransaction.commit();
    }

    @Override
    //metodo para enviar la informacion de la pelicula al detalle activity
    public void mandarDatos(String nombre, Integer imagen, Integer imagenPortada, String genero, String desc, Integer puntuacion, String aptoTodoPublico) {
        Intent unIntent = new Intent(this,DetalleActivity.class);

        Bundle unBundle= new Bundle();
        unBundle.putString("nombre",nombre);
        unBundle.putInt("imagen",imagen);
        unBundle.putInt("imagenPortada",imagenPortada);
        unBundle.putString("genero",genero);
        unBundle.putInt("puntuacion",puntuacion);
        unBundle.putString("descripcion",desc);
        unBundle.putString("aptoTodoPublico",aptoTodoPublico);

        unIntent.putExtras(unBundle);
        startActivity(unIntent);

    }
}
