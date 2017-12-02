package com.example.edu.a0817moacn01c_3.View;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;

import com.example.edu.a0817moacn01c_3.Model.Contenido;
import com.example.edu.a0817moacn01c_3.R;
import com.example.edu.a0817moacn01c_3.View.FiltrosFragment.ContenidoFiltrado;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PachorraActivity extends AppCompatActivity implements PachorraFragment.NotificadorDatos,Serializable,ContenidoFiltrado{
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

        Toolbar toolbarPachorra = (Toolbar) findViewById(R.id.toolbar_pachorra);
        setSupportActionBar(toolbarPachorra);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);



        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Integer i = item.getItemId();
                        switch (i){
                            case R.id.action_mostrarSoloPeliculas:
                                cargarFragment(0);
                                break;
                            case R.id.action_mostrarMixto:
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

        cargarFragment(1);
    }

    @Override
    public void mandarDatos(Integer position, List<Contenido> listaContenidoClickeada) {
        //metodo para enviar la informacion de la pelicula al detalle activity
        Intent unIntent = new Intent(this,DetalleActivity.class);

        Bundle unBundle = new Bundle();

        unBundle.putInt(DetalleActivity.POSITION,position);
        unIntent.putExtra(DetalleActivity.LISTASELECCIONADA,(Serializable) listaContenidoClickeada).putExtras(unBundle);

        startActivity(unIntent);

    }
    public void cargarFragment(Integer tipoCargar){
        AppBarFragment appBarFragment = new AppBarFragment();
        Bundle bundle= new Bundle();
        bundle.putInt("tipocargar",tipoCargar);
        appBarFragment.setArguments(bundle);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contenedorfragments_pachorra,appBarFragment);
        fragmentTransaction.commit();
    }
public void cargarFragmentFiltrado(String genero,String contenido,Integer fecha){
    Bundle bundle= new Bundle();
    bundle.putString(PachorraFragment.TIPOCONTENIDO,"filtro");
    bundle.putString("genero",genero);
    bundle.putString("contenido",contenido);
    bundle.putInt("fecha",fecha);
    PachorraFragment pachorraFragment = new PachorraFragment();
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    fragmentTransaction.replace(R.id.contenedorfragments_pachorra,pachorraFragment);
    pachorraFragment.setArguments(bundle);
    fragmentTransaction.commit();
}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_appbar_pachorra, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        switch (item.getItemId()){
            case R.id.action_mostrarFavoritos:
                PachorraFragment pachorraFragment= new PachorraFragment();
                Bundle bundle = new Bundle();
                bundle.putString(PachorraFragment.TIPOCONTENIDO,"favoritos");
                pachorraFragment.setArguments(bundle);
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.contenedorfragments_pachorra,pachorraFragment);
                fragmentTransaction.commit();
                break;
            case R.id.action_mostrarFiltros:
                FiltrosFragment filtrosFragment= new FiltrosFragment();
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.contenedorfragments_pachorra,filtrosFragment);
                fragmentTransaction.commit();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void mandarSeleccionFiltrada(String genero,String contenido,Integer fecha) {
        cargarFragmentFiltrado(genero,contenido,fecha);

    }

}
