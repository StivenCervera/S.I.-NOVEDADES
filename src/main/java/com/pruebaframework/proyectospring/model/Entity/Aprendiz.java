package com.pruebaframework.proyectospring.model.Entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.*;

@Entity 
@Table (name="aprendiz")
public class Aprendiz {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_Aprendiz")
    private int idAprendiz;

    @Column(name="id_Usuario_FK", unique = true)
    private int idUsuarioFK;

    @Column(name="correo_Aprendiz", length = 40)
    private String correoAprendiz;

    @Column(name="telefono_Aprendiz")
    private int telefonoAprendiz;

    @Column(name="nombre_Aprendiz", length = 45)
    private String nombreAprendiz;

    @Column(name="apellido_Aprendiz", length = 45)
    private String apellidoAprendiz;

    @Column(name="estado_Aprendiz", length = 10)
    private String estadoAprendiz;


    @OneToOne
    @JoinColumn(name = "id_Usuario_FK",insertable = false,updatable = false)
    private Usuario usuario;

    @JoinTable(
        name = "ficha_aprendiz",
        joinColumns = @JoinColumn(name = "id_Ficha_FK", nullable = false),
        inverseJoinColumns = @JoinColumn(name="id_Aprendiz_FK", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Ficha>ficha;


    public Aprendiz() {
    }

   
    
    public Aprendiz(int idAprendiz, int idUsuarioFK, String correoAprendiz, int telefonoAprendiz, String nombreAprendiz,
            String apellidoAprendiz, String estadoAprendiz) {
        this.idAprendiz = idAprendiz;
        this.idUsuarioFK = idUsuarioFK;
        this.correoAprendiz = correoAprendiz;
        this.telefonoAprendiz = telefonoAprendiz;
        this.nombreAprendiz = nombreAprendiz;
        this.apellidoAprendiz = apellidoAprendiz;
        this.estadoAprendiz = estadoAprendiz;



        
    }

    public int getIdAprendiz() {
        return idAprendiz;
    }

    public void setIdAprendiz(int idAprendiz) {
        this.idAprendiz = idAprendiz;
    }

    public int getIdUsuarioFK() {
        return idUsuarioFK;
    }

    public void setIdUsuarioFK(int idUsuarioFK) {
        this.idUsuarioFK = idUsuarioFK;
    }

    public String getCorreoAprendiz() {
        return correoAprendiz;
    }

    public void setCorreoAprendiz(String correoAprendiz) {
        this.correoAprendiz = correoAprendiz;
    }

    public int getTelefonoAprendiz() {
        return telefonoAprendiz;
    }

    public void setTelefonoAprendiz(int telefonoAprendiz) {
        this.telefonoAprendiz = telefonoAprendiz;
    }

    public String getNombreAprendiz() {
        return nombreAprendiz;
    }

    public void setNombreAprendiz(String nombreAprendiz) {
        this.nombreAprendiz = nombreAprendiz;
    }

    public String getApellidoAprendiz() {
        return apellidoAprendiz;
    }

    public void setApellidoAprendiz(String apellidoAprendiz) {
        this.apellidoAprendiz = apellidoAprendiz;
    }

    public String getEstadoAprendiz() {
        return estadoAprendiz;
    }

    public void setEstadoAprendiz(String estadoAprendiz) {
        this.estadoAprendiz = estadoAprendiz;
    }


    
}
