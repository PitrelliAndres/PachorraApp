package com.example.edu.a0817moacn01c_3.View;

import android.app.ActionBar;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;

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
    private ViewPager viewPager;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pachorra);


        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Integer i = item.getItemId();
                        switch (i){
                            case R.id.action_mostrarSoloPeliculas:
                                cargarFragment(0);
                                break;
                            case R.id.action_mostrarFiltros:
                                cargarFragment(1);
                                break;
                            case R.id.action_mostrarSoloSeries:
                                cargarFragment(2);
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
    public void cargarFragment(Integer tipoCargar){
        AppBarFragment appBarFragment= new AppBarFragment();

        Bundle bundle= new Bundle();
        bundle.putInt("tipocargar",tipoCargar);
        appBarFragment.setArguments(bundle);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contenedorfragments_pachorra,appBarFragment);
        fragmentTransaction.commit();
    }
}
