package com.pruebaframework.proyectospring.Controller;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pruebaframework.proyectospring.Form.rolForm;
import com.pruebaframework.proyectospring.dto.roldto;
import com.pruebaframework.proyectospring.model.Service.IRolService;

@Controller
@RequestMapping("/lista")
public class RolController {
    @Autowired
    IRolService rolService;

    @GetMapping("/show")
    public ModelAndView listarTodos (Model model)
    {
        var params = new HashMap<String, Object>();
        params.put("pdto", rolService.getAll());
return new ModelAndView ("lista",params);
    }

    @GetMapping("/new")
public ModelAndView registrar(){
    var params = new HashMap<String, Object>();
    rolForm form = new rolForm();
    form.setRold(new roldto());
    params.put("form", form);
return new ModelAndView ("formulario",params);
}
@PostMapping("/save")
public ModelAndView save(rolForm form)
{
    rolService.save(form.getRold());

return new ModelAndView ("redirect:/lista/show");
}

@GetMapping("/edit/{idRol}")
public ModelAndView editar(@ModelAttribute("idRol") Integer idRol){
    var params = new HashMap<String, Object>();
    rolForm form = new rolForm();
    form.setRold(rolService.get(idRol));
    params.put("form", form);
return new ModelAndView ("formulario",params);
}
@GetMapping("/delete/{idRol}")
public ModelAndView delete (@ModelAttribute("idRol") Integer idRol){
 rolService.delete(idRol);
return new ModelAndView ("redirect:/lista/show");
}

}
