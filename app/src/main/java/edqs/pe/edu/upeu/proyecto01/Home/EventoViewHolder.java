package edqs.pe.edu.upeu.proyecto01.Home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import edqs.pe.edu.upeu.proyecto01.R;
import edqs.pe.edu.upeu.proyecto01.to.EventoTO;

/**
 * Created by erick on 29/04/2018.
 */

public class EventoViewHolder extends RecyclerView.ViewHolder {

    private TextView txtNombre,txtLugar,txtFecha,txtHora;

    private EventoTO eventoTO;

    public EventoViewHolder(View itemView) {
        super(itemView);

        this.txtNombre=(TextView)itemView.findViewById(R.id.txtNombre);
        this.txtLugar=(TextView)itemView.findViewById(R.id.txtLugar);
        this.txtFecha=(TextView)itemView.findViewById(R.id.txtfecha);
        this.txtHora=(TextView)itemView.findViewById(R.id.txtHinicio);

    }

    public void setEvento(EventoTO eventoy){

        this.eventoTO=eventoy;
        this.txtNombre.setText(eventoTO.getNombreevento());
        this.txtLugar.setText(eventoTO.getLugarevento());
        this.txtFecha.setText(eventoTO.getFecha());
        this.txtHora.setText(eventoTO.getHorainicio());


    }
}
