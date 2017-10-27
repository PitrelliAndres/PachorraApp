package com.example.edu.a0817moacn01c_3;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Andiy on 18/10/2017.
 */

public class PeliculasRecyclerAdapter extends RecyclerView.Adapter{
    private List<Contenido> listaPeliculas;

    private Context contexto;
    private ContenidoClickeable contenidoClickeable;

    public PeliculasRecyclerAdapter(List<Contenido> listaPeliculas, Context contexto, ContenidoClickeable contenidoClickeable) {
        this.listaPeliculas = listaPeliculas;
        this.contexto = contexto;
        this.contenidoClickeable = contenidoClickeable;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater unInflador= LayoutInflater.from(contexto);
        View view= unInflador.inflate(R.layout.celdacontenido,parent,false);
        PeliculasViewHolder peliculasViewHolder= new PeliculasViewHolder(view);
        return peliculasViewHolder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final Contenido peliculas= listaPeliculas.get(position);
        PeliculasViewHolder peliculasViewHolder=(PeliculasViewHolder) holder;
        peliculasViewHolder.cargarPelicula(peliculas);

        peliculasViewHolder.itemView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                contenidoClickeable.mandarSeleccion(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaPeliculas.size();
    }


    private class PeliculasViewHolder extends RecyclerView.ViewHolder{
        private ImageView imagenPelicula;
        private CardView cardPeli;

        public PeliculasViewHolder(View itemView){
            super(itemView);
            imagenPelicula=itemView.findViewById(R.id.imageView_ImagenContenido);
            cardPeli=itemView.findViewById(R.id.cardview_ImagenPelicula);
        }
        public void cargarPelicula(Contenido unaPelicula){
            imagenPelicula.setImageResource(unaPelicula.getImagen());
        }
    }
    public interface ContenidoClickeable{
        public void mandarSeleccion(Integer position);
        //public void mandarSeleccion(Pelicula unaPelicula,Context unContexto);
    }
}
