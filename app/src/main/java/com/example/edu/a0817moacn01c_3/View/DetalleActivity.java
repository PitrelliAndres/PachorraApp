package com.example.edu.a0817moacn01c_3.View;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.edu.a0817moacn01c_3.Controller.ControllerContenido;
import com.example.edu.a0817moacn01c_3.Model.Contenido;
import com.example.edu.a0817moacn01c_3.R;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class DetalleActivity extends AppCompatActivity{

    private Bundle unBundle;

    private List<Contenido> listaSeleccionada;


    public static final String POSITION = "position";
    public static final String LISTASELECCIONADA = "lista seleccionada";

    private FloatingActionMenu fabmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        listaSeleccionada= new ArrayList<>();

        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager_Detalles);
        FragmentManager fragmentManager = getSupportFragmentManager();



        final ControllerContenido controllerContenido = new ControllerContenido();
/*        listaPeliculasRecomendadasMixto = controllerContenido.getListaMasrecomendados();
        listaPeliculasMasVistasMixto = controllerContenido.getListaMasvistos();
        listaPeliculasEstrenosMixto = controllerContenido.getListaEstrenos();


        listaPeliculasRecomendadasPeliculas=controllerContenido.getListaMasRecomendados(Contenido.PELICULA);
        listaPeliculasMasVistasPeliculas=controllerContenido.getListaMasVistos(Contenido.PELICULA);
        listaPeliculasEstrenosPeliculas=controllerContenido.getListaEstreno(Contenido.PELICULA);

        listaPeliculasRecomendadasSeries=controllerContenido.getListaMasRecomendados(Contenido.SERIE);
        listaPeliculasMasVistasSeries=controllerContenido.getListaMasVistos(Contenido.SERIE);
        listaPeliculasEstrenosSeries=controllerContenido.getListaEstreno(Contenido.SERIE);*/
        Intent unIntent = getIntent();
        this.unBundle = unIntent.getExtras();


        listaSeleccionada = (List<Contenido>) unIntent.getSerializableExtra(LISTASELECCIONADA);

        AdaptadorDetallesViewPager adaptadorDetallesViewPager= new AdaptadorDetallesViewPager(fragmentManager,listaSeleccionada);
        viewPager.setAdapter(adaptadorDetallesViewPager);
        Integer posicion = unBundle.getInt(POSITION);
        viewPager.setCurrentItem(posicion);

        //FAB
        fabmenu = (FloatingActionMenu) findViewById(R.id.fabDetalle);
        final FloatingActionButton fabuttonFavoritos = (FloatingActionButton) findViewById(R.id.fabMenuFavoritos);
        final FloatingActionButton fabuttonCompartir = (FloatingActionButton) findViewById(R.id.fabMenuCompartir);
        final FloatingActionButton fabuttonRecomendar= (FloatingActionButton) findViewById(R.id.fabMenuRecomendar);
        final FloatingActionButton fabuttonPedirRecomendacion = (FloatingActionButton) findViewById(R.id.fabMenuPedirRecomendacion);

        fabmenu.setOnMenuButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Contenido item = listaSeleccionada.get(viewPager.getCurrentItem());
                Integer colorItem = controllerContenido.getColor(item);
                if(!fabmenu.isOpened()){
                    fabuttonCompartir.setLabelText("Compartir " + item.getNombre());
                    configurarColor(fabuttonCompartir, colorItem);
                    fabuttonCompartir.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            botonCompartir(item);
                        }
                    });
                    fabuttonFavoritos.setLabelText("Agregar " + item.getNombre() + " a favoritos");
                    configurarColor(fabuttonFavoritos, colorItem);
                    fabuttonPedirRecomendacion.setLabelText("Pedir recomendación de esta " + item.getTipoContenido());
                    configurarColor(fabuttonPedirRecomendacion, colorItem);
                    fabuttonRecomendar.setLabelText("Recomendar " + item.getNombre());
                    configurarColor(fabuttonRecomendar, colorItem);
                }
                fabmenu.toggle(true);
            }
        });

        getSupportActionBar().setTitle(listaSeleccionada.get(unBundle.getInt(POSITION)).getNombre());


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
                if (state != 0){
                    fabmenu.close(true);
                }
            }
        });



    }
    public void configurarColor(FloatingActionButton fabutton, Integer colorContenido){
        //fabutton.setColorNormalResId(colorContenido);
        fabutton.setColorPressedResId(colorContenido);
        // Todo: resolver quilombo de resourceId int != color int
        //fabutton.setLabelColors(colorContenido, R.color.colorAccent, colorContenido);
    }
    public void botonCompartir(Contenido contenido){

        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "Comparto una " + contenido.getTipoContenido() + ", Edu:\n"+contenido.getNombre() + "\n" + contenido.getSinopsis();
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, contenido.getNombre());
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Compartir por"));
    }
}
