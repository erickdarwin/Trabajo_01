package edqs.pe.edu.upeu.proyecto01.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import edqs.pe.edu.upeu.proyecto01.Home.AsisViewHolder;
import edqs.pe.edu.upeu.proyecto01.Home.EventoViewHolder;
import edqs.pe.edu.upeu.proyecto01.R;
import edqs.pe.edu.upeu.proyecto01.to.AsistenciaTO;
import edqs.pe.edu.upeu.proyecto01.to.EventoTO;

/**
 * Created by erick on 29/04/2018.
 */

public class AsisRecyclerAdapter extends RecyclerView.Adapter<AsisViewHolder> {
    private static LayoutInflater inflater=null;
    public Context cont;
    List<AsistenciaTO> asistencias;


    public AsisRecyclerAdapter(List<AsistenciaTO> asis){
        this.asistencias=asis;
    }

    @Override
    public AsisViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        Context context =parent.getContext();
        View view= LayoutInflater.from(context).inflate(R.layout.estructuralistasis,parent,false);

        AsisViewHolder asisViewHolder = new AsisViewHolder(view);

        return asisViewHolder;

    }


    @Override
    public void onBindViewHolder(AsisViewHolder holder, int position) {


        AsistenciaTO asitenciax =asistencias.get(position);
        holder.setAsistencia(asitenciax);
    }


    @Override
    public int getItemCount() {
        return asistencias.size();


    }






}

