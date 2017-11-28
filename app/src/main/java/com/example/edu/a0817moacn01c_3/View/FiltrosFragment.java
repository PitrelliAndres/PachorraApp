package com.example.edu.a0817moacn01c_3.View;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.edu.a0817moacn01c_3.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FiltrosFragment extends Fragment {


    public FiltrosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View view =inflater.inflate(R.layout.fragment_filtros, container, false);
              Spinner spinner = (Spinner) view.findViewById(R.id.spinner_genero);
// Create an ArrayAdapter using the string array and a default spinner layout
        String[] generos= {"accion","comedia","drama"};
        ArrayAdapter<String> adapter = new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item ,generos);
// Specify the layout to use when the list of choices appears
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        return view;
    }

}
