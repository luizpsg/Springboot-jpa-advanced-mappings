package com.luizpaulo.advancedmappings;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luizpaulo.advancedmappings.dao.AppDAO;
import com.luizpaulo.advancedmappings.entity.Course;
import com.luizpaulo.advancedmappings.entity.Student;

@SpringBootApplication
public class AdvancedmappingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedmappingsApplication.class, args);
	}

  @Bean
  public CommandLineRunner commandLineRunner(AppDAO appDAO){

    return runner -> {
        
      //createCourseAndStudents(appDAO);

      //findCourseAndStudents(appDAO);

      findStudentAndCourses(appDAO);
    };
  }

  private void findStudentAndCourses(AppDAO appDAO) {
      
      int theId = 1;
  
      Student tempStudent = appDAO.findStudentsAndCoursesByStudentId(theId);
  
      System.out.println("Found student: " + tempStudent);
  
      System.out.println("Courses: " + tempStudent.getCourses());
  
      System.out.println("Done!");
  }

  private void findCourseAndStudents(AppDAO appDAO) {
    
    int theId = 10;

    Course tempCourse = appDAO.findCoursesAndStudentsByCourseId(theId);

    System.out.println("Found course: " + tempCourse);

    System.out.println("Students: " + tempCourse.getStudents());

    System.out.println("Done!");
  }

  private void createCourseAndStudents(AppDAO appDAO) {
    
    // create a course
    Course tempCourse = new Course("Pacman - How To Score One Million Points");

    // create the students
    Student tempStudent1 = new Student("Luiz Paulo", "Gonçalves", "luizpsg@lp.com");
    Student tempStudent2 = new Student("Braulio", "Nildo", "braunildo@lp.com");
    
    // add students to the course
    tempCourse.addStudent(tempStudent1);
    tempCourse.addStudent(tempStudent2);

    // save the course and associated students
    System.out.println("Saving course: " + tempCourse);
    System.out.println("Saving students: " + tempCourse.getStudents());
    appDAO.save(tempCourse);
  }





  /*
  private void deleteCourseAndReviews(AppDAO appDAO) {
      
      int theId = 10;
  
      System.out.println("Finding course id: " + theId);
  
      Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);
  
      System.out.println("Found course: " + tempCourse);
  
      System.out.println("Deleting course: " + tempCourse);
  
      appDAO.deleteCourseById(theId);
  
      System.out.println("Done!");
  }

  private void retrieveCourseAndReviews(AppDAO appDAO) {
      
      int theId = 10;
  
      Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);
  
      System.out.println("Found course: " + tempCourse);
  
      System.out.println("Reviews: " + tempCourse.getReviews());
  
      System.out.println("Done!");
  }

  private void createCourseAndReviews(AppDAO appDAO) {
      
      // create a course
      Course tempCourse = new Course("Pacman - How To Score One Million Points");
  
      // add some reviews
      tempCourse.addReview(new Review("Great course ... loved it!"));
      tempCourse.addReview(new Review("Cool course, job well done"));
      tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));
  
      // save the course ... and leverage the cascade all :-)
      System.out.println("Saving course: " + tempCourse);
      System.out.println("Saving reviews: " + tempCourse.getReviews());
      appDAO.save(tempCourse);
  
      System.out.println("Done!");
  }

  private void deleteCourse(AppDAO appDAO) {
    
    int theId = 10;

    System.out.println("Finding course id: " + theId);

    Course tempCourse = appDAO.findCourseById(theId);

    System.out.println("Found course: " + tempCourse);

    System.out.println("Deleting course: " + tempCourse);

    appDAO.deleteCourseById(theId);

    System.out.println("Done!");
  }

  private void updateCourse(AppDAO appDAO) {
    int theId = 10;

    Course tempCourse = appDAO.findCourseById(theId);

    System.out.println("Found course: " + tempCourse);

    System.out.println("Updating course: " + tempCourse);

    tempCourse.setTitle("Java - The Ultimate Guide");

    appDAO.update(tempCourse);

    System.out.println("Done!");
  }

  private void updateInstructor(AppDAO appDAO) {
    int theId = 1;

    System.out.println("Finding instructor id: " + theId);

    Instructor tempInstructor = appDAO.findInstructorById(theId);

    System.out.println("Found instructor: " + tempInstructor);

    System.out.println("Updating instructor: " + tempInstructor);

    tempInstructor.setFirstName("Luiz Paulo");
    tempInstructor.setLastName("Gonçalves");

    appDAO.update(tempInstructor);

    System.out.println("Done!");
  }

  private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
    
    int theId = 1;

    System.out.println("Finding instructor id: " + theId);

    Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

    System.out.println("Found instructor: " + tempInstructor);

    System.out.println("Courses: " + tempInstructor.getCourses());

    System.out.println("Done!");
  }

  private void findCoursesForInstructor(AppDAO appDAO) {
    // get the courses for a given instructor
    int theId = 1;

    System.out.println("Finding instructor id: " + theId);

    Instructor tempInstructor = appDAO.findInstructorById(theId);

    System.out.println("tempInstructor: " + tempInstructor);

    System.out.println("Finding courses for instructor id: " + theId);
    List<Course> courses = appDAO.findCoursesByInstructorId(theId);

    tempInstructor.setCourses(courses);

    System.out.println("The associated courses: " + tempInstructor.getCourses());

    System.out.println("Done!");
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
    int theId = 1;

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
 */
  
}
