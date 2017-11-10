package com.example.edu.a0817moacn01c_3.View;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.edu.a0817moacn01c_3.R;

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
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        /*switch ()*/

                        return false;
                    }
                }
        );
    }

    @Override
    //metodo para enviar la informacion de la pelicula al detalle activity
    public void mandarDatos(Integer position,Integer nroListaContenido) {
        Intent unIntent = new Intent(this,DetalleActivity.class);

        Bundle unBundle= new Bundle();

        unBundle.putInt("position",position);
        unBundle.putInt("nroLista", nroListaContenido);


        unIntent.putExtras(unBundle);
        startActivity(unIntent);

    }
}
