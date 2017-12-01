package com.example.edu.a0817moacn01c_3.View;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
  //      callbackManager = CallbackManager.Factory.create();
       Bundle unBundle = getArguments();
       Integer posicion=unBundle.getInt("posicion");
        unTextView=(TextView)view.findViewById(R.id.textViewTituloONBOARDING);
        segundoTextView =(TextView)view.findViewById(R.id.textViewOnboarding);
        unButton=(Button)view.findViewById(R.id.BotonViewPager);
     //   LoginButton loginButton = (LoginButton) view.findViewById(R.id.botonFacebook);

       switch (posicion){
           case 0 :

          unString = "BIENVENIDOS A PACHORRAPP";
          segundoString= " A CONTINUACION TE MOSTRARE COMO UTILIZARLA PARA EXPRIMIRLA AL MANGO";
               unTextView.setText(unString);
               segundoTextView.setText(segundoString);
               unButton.setText("Saltearse los pasos e ir a la pantalla principal");
             //loginButton.setVisibility(View.GONE);
       break;
           case 1 :
               unString= "TENES 2 PANTALLAS";
               segundoString="UNA PARA USO PERSONAL QUE DENOMINAREMOS PACHORRA Y OTRA PARA USO SOCIABLE QUE DENOMINAREMOS POCHOCLO";
            unTextView.setText(unString);
            segundoTextView.setText(segundoString);
               unButton.setText("Saltearse los pasos e ir a la pantalla principal");
               //loginButton.setVisibility(View.GONE);
               break;
           case 2 :
               unString="PACHORRA ES RECOMENDADA PARA CUANDO ESTAS EN TU CASA, TIRADO EN EL SILLON Y NO SABES A QUE DARLE PLAY, ENTONCES NOSOTROS TE MOSTRAMOS CUALES SON LAS TENDENCIAS DE ACUERDO A TUS GUSTOS Y CUALES TE VAN A GUSTAR";
               segundoString="Y NO SOLO ESO SINO QUE TAMBIEN PODES DAR RECOMENDACIONES A OTROS AMIGOS O CHUSMEAR QUE ES LO QUE VEN";
               unTextView.setText(unString);
               segundoTextView.setText(segundoString);
               unButton.setText("Ir a la pantalla principal");
               /*loginButton.setReadPermissions("email");
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
               });*/
               break;


}
        return view;
    }

/*    @Override
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
    }*/


}