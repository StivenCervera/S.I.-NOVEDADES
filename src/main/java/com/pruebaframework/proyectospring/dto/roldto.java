package com.pruebaframework.proyectospring.dto;

public class roldto {
    private int idRol;
    private String tipoRol;

    public roldto() {
    }

    public roldto(String tipoRol) {
        this.tipoRol = tipoRol;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getTipoRol() {
        return tipoRol;
    }

    public void setTipoRol(String tipoRol) {
        this.tipoRol = tipoRol;
    }
 
}
