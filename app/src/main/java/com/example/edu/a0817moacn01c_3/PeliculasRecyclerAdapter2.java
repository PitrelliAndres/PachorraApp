package com.example.edu.a0817moacn01c_3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Andiy on 18/10/2017.
 */

public class PeliculasRecyclerAdapter2 extends RecyclerView.Adapter {
    private List<Peliculas> listaPeliculas;
    private Context contexto;
    private ClickeablePelicula clickeablePelicula;

    public PeliculasRecyclerAdapter2(List<Peliculas> listaPeliculas, Context contexto, ClickeablePelicula clickeablePelicula) {
        this.listaPeliculas = listaPeliculas;
        this.contexto = contexto;
        this.clickeablePelicula = clickeablePelicula;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater unInflador= LayoutInflater.from(contexto);
        View view= unInflador.inflate(R.layout.celdapeliculas,parent,false);
        PeliculasViewHolder peliculasViewHolder= new PeliculasViewHolder(view);
        return peliculasViewHolder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Peliculas peliculas= listaPeliculas.get(position);
        PeliculasRecyclerAdapter2.PeliculasViewHolder peliculasViewHolder=(PeliculasViewHolder) holder;
        peliculasViewHolder.cargarPelicula(peliculas);

        peliculasViewHolder.itemView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                clickeablePelicula.mandarSeleccion(peliculas);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaPeliculas.size();
    }
    private class PeliculasViewHolder extends RecyclerView.ViewHolder{
        private ImageView imagenPelicula;

        public PeliculasViewHolder(View itemView){
            super(itemView);
            imagenPelicula=itemView.findViewById(R.id.imageView_ImagenPelicula);
        }
        public void cargarPelicula(Peliculas unaPelicula){
            imagenPelicula.setImageResource(unaPelicula.getImagen());
        }
    }
    public interface ClickeablePelicula{
        public void mandarSeleccion(Peliculas unaPelicula);
        //public void mandarSeleccion(Peliculas unaPelicula,Context unContexto);
    }
}
