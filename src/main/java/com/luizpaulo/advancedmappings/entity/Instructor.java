package com.luizpaulo.advancedmappings.entity;



import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

// annotate the class as an entity and map to db table
@Entity
@Table(name = "instructor")
public class Instructor {

  // define the fields
  // annotate the fields with db column names
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "email")
  private String email;

  //** set up mapping to InstructorDetail entity
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "instructor_detail_id")
  private InstructorDetail instructorDetail;

  @OneToMany(mappedBy = "instructor", fetch = FetchType.EAGER,
  cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  private List<Course> courses;

  // create constructors
  public Instructor() {
  }

  public Instructor(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  // generate getter/setter methods
  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public InstructorDetail getInstructorDetail() {
    return this.instructorDetail;
  }

  public void setInstructorDetail(InstructorDetail instructorDetail) {
    this.instructorDetail = instructorDetail;
  }

  public List<Course> getCourses() {
    return this.courses;
  }

  public void setCourses(List<Course> courses) {
    this.courses = courses;
  }

  // add convenience methods for bi-directional relationship
  public void add(Course tempCourse) {
    if (courses == null) {
      courses = new ArrayList<>();
    }

    courses.add(tempCourse);

    tempCourse.setInstructor(this);
  }

  // generate toString() method
  @Override
  public String toString() {
    return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
        + ", instructorDetail=" + instructorDetail + "]";
  }
}
