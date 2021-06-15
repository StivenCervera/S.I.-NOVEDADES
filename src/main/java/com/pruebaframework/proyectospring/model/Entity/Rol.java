package com.pruebaframework.proyectospring.model.Entity;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity 
@Table(name="Rol")
public class Rol {
   
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_Rol")
    private int idRol;

    @Column(name="tipo_Rol", length=45)
    private String tipoRol;

    @OneToMany(mappedBy = "rol")
    private  List<Usuario>list;
    

    public Rol() {
    }

    public Rol(String tipoRol) {
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

