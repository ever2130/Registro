package com.example.parcial2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ControladorBaseD {
    private BaseDatos basedatos;

    public ControladorBaseD (Context context){
        this.basedatos =  new BaseDatos(context, ModeloDatabase.Nombre_db,null,1);
    }

    public long agregarRegistro (RegistroPersonas registro){

            SQLiteDatabase database = basedatos.getWritableDatabase();
            ContentValues val = new ContentValues();
            val.put(ModeloDatabase.col_cedula, registro.getCedula());
            val.put(ModeloDatabase.col_nombre, registro.getNombre());
            val.put(ModeloDatabase.col_estrato, registro.getEstrato());
            val.put(ModeloDatabase.col_salario,registro.getSalario());
           val.put(ModeloDatabase.col_neducativo,registro.getNEducativo());
            return database.insert(ModeloDatabase.Nombre_Tabla,null,val);

    }
    public int actualizarRegistro(RegistroPersonas registro) {
        try {
            SQLiteDatabase database = basedatos.getWritableDatabase();
            ContentValues VA = new ContentValues();
            VA.put(ModeloDatabase.col_cedula, registro.getCedula());
            VA.put(ModeloDatabase.col_nombre, registro.getNombre());
            VA.put(ModeloDatabase.col_estrato, registro.getEstrato());
            VA.put(ModeloDatabase.col_salario,registro.getSalario());
            VA.put(ModeloDatabase.col_neducativo,registro.getNEducativo());

            String CA = ModeloDatabase.col_cedula + " = ?";
            String[] AC = {String.valueOf(registro.getCedula())};

            return database.update(ModeloDatabase.Nombre_Tabla, VA, CA, AC);
        } catch (Exception e) {
            return 0;
        }
    }

    public int borrarRegistro(RegistroPersonas tomas) {
        try {
            SQLiteDatabase database = basedatos.getWritableDatabase();
            String[] arg = {String.valueOf(tomas.getCedula())};
            return database.delete(ModeloDatabase.Nombre_Tabla, ModeloDatabase.col_cedula + " = ?", arg);
        } catch (Exception e) {
            return 0;
        }
    }
    public RegistroPersonas buscarPersona(String id) {
        RegistroPersonas reg;
        SQLiteDatabase database = basedatos.getReadableDatabase();
        String[] colBuscar = {ModeloDatabase.col_cedula, ModeloDatabase.col_nombre, ModeloDatabase.col_estrato, ModeloDatabase.col_salario, ModeloDatabase.col_neducativo};
        String[] argvector = {id};
        Cursor c = database.query(ModeloDatabase.Nombre_Tabla,colBuscar, ModeloDatabase.col_cedula+" = ?",argvector,null,null,null);
        if (c==null){
            return null;
        }
        if (!c.moveToFirst()){
            return null;
        }
        do {

             reg = new RegistroPersonas(c.getString(0),c.getString(1),
                    c.getString(2),c.getString(3),c.getString(4));

        } while (c.moveToNext());
        c.close();
        return reg;
    }
    public ArrayList<RegistroPersonas> obtenerPersona() {
        ArrayList<RegistroPersonas> registros = new ArrayList<>();
    SQLiteDatabase database = basedatos.getReadableDatabase();
    String[] colBuscar = {ModeloDatabase.col_cedula, ModeloDatabase.col_nombre, ModeloDatabase.col_estrato, ModeloDatabase.col_salario, ModeloDatabase.col_neducativo};
        Cursor c = database.query(ModeloDatabase.Nombre_Tabla,colBuscar,null,null,null,null,null);
        if (c==null){
            return registros;
        }
        if (!c.moveToFirst()){
            return registros;
        }
        do {

            RegistroPersonas tom = new RegistroPersonas(c.getString(0),c.getString(1),
                    c.getString(2),c.getString(3),c.getString(4));
            registros.add(tom);
        } while (c.moveToNext());
        c.close();
        return registros;
    }
}
