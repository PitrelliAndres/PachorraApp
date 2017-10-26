package com.example.edu.a0817moacn01c_3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andiy on 22/10/2017.
 */

public class PeliculasCargadas {
    private List<Contenido>peliculasRecomendadas;
    private List<Contenido>peliculasmasVistas;
    private List<Contenido>pelicuasEstrenos;

    public PeliculasCargadas() {

    }

    public List<Contenido> cargarPeliculasRecomendadasAmigos(){
        peliculasRecomendadas = new ArrayList<>();
        String descArmaMortal = "Una pareja de policías tiene como misión proteger a un individuo que va a testificar en contra de una organización de traficantes de droga. Las cosas se complican cuando uno de ellos decide iniciar la investigación por su cuenta sin comunicarlo a la comisaría. Una pareja de policías tiene como misión proteger a un individuo que va a testificar en contra de una organización de traficantes de droga. Las cosas se complican cuando uno de ellos decide iniciar la investigación por su cuenta sin comunicarlo a la comisaría. Una pareja de policías tiene como misión proteger a un individuo que va a testificar en contra de una organización de traficantes de droga. Las cosas se complican cuando uno de ellos decide iniciar la investigación por su cuenta sin comunicarlo a la comisaría. Una pareja de policías tiene como misión proteger a un individuo que va a testificar en contra de una organización de traficantes de droga. Las cosas se complican cuando uno de ellos decide iniciar la investigación por su cuenta sin comunicarlo a la comisaría. Una pareja de policías tiene como misión proteger a un individuo que va a testificar en contra de una organización de traficantes de droga. Las cosas se complican cuando uno de ellos decide iniciar la investigación por su cuenta sin comunicarlo a la comisaría.";
        peliculasRecomendadas.add(new Peliculas(1,"Arma Mortal", R.drawable.arma_mortal, R.drawable.arma_mortal,"accion",descArmaMortal,10.0,"ATP","Pelicula"));
        peliculasRecomendadas.add(new Series(2,"Derek", R.drawable.derek, R.drawable.derek_backdrop,"Mockumentary, Ciencia Ficción",descArmaMortal,9.5,"ATP",2,2,2,"Serie"));
        peliculasRecomendadas.add(new Series(3,"avatar", R.drawable.avatar, R.drawable.avatar,"accion",descArmaMortal,6.0,"ATP",1,3,5,"Serie"));
        peliculasRecomendadas.add(new Peliculas(4,"El Dia De La Marmota", R.drawable.el_dia_de_la_marmota, R.drawable.dia_de_la_marmota_backdrop,"accion",descArmaMortal,8.0,"ATP","Pelicula"));
        peliculasRecomendadas.add(new Series(5,"El Senor De Los_Anillos", R.drawable.el_senor_de_los_anillos, R.drawable.el_senor_de_los_anillos,"accion",descArmaMortal,10.0,"ATP",2,3,5,"Serie"));
        peliculasRecomendadas.add(new Peliculas(6,"Forrest Gump", R.drawable.forrest_gump, R.drawable.forrest_gump,"accion",descArmaMortal,10.0,"ATP","Pelicula"));
        peliculasRecomendadas.add(new Peliculas(7,"Indiana Jones", R.drawable.indiana_jones, R.drawable.indiana_jones,"accion",descArmaMortal,10.0,"ATP","Pelicula"));
        return peliculasRecomendadas;
    }
    public List<Contenido> cargarPeliculasMasVistas(){
        peliculasmasVistas = new ArrayList<>();
        String descArmaMortal = "Una pareja de policías tiene como misión proteger a un individuo que va a testificar en contra de una organización de traficantes de droga. Las cosas se complican cuando uno de ellos decide iniciar la investigación por su cuenta sin comunicarlo a la comisaría. Una pareja de policías tiene como misión proteger a un individuo que va a testificar en contra de una organización de traficantes de droga. Las cosas se complican cuando uno de ellos decide iniciar la investigación por su cuenta sin comunicarlo a la comisaría. Una pareja de policías tiene como misión proteger a un individuo que va a testificar en contra de una organización de traficantes de droga. Las cosas se complican cuando uno de ellos decide iniciar la investigación por su cuenta sin comunicarlo a la comisaría. Una pareja de policías tiene como misión proteger a un individuo que va a testificar en contra de una organización de traficantes de droga. Las cosas se complican cuando uno de ellos decide iniciar la investigación por su cuenta sin comunicarlo a la comisaría. Una pareja de policías tiene como misión proteger a un individuo que va a testificar en contra de una organización de traficantes de droga. Las cosas se complican cuando uno de ellos decide iniciar la investigación por su cuenta sin comunicarlo a la comisaría.";
        peliculasmasVistas.add(new Peliculas(8,"Logan", R.drawable.arma_mortal, R.drawable.arma_mortal,"Accion",descArmaMortal,10.0,"ATP","Pelicula"));
        peliculasmasVistas.add(new Peliculas(9,"Spider man: Homecoming", R.drawable.arma_mortal, R.drawable.arma_mortal,"Ciencia Ficción",descArmaMortal,8.0,"ATP","Pelicula"));
        peliculasmasVistas.add(new Peliculas(10,"It", R.drawable.arma_mortal, R.drawable.arma_mortal,"Terror",descArmaMortal,7.0,"+16","Pelicula"));
        peliculasmasVistas.add(new Peliculas(11,"Mi Villano Favorito 3", R.drawable.arma_mortal, R.drawable.arma_mortal,"Comedia",descArmaMortal,8.0,"ATP","Pelicula"));
        peliculasmasVistas.add(new Peliculas(12,"La Bella Y La Bestia", R.drawable.arma_mortal, R.drawable.arma_mortal,"Infantil",descArmaMortal,9.0,"ATP","Pelicula"));
        peliculasmasVistas.add(new Peliculas(13,"Guardianes de la galaxia 2", R.drawable.arma_mortal, R.drawable.arma_mortal,"Ciencia ficcion",descArmaMortal,9.0,"ATP","Pelicula"));
        peliculasmasVistas.add(new Peliculas(14,"Rapidos y Furiosos 8", R.drawable.arma_mortal, R.drawable.arma_mortal,"Accion",descArmaMortal,6.0,"ATP","Pelicula"));
        return peliculasmasVistas;
    }
    public List<Contenido> cargarPeliculasEstrenos(){
        pelicuasEstrenos = new ArrayList<>();
        String descArmaMortal = "Una pareja de policías tiene como misión proteger a un individuo que va a testificar en contra de una organización de traficantes de droga. Las cosas se complican cuando uno de ellos decide iniciar la investigación por su cuenta sin comunicarlo a la comisaría. Una pareja de policías tiene como misión proteger a un individuo que va a testificar en contra de una organización de traficantes de droga. Las cosas se complican cuando uno de ellos decide iniciar la investigación por su cuenta sin comunicarlo a la comisaría. Una pareja de policías tiene como misión proteger a un individuo que va a testificar en contra de una organización de traficantes de droga. Las cosas se complican cuando uno de ellos decide iniciar la investigación por su cuenta sin comunicarlo a la comisaría. Una pareja de policías tiene como misión proteger a un individuo que va a testificar en contra de una organización de traficantes de droga. Las cosas se complican cuando uno de ellos decide iniciar la investigación por su cuenta sin comunicarlo a la comisaría. Una pareja de policías tiene como misión proteger a un individuo que va a testificar en contra de una organización de traficantes de droga. Las cosas se complican cuando uno de ellos decide iniciar la investigación por su cuenta sin comunicarlo a la comisaría.";
        pelicuasEstrenos.add(new Peliculas(15,"Blade Runner ", R.drawable.arma_mortal, R.drawable.arma_mortal,"ciencia ficcion",descArmaMortal,9.0,"ATP","Pelicula"));
        pelicuasEstrenos.add(new Peliculas(16,"El Muñeco De Nieve", R.drawable.arma_mortal, R.drawable.arma_mortal,"drama",descArmaMortal,5.0,"ATP","Pelicula"));
        pelicuasEstrenos.add(new Peliculas(17,"El Ultimo Traje", R.drawable.arma_mortal, R.drawable.arma_mortal,"drama",descArmaMortal,8.0,"ATP","Pelicula"));
        pelicuasEstrenos.add(new Peliculas(18,"La Cabaña", R.drawable.arma_mortal, R.drawable.arma_mortal,"drama",descArmaMortal,8.0,"ATP","Pelicula"));
        pelicuasEstrenos.add(new Peliculas(19,"Anabelle 2", R.drawable.arma_mortal, R.drawable.arma_mortal,"Terror",descArmaMortal,6.0,"+16","Pelicula"));
        pelicuasEstrenos.add(new Peliculas(20,"Mal Genio", R.drawable.arma_mortal, R.drawable.arma_mortal,"Comedia",descArmaMortal,8.0,"ATP","Pelicula"));
        pelicuasEstrenos.add(new Peliculas(21,"La Llamada", R.drawable.arma_mortal, R.drawable.arma_mortal,"Comedia Musical",descArmaMortal,7.0,"ATP","Pelicula"));
        return pelicuasEstrenos;
    }
    public List<Contenido> getPeliculasRecomendadas() {
        return peliculasRecomendadas;
    }

    public List<Contenido> getPeliculasmasVistas() {
        return peliculasmasVistas;
    }

    public List<Contenido> getPelicuasEstrenos() {
        return pelicuasEstrenos;
    }
}