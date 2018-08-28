package com.example.dmorales.evaluacion2018.modelo;

public class Nacional {
    //    private String codigo;
//    private String sede;
//    private String id_local;
//    private String nom_local;
//    private String aula;
//    private String nombres;
//    private String cargo;
//    private String estado1;
//    private String estado2;
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


    public Nacional(String nivel, String cod_sede_reg, String cod_sede_prov, String cod_sede_distrital, String sede_region, String sede_provincia, String sede_distrital, String cod_local, String nom_local, String direccion,String aula, String codigo, String nombres, String id_cargo, String cargo, String tipo_candidato, String n_bungalow, String resp_bungalow) {
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
    }

    public Nacional() {
        this.nivel = "";
        this.cod_sede_reg = "";
        this.cod_sede_prov = "";
        this.cod_sede_distrital = "";
        this.sede_region = "";
        this.sede_provincia = "";
        this.sede_distrital = "";
        this.cod_local = "";
        this.nom_local = "";
        this.direccion = "";
        this.aula = "";
        this.codigo = "";
        this.nombres = "";
        this.id_cargo = "";
        this.cargo = "";
        this.tipo_candidato = "";
        this.n_bungalow = "";
        this.resp_bungalow = "";
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
}
