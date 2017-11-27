package com.example.edu.a0817moacn01c_3.View;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.edu.a0817moacn01c_3.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OnboardingFragment extends Fragment {
    private TextView unTextView;
    private TextView segundoTextView;
    private String unString;
    private String segundoString;
    private Button unButton;

    public OnboardingFragment() {
        // Required empty public constructor
    }

    static OnboardingFragment teTiroLasInstrucciones(Integer posicion){
        OnboardingFragment unOnboardingFragment = new OnboardingFragment();
        Bundle unBundle = new Bundle();
        unBundle.putInt("posicion",posicion);
        unOnboardingFragment.setArguments(unBundle);

        return unOnboardingFragment;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_onboarding, container, false);

       Bundle unBundle = getArguments();
       Integer posicion=unBundle.getInt("posicion");
        unTextView=view.findViewById(R.id.textViewTituloONBOARDING);
        segundoTextView =view.findViewById(R.id.textViewOnboarding);
        unButton=view.findViewById(R.id.BotonViewPager);

       switch (posicion){
           case 0 :

          unString = "BIENVENIDOS A PACHORRAPP";
          segundoString= " A CONTINUACION TE MOSTRARE COMO UTILIZARLA PARA EXPRIMIRLA AL MANGO";
               unTextView.setText(unString);
               segundoTextView.setText(segundoString);
               unButton.setText("Saltearse los pasos e ir a la pantalla principal");
       break;
           case 1 :
               unString= "TENES 2 PANTALLAS";
               segundoString="UNA PARA USO PERSONAL QUE DENOMINAREMOS PACHORRA Y OTRA PARA USO SOCIABLE QUE DENOMINAREMOS POCHOCLO";
            unTextView.setText(unString);
            segundoTextView.setText(segundoString);
               unButton.setText("Saltearse los pasos e ir a la pantalla principal");
               break;
           case 2 :
               unString="PACHORRA ES RECOMENDADA PARA CUANDO ESTAS EN TU CASA, TIRADO EN EL SILLON Y NO SABES A QUE DARLE PLAY, ENTONCES NOSOTROS TE MOSTRAMOS CUALES SON LAS TENDENCIAS DE ACUERDO A TUS GUSTOS Y CUALES TE VAN A GUSTAR";
               segundoString="Y NO SOLO ESO SINO QUE TAMBIEN PODES DAR RECOMENDACIONES A OTROS AMIGOS O CHUSMEAR QUE ES LO QUE VEN";
               unTextView.setText(unString);
               segundoTextView.setText(segundoString);
               unButton.setText("Ir a la pantalla principal");
               break;
       }


        return view;
    }


}
