package com.learn.spring_boot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@RestController()
public class HelloController {

  @PersistenceContext
  private EntityManager entityManager;

  @GetMapping("/")
  public String Index(){
    Query query = entityManager.createNativeQuery("SELECT 1");
    return "Database connection successful! Result: " + query.getSingleResult();
  }
  
}
