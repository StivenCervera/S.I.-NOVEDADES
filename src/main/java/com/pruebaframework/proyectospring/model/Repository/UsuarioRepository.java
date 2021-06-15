package com.pruebaframework.proyectospring.model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pruebaframework.proyectospring.model.Entity.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    
}
