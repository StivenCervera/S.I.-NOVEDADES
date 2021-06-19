package com.pruebaframework.proyectospring;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class proyectospringConfiguracion {
    @Bean
    public ModelMapper modelMapper (){
        return new ModelMapper();
    }
}
