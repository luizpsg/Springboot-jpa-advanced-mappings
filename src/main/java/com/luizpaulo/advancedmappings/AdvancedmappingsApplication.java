package com.luizpaulo.advancedmappings;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luizpaulo.advancedmappings.dao.AppDAO;
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
    
      createInstructor(appDAO);

    };
  }

  private void createInstructor(AppDAO appDAO) {
    /*
    // create the instructor
    Instructor tempInstructor = new Instructor("Luiz Paulo", "Gonçalves", "luizpsg@lp.com");

    // create the instructor detail
    InstructorDetail tempInstructorDetail = new InstructorDetail("youtube.com/luizpsg", "coding");
     */
    
    // create the instructor
    Instructor tempInstructor = new Instructor("Vivian", "Almeida", "vivi@lp.com");

    // create the instructor detail
    InstructorDetail tempInstructorDetail = new InstructorDetail("youtube.com/luizpsg", "accounting");

    // associate the objects
    tempInstructor.setInstructorDetail(tempInstructorDetail);

    // save the instructor
    //
    // Note: this will also save the details object 
    // because of CascadeType.ALL
    //
    System.out.println("Saving instructor: " + tempInstructor);
    appDAO.save(tempInstructor);

    System.out.println("Done!");
  }

}
