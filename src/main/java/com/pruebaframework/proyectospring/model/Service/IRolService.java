package com.pruebaframework.proyectospring.model.Service;

import java.util.List;

import com.pruebaframework.proyectospring.dto.roldto;

public interface IRolService {
    public List<roldto> getAll();
    public roldto get(Integer idRol); //consulta específica
    public roldto save(roldto rol);
    public void delete(Integer idRol); //borrar
}

