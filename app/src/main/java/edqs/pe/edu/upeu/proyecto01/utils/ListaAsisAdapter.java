package edqs.pe.edu.upeu.proyecto01.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import edqs.pe.edu.upeu.proyecto01.Home.ListarAsistenciaActivity;
import edqs.pe.edu.upeu.proyecto01.R;
import edqs.pe.edu.upeu.proyecto01.to.AsistenciaTO;

/**
 * Created by erick on 29/04/2018.
 */

public class ListaAsisAdapter extends ArrayAdapter<AsistenciaTO>{

    private static LayoutInflater inflater=null;


    public ListaAsisAdapter(Context context, List<AsistenciaTO> contenido) {
        super(context, R.layout.estructuralistasis, contenido);
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public static class ViewAsistencia{
        public TextView codigo;
        public TextView nombres;
        public TextView hora;
        public  TextView usuario;
    }

    public View getView(final int position, View connverView, ViewGroup parent){
        ViewAsistencia holder;
        if(connverView==null){
            connverView=inflater.inflate(R.layout.estructuralistasis, null);
            holder=new ViewAsistencia();
            holder.codigo=(TextView)connverView.findViewById(R.id.txtDniA);
            holder.nombres=(TextView)connverView.findViewById(R.id.txtNombreA);
            holder.hora=(TextView)connverView.findViewById(R.id.txtHinicioA);
            holder.usuario=(TextView)connverView.findViewById(R.id.idNombreUsuario);
            connverView.setTag(holder);

        }else{ holder=(ViewAsistencia)connverView.getTag(); }

        final AsistenciaTO asisTO=(AsistenciaTO)super.getItem(position);
        holder.codigo.setText(asisTO.getCodigo());
        holder.nombres.setText(asisTO.getNombres());
        holder.hora.setText(asisTO.getFechahora());
        holder.usuario.setText(asisTO.getNombreusuario());

        return connverView;
    }


}
