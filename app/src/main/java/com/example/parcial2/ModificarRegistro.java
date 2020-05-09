package com.example.parcial2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ModificarRegistro extends AppCompatActivity implements View.OnClickListener{
    ControladorBaseD control;
    EditText nombre,salario;
    Button btnguardar, btnlist;
    Spinner estrato,nacademico;
    String cod;
    int ind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.mod_registro);



        nombre = findViewById(R.id.edtnombre);
        salario = findViewById(R.id.edtsalario);
        estrato = findViewById(R.id.spinnerEstrato);
        nacademico = findViewById(R.id.spinnerNAacade);
        btnguardar = findViewById(R.id.btnguardar);
        btnlist = findViewById(R.id.btnlistado);

        String [] estratos ={"1","2","3 ","4","5","6"};
        String [] niveles ={"Bachillerato","Pregrado","Maestría","Doctorado"};

        ArrayAdapter<String> arrayAdapterestrato = new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item,estratos);
        estrato.setAdapter(arrayAdapterestrato);
        ArrayAdapter<String> arrayAdapteracademico = new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item,niveles);
        nacademico.setAdapter(arrayAdapteracademico);

        control = new ControladorBaseD(getApplicationContext());
        Intent i = getIntent();
        ind = i.getIntExtra("indice",0);
        ArrayList<RegistroPersonas> lista = control.obtenerPersona();
        RegistroPersonas registro = lista.get(ind);
        cod = registro.getCedula();
        btnguardar.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        final String estrat= estrato.getSelectedItem().toString();
        final String nacademic = nacademico.getSelectedItem().toString();
        switch (v.getId()) {
            case R.id.btnguardar:

                RegistroPersonas reg = new RegistroPersonas(cod,nombre.getText().toString(),estrat,(salario.getText().toString()),nacademic);
                long ret = control.actualizarRegistro(reg);
                if (ret == 1) {
                    Toast.makeText(v.getContext(), "registro guardado", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(v.getContext(), "registro fallido", Toast.LENGTH_SHORT).show();
                }
                nombre.setText("");  salario.setText("");
                Intent inten = new Intent(this, MainActivity.class);
                startActivity(inten);
                break;
            case R.id.btncancelar:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }


}