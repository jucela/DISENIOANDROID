package com.example.dmorales.evaluacion2018.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dmorales.evaluacion2018.R;
import com.example.dmorales.evaluacion2018.modelo.Registrado;

import java.util.ArrayList;

public class RegistradoAdapter3 extends RecyclerView.Adapter<RegistradoAdapter3.ViewHolder>{
    ArrayList<Registrado> registrados;
    Context context;

    public RegistradoAdapter3(ArrayList<Registrado> registrados, Context context) {
        this.registrados = registrados;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_registrado3,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Registrado registrado = registrados.get(position);
        holder.txtDni.setText(registrado.getCodigo());
        holder.txtNombres.setText(registrado.getNombres());
        holder.txtAula.setText(registrado.getAula());
        holder.txtFecha.setText(registrado.getDia1() + "-" + registrado.getMes1() + "-" + registrado.getAnio1());
        holder.txtEntrada.setText(registrado.getHora1() + ":" + registrado.getMinuto1());

//        if(registrado.getSubido() == 1){
//            holder.cv.setCardBackgroundColor(Color.WHITE);
//        }else{
//            holder.cv.setCardBackgroundColor(Color.rgb(227,242,253));
//        }
    }

    public String checkDigito (int number) {
        return number <= 9 ? "0" + number : String.valueOf(number);
    }

    @Override
    public int getItemCount() {
        return registrados.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtDni;
        TextView txtNombres;
        TextView txtAula;
        TextView txtFecha;
        TextView txtEntrada;
        CardView cv;
        public ViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.item_registrado_cv3);
            txtDni = itemView.findViewById(R.id.item_registrado_txtDni3);
            txtNombres = itemView.findViewById(R.id.item_registrado_txtNombres3);
            txtAula = itemView.findViewById(R.id.item_registrado_txtAula3);
            txtFecha = itemView.findViewById(R.id.item_registrado_txtFecha3);
            txtEntrada = itemView.findViewById(R.id.item_registrado_txtHentrada3);
        }
    }
}
