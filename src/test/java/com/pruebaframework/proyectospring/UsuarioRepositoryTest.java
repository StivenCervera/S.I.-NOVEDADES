package com.pruebaframework.proyectospring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.pruebaframework.proyectospring.model.Entity.Usuario;
import com.pruebaframework.proyectospring.model.Repository.UsuarioRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class UsuarioRepositoryTest {

    @Autowired    
    UsuarioRepository reportd;
    
    @Test
    public void UsuarioTest() {
       Usuario td1= new Usuario("fwfwef",1,123123,"fwqe");

        reportd.save(td1);

        reportd.flush();
        assertEquals(1, reportd.findAll().size());
    }
}
