package com.pruebaframework.proyectospring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.pruebaframework.proyectospring.model.Entity.Rol;
import com.pruebaframework.proyectospring.model.Repository.RolRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)

public class RolRepositoryTest {
    @Autowired    
     RolRepository report;
  
    @Test
    public void RolTest() {
      Rol td1 = new Rol("primero");
      report.save(td1);
    
      report.flush();
     
        assertEquals(1, report.findAll().size());
       
    }
}
