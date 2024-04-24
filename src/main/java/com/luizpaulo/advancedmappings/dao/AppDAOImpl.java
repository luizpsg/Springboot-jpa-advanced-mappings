package com.luizpaulo.advancedmappings.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luizpaulo.advancedmappings.entity.Instructor;

import jakarta.persistence.EntityManager;

@Repository
public class AppDAOImpl implements AppDAO{

    // define field for entity manager
    EntityManager entityManager;
    
    // inject entity manager using constructor injection
    //@Autowired
    public AppDAOImpl(EntityManager entityManager){
      this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
      entityManager.persist(instructor);
    }

  }