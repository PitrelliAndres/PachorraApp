package com.example.edu.a0817moacn01c_3;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetalleActivity extends AppCompatActivity{
    private DetalleFragment detalleFragment;
    private Bundle unBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        detalleFragment = new DetalleFragment();

        // Obtener info en del Bundle en el Intent emitido
        recibirDatos();

        detalleFragment.setArguments(unBundle);
        fragmentTransaction.replace(R.id.contenedorDeFragmentsDetalle, detalleFragment);
        fragmentTransaction.commit();
        //dsdsadsad

    }

    public void recibirDatos(){
        Intent unIntent = getIntent();
        this.unBundle = unIntent.getExtras();
        // Creo que masa adelante solo pasamos un identificador y el fragment hace la consulta en BD y/o API
    }

}
