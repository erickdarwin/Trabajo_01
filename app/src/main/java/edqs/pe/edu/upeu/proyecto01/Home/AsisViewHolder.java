package edqs.pe.edu.upeu.proyecto01.Home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import edqs.pe.edu.upeu.proyecto01.R;
import edqs.pe.edu.upeu.proyecto01.to.AsistenciaTO;
import edqs.pe.edu.upeu.proyecto01.to.EventoTO;

/**
 * Created by erick on 29/04/2018.
 */

public class AsisViewHolder extends RecyclerView.ViewHolder {

    private TextView txtNombre,txtDni,txtHora;

    private AsistenciaTO asistenciaTO;

    public AsisViewHolder(View itemView) {
        super(itemView);

        this.txtNombre=(TextView)itemView.findViewById(R.id.txtNombreA);
        this.txtDni=(TextView)itemView.findViewById(R.id.txtDniA);
        this.txtHora=(TextView)itemView.findViewById(R.id.txtHinicioA);

    }

    public void setAsistencia(AsistenciaTO asistenciay){

        this.asistenciaTO=asistenciay;
        this.txtNombre.setText(asistenciaTO.getNombres());
        this.txtDni.setText(asistenciaTO.getCodigo());
        this.txtHora.setText(asistenciaTO.getFechahora());


    }
}
