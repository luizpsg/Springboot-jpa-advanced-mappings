package com.luizpaulo.advancedmappings.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luizpaulo.advancedmappings.entity.Instructor;
import com.luizpaulo.advancedmappings.entity.InstructorDetail;

import jakarta.persistence.EntityManager;

@Repository
public class AppDAOImpl implements AppDAO {

  // define field for entity manager
  EntityManager entityManager;

  // inject entity manager using constructor injection
  // @Autowired
  public AppDAOImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  @Transactional
  public void save(Instructor instructor) {
    entityManager.persist(instructor);
  }

  @Override
  public Instructor findInstructorById(int id) {

    return entityManager.find(Instructor.class, id);
  }

  @Override
  @Transactional
  public void deleteInstructorById(int id) {

    // retrieve the instructor
    Instructor instructor = entityManager.find(Instructor.class, id);

    // delete the instructor
    entityManager.remove(instructor);
  }

  @Override
  public InstructorDetail findInstructorDetailById(int id) {

    return entityManager.find(InstructorDetail.class, id);

  }

  @Override
  @Transactional
  public void deleteInstructorDetailById(int id) {

    // retrieve instructor detail
    InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, id);

    // remove the associated object reference
    tempInstructorDetail.getInstructor().setInstructorDetail(null);

    // delete instructor detail
    entityManager.remove(tempInstructorDetail);
  }

}