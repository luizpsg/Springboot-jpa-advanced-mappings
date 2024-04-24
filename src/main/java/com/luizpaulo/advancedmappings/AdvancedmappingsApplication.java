package com.luizpaulo.advancedmappings;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdvancedmappingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedmappingsApplication.class, args);
	}

  @Bean
  public CommandLineRunner commandLineRunner(String [] args){
    return runner -> {
      System.out.println("Hello World!");
    };
  }

}
