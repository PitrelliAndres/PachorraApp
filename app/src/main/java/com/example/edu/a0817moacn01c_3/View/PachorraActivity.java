package com.example.edu.a0817moacn01c_3.View;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.edu.a0817moacn01c_3.Model.Contenido;
import com.example.edu.a0817moacn01c_3.R;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PachorraActivity extends AppCompatActivity implements PachorraFragment.NotificadorDatos,Serializable{
    private BottomNavigationView bottomNavigationView;
    public static final String tituloFragmentPeliculas = "Peliculas";
    public static final String tituloFragmentSeries = "Series";
    public static final String tituloFragmentMixto = "Inicio";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pachorra);

        final ViewPager viewPager=(ViewPager)findViewById(R.id.viewpager_Pachorra);
        FragmentManager fragmentManager = getSupportFragmentManager();
        AdaptadorPachorraViewPager adaptadorPachorraViewPager= new AdaptadorPachorraViewPager(fragmentManager);
        viewPager.setAdapter(adaptadorPachorraViewPager);
        viewPager.setCurrentItem(1,false);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        String titulo = item.getTitle().toString();
                        Integer i = item.getOrder();
                        switch (titulo){
                            case tituloFragmentPeliculas:
                                viewPager.setCurrentItem(0,true);
                                break;
                            case tituloFragmentMixto:
                                viewPager.setCurrentItem(1, true);
                                break;
                            case tituloFragmentSeries:
                                viewPager.setCurrentItem(2, true);
                                break;
                            default:
                                viewPager.setCurrentItem(1, true);
                                break;
                        }

                        return true;
                    }
                }
        );
    }

    @Override

    //metodo para enviar la informacion de la pelicula al detalle activity

    //Todo : preguntar como hacer el seralizable para pasar una lista de objetos
    public void mandarDatos(Integer position, List<Contenido> listaContenidoClickeada) {
        Intent unIntent = new Intent(this,DetalleActivity.class);

        Bundle unBundle = new Bundle();

        unBundle.putInt(DetalleActivity.POSITION,position);
        unIntent.putExtra(DetalleActivity.LISTASELECCIONADA,(Serializable) listaContenidoClickeada).putExtras(unBundle);

        startActivity(unIntent);

    }
}
