package edqs.pe.edu.upeu.proyecto01.Home;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.crashlytics.android.Crashlytics;
import edqs.pe.edu.upeu.proyecto01.R;
import edqs.pe.edu.upeu.proyecto01.dao.UsuarioDao;
import io.fabric.sdk.android.Fabric;



import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;




public class HomeActivity extends AppCompatActivity {




    private SignInButton mGoogleSignInButton;
    private GoogleApiClient mGoogleApiClient;


    TextView msg;
    UsuarioDao usu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_home);
        final EditText txtUsuario =(EditText) findViewById(R.id.idUsuario);
        final EditText txtClave =(EditText) findViewById(R.id.idClave);
        final Button btnCancelar =(Button)findViewById(R.id.idCancelar);
        final Button btnIngresar=(Button)findViewById(R.id.IdIngresar);
        msg=(TextView)findViewById(R.id.idMsg);
        usu=new UsuarioDao(this);

        btnIngresar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(usu.validarUsuario(txtUsuario.getText().toString(), txtClave.getText().toString())){
                    ingresar();
                }else{
                    msg.setText("Intente Nuevamente...!");
                }

            }
        });








            mGoogleSignInButton = (SignInButton) findViewById(R.id.google_sign_in_button);
            mGoogleSignInButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    signInWithGoogle();

                }

            });





        }







    private void checkInitialized() {
    }

    private void handleSignInResult(Object o) {
//Handle sign result here
    }


    private static final int RC_SIGN_IN = 9001;

    private void signInWithGoogle() {
        if (mGoogleApiClient != null) {
            mGoogleApiClient.disconnect();
        }
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        final Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    private void signOut() {
        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(Status status) {

                        // Toast.makeText(getApplicationContext(),"Si ingreso y Paso por aqui",Toast.LENGTH_SHORT).show();
                    }
                });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);

            if(result.isSuccess()) {
                final GoogleApiClient client = mGoogleApiClient;
                result.getSignInAccount();
                //Toast.makeText(getApplicationContext(),"Si ingreso con Google  Uno",Toast.LENGTH_SHORT).show();
            } else {

                startActivity(new Intent(this, HomeNavitionDraw.class));
                //Toast.makeText(getApplicationContext(),"Si ingreso con Google Dos",Toast.LENGTH_SHORT).show();
                //handleSignInResult(...);
            }
        } else {
            // Handle other values for requestCode
            // Toast.makeText(getApplicationContext(),"Si ingreso con Google  Error",Toast.LENGTH_SHORT).show();
        }
    }




    public void ingresar(){
        final EditText txtUsuario =(EditText) findViewById(R.id.idUsuario);
        usu=new UsuarioDao(this);
        Cursor curx=usu.listarUsuario(txtUsuario.getText().toString());
        String nombre="";
        int idUsuario=0;
        if(curx.moveToNext()){
            nombre=curx.getString(3)+" "+curx.getString(4);
            idUsuario=curx.getInt(0);
        }
        Intent intent=new Intent();
        intent.putExtra("txtUsuarioNombre", nombre);
        intent.putExtra("idUsuario", idUsuario);
        intent.setClass(this, HomeNavitionDraw.class);
        startActivity(intent);
    }



}






