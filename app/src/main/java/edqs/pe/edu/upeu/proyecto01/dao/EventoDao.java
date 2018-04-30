package edqs.pe.edu.upeu.proyecto01.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import edqs.pe.edu.upeu.proyecto01.db.DBExterno;
import edqs.pe.edu.upeu.proyecto01.to.EventoTO;

/**
 * Created by erick on 29/04/2018.
 */

public class EventoDao extends DBExterno {
    DBExterno con;
    Context contex;
    SQLiteDatabase db;
    Cursor cur;
    String sql;

    public EventoDao(Context context) {
        super(context);
        this.contex=context;
    }

   // public int eventoActivo(){
        //con=new DBExterno(contex);
//        db=con.getReadableDatabase();
      //  sql=" select * from evento where estado='1' ";
//        cur=db.rawQuery(sql, null);
//        if(cur.moveToNext()){
 //           return cur.getInt(0);
   //     }else{
     //       return 0;
       //}
    //}

    public List ListarEvento(){
        con=new DBExterno(contex);
        db=con.getReadableDatabase();
        sql=" select * from evento";
        cur=db.rawQuery(sql,null);
        ArrayList<EventoTO> lista=new ArrayList<EventoTO>();
        EventoTO to=null;
        while (cur.moveToNext()){
            to=new EventoTO();
            to.setIdEvento(cur.getInt(0));
            to.setNombreevento(cur.getString(4));
            to.setLugarevento(cur.getString(5));
            to.setFecha(cur.getString(1));
            to.setHorainicio(cur.getString(2));

            to.setEstado(cur.getString(7));
            lista.add(to);
        }

        return lista;
    }

    public void cambiarEstadoEvento(int idEvento){
        con=new DBExterno(contex);
        db=con.getWritableDatabase();
        db.execSQL("update evento set estado='0' ");
        db.execSQL("update evento set estado='1' where idEvento="+idEvento+" ");
    }


}
