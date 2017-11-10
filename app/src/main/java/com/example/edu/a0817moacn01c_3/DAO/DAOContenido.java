package com.example.edu.a0817moacn01c_3.DAO;

import android.content.Context;
import android.content.res.AssetManager;

import com.example.edu.a0817moacn01c_3.Model.ContenedorDeContenido;
import com.example.edu.a0817moacn01c_3.Model.Contenido;
import com.example.edu.a0817moacn01c_3.Model.Pelicula;
import com.example.edu.a0817moacn01c_3.Model.Serie;
import com.example.edu.a0817moacn01c_3.R;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andiy on 30/10/2017.
 */

public class DAOContenido {

    public List<Contenido> obtenerListaRecomendadas(){
        List<Contenido> contenidos= new ArrayList<>();
        String textdescPreparacion="Fusce hendrerit nisl a lectus porttitor egestas. Aenean viverra dignissim vehicula. Sed vestibulum felis sapien, in pretium est dictum eget. Nullam pharetra luctus tortor, vitae placerat massa placerat id. Fusce vel augue sed lorem rutrum vestibulum eget eget dolor. Aliquam molestie, odio et auctor mollis, ex turpis interdum felis, ac suscipit elit metus non velit. Praesent et sagittis lectus. Phasellus eget magna sagittis, tristac suscipit elit metus non velit. Praesent et sagittis lectus. Phasellus eget magna sagittis, tristique lectus ac, auctor ante. Vivamus ac ultricies est, non maximus lacus. Ut aliquet finibus lacus vel accumsan. Praesent ultrices dui nec luctus posuere. Mauris non erat sem. Integer vulputate, dolor et tincidunt ultrices, sapien erat lobortis lectus, eget rhoncus tellus urna in diam. Lorem ipsum dolor sit amet, consectetur adipiscing elit.";

        contenidos.add(new Pelicula(1,"Arma Mortal", R.drawable.arma_mortal,R.drawable.arma_mortal,"accion",textdescPreparacion,10.0,"ATP","a"));
        contenidos.add(new Serie(2,"Derek", R.drawable.derek,R.drawable.derek,"accion",textdescPreparacion,10.0,"ATP",2,3));
        contenidos.add(new Pelicula(3,"avatar", R.drawable.avatar,R.drawable.avatar,"accion",textdescPreparacion,10.0,"ATP","a"));
        contenidos.add(new Pelicula(4,"El Dia De La Marmota", R.drawable.el_dia_de_la_marmota,R.drawable.el_dia_de_la_marmota,"accion",textdescPreparacion,10.0,"ATP","a"));
        contenidos.add(new Serie(5,"El Senor De Los_Anillos", R.drawable.el_senor_de_los_anillos,R.drawable.el_senor_de_los_anillos,"accion",textdescPreparacion,10.0,"ATP",2,2));
        contenidos.add(new Pelicula(6,"Forrest Gump", R.drawable.forrest_gump,R.drawable.forrest_gump,"accion",textdescPreparacion,10.0,"ATP","a"));
        return contenidos;
    }
    public List<Contenido> obtenerListaMasVistas(){
        List<Contenido> contenidos= new ArrayList<>();
        String textdescPreparacion="Fusce hendrerit nisl a lectus porttitor egestas. Aenean viverra dignissim vehicula. Sed vestibulum felis sapien, in pretium est dictum eget. Nullam pharetra luctus tortor, vitae placerat massa placerat id. Fusce vel augue sed lorem rutrum vestibulum eget eget dolor. Aliquam molestie, odio et auctor mollis, ex turpis interdum felis, ac suscipit elit metus non velit. Praesent et sagittis lectus. Phasellus eget magna sagittis, tristique lectus ac, auctor ante. Vivamus ac ultricies est, non maximus lacus. Ut aliquet finibus lacus vel accumsan. Praesent ultrices dui nec luctus posuere. Mauris non erat sem. Integer vulputate, dolor et tincidunt ultrices, sapien erat lobortis lectus, eget rhoncus tellus urna in diam. Lorem ipsum dolor sit amet, consectetur adipiscing elit.";

        contenidos.add(new Pelicula(1,"Arma Mortal", R.drawable.arma_mortal,R.drawable.arma_mortal,"accion",textdescPreparacion,10.0,"ATP","a"));
        contenidos.add(new Pelicula(2,"Derek", R.drawable.derek,R.drawable.derek,"accion",textdescPreparacion,10.0,"ATP","a"));
        contenidos.add(new Serie(3,"avatar", R.drawable.avatar,R.drawable.avatar,"accion",textdescPreparacion,10.0,"ATP",2,2));
        contenidos.add(new Pelicula(4,"El Dia De La Marmota", R.drawable.el_dia_de_la_marmota,R.drawable.el_dia_de_la_marmota,"accion",textdescPreparacion,10.0,"ATP","a"));
        contenidos.add(new Pelicula(5,"El Senor De Los_Anillos", R.drawable.el_senor_de_los_anillos,R.drawable.el_senor_de_los_anillos,"accion",textdescPreparacion,10.0,"ATP","a"));
        contenidos.add(new Pelicula(6,"Forrest Gump", R.drawable.forrest_gump,R.drawable.forrest_gump,"accion",textdescPreparacion,10.0,"ATP","a"));
        return contenidos;
    }
    public List<Contenido> obtenerListaEstrenos(){
        List<Contenido> contenidos= new ArrayList<>();
        String textdescPreparacion="Fusce hendrerit nisl a lectus porttitor egestas. Aenean viverra dignissim vehicula. Sed vestibulum felis sapien, in pretium est dictum eget. Nullam pharetra luctus tortor, vitae placerat massa placerat id. Fusce vel augue sed lorem rutrum vestibulum eget eget dolor. Aliquam molestie, odio et auctor mollis, ex turpis interdum felis, ac suscipit elit metus non velit. Praesent et sagittis lectus. Phasellus eget magna sagittis, tristique lectus ac, auctor ante. Vivamus ac ultricies est, non maximus lacus. Ut aliquet finibus lacus vel accumsan. Praesent ultrices dui nec luctus posuere. Mauris non erat sem. Integer vulputate, dolor et tincidunt ultrices, sapien erat lobortis lectus, eget rhoncus tellus urna in diam. Lorem ipsum dolor sit amet, consectetur adipiscing elit.";

        contenidos.add(new Pelicula(1,"Arma Mortal", R.drawable.arma_mortal,R.drawable.arma_mortal,"accion",textdescPreparacion,10.0,"ATP","a"));
        contenidos.add(new Serie(2,"Derek", R.drawable.derek,R.drawable.derek,"accion",textdescPreparacion,10.0,"ATP",2,2));
        contenidos.add(new Pelicula(3,"avatar", R.drawable.avatar,R.drawable.avatar,"accion",textdescPreparacion,10.0,"ATP","a"));
        contenidos.add(new Serie(4,"El Dia De La Marmota", R.drawable.el_dia_de_la_marmota,R.drawable.el_dia_de_la_marmota,"accion",textdescPreparacion,10.0,"ATP",2,2));
        contenidos.add(new Pelicula(5,"El Senor De Los_Anillos", R.drawable.el_senor_de_los_anillos,R.drawable.el_senor_de_los_anillos,"accion",textdescPreparacion,10.0,"ATP","a"));
        contenidos.add(new Pelicula(6,"Forrest Gump", R.drawable.forrest_gump,R.drawable.forrest_gump,"accion",textdescPreparacion,10.0,"ATP","a"));
        return contenidos;
    }
/*    public List<Contenido> getListaDeContenidoFromArchivo(Context context){
        ContenedorDeContenido contenedorDeContenido = null;
        try {
            AssetManager manager = context.getAssets();
            InputStream productsJson = null;
            productsJson = manager.open("listadecontenido.json");
            BufferedReader bufferReaderIn = new BufferedReader(new InputStreamReader(productsJson));

            Gson gson = new Gson();
            contenedorDeContenido = gson.fromJson(bufferReaderIn, ContenedorDeContenido.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return contenedorDeContenido.getContenidos();
    }*/

}
