package com.luizpaulo.advancedmappings.dao;

import com.luizpaulo.advancedmappings.entity.Instructor;
import com.luizpaulo.advancedmappings.entity.InstructorDetail;

public interface AppDAO {

  public void save(Instructor instructor);

  Instructor findInstructorById(int id);

  void deleteInstructorById(int id);

  InstructorDetail findInstructorDetailById(int id);

  void deleteInstructorDetailById(int id);

}
