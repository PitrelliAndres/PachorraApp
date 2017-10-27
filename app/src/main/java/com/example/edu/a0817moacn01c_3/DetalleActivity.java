package com.example.edu.a0817moacn01c_3;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class DetalleActivity extends AppCompatActivity{

    private Bundle unBundle;

    private List<Contenido> listaSeleccionada;
    private List<Contenido> listaRecomendados;
    private List<Contenido> listaMasVistos;
    private List<Contenido> ListaEstrenos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        listaSeleccionada= new ArrayList<>();

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager_Detalles);
        FragmentManager fragmentManager = getSupportFragmentManager();

        CargarContenido cargarPeliculas = new CargarContenido();
        listaRecomendados=cargarPeliculas.cargarPeliculasRecomendadasAmigos();
        listaMasVistos=cargarPeliculas.cargarPeliculasMasVistas();
        ListaEstrenos=cargarPeliculas.cargarPeliculasEstrenos();

        Intent unIntent = getIntent();
        this.unBundle = unIntent.getExtras();
        Integer nroLista = unBundle.getInt("nroLista");
        switch(nroLista){
            case 1:
                listaSeleccionada=listaRecomendados;
                AdaptadorDetallesViewPager adaptadorDetallesViewPager= new AdaptadorDetallesViewPager(fragmentManager,listaSeleccionada);
                viewPager.setAdapter(adaptadorDetallesViewPager);
                Integer posicion = unBundle.getInt("position");
                viewPager.setCurrentItem(posicion);
                break;
            case 2:
                listaSeleccionada=listaMasVistos;
                AdaptadorDetallesViewPager adaptadorDetallesViewPager2= new AdaptadorDetallesViewPager(fragmentManager,listaSeleccionada);
                viewPager.setAdapter(adaptadorDetallesViewPager2);
                Integer posicion2 = unBundle.getInt("position");
                viewPager.setCurrentItem(posicion2);
                break;
            case 3:
                listaSeleccionada=ListaEstrenos;
                AdaptadorDetallesViewPager adaptadorDetallesViewPager3= new AdaptadorDetallesViewPager(fragmentManager,listaSeleccionada);
                viewPager.setAdapter(adaptadorDetallesViewPager3);
                Integer posicion3 = unBundle.getInt("position");
                viewPager.setCurrentItem(posicion3);
                break;
        }

    }

    public void recibirDatos(){

        // Creo que masa adelante solo pasamos un identificador y el fragment hace la consulta en BD y/o API
    }
    public void botonCompartir(View view){

        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "Comparto algo edu";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }
}
