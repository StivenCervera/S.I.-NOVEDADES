package com.pruebaframework.proyectospring.model.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebaframework.proyectospring.model.Entity.Rol;
import com.pruebaframework.proyectospring.model.Repository.RolRepository;

@Service
public class RolServiceImpl  implements IRolService {
    @Autowired
    private RolRepository rolRepository;
    @Override
    public List<Rol> listarTodos() {
        return (List<Rol>) rolRepository.findAll();
    }
    
}