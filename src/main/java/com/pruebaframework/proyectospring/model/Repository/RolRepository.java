package com.pruebaframework.proyectospring.model.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pruebaframework.proyectospring.model.Entity.Rol;
@Repository
public interface RolRepository extends JpaRepository<Rol,Integer> {
    
}
