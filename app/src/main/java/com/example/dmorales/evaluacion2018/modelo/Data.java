package com.example.dmorales.evaluacion2018.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class Data {
    Context contexto;
    SQLiteOpenHelper sqLiteOpenHelper;
    SQLiteDatabase sqLiteDatabase;

    public Data(Context contexto) throws IOException {
        this.contexto = contexto;
        sqLiteOpenHelper = new DataBaseHelper(contexto);
        createDataBase();
    }

    public void createDataBase() throws IOException {
        boolean dbExist = checkDataBase();
        if(!dbExist){
            sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
            sqLiteDatabase.close();
            try{
                copyDataBase();
                sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
                sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_FECHA_REGISTRO);
                sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_FECHA_REGISTRO_TEMPORAL);
                sqLiteDatabase.close();
            }catch (IOException e){
                throw new Error("Error: copiando base de datos");
            }
        }

    }

    public void copyDataBase() throws IOException{
        InputStream myInput = contexto.getAssets().open(SQLConstantes.DB_NAME);
        String outFileName = SQLConstantes.DB_PATH + SQLConstantes.DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) != -1){
            if (length > 0){
                myOutput.write(buffer,0,length);
            }
        }
        myOutput.flush();
        myInput.close();
        myOutput.close();

    }



    public void open() throws SQLException {
        String myPath = SQLConstantes.DB_PATH + SQLConstantes.DB_NAME;
        sqLiteDatabase = SQLiteDatabase.openDatabase(myPath,null,SQLiteDatabase.OPEN_READWRITE);
    }

    public synchronized void close(){
        if(sqLiteDatabase != null){
            sqLiteDatabase.close();
        }
    }

    public boolean checkDataBase(){
        try{
            String myPath = SQLConstantes.DB_PATH + SQLConstantes.DB_NAME;
            sqLiteDatabase = SQLiteDatabase.openDatabase(myPath,null, SQLiteDatabase.OPEN_READWRITE);
        }catch (Exception e){
            File dbFile = new File(SQLConstantes.DB_PATH + SQLConstantes.DB_NAME);
            return dbFile.exists();
        }
        if (sqLiteDatabase != null) sqLiteDatabase.close();

        return sqLiteDatabase != null ? true : false;
    }

    public UsuarioLocal getUsuarioLocal(String clave){
        UsuarioLocal usuario = null;
        String[] whereArgs = new String[]{clave};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablausuariolocal,
                    SQLConstantes.COLUMNAS_USUARIO_LOCAL,SQLConstantes.WHERE_CLAUSE_CLAVE,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                usuario = new UsuarioLocal();
                usuario.setUsuario(cursor.getString(cursor.getColumnIndex(SQLConstantes.usuario_local_usuario)));
                usuario.setClave(cursor.getString(cursor.getColumnIndex(SQLConstantes.usuario_local_clave)));
                usuario.setCod_local(cursor.getString(cursor.getColumnIndex(SQLConstantes.usuario_local_cod_local)));
                usuario.setNom_local(cursor.getString(cursor.getColumnIndex(SQLConstantes.usuario_local_nom_local)));
                usuario.setSede_region(cursor.getString(cursor.getColumnIndex(SQLConstantes.usuario_local_sede_region)));
                usuario.setCod_nivel(cursor.getString(cursor.getColumnIndex(SQLConstantes.usuario_local_cod_nivel)));
                usuario.setNom_nivel(cursor.getString(cursor.getColumnIndex(SQLConstantes.usuario_local_nom_nivel)));
                usuario.setFase(cursor.getString(cursor.getColumnIndex(SQLConstantes.usuario_local_fase)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return usuario;
    }

    public Nacional getNacional(String dni){
        Nacional nacional = null;
        String[] whereArgs = new String[]{dni};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablanacional,
                    SQLConstantes.COLUMNAS_NACIONAL,SQLConstantes.WHERE_CLAUSE_CODIGO,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                nacional = new Nacional();
                nacional.setNivel(cursor.getString(cursor.getColumnIndex(SQLConstantes.nacional_nivel)));
                nacional.setCod_sede_reg(cursor.getString(cursor.getColumnIndex(SQLConstantes.nacional_cod_sede_reg)));
                nacional.setCod_sede_prov(cursor.getString(cursor.getColumnIndex(SQLConstantes.nacional_cod_sede_prov)));
                nacional.setCod_sede_distrital(cursor.getString(cursor.getColumnIndex(SQLConstantes.nacional_cod_sede_distrital)));
                nacional.setSede_region(cursor.getString(cursor.getColumnIndex(SQLConstantes.nacional_sede_region)));
                nacional.setSede_provincia(cursor.getString(cursor.getColumnIndex(SQLConstantes.nacional_sede_provincia)));
                nacional.setSede_distrital(cursor.getString(cursor.getColumnIndex(SQLConstantes.nacional_sede_distrital)));
                nacional.setCod_local(cursor.getString(cursor.getColumnIndex(SQLConstantes.nacional_cod_local)));
                nacional.setNom_local(cursor.getString(cursor.getColumnIndex(SQLConstantes.nacional_nom_local)));
                nacional.setDireccion(cursor.getString(cursor.getColumnIndex(SQLConstantes.nacional_direccion)));
                nacional.setAula(cursor.getString(cursor.getColumnIndex(SQLConstantes.nacional_aula)));
                nacional.setCodigo(cursor.getString(cursor.getColumnIndex(SQLConstantes.nacional_codigo)));
                nacional.setNombres(cursor.getString(cursor.getColumnIndex(SQLConstantes.nacional_nombres)));
                nacional.setId_cargo(cursor.getString(cursor.getColumnIndex(SQLConstantes.nacional_id_cargo)));
                nacional.setCargo(cursor.getString(cursor.getColumnIndex(SQLConstantes.nacional_cargo)));
                nacional.setTipo_candidato(cursor.getString(cursor.getColumnIndex(SQLConstantes.nacional_tipo_candidato)));
                nacional.setN_bungalow(cursor.getString(cursor.getColumnIndex(SQLConstantes.nacional_n_bungalow)));
                nacional.setResp_bungalow(cursor.getString(cursor.getColumnIndex(SQLConstantes.nacional_resp_bungalow)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return nacional;
    }
    //REGISTRADO-SALIDA LOCAL
    public Registrado getRegistrado(String dni){
        Registrado registrado = null;
        String[] whereArgs = new String[]{dni};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablafecharegistro,
                    SQLConstantes.COLUMNAS_FECHA_REGISTRO_TEMPORAL ,SQLConstantes.WHERE_CLAUSE_CODIGO,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                registrado = new Registrado();
                registrado.setCodigo(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_codigo)));
                registrado.setNombres(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_nombres)));
                registrado.setSede_region(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_sede_region)));
                registrado.setNom_local(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_nom_local)));
                registrado.setDireccion(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_direccion)));
                registrado.setAula(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_aula)));
                registrado.setCargo(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_cargo)));
                registrado.setN_bungalow(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_n_bungalow)));
                registrado.setResp_bungalow(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_resp_bungalow)));
                registrado.setDia1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_dia1)));
                registrado.setMes1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_mes1)));
                registrado.setAnio1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_anio1)));
                registrado.setHora1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_hora1)));
                registrado.setMinuto1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_minuto1)));
                registrado.setDia2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_dia2)));
                registrado.setMes2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_mes2)));
                registrado.setAnio2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_anio2)));
                registrado.setHora2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_hora2)));
                registrado.setMinuto2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_minuto2)));
                registrado.setEstado1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_estado1)));
                registrado.setEstado2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_estado2)));
                registrado.setSubido1(cursor.getInt(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_subido1)));
                registrado.setSubido2(cursor.getInt(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_subido2)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return registrado;
    }


    //NORMAL//

    public void insertarFechaRegistro(Registrado registrado){
        ContentValues contentValues = registrado.toValues();
        sqLiteDatabase.insert(SQLConstantes.tablafecharegistro,null,contentValues);
    }

    public void actualizarFechaRegistro(String codigo, ContentValues valores){
        String[] whereArgs = new String[]{codigo};
        sqLiteDatabase.update(SQLConstantes.tablafecharegistro,valores,SQLConstantes.WHERE_CLAUSE_CODIGO,whereArgs);
    }

    public Registrado getFechaRegistro(String dni){
        Registrado registrado = null;
        String[] whereArgs = new String[]{dni};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablafecharegistro,
                    SQLConstantes.COLUMNAS_FECHA_REGISTRO,SQLConstantes.WHERE_CLAUSE_CODIGO,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                registrado = new Registrado();
                registrado.setNivel(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_nivel)));
                registrado.setCod_sede_reg(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_cod_sede_reg)));
                registrado.setCod_sede_prov(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_cod_sede_prov)));
                registrado.setCod_sede_distrital(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_cod_sede_distrital)));
                registrado.setSede_region(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_sede_region)));
                registrado.setSede_provincia(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_sede_provincia)));
                registrado.setSede_distrital(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_sede_distrital)));
                registrado.setCod_local(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_cod_local)));
                registrado.setNom_local(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_nom_local)));
                registrado.setDireccion(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_direccion)));
                registrado.setAula(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_aula)));
                registrado.setCodigo(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_codigo)));
                registrado.setNombres(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_nombres)));
                registrado.setId_cargo(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_id_cargo)));
                registrado.setCargo(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_cargo)));
                registrado.setTipo_candidato(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_tipo_candidato)));
                registrado.setN_bungalow(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_n_bungalow)));
                registrado.setResp_bungalow(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_resp_bungalow)));
                registrado.setDia1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_dia1)));
                registrado.setMes1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_mes1)));
                registrado.setAnio1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_anio1)));
                registrado.setHora1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_hora1)));
                registrado.setMinuto1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_minuto1)));
                registrado.setDia2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_dia2)));
                registrado.setMes2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_mes2)));
                registrado.setAnio2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_anio2)));
                registrado.setHora2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_hora2)));
                registrado.setMinuto2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_minuto2)));
                registrado.setEstado1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_estado1)));
                registrado.setEstado2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_estado2)));
                registrado.setSubido1(cursor.getInt(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_subido1)));
                registrado.setSubido2(cursor.getInt(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_subido2)));

            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return registrado;
    }

    public ArrayList<Registrado> getAllRegistrados(String cod_local){
        ArrayList<Registrado> registrados = new ArrayList<>();
        String[] whereArgs = new String[]{cod_local};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablafecharegistro,
                    null,SQLConstantes.WHERE_CLAUSE_COD_LOCAL,whereArgs,null,null,null);
            while(cursor.moveToNext()){
                Registrado registrado = new Registrado();
                registrado.setCod_sede_prov(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_cod_sede_prov)));
                registrado.setCod_sede_distrital(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_cod_sede_distrital)));
                registrado.setSede_region(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_sede_region)));
                registrado.setSede_provincia(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_sede_provincia)));
                registrado.setSede_distrital(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_sede_distrital)));
                registrado.setCod_local(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_cod_local)));
                registrado.setNom_local(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_nom_local)));
                registrado.setDireccion(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_direccion)));
                registrado.setAula(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_aula)));
                registrado.setCodigo(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_codigo)));
                registrado.setNombres(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_nombres)));
                registrado.setId_cargo(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_id_cargo)));
                registrado.setCargo(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_cargo)));
                registrado.setTipo_candidato(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_tipo_candidato)));
                registrado.setN_bungalow(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_n_bungalow)));
                registrado.setResp_bungalow(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_resp_bungalow)));
                registrado.setDia1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_dia1)));
                registrado.setMes1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_mes1)));
                registrado.setAnio1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_anio1)));
                registrado.setHora1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_hora1)));
                registrado.setMinuto1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_minuto1)));
                registrado.setDia2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_dia2)));
                registrado.setMes2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_mes2)));
                registrado.setAnio2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_anio2)));
                registrado.setHora2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_hora2)));
                registrado.setMinuto2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_minuto2)));
                registrado.setEstado1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_estado1)));
                registrado.setEstado2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_estado2)));
                registrado.setSubido1(cursor.getInt(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_subido1)));
                registrado.setSubido2(cursor.getInt(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_subido2)));
                registrados.add(registrado);
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return registrados;
    }

    public ArrayList<Registrado> getAllRegistradosTemporal(){
        ArrayList<Registrado> registrados = new ArrayList<>();
        String[] whereArgs = new String[]{"0","1"};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablafecharegistro,
                    null,SQLConstantes.WHERE_CLAUSE_SUBIDO1,whereArgs,null,null,null);
            while(cursor.moveToNext()){
                Registrado registrado = new Registrado();
                registrado.set_id(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_id)));
                registrado.setNivel(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_nivel)));
                registrado.setCod_sede_reg(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_cod_sede_reg)));
                registrado.setCod_sede_prov(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_cod_sede_prov)));
                registrado.setCod_sede_distrital(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_cod_sede_distrital)));
                registrado.setSede_region(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_sede_region)));
                registrado.setSede_provincia(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_sede_provincia)));
                registrado.setSede_distrital(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_sede_distrital)));
                registrado.setCod_local(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_cod_local)));
                registrado.setNom_local(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_nom_local)));
                registrado.setDireccion(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_direccion)));
                registrado.setAula(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_aula)));
                registrado.setCodigo(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_codigo)));
                registrado.setNombres(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_nombres)));
                registrado.setId_cargo(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_id_cargo)));
                registrado.setCargo(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_cargo)));
                registrado.setTipo_candidato(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_tipo_candidato)));
                registrado.setN_bungalow(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_n_bungalow)));
                registrado.setResp_bungalow(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_resp_bungalow)));
                registrado.setFecha_registro1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_fecha_registro1)));
                registrado.setFecha_registro2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_fecha_registro2)));
                registrado.setDia1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_dia1)));
                registrado.setMes1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_mes1)));
                registrado.setAnio1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_anio1)));
                registrado.setHora1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_hora1)));
                registrado.setMinuto1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_minuto1)));
                registrado.setDia2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_dia2)));
                registrado.setMes2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_mes2)));
                registrado.setAnio2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_anio2)));
                registrado.setHora2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_hora2)));
                registrado.setMinuto2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_minuto2)));
                registrado.setEstado1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_estado1)));
                registrado.setEstado2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_estado2)));
                registrado.setSubido1(cursor.getInt(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_subido1)));
                registrado.setSubido2(cursor.getInt(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_subido2)));
                registrados.add(registrado);
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return registrados;
    }

    public ArrayList<Registrado> getAllRegistradosTemporal2(){
        ArrayList<Registrado> registrados = new ArrayList<>();
        String[] whereArgs = new String[]{"0","1"};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablafecharegistro,
                    null,SQLConstantes.WHERE_CLAUSE_SUBIDO2,whereArgs,null,null,null);
            while(cursor.moveToNext()){
                Registrado registrado = new Registrado();
                registrado.set_id(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_id)));
                registrado.setNivel(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_nivel)));
                registrado.setCod_sede_reg(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_cod_sede_reg)));
                registrado.setCod_sede_prov(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_cod_sede_prov)));
                registrado.setCod_sede_distrital(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_cod_sede_distrital)));
                registrado.setSede_region(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_sede_region)));
                registrado.setSede_provincia(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_sede_provincia)));
                registrado.setSede_distrital(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_sede_distrital)));
                registrado.setCod_local(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_cod_local)));
                registrado.setNom_local(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_nom_local)));
                registrado.setDireccion(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_direccion)));
                registrado.setAula(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_aula)));
                registrado.setCodigo(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_codigo)));
                registrado.setNombres(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_nombres)));
                registrado.setId_cargo(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_id_cargo)));
                registrado.setCargo(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_cargo)));
                registrado.setTipo_candidato(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_tipo_candidato)));
                registrado.setN_bungalow(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_n_bungalow)));
                registrado.setResp_bungalow(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_resp_bungalow)));
                registrado.setFecha_registro1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_fecha_registro1)));
                registrado.setFecha_registro2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_fecha_registro2)));
                registrado.setDia1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_dia1)));
                registrado.setMes1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_mes1)));
                registrado.setAnio1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_anio1)));
                registrado.setHora1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_hora1)));
                registrado.setMinuto1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_minuto1)));
                registrado.setDia2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_dia2)));
                registrado.setMes2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_mes2)));
                registrado.setAnio2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_anio2)));
                registrado.setHora2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_hora2)));
                registrado.setMinuto2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_minuto2)));
                registrado.setEstado1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_estado1)));
                registrado.setEstado2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_estado2)));
                registrado.setSubido1(cursor.getInt(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_subido1)));
                registrado.setSubido2(cursor.getInt(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_subido2)));
                registrados.add(registrado);
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return registrados;
    }



    //MOSTRAR TODOS
    public ArrayList<Registrado> getAllRegistradosNube(){
        ArrayList<Registrado> registrados = new ArrayList<>();
        String[] whereArgs = new String[]{"1"};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablafecharegistro,
                    null,SQLConstantes.WHERE_CLAUSE_SUBIDO1,whereArgs,null,null,null);
            while(cursor.moveToNext()){
                Registrado registrado = new Registrado();
                registrado.setCodigo(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_codigo)));
                registrado.setSede_region(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_sede_region)));
                registrado.setCod_local(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_cod_local)));
                registrado.setNom_local(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_nom_local)));
                registrado.setDireccion(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_direccion)));
                registrado.setAula(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_aula)));
                registrado.setNombres(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_nombres)));
                registrado.setDia1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_dia1)));
                registrado.setMes1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_mes1)));
                registrado.setAnio1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_anio1)));
                registrado.setHora1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_hora1)));
                registrado.setMinuto1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_minuto1)));
                registrado.setDia2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_dia2)));
                registrado.setMes2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_mes2)));
                registrado.setAnio2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_anio2)));
                registrado.setHora2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_hora2)));
                registrado.setMinuto2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_minuto2)));
                registrado.setEstado1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_estado1)));
                registrado.setEstado2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_estado2)));
                registrado.setSubido1(cursor.getInt(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_subido1)));
                registrado.setSubido2(cursor.getInt(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_subido2)));
                registrados.add(registrado);
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return registrados;
    }

    //MOSTRAR POR SEDE
    public ArrayList<Registrado> getSedeRegistradosNube(String cod_local){
        ArrayList<Registrado> registrados = new ArrayList<>();
        String[] whereArgs = new String[]{cod_local,"1"};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablafecharegistro,
                    null,SQLConstantes.WHERE_CLAUSE_SEDESUBIDO1,whereArgs,null,null,null);
            while(cursor.moveToNext()){
                Registrado registrado = new Registrado();
                registrado.set_id(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_id)));
                registrado.setCodigo(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_codigo)));
                registrado.setSede_region(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_sede_region)));
                registrado.setCod_local(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_cod_local)));
                registrado.setNom_local(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_nom_local)));
                registrado.setDireccion(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_direccion)));
                registrado.setAula(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_aula)));
                registrado.setNombres(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_nombres)));
                registrado.setN_bungalow(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_n_bungalow)));
                registrado.setResp_bungalow(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_resp_bungalow)));
                registrado.setFecha_registro1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_fecha_registro1)));
                registrado.setFecha_registro2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_fecha_registro2)));
                registrado.setDia1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_dia1)));
                registrado.setMes1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_mes1)));
                registrado.setAnio1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_anio1)));
                registrado.setHora1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_hora1)));
                registrado.setMinuto1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_minuto1)));
                registrado.setDia2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_dia2)));
                registrado.setMes2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_mes2)));
                registrado.setAnio2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_anio2)));
                registrado.setHora2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_hora2)));
                registrado.setMinuto2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_minuto2)));
                registrado.setEstado1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_estado1)));
                registrado.setEstado2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_estado2)));
                registrado.setSubido1(cursor.getInt(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_subido1)));
                registrado.setSubido2(cursor.getInt(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_subido2)));
                registrados.add(registrado);
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return registrados;
    }

    //MOSTRAR POR LOCAL
    public ArrayList<Registrado> getLocalRegistradosNube(String local){
        ArrayList<Registrado> registrados = new ArrayList<>();
        String[] whereArgs = new String[]{local,"1"};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablafecharegistro,
                    null,SQLConstantes.WHERE_CLAUSE_SEDESUBIDO1,whereArgs,null,null,null);
            while(cursor.moveToNext()){
                Registrado registrado = new Registrado();
                registrado.set_id(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_id)));
                registrado.setCodigo(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_codigo)));
                registrado.setSede_region(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_sede_region)));
                registrado.setCod_local(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_cod_local)));
                registrado.setNom_local(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_nom_local)));
                registrado.setDireccion(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_direccion)));
                registrado.setAula(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_aula)));
                registrado.setNombres(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_nombres)));
                registrado.setN_bungalow(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_n_bungalow)));
                registrado.setResp_bungalow(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_resp_bungalow)));
                registrado.setDia1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_dia1)));
                registrado.setMes1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_mes1)));
                registrado.setAnio1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_anio1)));
                registrado.setHora1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_hora1)));
                registrado.setMinuto1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_minuto1)));
                registrado.setDia2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_dia2)));
                registrado.setMes2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_mes2)));
                registrado.setAnio2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_anio2)));
                registrado.setHora2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_hora2)));
                registrado.setMinuto2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_minuto2)));
                registrado.setEstado1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_estado1)));
                registrado.setEstado2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_estado2)));
                registrado.setSubido1(cursor.getInt(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_subido1)));
                registrado.setSubido2(cursor.getInt(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_subido2)));
                registrados.add(registrado);
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return registrados;
    }

    //MOSTRAR POR DIA
    public ArrayList<Registrado> getSedeRegistradosDia(String aula){
        ArrayList<Registrado> registrados = new ArrayList<>();
        String[] whereArgs = new String[]{aula};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablafecharegistro,
                    null,SQLConstantes.WHERE_CLAUSE_AULA,whereArgs,null,null,null);
            while(cursor.moveToNext()){
                Registrado registrado = new Registrado();
                registrado.set_id(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_id)));
                registrado.setCodigo(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_codigo)));
                registrado.setSede_region(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_sede_region)));
                registrado.setCod_local(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_cod_local)));
                registrado.setNom_local(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_nom_local)));
                registrado.setDireccion(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_direccion)));
                registrado.setAula(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_aula)));
                registrado.setNombres(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_nombres)));
                registrado.setN_bungalow(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_n_bungalow)));
                registrado.setResp_bungalow(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_resp_bungalow)));
                registrado.setFecha_registro1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_fecha_registro1)));
                registrado.setFecha_registro2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_fecha_registro2)));
                registrado.setDia1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_dia1)));
                registrado.setMes1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_mes1)));
                registrado.setAnio1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_anio1)));
                registrado.setHora1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_hora1)));
                registrado.setMinuto1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_minuto1)));
                registrado.setDia2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_dia2)));
                registrado.setMes2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_mes2)));
                registrado.setAnio2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_anio2)));
                registrado.setHora2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_hora2)));
                registrado.setMinuto2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_minuto2)));
                registrado.setEstado1(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_estado1)));
                registrado.setEstado2(cursor.getString(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_estado2)));
                registrado.setSubido1(cursor.getInt(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_subido1)));
                registrado.setSubido2(cursor.getInt(cursor.getColumnIndex(SQLConstantes.fecha_de_registro_subido2)));
                registrados.add(registrado);
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return registrados;
    }


    public void deleteAllElementosFromTabla(String nombreTabla){
        sqLiteDatabase.execSQL("delete from "+ nombreTabla);
    }

}
