package edqs.pe.edu.upeu.proyecto01.db;

import android.content.Context;

import pe.edu.upeu.dbexterno.ExternalSQLiteOpenHelper;


/**
 * Created by erick on 28/04/2018.
 */

public class DBExterno extends ExternalSQLiteOpenHelper {


    public DBExterno(Context context) {
        super(context, "asistenciadb.db", null, 1);
    }
}
