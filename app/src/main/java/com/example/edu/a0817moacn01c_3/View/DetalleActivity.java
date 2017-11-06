package com.example.edu.a0817moacn01c_3.View;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.edu.a0817moacn01c_3.Controller.ControllerContenido;
import com.example.edu.a0817moacn01c_3.Model.Contenido;
import com.example.edu.a0817moacn01c_3.R;

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

        ControllerContenido controllerContenido = new ControllerContenido();

        listaRecomendados= controllerContenido.getListaMasrecomendados();
        listaMasVistos= controllerContenido.getListaMasvistos();
        ListaEstrenos= controllerContenido.getListaEstrenos();


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
        getSupportActionBar().setTitle(listaSeleccionada.get(unBundle.getInt("position")).getNombre());

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                getSupportActionBar().setTitle(listaSeleccionada.get(position).getNombre());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

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
