package com.example.edu.a0817moacn01c_3.View;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.edu.a0817moacn01c_3.R;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class OnboardingFragment extends Fragment {
    private TextView unTextView;
    private TextView segundoTextView;
    private String unString;
    private String segundoString;
    private Button unButton;
    private CallbackManager callbackManager;
    private ImageView imageView;
    private TextView qtPintaHoy;
    private String tituloArriba;

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
       callbackManager = CallbackManager.Factory.create();
       Bundle unBundle = getArguments();
       Integer posicion=unBundle.getInt("posicion");
        unTextView=(TextView)view.findViewById(R.id.textViewTituloONBOARDING);
        segundoTextView =(TextView)view.findViewById(R.id.textViewOnboarding);
        unButton=(Button)view.findViewById(R.id.BotonViewPager);
        imageView=(ImageView)view.findViewById(R.id.imagen_onboarding);
        LoginButton loginButton = (LoginButton) view.findViewById(R.id.botonFacebook);
        RelativeLayout fondoOnboarding = (RelativeLayout) view.findViewById(R.id.fondo_onboarding);
        qtPintaHoy = (TextView)view.findViewById(R.id.textview_TITULO_sin_Cambio);

       switch (posicion){
           case 0 :

          unString = "SOLO PACHORREAR";
          segundoString= "Tene tus series y peliculas favoritas al alcance de tu mano";
               tituloArriba="¿Que te pinta hoy...?";
               unTextView.setText(unString);
               segundoTextView.setText(segundoString);
               unButton.setText("Omitir");
               qtPintaHoy.setText(tituloArriba);

             loginButton.setVisibility(View.GONE);
               imageView.setImageResource(R.drawable.pachorra);
       break;
           case 1 :
               tituloArriba="¿Que te pinta hoy...?";
               unString = "CLAVATE UN POCHOCLO";
               segundoString="Podes organizar salidas con tus amigos, ver sus actividades, pedir alguna recomendacion o darla";
            segundoTextView.setText(segundoString);
               unTextView.setText(unString);
               unButton.setText("Omitir");
               qtPintaHoy.setText(tituloArriba);
               loginButton.setVisibility(View.GONE);
               imageView.setImageResource(R.drawable.cine);

               fondoOnboarding.setBackgroundResource(R.color.colorAccent);
               break;
           case 2 :
               unString = "CONECTATE CON TUS AMIGOS";
               segundoString="Para tener una experiencia mas satifactoria conectate con facebook";
               segundoTextView.setText(segundoString);
               unButton.setText("Ahora no");
               unTextView.setText(unString);
               imageView.setImageResource(R.drawable.ic_people_black_24dp);
               fondoOnboarding.setBackgroundResource(R.color.colorPrimary);
               loginButton.setReadPermissions("email");
               loginButton.setFragment(this);
               loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                   @Override
                   public void onSuccess(LoginResult loginResult) {
                       // App code

                       Toast.makeText(getContext(), loginResult.toString(), Toast.LENGTH_SHORT).show();
                   }

                   @Override
                   public void onCancel() {
                       // App code
                       Toast.makeText(getContext(), "CANCELADO", Toast.LENGTH_SHORT).show();
                   }

                   @Override
                   public void onError(FacebookException exception) {
                       // App code
                       Toast.makeText(getContext(), exception.toString(), Toast.LENGTH_SHORT).show();
                   }
               });
               break;


}
        return view;
    }

   @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private Boolean isLogin(){
        AccessToken accesToken = AccessToken.getCurrentAccessToken();
        return accesToken != null;
    }

    public void salir(View view){
        LoginManager.getInstance().logOut();
    }

    public void showMe(View view){
        GraphRequest request = GraphRequest.newMeRequest(
                AccessToken.getCurrentAccessToken(),
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(
                            JSONObject object,
                            GraphResponse response) {
                        Toast.makeText(getContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,link");
        request.setParameters(parameters);
        request.executeAsync();
    }


}