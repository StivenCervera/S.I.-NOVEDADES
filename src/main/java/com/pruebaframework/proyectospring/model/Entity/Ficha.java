package com.pruebaframework.proyectospring.model.Entity;
import java.util.*;
import javax.persistence.*;
@Entity 
@Table(name="ficha")
public class Ficha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_Ficha")
    private int idFicha;

    @Column(name ="id_Programa")
    private int idPrograma;

    @Column(name ="numero_Ficha")
    private int numeroFicha;

    @Column(name = "id_Representante_Ficha")
   private int idRepresentanteFicha;
    


    @Column(name = "id_Suplente_Ficha")
    private int idSuplenteFicha;


    @ManyToMany(mappedBy = "ficha")
    private List<Aprendiz>aprendiz;
    public Ficha() {
    }

    public Ficha(int idFicha, int idPrograma, int numeroFicha, int idRepresentanteFicha, int idSuplenteFicha) {
        this.idFicha = idFicha;
        this.idPrograma = idPrograma;
        this.numeroFicha = numeroFicha;
        this.idRepresentanteFicha = idRepresentanteFicha;
        this.idSuplenteFicha = idSuplenteFicha;
    }

    public int getIdFicha() {
        return idFicha;
    }

    public void setIdFicha(int idFicha) {
        this.idFicha = idFicha;
    }

    public int getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(int idPrograma) {
        this.idPrograma = idPrograma;
    }

    public int getNumeroFicha() {
        return numeroFicha;
    }

    public void setNumeroFicha(int numeroFicha) {
        this.numeroFicha = numeroFicha;
    }

    public int getIdRepresentanteFicha() {
        return idRepresentanteFicha;
    }

    public void setIdRepresentanteFicha(int idRepresentanteFicha) {
        this.idRepresentanteFicha = idRepresentanteFicha;
    }

    public int getIdSuplenteFicha() {
        return idSuplenteFicha;
    }

    public void setIdSuplenteFicha(int idSuplenteFicha) {
        this.idSuplenteFicha = idSuplenteFicha;
    }
    
    

    
}
