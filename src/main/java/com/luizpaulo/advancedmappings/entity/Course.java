package com.luizpaulo.advancedmappings.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "title")
  private String title;

  @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  @JoinColumn(name = "instructor_id")
  private Instructor instructor;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "course_id")
  private List<Review> reviews;

  @ManyToMany(
    fetch = FetchType.LAZY, 
    cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  @JoinTable(
    name = "course_student",
    joinColumns = @JoinColumn(name = "course_id"),
    inverseJoinColumns = @JoinColumn(name = "student_id")
  )
  private List<Student> students;

  public Course() {
  }

  public Course(String title) {
    this.title = title;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Instructor getInstructor() {
    return this.instructor;
  }

  public void setInstructor(Instructor instructor) {
    this.instructor = instructor;
  }

  public List<Review> getReviews() {
    return this.reviews;
  }

  public void setReviews(List<Review> reviews) {
    this.reviews = reviews;
  }

  // add a convenience method
  public void addReview(Review theReview) {
    if (reviews == null) {
      reviews = new ArrayList<>();
    }

    reviews.add(theReview);
  }

  public List<Student> getStudents() {
    return this.students;
  }

  public void setStudents(List<Student> students) {
    this.students = students;
  }

  // add a convenience method to add a student
  public void addStudent(Student theStudent) {
    if (students == null) {
      students = new ArrayList<>();
    }

    students.add(theStudent);
  }

  @Override
  public String toString() {
    return "Course {" +
      " id='" + getId() + "'" +
      ", title='" + getTitle() + "'" +
      "}";
  }
}
