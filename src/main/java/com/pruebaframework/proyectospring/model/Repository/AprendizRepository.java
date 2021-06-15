package com.pruebaframework.proyectospring.model.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebaframework.proyectospring.model.Entity.Aprendiz;
public interface AprendizRepository  extends JpaRepository<Aprendiz,Integer> {
    
}
