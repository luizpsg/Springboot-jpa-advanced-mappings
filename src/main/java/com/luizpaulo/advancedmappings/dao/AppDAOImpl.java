package com.luizpaulo.advancedmappings.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luizpaulo.advancedmappings.entity.Course;
import com.luizpaulo.advancedmappings.entity.Instructor;
import com.luizpaulo.advancedmappings.entity.InstructorDetail;
import com.luizpaulo.advancedmappings.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

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

    List<Course> courses = instructor.getCourses();

    for(Course tempCourse : courses){
      tempCourse.setInstructor(null);
    }

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

  @Override
  public List<Course> findCoursesByInstructorId(int theId) {

    TypedQuery<Course> query = entityManager.createQuery(
                      "from Course where instructor.id=:data", Course.class);
    
    query.setParameter("data", theId);


    List<Course> courses = query.getResultList();

    return courses;
  }

  @Override
  public Instructor findInstructorByIdJoinFetch(int theId) {
    
    TypedQuery<Instructor> query = entityManager.createQuery(
                                                  "select i from Instructor i "
                                                  + "JOIN FETCH i.courses "
                                                  + "JOIN FETCH i.instructorDetail "
                                                  + "where i.id=:data", Instructor.class);
                                
    query.setParameter("data", theId);

    Instructor instructor = query.getSingleResult();

    return instructor;
  }

  @Override
  @Transactional
  public void update(Instructor instructor) {
    entityManager.merge(instructor);
  }

  @Override
  @Transactional
  public void update(Course tempCourse) {
    entityManager.merge(tempCourse);
  }

  @Override
  public Course findCourseById(int id) {
    return entityManager.find(Course.class, id);
  }

  @Override
  @Transactional
  public void deleteCourseById(int id) {
    Course tempCourse = entityManager.find(Course.class, id);

    entityManager.remove(tempCourse);
  }

  @Override
  @Transactional
  public void save(Course course) {
    entityManager.persist(course);
  }

  @Override
  public Course findCourseAndReviewsByCourseId(int id) {
    TypedQuery<Course> query = entityManager.createQuery(
                      "select c from Course c "
                      + "JOIN FETCH c.reviews "
                      + "where c.id=:data", Course.class);
    
    query.setParameter("data", id);

    Course course = query.getSingleResult();

    return course;
  }

  @Override
  public Course findCoursesAndStudentsByCourseId(int id) {
    
    TypedQuery<Course> query = entityManager.createQuery(
                      "select c from Course c "
                      + "JOIN FETCH c.students "
                      + "where c.id=:data", Course.class);

    query.setParameter("data", id);

    Course course = query.getSingleResult();

    return course;
  }

  @Override
  public Student findStudentsAndCoursesByStudentId(int id) {

    TypedQuery<Student> query = entityManager.createQuery(
                      "select s from Student s "
                      + "JOIN FETCH s.courses "
                      + "where s.id=:data", Student.class);

    query.setParameter("data", id);

    Student student = query.getSingleResult();

    return student;
      
    
  }

  @Override
  @Transactional
  public void update(Student tempStudent) {
    
    entityManager.merge(tempStudent);
  }

  @Override
  @Transactional
  public void deleteStudentById(int id) {
    
    Student tempStudent = entityManager.find(Student.class, id);

    entityManager.remove(tempStudent);
  }

}