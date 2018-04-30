package edqs.pe.edu.upeu.proyecto01.Home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.google.zxing.Result;

import edqs.pe.edu.upeu.proyecto01.R;
import edqs.pe.edu.upeu.proyecto01.dao.AsistenciaDao;
import edqs.pe.edu.upeu.proyecto01.dao.EventoDao;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class HomeNavitionDraw extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    TextView resultado;

    Button btnRegAsist;
    private ZXingScannerView Vistaescaner;
    EventoDao eve;
    AsistenciaDao asis;
    int idUsuario=0;
    Context cotex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_navition_draw);




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    /*@Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_navition_draw, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        FragmentManager fragmentManager = getSupportFragmentManager();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            fragmentManager.beginTransaction().replace(R.id.contenedor, new ListAsis()).commit();

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentManager fragmentManager = getSupportFragmentManager();
        if (id == R.id.nav_eventos) {
            // Handle the camera action

            fragmentManager.beginTransaction().replace(R.id.contenedor, new ReportFragment()).commit();

        } else if (id == R.id.nav_registrar) {
            fragmentManager.beginTransaction().replace(R.id.contenedor, new RegisterFragment()).commit();


        } else if (id == R.id.nav_lista_Asistencia) {
            fragmentManager.beginTransaction().replace(R.id.contenedor, new ListAsis()).commit();

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void mostrarCamara(){
        Intent inte=new Intent("com.google.zxing.client.android.SCAN");
        inte.putExtra("SCAN_MODE","QR_CODE_MODE");
        startActivityForResult(inte,0);
    }
/*
    public void onResultado(View view){
        asis=new AsistenciaDao(this);
        Cursor cur=asis.listarAsistencia();
        if(cur.moveToNext()){
            resultado = (TextView) findViewById(R.id.idResultado);
            resultado.setText(String.valueOf(cur.getCount()));
        }
    }
    public  void onListarasitencia(View view){
        Intent inte=new Intent();
        inte.setClass(this,ListarAsistenciaActivity.class);
        startActivity(inte);
    }*/

    public void onRegistrar(View view){
        Vistaescaner = new ZXingScannerView(this);
        Vistaescaner.setResultHandler(new zxingscanner());
        setContentView(Vistaescaner);
        Log.v("DATOS------:",String.valueOf(idUsuario));
        Vistaescaner.startCamera();
    }

    /*public void onActivarevento(View view){
        Intent intent=new Intent();
        //intent.putExtra("idUsuario", idUsuario);
        intent.setClass(this, ActivarEventoActivity.class);
        startActivity(intent);
        //finish();
    }*/
/*
    public void scanerQR(View view){
        Intent intent=new Intent();
        intent.putExtra("idUsuario", idUsuario);
        intent.setClass(this, SimpleScannerActivity.class);
        startActivity(intent);
    }
*/
public void onActivityResult(int requescode, int resulcode, Intent intent){
        if(resulcode==RESULT_OK){
            String contenido=intent.getStringExtra("SCAN_RESULT");
            resultado=(TextView)findViewById(R.id.idResultado);
            resultado.setText(contenido.toString());
            super.onActivityResult(requescode,resulcode,intent);
            mostrarCamara();
        }
    }

    class zxingscanner implements ZXingScannerView.ResultHandler{
        @Override
        public void handleResult(Result result) {
            String dato = result.getText();
            eve=new EventoDao(cotex);
            asis=new AsistenciaDao(cotex);
           // int idEvento=eve.eventoActivo();
           // asis.registrarAsistencia(idEvento, idUsuario,dato,dato,dato);
            setContentView(R.layout.fragment_register);
            Vistaescaner.stopCamera();


            resultado = (TextView) findViewById(R.id.idResultado);
            resultado.setText(dato);
        }
    }
    }
