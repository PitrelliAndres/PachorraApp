package com.example.edu.a0817moacn01c_3.View;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.edu.a0817moacn01c_3.Controller.ControllerContenido;
import com.example.edu.a0817moacn01c_3.Model.Contenido;
import com.example.edu.a0817moacn01c_3.R;
import com.example.edu.a0817moacn01c_3.utils.TMDBHelper;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Andiy on 18/10/2017.
 */

public class PeliculasRecyclerAdapter extends RecyclerView.Adapter implements Serializable{
    private List<Contenido> listaContenidos;
    private Context contexto;
    private ContenidoClickeable contenidoClickeable;

    public PeliculasRecyclerAdapter(List<Contenido> listaContenidos, Context contexto, ContenidoClickeable contenidoClickeable) {
        this.listaContenidos = listaContenidos;
        this.contexto = contexto;
        this.contenidoClickeable = contenidoClickeable;
    }

    public void setListaContenidos(List<Contenido> listaPeliculas) {
        this.listaContenidos = listaPeliculas;
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
        final Contenido peliculas= listaContenidos.get(position);
        PeliculasViewHolder peliculasViewHolder=(PeliculasViewHolder) holder;
        peliculasViewHolder.cargarContenido(peliculas);



        peliculasViewHolder.itemView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                contenidoClickeable.mandarSeleccion(position,listaContenidos);
            }
        });

        peliculasViewHolder.botonFavoritos.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                ControllerContenido controllerContenido= new ControllerContenido();
                controllerContenido.agregarFavoritos(peliculas,contexto);
                FirebaseAuth mauth = FirebaseAuth.getInstance();
                String uid = mauth.getCurrentUser().getUid();
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Users").child(uid).child("Favoritos");
                myRef.push().setValue(peliculas);


            }
        });

    }

    @Override
    public int getItemCount() {
        return listaContenidos.size();
    }


    private class PeliculasViewHolder extends RecyclerView.ViewHolder{
        private ImageView imagenPelicula;
        private CardView cardPeli;
        private ImageView iconoContenido;
        private TextView tituloContenido;
        private String urlImagenAfiche;
        private Button botonFavoritos;

        public PeliculasViewHolder(View itemView){
            super(itemView);
            imagenPelicula=(ImageView)itemView.findViewById(R.id.imageView_ImagenContenidoPeliculas);
            cardPeli=(CardView)itemView.findViewById(R.id.cardview_ImagenPelicula);
            iconoContenido =(ImageView) itemView.findViewById(R.id.imageView_IconoContenido);
            tituloContenido =(TextView) itemView.findViewById(R.id.textView_tituloContenido);
            botonFavoritos=(Button) itemView.findViewById(R.id.button_agregar_favoritos);

        }
        public void cargarContenido(Contenido unContenido){
            Integer icono;
            Integer colorContenido;
            switch (unContenido.getTipoContenido()){
                case Contenido.PELICULA:
                    icono = R.drawable.ic_peliculas_color_24dp;
                    colorContenido = R.color.colorPeliculas;
                    break;
                case Contenido.SERIE:
                    icono = R.drawable.ic_series_color_24dp;
                    colorContenido = R.color.colorSeries;
                    break;
                default:
                    icono = R.drawable.ic_favorite_24dp;
                    colorContenido = R.color.colorAccent;
                    break;
            }
            urlImagenAfiche= TMDBHelper.getImagePoster(TMDBHelper.IMAGE_SIZE_W300,unContenido.getUrlafiche());

            Glide.with(contexto).load(urlImagenAfiche).into(imagenPelicula);
            iconoContenido.setImageResource(icono);
            tituloContenido.setText(unContenido.getNombre());

        }
    }
    public interface ContenidoClickeable{
        public void mandarSeleccion(Integer position,List<Contenido> listaContenidoClickeada);


    }
}
