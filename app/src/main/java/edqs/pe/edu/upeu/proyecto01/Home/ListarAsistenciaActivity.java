package edqs.pe.edu.upeu.proyecto01.Home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import edqs.pe.edu.upeu.proyecto01.R;
import edqs.pe.edu.upeu.proyecto01.dao.AsistenciaDao;
import edqs.pe.edu.upeu.proyecto01.utils.ListaAsisAdapter;

/**
 * Created by erick on 29/04/2018.
 */

public class ListarAsistenciaActivity extends AppCompatActivity {

    AsistenciaDao dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_asistencia);

    }
}

