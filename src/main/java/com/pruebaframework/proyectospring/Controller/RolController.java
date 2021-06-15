package com.pruebaframework.proyectospring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pruebaframework.proyectospring.model.Entity.Rol;
import com.pruebaframework.proyectospring.model.Service.IRolService;

@Controller
@RequestMapping("/static")
public class RolController {
    @Autowired
    IRolService rolService;
    @GetMapping("/")
    public String listarTodos (Model model)
    {
        List<Rol> roles = rolService.listarTodos();
        model.addAttribute("Rol", roles);

		return "/static/lista";
    }
}
