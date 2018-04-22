package com.integrador.proyecto.proyectointegrador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jinex on 20/04/2017.
 */
public class ListViewAdapter extends BaseAdapter{
    private ArrayList<Alimento> arrayListItem;
    private Context context;
    private LayoutInflater layoutInflater;

    public ListViewAdapter(Context context, ArrayList<Alimento> arrayListItem) {
        this.context = context;
        this.arrayListItem = arrayListItem;
    }

    @Override
    public int getCount() {
        return arrayListItem.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayListItem.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View vistaItem=layoutInflater.inflate(R.layout.item_alimento, parent,false);
        TextView lblCod= (TextView) vistaItem.findViewById(R.id.lblCod);
        TextView lblNom= (TextView) vistaItem.findViewById(R.id.lblNom);
        TextView lblUni= (TextView) vistaItem.findViewById(R.id.lblUni);
        TextView lblCant= (TextView) vistaItem.findViewById(R.id.lblCant);
        TextView lblCalo= (TextView) vistaItem.findViewById(R.id.lblCalo);
        TextView lblCarbo= (TextView) vistaItem.findViewById(R.id.lblCarbo);
        TextView lblProte= (TextView) vistaItem.findViewById(R.id.lblProte);
        TextView lblGrasa= (TextView) vistaItem.findViewById(R.id.lblGrasa);


        lblCod.setText(arrayListItem.get(i).getCodigo());
        lblNom.setText(arrayListItem.get(i).getNombre());
        lblUni.setText(arrayListItem.get(i).getUnidad());
        lblCant.setText(arrayListItem.get(i).getCantidad()+"");
        lblCalo.setText(arrayListItem.get(i).getCalorias()+"");
        lblCarbo.setText(arrayListItem.get(i).getCarbohidratos()+"");
        lblProte.setText(arrayListItem.get(i).getProteinas()+"");
        lblGrasa.setText(arrayListItem.get(i).getGrasas()+"");




        return vistaItem;
    }
}
