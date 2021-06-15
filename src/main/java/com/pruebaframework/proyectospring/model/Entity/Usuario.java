package com.pruebaframework.proyectospring.model.Entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="usuario" )
public class Usuario {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name ="id_Usuario")
    private int idUsuario;

    @Column(name ="rol_Fk")
    private int rolFk;

    @Column(name ="tipo_Documento")
    private int tipoDocumento;

    @Column(name ="contraseña", length = 10)
    private String contraseña;

    @Column(name ="usuario", length = 20)
    private String usuario;

    @ManyToOne
    @JoinColumn(name = "rol_Fk",insertable = false,updatable = false)
    private Rol rol;

  
    
    public Usuario() {
    }

    public Usuario( String contraseña,int rolFk, int tipoDocumento,  String usuario) {
        this.rolFk = rolFk;
        this.tipoDocumento = tipoDocumento;
        this.contraseña = contraseña;
        this.usuario = usuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getRolFk() {
        return rolFk;
    }

    public void setRolFk(int rolFk) {
        this.rolFk = rolFk;
    }

    public int getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(int tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
        
}
