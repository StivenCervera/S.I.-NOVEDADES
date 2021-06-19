package com.pruebaframework.proyectospring.model.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebaframework.proyectospring.dto.roldto;
import com.pruebaframework.proyectospring.model.Entity.Rol;
import com.pruebaframework.proyectospring.model.Repository.RolRepository;

@Service
public class RolServiceImpl  implements IRolService {
    @Autowired
    private RolRepository rolRepository;
    @Autowired
    private ModelMapper modelMapper; 
    
    @Override
    public void delete(Integer id) {
        rolRepository.deleteById(id);
    }
    
    @Override
    public roldto get(Integer id) {
        Rol entity=rolRepository.getById(id);
        roldto tdo = modelMapper.map(entity,roldto.class);
        return tdo;
    }
   
    @Override
    public List<roldto> getAll() {
        List<Rol>p= rolRepository.findAll();
        List<roldto>pdto =p.stream().map(role -> modelMapper.map(role, roldto.class)).collect(Collectors.toList());
        return pdto ;
    }
    @Override
    public roldto save(roldto rol) {
      Rol entity =modelMapper.map(rol,Rol.class);
      rolRepository.save(entity);
        return modelMapper.map(entity,roldto.class);
    }
    
    
}