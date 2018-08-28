package com.example.dmorales.evaluacion2018.modelo;

public class UsuarioLocal {

    private String _id;
    private String usuario;
    private String clave;
    private String cod_local;
    private String nom_local;
    private String cod_sede_reg;
    private String sede_region;
    private String cod_nivel;
    private String nom_nivel;
    private String fase;

    public UsuarioLocal(String _id, String usuario, String clave, String cod_local, String nom_local, String cod_sede_reg, String sede_region, String cod_nivel, String nom_nivel,String fase) {
        this._id = _id;
        this.usuario = usuario;
        this.clave = clave;
        this.cod_local = cod_local;
        this.nom_local = nom_local;
        this.cod_sede_reg = cod_sede_reg;
        this.sede_region = sede_region;
        this.cod_nivel = cod_nivel;
        this.nom_nivel = nom_nivel;
        this.fase = fase;
    }

    public UsuarioLocal() {
        this._id = "";
        this.usuario = "";
        this.clave = "";
        this.cod_local = "";
        this.nom_local = "";
        this.cod_sede_reg = "";
        this.sede_region = "";
        this.cod_nivel = "";
        this.nom_nivel = "";
        this.fase = "";
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNom_local() {
        return nom_local;
    }

    public void setNom_local(String nom_local) {
        this.nom_local = nom_local;
    }

    public String getSede_region() {
        return sede_region;
    }

    public void setSede_region(String sede_region) {
        this.sede_region = sede_region;
    }

    public String getCod_nivel() {
        return cod_nivel;
    }

    public void setCod_nivel(String cod_nivel) {
        this.cod_nivel = cod_nivel;
    }

    public String getNom_nivel() {
        return nom_nivel;
    }

    public void setNom_nivel(String nom_nivel) {
        this.nom_nivel = nom_nivel;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCod_local() {
        return cod_local;
    }

    public void setCod_local(String cod_local) {
        this.cod_local = cod_local;
    }

    public String getCod_sede_reg() {
        return cod_sede_reg;
    }

    public void setCod_sede_reg(String cod_sede_reg) {
        this.cod_sede_reg = cod_sede_reg;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }
}
