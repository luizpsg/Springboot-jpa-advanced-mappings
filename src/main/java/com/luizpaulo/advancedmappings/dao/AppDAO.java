package com.luizpaulo.advancedmappings.dao;

import java.util.List;

import com.luizpaulo.advancedmappings.entity.Course;
import com.luizpaulo.advancedmappings.entity.Instructor;
import com.luizpaulo.advancedmappings.entity.InstructorDetail;
import com.luizpaulo.advancedmappings.entity.Student;

public interface AppDAO {

  public void save(Instructor instructor);

  Instructor findInstructorById(int id);

  void deleteInstructorById(int id);

  InstructorDetail findInstructorDetailById(int id);

  void deleteInstructorDetailById(int id);

  List<Course> findCoursesByInstructorId(int id);

  Instructor findInstructorByIdJoinFetch(int id);

  void update(Instructor instructor);

  void update(Course course);

  Course findCourseById(int id);

  void deleteCourseById(int id);

  void save(Course course);

  Course findCourseAndReviewsByCourseId(int id);
  
  Course findCoursesAndStudentsByCourseId(int id);

  Student findStudentsAndCoursesByStudentId(int id);

}
