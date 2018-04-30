package edqs.pe.edu.upeu.proyecto01.utils;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

import edqs.pe.edu.upeu.proyecto01.Home.ActivarEventoActivity;
import edqs.pe.edu.upeu.proyecto01.R;
import edqs.pe.edu.upeu.proyecto01.dao.EventoDao;
import edqs.pe.edu.upeu.proyecto01.to.EventoTO;

/**
 * Created by erick on 29/04/2018.
 */

public class ListaEventoAdapter extends ArrayAdapter<EventoTO> {
    private static LayoutInflater inflater=null;
    public Context cont;

    public ListaEventoAdapter(ActivarEventoActivity context, List<EventoTO> objet) {
        super(context, R.layout.estructuralistevento , objet);
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.cont=context;

    }

    public static class ViewEvento{
        public TextView tituloevento;
        public RadioButton estado;
    }


    public View getView(final int position, View connverView, ViewGroup parent){
        final ViewEvento holder;
        if(connverView==null){
            connverView=inflater.inflate(R.layout.estructuralistevento, null);
            holder=new ViewEvento();
            holder.tituloevento=(TextView)connverView.findViewById(R.id.txtTituloEvento);
            holder.estado=(RadioButton)connverView.findViewById(R.id.rbtnEstado);

            connverView.setTag(holder);

        }else{ holder=(ViewEvento)connverView.getTag(); }

        final EventoTO eventTO=(EventoTO)super.getItem(position);
        holder.tituloevento.setText(eventTO.getNombreevento());
        if (eventTO.getEstado().toString().equals("1")){
            holder.estado.setChecked(true);
        }else{
            holder.estado.setChecked(false);
        }
        holder.estado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Pasa Datos:", "SI: "+eventTO.getNombreevento());
                EventoDao dao=new EventoDao(cont);
                dao.cambiarEstadoEvento(eventTO.getIdEvento());
                Intent intent=new Intent();
                intent.setClass(view.getContext(), ActivarEventoActivity.class);
                cont.startActivity(intent);

            }
        });



        return connverView;
    }

}
