package com.example.parcial2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdap extends ArrayAdapter<RegistroPersonas> {
    private ArrayList<RegistroPersonas> lista;
    private Context cont;
    private int layoutT;

    public ListAdap(@NonNull Context context, int resource, @NonNull ArrayList<RegistroPersonas> objects) {
        super(context, resource, objects);
        this.lista = objects;
        this.cont = context;
        this.layoutT = resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=convertView;
        if (view == null){
            view= LayoutInflater.from(cont).inflate(layoutT, null);
        }

        RegistroPersonas registro = lista.get(position);
        TextView txtcedula = view.findViewById(R.id.txtcedula);
        TextView txtnombre = view.findViewById(R.id.txtnombre);
        TextView txtestrato = view.findViewById(R.id.txtestrato);
        TextView txtsalario = view.findViewById(R.id.txtsalario);
        TextView txtNeducativo = view.findViewById(R.id.txtNeducativo);



        txtcedula.setText("Cedula: "+registro.getCedula());
        txtnombre.setText("Nombre : "+registro.getNombre());
        txtestrato.setText("Estrato : "+registro.getEstrato());
        txtsalario.setText("Salario: "+registro.getSalario());
        txtNeducativo.setText("Nivel Educativo : "+registro.getNEducativo());

        return view;

    }
}
