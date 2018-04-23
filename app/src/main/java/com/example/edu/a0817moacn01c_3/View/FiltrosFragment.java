package com.example.edu.a0817moacn01c_3.View;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.edu.a0817moacn01c_3.Controller.ControllerContenido;
import com.example.edu.a0817moacn01c_3.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FiltrosFragment extends Fragment {

    private ContenidoFiltrado contenidoFiltrado;
    Spinner spinnerGenero;
    Spinner spinnerTipoContenido;
    EditText fecha;
    String[] generos;// = {"accion", "comedia", "drama"};
    String[] contenido;// = {"Pelicula", "Serie"};
    Button botonFiltrar;
    Integer fechaIntroducida;
    ControllerContenido controllerContenido;

    public FiltrosFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        contenidoFiltrado = (ContenidoFiltrado) context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filtros, container, false);
        spinnerGenero = (Spinner) view.findViewById(R.id.spinner_genero);
        spinnerTipoContenido = (Spinner) view.findViewById(R.id.spinner_tipoContenido);
        fecha = (EditText) view.findViewById(R.id.editext_introducir_fecha);

        controllerContenido = new ControllerContenido(getContext());
        contenido = controllerContenido.getTiposDeContenido();
        generos = controllerContenido.getGenerosNombres();

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter1 = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, contenido);

        ArrayAdapter<String> adapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, generos);
        // Specify the layout to use when the list of choices appears
        // Apply the adapter to the spinner

        spinnerGenero.setAdapter(adapter);
        spinnerTipoContenido.setAdapter(adapter1);
        botonFiltrar = (Button) view.findViewById(R.id.boton_filtrar);


        botonFiltrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fechaIntroducida = Integer.parseInt(fecha.getText().toString());
                contenidoFiltrado.mandarSeleccionFiltrada(spinnerGenero.getSelectedItem().toString(), spinnerTipoContenido.getSelectedItem().toString(), fechaIntroducida);
            }
        });

        return view;

    }

    public interface ContenidoFiltrado {
        public void mandarSeleccionFiltrada(String genero, String contenido, Integer fecha);
    }
}
