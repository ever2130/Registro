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
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
ControladorBaseD control;
    EditText cedula,nombre,salario;
    Button btnguardar, btnlist;
    Spinner estrato,nacademico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        cedula = findViewById(R.id.edtcedula);
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

        btnguardar.setOnClickListener(this);
        btnlist.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final String estrat= estrato.getSelectedItem().toString();
        final String nacademic = nacademico.getSelectedItem().toString();
        switch (v.getId()) {
            case R.id.btnguardar:


                    RegistroPersonas reg = new RegistroPersonas(cedula.getText().toString(),nombre.getText().toString(),
                            estrat,(salario.getText().toString()),nacademic);
                    long ret = control.agregarRegistro(reg);
                    if (ret != -1) {
                        Toast.makeText(v.getContext(), "registro guardado", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(v.getContext(), "registro fallido", Toast.LENGTH_SHORT).show();
                    }
                    nombre.setText(""); cedula.setText(""); salario.setText("");


                break;
            case R.id.btnlistado:
                Intent i = new Intent(this, Listado.class);
                startActivity(i);
                break;
            case R.id.btnbuscar:
                Intent in = new Intent(this, Mostrar_Buscado.class);
                startActivity(in);
               /* RegistroPersonas r;

               r= control.buscarPersona(cedula.getText().toString());
               nombre.setText(r.getNombre());
               salario.setText( r.getSalario());*/
                break;
        }
    }




}
