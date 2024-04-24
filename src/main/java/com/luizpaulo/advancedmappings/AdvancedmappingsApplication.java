package com.luizpaulo.advancedmappings;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luizpaulo.advancedmappings.dao.AppDAO;
import com.luizpaulo.advancedmappings.entity.Course;
import com.luizpaulo.advancedmappings.entity.Instructor;
import com.luizpaulo.advancedmappings.entity.InstructorDetail;

@SpringBootApplication
public class AdvancedmappingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedmappingsApplication.class, args);
	}

  @Bean
  public CommandLineRunner commandLineRunner(AppDAO appDAO){

    return runner -> {
    
      //createInstructor(appDAO);

      //findInstructor(appDAO);

      //deleteInstructor(appDAO);

      //findInstructorDetail(appDAO);

      //deleteInstructorDetail(appDAO);

      //createInstructorWithCourses(appDAO);

      findInstructorWithCourses(appDAO);
    };
  }

  private void findInstructorWithCourses(AppDAO appDAO) {

    // get the instructor from db
    int theId = 1;
    System.out.println("Finding instructor with id: " + theId);

    Instructor tempInstructor = appDAO.findInstructorById(theId);

    System.out.println("Found instructor: " + tempInstructor);

    // get courses for the instructor
    System.out.println("Courses: " + tempInstructor.getCourses());

    System.out.println("Done!");
  }

  private void createInstructorWithCourses(AppDAO appDAO) {    
    
    // create the instructor
    Instructor tempInstructor = new Instructor("Braulio", "Nildo", "braunildo@lp.com");

    // create the instructor detail
    InstructorDetail tempInstructorDetail = new InstructorDetail("youtube.com/luizpsg", "eating");

    tempInstructor.setInstructorDetail(tempInstructorDetail);

    // create some courses
    Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
    Course tempCourse2 = new Course("The Pinball Masterclass");

    // add courses to instructor
    tempInstructor.add(tempCourse1);
    tempInstructor.add(tempCourse2);

    // save the instructor
    //
    // Note: this will also save the courses
    // because of CascadeType.ALL
    //
    System.out.println("Saving instructor: " + tempInstructor);
    System.out.println("Saving courses: " + tempInstructor.getCourses());
    appDAO.save(tempInstructor);

    System.out.println("Done!");
  }

  private void deleteInstructorDetail(AppDAO appDAO) {
    // delete the instructor detail
    int theId = 3;

    System.out.println("Deleting instructor detail with id: " + theId);
    
    appDAO.deleteInstructorDetailById(theId);

    System.out.println("Instructor detail deleted with id: " + theId);
  }

  private void findInstructorDetail(AppDAO appDAO) {
    // get the instructor detail by primary key / id
    int theId = 2;
    InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

    System.out.println("Found instructor detail: " + tempInstructorDetail);
    System.out.println("the instructor details only: " + tempInstructorDetail.getInstructor());
  }

  private void deleteInstructor(AppDAO appDAO) {

    // delete the instructor
    int theId = 2;

    System.out.println("Deleting instructor with id: " + theId);
    
    appDAO.deleteInstructorById(theId);

    System.out.println("Instructor deleted with id: " + theId);
  }

  private void findInstructor(AppDAO appDAO) {
    // get the instructor by primary key / id
    int theId = 2;
    Instructor tempInstructor = appDAO.findInstructorById(theId);

    System.out.println("Found instructor: " + tempInstructor);
    System.out.println("the instructor details only: " + tempInstructor.getInstructorDetail());
  }

  private void createInstructor(AppDAO appDAO) {
    
    // create the instructor
    Instructor tempInstructor = new Instructor("Braulio", "Nildo", "braunildo@lp.com");

    // create the instructor detail
    InstructorDetail tempInstructorDetail = new InstructorDetail("youtube.com/luizpsg", "eating");
     
    
    // create the instructor
    Instructor tempInstructor2 = new Instructor("Vivian", "Almeida", "vivi@lp.com");

    // create the instructor detail
    InstructorDetail tempInstructorDetail2 = new InstructorDetail("youtube.com/luizpsg", "accounting");

    // associate the objects
    tempInstructor.setInstructorDetail(tempInstructorDetail);
    tempInstructor2.setInstructorDetail(tempInstructorDetail2);

    // save the instructor
    //
    // Note: this will also save the details object 
    // because of CascadeType.ALL
    //
    System.out.println("Saving instructor: " + tempInstructor);
    System.out.println("Saving instructor: " + tempInstructor2);
    appDAO.save(tempInstructor);
    appDAO.save(tempInstructor2);

    System.out.println("Done!");
  }

  
}
