package edqs.pe.edu.upeu.proyecto01.utils;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

import edqs.pe.edu.upeu.proyecto01.Home.EventoViewHolder;
import edqs.pe.edu.upeu.proyecto01.R;

import edqs.pe.edu.upeu.proyecto01.to.EventoTO;

/**
 * Created by erick on 29/04/2018.
 */

public class EventoRecyclerAdapter extends RecyclerView.Adapter<EventoViewHolder> {
    private static LayoutInflater inflater=null;
    public Context cont;
    List<EventoTO> eventos;


    public EventoRecyclerAdapter(List<EventoTO> eventos){
        this.eventos=eventos;
    }

    @Override
    public EventoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        Context context =parent.getContext();
        View view= LayoutInflater.from(context).inflate(R.layout.listaevento,parent,false);

        EventoViewHolder eventoViewHolder = new EventoViewHolder(view);

        return eventoViewHolder;

    }

    @Override
    public void onBindViewHolder(EventoViewHolder holder, int position) {


        EventoTO eventox =eventos.get(position);
        holder.setEvento(eventox);
    }


    @Override
    public int getItemCount() {
        return eventos.size();


    }






}
