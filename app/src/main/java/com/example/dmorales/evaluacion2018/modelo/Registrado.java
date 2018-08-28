package com.example.dmorales.evaluacion2018.modelo;

import android.content.ContentValues;

public class Registrado {
    private String _id;
    private String nivel;
    private String cod_sede_reg;
    private String cod_sede_prov;
    private String cod_sede_distrital;
    private String sede_region;
    private String sede_provincia;
    private String sede_distrital;
    private String cod_local;
    private String nom_local;
    private String direccion;
    private String aula;
    private String codigo;
    private String nombres;
    private String id_cargo;
    private String cargo;
    private String tipo_candidato;
    private String n_bungalow;
    private String resp_bungalow;
    private String fecha_registro1;
    private String fecha_registro2;
    private String dia1;
    private String mes1;
    private String anio1;
    private String hora1;
    private String minuto1;
    private String dia2;
    private String mes2;
    private String anio2;
    private String hora2;
    private String minuto2;
    private String estado1;
    private String estado2;
    private int subido1;
    private int subido2;

    public Registrado(String _id, String nivel, String cod_sede_reg, String cod_sede_prov, String cod_sede_distrital, String sede_region, String sede_provincia, String sede_distrital, String cod_local, String nom_local, String direccion, String aula, String codigo, String nombres, String id_cargo, String cargo, String tipo_candidato, String n_bungalow, String resp_bungalow, String fecha_registro1, String fecha_registro2, String dia1, String mes1, String anio1, String hora1, String minuto1, String dia2, String mes2, String anio2, String hora2, String minuto2, String estado1, String estado2, int subido1, int subido2) {
        this._id = _id;
        this.nivel = nivel;
        this.cod_sede_reg = cod_sede_reg;
        this.cod_sede_prov = cod_sede_prov;
        this.cod_sede_distrital = cod_sede_distrital;
        this.sede_region = sede_region;
        this.sede_provincia = sede_provincia;
        this.sede_distrital = sede_distrital;
        this.cod_local = cod_local;
        this.nom_local = nom_local;
        this.direccion = direccion;
        this.aula = aula;
        this.codigo = codigo;
        this.nombres = nombres;
        this.id_cargo = id_cargo;
        this.cargo = cargo;
        this.tipo_candidato = tipo_candidato;
        this.n_bungalow = n_bungalow;
        this.resp_bungalow = resp_bungalow;
        this.fecha_registro1 = fecha_registro1;
        this.fecha_registro2 = fecha_registro2;
        this.dia1 = dia1;
        this.mes1 = mes1;
        this.anio1 = anio1;
        this.hora1 = hora1;
        this.minuto1 = minuto1;
        this.dia2 = dia2;
        this.mes2 = mes2;
        this.anio2 = anio2;
        this.hora2 = hora2;
        this.minuto2 = minuto2;
        this.estado1 = estado1;
        this.estado2 = estado2;
        this.subido1 = subido1;
        this.subido2 = subido2;
    }

    public Registrado(){
        this._id="";
        this.nivel="";
        this.cod_sede_reg="";
        this.cod_sede_prov="";
        this.cod_sede_distrital="";
        this.sede_region="";
        this.sede_provincia="";
        this.sede_distrital="";
        this.cod_local="";
        this.nom_local="";
        this.aula="";
        this.codigo="";
        this.nombres="";
        this.id_cargo="";
        this.cargo="";
        this.tipo_candidato = "";
        this.n_bungalow = "";
        this.resp_bungalow = "";
        this.fecha_registro1 ="";
        this.fecha_registro2 ="";
        this.dia1="";
        this.mes1="";
        this.anio1="";
        this.hora1="";
        this.minuto1="";
        this.dia2="";
        this.mes2="";
        this.anio2="";
        this.hora2="";
        this.minuto2="";
        this.estado1="";
        this.estado2="";
        this.subido1 = 0;
        this.subido2 = 0;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getCod_sede_reg() {
        return cod_sede_reg;
    }

    public void setCod_sede_reg(String cod_sede_reg) {
        this.cod_sede_reg = cod_sede_reg;
    }

    public String getCod_sede_prov() {
        return cod_sede_prov;
    }

    public void setCod_sede_prov(String cod_sede_prov) {
        this.cod_sede_prov = cod_sede_prov;
    }

    public String getCod_sede_distrital() {
        return cod_sede_distrital;
    }

    public void setCod_sede_distrital(String cod_sede_distrital) {
        this.cod_sede_distrital = cod_sede_distrital;
    }

    public String getSede_region() {
        return sede_region;
    }

    public void setSede_region(String sede_region) {
        this.sede_region = sede_region;
    }

    public String getSede_provincia() {
        return sede_provincia;
    }

    public void setSede_provincia(String sede_provincia) {
        this.sede_provincia = sede_provincia;
    }

    public String getSede_distrital() {
        return sede_distrital;
    }

    public void setSede_distrital(String sede_distrital) {
        this.sede_distrital = sede_distrital;
    }

    public String getCod_local() {
        return cod_local;
    }

    public void setCod_local(String cod_local) {
        this.cod_local = cod_local;
    }

    public String getNom_local() {
        return nom_local;
    }

    public void setNom_local(String nom_local) {
        this.nom_local = nom_local;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(String id_cargo) {
        this.id_cargo = id_cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDia1() {
        return dia1;
    }

    public void setDia1(String dia1) {
        this.dia1 = dia1;
    }

    public String getMes1() {
        return mes1;
    }

    public void setMes1(String mes1) {
        this.mes1 = mes1;
    }

    public String getAnio1() {
        return anio1;
    }

    public void setAnio1(String anio1) {
        this.anio1 = anio1;
    }

    public String getHora1() {
        return hora1;
    }

    public void setHora1(String hora1) {
        this.hora1 = hora1;
    }

    public String getMinuto1() {
        return minuto1;
    }

    public void setMinuto1(String minuto1) {
        this.minuto1 = minuto1;
    }

    public String getDia2() {
        return dia2;
    }

    public void setDia2(String dia2) {
        this.dia2 = dia2;
    }

    public String getMes2() {
        return mes2;
    }

    public void setMes2(String mes2) {
        this.mes2 = mes2;
    }

    public String getAnio2() {
        return anio2;
    }

    public void setAnio2(String anio2) {
        this.anio2 = anio2;
    }

    public String getHora2() {
        return hora2;
    }

    public void setHora2(String hora2) {
        this.hora2 = hora2;
    }

    public String getMinuto2() {
        return minuto2;
    }

    public void setMinuto2(String minuto2) {
        this.minuto2 = minuto2;
    }

    public String getEstado1() {
        return estado1;
    }

    public void setEstado1(String estado1) {
        this.estado1 = estado1;
    }

    public String getEstado2() {
        return estado2;
    }

    public void setEstado2(String estado2) {
        this.estado2 = estado2;
    }

    public int getSubido1() {
        return subido1;
    }

    public void setSubido1(int subido1) {
        this.subido1 = subido1;
    }

    public int getSubido2() {
        return subido2;
    }

    public void setSubido2(int subido2) {
        this.subido2 = subido2;
    }

    public String getTipo_candidato() {
        return tipo_candidato;
    }

    public void setTipo_candidato(String tipo_candidato) {
        this.tipo_candidato = tipo_candidato;
    }

    public String getN_bungalow() {
        return n_bungalow;
    }

    public void setN_bungalow(String n_bungalow) {
        this.n_bungalow = n_bungalow;
    }

    public String getResp_bungalow() {
        return resp_bungalow;
    }

    public void setResp_bungalow(String resp_bungalow) {
        this.resp_bungalow = resp_bungalow;
    }

    public String getFecha_registro1() {
        return fecha_registro1;
    }

    public void setFecha_registro1(String fecha_registro1) {
        this.fecha_registro1 = fecha_registro1;
    }

    public String getFecha_registro2() {
        return fecha_registro2;
    }

    public void setFecha_registro2(String fecha_registro2) {
        this.fecha_registro2 = fecha_registro2;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.fecha_de_registro_id,_id);
        contentValues.put(SQLConstantes.fecha_de_registro_nivel,nivel);
        contentValues.put(SQLConstantes.fecha_de_registro_cod_sede_reg,cod_sede_reg);
        contentValues.put(SQLConstantes.fecha_de_registro_cod_sede_prov,cod_sede_prov);
        contentValues.put(SQLConstantes.fecha_de_registro_cod_sede_distrital,cod_sede_distrital);
        contentValues.put(SQLConstantes.fecha_de_registro_sede_region,sede_region);
        contentValues.put(SQLConstantes.fecha_de_registro_sede_provincia,sede_provincia);
        contentValues.put(SQLConstantes.fecha_de_registro_sede_distrital,sede_distrital);
        contentValues.put(SQLConstantes.fecha_de_registro_cod_local,cod_local);
        contentValues.put(SQLConstantes.fecha_de_registro_nom_local,nom_local);
        contentValues.put(SQLConstantes.fecha_de_registro_direccion,direccion);
        contentValues.put(SQLConstantes.fecha_de_registro_aula,aula);
        contentValues.put(SQLConstantes.fecha_de_registro_codigo,codigo);
        contentValues.put(SQLConstantes.fecha_de_registro_nombres,nombres);
        contentValues.put(SQLConstantes.fecha_de_registro_id_cargo,id_cargo);
        contentValues.put(SQLConstantes.fecha_de_registro_cargo,cargo);
        contentValues.put(SQLConstantes.fecha_de_registro_tipo_candidato,tipo_candidato);
        contentValues.put(SQLConstantes.fecha_de_registro_n_bungalow,n_bungalow);
        contentValues.put(SQLConstantes.fecha_de_registro_resp_bungalow,resp_bungalow);
        contentValues.put(SQLConstantes.fecha_de_registro_fecha_registro1,fecha_registro1);
        contentValues.put(SQLConstantes.fecha_de_registro_fecha_registro2,fecha_registro2);
        contentValues.put(SQLConstantes.fecha_de_registro_dia1,dia1);
        contentValues.put(SQLConstantes.fecha_de_registro_mes1,mes1);
        contentValues.put(SQLConstantes.fecha_de_registro_anio1,anio1);
        contentValues.put(SQLConstantes.fecha_de_registro_hora1,hora1);
        contentValues.put(SQLConstantes.fecha_de_registro_minuto1,minuto1);
        contentValues.put(SQLConstantes.fecha_de_registro_dia2,dia2);
        contentValues.put(SQLConstantes.fecha_de_registro_mes2,mes2);
        contentValues.put(SQLConstantes.fecha_de_registro_anio2,anio2);
        contentValues.put(SQLConstantes.fecha_de_registro_hora2,hora2);
        contentValues.put(SQLConstantes.fecha_de_registro_minuto2,minuto2);
        contentValues.put(SQLConstantes.fecha_de_registro_estado1,estado1);
        contentValues.put(SQLConstantes.fecha_de_registro_estado2,estado2);
        contentValues.put(SQLConstantes.fecha_de_registro_subido1,subido1);
        contentValues.put(SQLConstantes.fecha_de_registro_subido2,subido2);
        return contentValues;
    }
}
