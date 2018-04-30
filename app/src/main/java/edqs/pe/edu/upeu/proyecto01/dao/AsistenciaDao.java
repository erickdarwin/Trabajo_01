package edqs.pe.edu.upeu.proyecto01.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import edqs.pe.edu.upeu.proyecto01.db.DBExterno;
import edqs.pe.edu.upeu.proyecto01.to.AsistenciaTO;

/**
 * Created by erick on 29/04/2018.
 */

public class AsistenciaDao extends DBExterno {
    DBExterno con;
    Context contex;
    SQLiteDatabase db;
    Cursor cur;
    String sql;

    public AsistenciaDao(Context context) {
        super(context);
        this.contex=context;
    }

    public void registrarAsistencia(int idEvento, int idUsuario, String codigo, String nombre, String companhia){
        con=new DBExterno(contex);
        db=con.getWritableDatabase();
        db.execSQL("insert into asistencia(idEvento,idUsuario,codigo,nombres,companhia, fechahora,ofline) " +
                " values("+idEvento+","+idUsuario+",'"+codigo+"','"+nombre+"','"+companhia+"',datetime('now'),'0'); ");
    }

    public Cursor listarAsistencia(){
        con=new DBExterno(contex);
        db=con.getReadableDatabase();
        sql="select * from asistencia ";
        cur=db.rawQuery(sql,null);
        return cur;
    }

    public List listarAsistenciaArray(){
        con=new DBExterno(contex);
        db=con.getReadableDatabase();
        sql=" select a.*,u.usuario from asistencia a, usuario u where a.idUsuario=u.idUsuario; ";
        cur=db.rawQuery(sql,null);
        ArrayList<AsistenciaTO> lista=new ArrayList<AsistenciaTO>();
        AsistenciaTO to=null;
        while (cur.moveToNext()){
            to=new AsistenciaTO();
            to.setCodigo(cur.getString(2));
            to.setNombres(cur.getString(3));
            to.setFechahora(cur.getString(5));
            lista.add(to);
        }

        return lista;
    }
}

