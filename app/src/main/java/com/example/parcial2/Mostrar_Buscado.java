package com.example.parcial2;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class Mostrar_Buscado extends AppCompatActivity implements View.OnClickListener{
    ControladorBaseD control;
EditText cedula;
Button buscar,volver;
TextView txtnombre,txtestrato,txtsalario,txtNeducativo;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostrar_buscado);
         txtnombre = findViewById(R.id.txtnombreb);
         txtestrato = findViewById(R.id.txtestratob);
         txtsalario = findViewById(R.id.txtsalariob);
         txtNeducativo = findViewById(R.id.txtneducativo);

        cedula = findViewById(R.id.editTextcedula);
        buscar =  findViewById(R.id.buttonbuscarr);
        volver = findViewById(R.id.buttonvolver);
        control = new ControladorBaseD(getApplicationContext());
        buscar.setOnClickListener(this);
volver.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        RegistroPersonas r;
        r= control.buscarPersona(cedula.getText().toString());

        switch (v.getId()) {
            case R.id.buttonbuscarr:

if (r != null){
    txtnombre.setText("Nombre : "+r.getNombre().toString());
    txtestrato.setText("Estrato : "+r.getEstrato());
    txtsalario.setText("Salario: "+r.getSalario());
    txtNeducativo.setText("Nivel Educativo : "+r.getNEducativo());

}else{
    Toast.makeText(getApplicationContext(),"no se encontro",Toast.LENGTH_SHORT).show();
}


                break;
            case R.id.buttonvolver:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }


    }
}
