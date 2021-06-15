package com.pruebaframework.proyectospring.model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebaframework.proyectospring.model.Entity.Ficha;

public interface FichaRepository extends JpaRepository<Ficha,Integer> {
    
}
