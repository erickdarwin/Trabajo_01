package edqs.pe.edu.upeu.proyecto01.Home;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import edqs.pe.edu.upeu.proyecto01.R;
import edqs.pe.edu.upeu.proyecto01.dao.AsistenciaDao;
import edqs.pe.edu.upeu.proyecto01.dao.EventoDao;
import edqs.pe.edu.upeu.proyecto01.to.AsistenciaTO;
import edqs.pe.edu.upeu.proyecto01.to.EventoTO;
import edqs.pe.edu.upeu.proyecto01.utils.AsisRecyclerAdapter;
import edqs.pe.edu.upeu.proyecto01.utils.EventoRecyclerAdapter;
import edqs.pe.edu.upeu.proyecto01.utils.ListaAsisAdapter;


public class ListAsis extends Fragment {
    public AsistenciaDao dao;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter<AsisViewHolder> adapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewMyFragment =inflater.inflate(R.layout.estructuralistasis, container, false);

        this.recyclerView=(RecyclerView)viewMyFragment.findViewById(R.id.recyclerview);

        this.layoutManager=new LinearLayoutManager(this.getContext());
        dao=new AsistenciaDao(this.getContext());
        List<AsistenciaTO> lista=dao.listarAsistenciaArray();
        this.adapter= new AsisRecyclerAdapter(lista);

    //       this.recyclerView.setLayoutManager(layoutManager);
  //     this.recyclerView.setAdapter(adapter);

        return viewMyFragment;
    }


}
