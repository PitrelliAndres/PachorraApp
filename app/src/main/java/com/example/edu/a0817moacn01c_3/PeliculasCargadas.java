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

    public List<Peliculas> cargarPeliculasRecomendadasAmigos(){
        peliculasRecomendadas = new ArrayList<>();
        String descArmaMortal = "Una pareja de policías tiene como misión proteger a un individuo que va a testificar en contra de una organización de traficantes de droga. Las cosas se complican cuando uno de ellos decide iniciar la investigación por su cuenta sin comunicarlo a la comisaría. Una pareja de policías tiene como misión proteger a un individuo que va a testificar en contra de una organización de traficantes de droga. Las cosas se complican cuando uno de ellos decide iniciar la investigación por su cuenta sin comunicarlo a la comisaría. Una pareja de policías tiene como misión proteger a un individuo que va a testificar en contra de una organización de traficantes de droga. Las cosas se complican cuando uno de ellos decide iniciar la investigación por su cuenta sin comunicarlo a la comisaría. Una pareja de policías tiene como misión proteger a un individuo que va a testificar en contra de una organización de traficantes de droga. Las cosas se complican cuando uno de ellos decide iniciar la investigación por su cuenta sin comunicarlo a la comisaría. Una pareja de policías tiene como misión proteger a un individuo que va a testificar en contra de una organización de traficantes de droga. Las cosas se complican cuando uno de ellos decide iniciar la investigación por su cuenta sin comunicarlo a la comisaría.";
        peliculasRecomendadas.add(new Peliculas("Arma Mortal", R.drawable.arma_mortal, R.drawable.arma_mortal,"accion",descArmaMortal,10.0,"ATP"));
        peliculasRecomendadas.add(new Peliculas("Derek", R.drawable.derek, R.drawable.derek_backdrop,"Mockumentary, Ciencia Ficción",descArmaMortal,9.5,"ATP"));
        peliculasRecomendadas.add(new Peliculas("avatar", R.drawable.avatar, R.drawable.avatar,"accion",descArmaMortal,6.0,"ATP"));
        peliculasRecomendadas.add(new Peliculas("El Dia De La Marmota", R.drawable.el_dia_de_la_marmota, R.drawable.dia_de_la_marmota_backdrop,"accion",descArmaMortal,8.0,"ATP"));
        peliculasRecomendadas.add(new Peliculas("El Senor De Los_Anillos", R.drawable.el_senor_de_los_anillos, R.drawable.el_senor_de_los_anillos,"accion",descArmaMortal,10.0,"ATP"));
        peliculasRecomendadas.add(new Peliculas("Forrest Gump", R.drawable.forrest_gump, R.drawable.forrest_gump,"accion",descArmaMortal,10.0,"ATP"));
        peliculasRecomendadas.add(new Peliculas("Indiana Jones", R.drawable.indiana_jones, R.drawable.indiana_jones,"accion",descArmaMortal,10.0,"ATP"));
        return peliculasRecomendadas;
    }
    public List<Peliculas> cargarPeliculasMasVistas(){
        peliculasmasVistas = new ArrayList<>();
        String descArmaMortal = "Una pareja de policías tiene como misión proteger a un individuo que va a testificar en contra de una organización de traficantes de droga. Las cosas se complican cuando uno de ellos decide iniciar la investigación por su cuenta sin comunicarlo a la comisaría. Una pareja de policías tiene como misión proteger a un individuo que va a testificar en contra de una organización de traficantes de droga. Las cosas se complican cuando uno de ellos decide iniciar la investigación por su cuenta sin comunicarlo a la comisaría. Una pareja de policías tiene como misión proteger a un individuo que va a testificar en contra de una organización de traficantes de droga. Las cosas se complican cuando uno de ellos decide iniciar la investigación por su cuenta sin comunicarlo a la comisaría. Una pareja de policías tiene como misión proteger a un individuo que va a testificar en contra de una organización de traficantes de droga. Las cosas se complican cuando uno de ellos decide iniciar la investigación por su cuenta sin comunicarlo a la comisaría. Una pareja de policías tiene como misión proteger a un individuo que va a testificar en contra de una organización de traficantes de droga. Las cosas se complican cuando uno de ellos decide iniciar la investigación por su cuenta sin comunicarlo a la comisaría.";
        peliculasmasVistas.add(new Peliculas("Logan", R.drawable.arma_mortal, R.drawable.arma_mortal,"Accion",descArmaMortal,10.0,"ATP"));
        peliculasmasVistas.add(new Peliculas("Spider man: Homecoming", R.drawable.arma_mortal, R.drawable.arma_mortal,"Ciencia Ficción",descArmaMortal,8.0,"ATP"));
        peliculasmasVistas.add(new Peliculas("It", R.drawable.arma_mortal, R.drawable.arma_mortal,"Terror",descArmaMortal,7.0,"+16"));
        peliculasmasVistas.add(new Peliculas("Mi Villano Favorito 3", R.drawable.arma_mortal, R.drawable.arma_mortal,"Comedia",descArmaMortal,8.0,"ATP"));
        peliculasmasVistas.add(new Peliculas("La Bella Y La Bestia", R.drawable.arma_mortal, R.drawable.arma_mortal,"Infantil",descArmaMortal,9.0,"ATP"));
        peliculasmasVistas.add(new Peliculas("Guardianes de la galaxia 2", R.drawable.arma_mortal, R.drawable.arma_mortal,"Ciencia ficcion",descArmaMortal,9.0,"ATP"));
        peliculasmasVistas.add(new Peliculas("Rapidos y Furiosos 8", R.drawable.arma_mortal, R.drawable.arma_mortal,"Accion",descArmaMortal,6.0,"ATP"));
        return peliculasmasVistas;
    }
    public List<Peliculas> cargarPeliculasEstrenos(){
        pelicuasEstrenos = new ArrayList<>();
        String descArmaMortal = "Una pareja de policías tiene como misión proteger a un individuo que va a testificar en contra de una organización de traficantes de droga. Las cosas se complican cuando uno de ellos decide iniciar la investigación por su cuenta sin comunicarlo a la comisaría. Una pareja de policías tiene como misión proteger a un individuo que va a testificar en contra de una organización de traficantes de droga. Las cosas se complican cuando uno de ellos decide iniciar la investigación por su cuenta sin comunicarlo a la comisaría. Una pareja de policías tiene como misión proteger a un individuo que va a testificar en contra de una organización de traficantes de droga. Las cosas se complican cuando uno de ellos decide iniciar la investigación por su cuenta sin comunicarlo a la comisaría. Una pareja de policías tiene como misión proteger a un individuo que va a testificar en contra de una organización de traficantes de droga. Las cosas se complican cuando uno de ellos decide iniciar la investigación por su cuenta sin comunicarlo a la comisaría. Una pareja de policías tiene como misión proteger a un individuo que va a testificar en contra de una organización de traficantes de droga. Las cosas se complican cuando uno de ellos decide iniciar la investigación por su cuenta sin comunicarlo a la comisaría.";
        pelicuasEstrenos.add(new Peliculas("Blade Runner ", R.drawable.arma_mortal, R.drawable.arma_mortal,"ciencia ficcion",descArmaMortal,9.0,"ATP"));
        pelicuasEstrenos.add(new Peliculas("El Muñeco De Nieve", R.drawable.arma_mortal, R.drawable.arma_mortal,"drama",descArmaMortal,5.0,"ATP"));
        pelicuasEstrenos.add(new Peliculas("El Ultimo Traje", R.drawable.arma_mortal, R.drawable.arma_mortal,"drama",descArmaMortal,8.0,"ATP"));
        pelicuasEstrenos.add(new Peliculas("La Cabaña", R.drawable.arma_mortal, R.drawable.arma_mortal,"drama",descArmaMortal,8.0,"ATP"));
        pelicuasEstrenos.add(new Peliculas("Anabelle 2", R.drawable.arma_mortal, R.drawable.arma_mortal,"Terror",descArmaMortal,6.0,"+16"));
        pelicuasEstrenos.add(new Peliculas("Mal Genio", R.drawable.arma_mortal, R.drawable.arma_mortal,"Comedia",descArmaMortal,8.0,"ATP"));
        pelicuasEstrenos.add(new Peliculas("La Llamada", R.drawable.arma_mortal, R.drawable.arma_mortal,"Comedia Musical",descArmaMortal,7.0,"ATP"));
        return pelicuasEstrenos;
    }
    public List<Peliculas> getPeliculasRecomendadas() {
        return peliculasRecomendadas;
    }

    public List<Peliculas> getPeliculasmasVistas() {
        return peliculasmasVistas;
    }

    public List<Peliculas> getPelicuasEstrenos() {
        return pelicuasEstrenos;
    }
}
