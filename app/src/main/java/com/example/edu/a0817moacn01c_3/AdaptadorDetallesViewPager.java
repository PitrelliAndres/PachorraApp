package com.example.edu.a0817moacn01c_3;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andiy on 22/10/2017.
 */

    public class AdaptadorDetallesViewPager extends FragmentStatePagerAdapter {
        private List<Fragment> fragmentList;
        private List<Peliculas> listaRecomendadas;

    public AdaptadorDetallesViewPager(FragmentManager fm) {
        super(fm);

        fragmentList = new ArrayList<>();

        PeliculasCargadas peliculasCargadas = new PeliculasCargadas();
        listaRecomendadas=peliculasCargadas.cargarPeliculasRecomendadasAmigos();
        for (Peliculas unaPelicula:listaRecomendadas) {

            fragmentList.add(DetalleFragment.dameDetalleFragment(unaPelicula.getNombre(),unaPelicula.getImagen(),unaPelicula.getImagenPortada(),unaPelicula.getGenero(),unaPelicula.getDesc(),unaPelicula.getPuntuacion(),unaPelicula.getAptoParaPublico()));
        }
      }



    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
