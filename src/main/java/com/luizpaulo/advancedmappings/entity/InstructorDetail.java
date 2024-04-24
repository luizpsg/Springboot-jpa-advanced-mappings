package com.luizpaulo.advancedmappings.entity;

import jakarta.persistence.*;


// annotate the class as an entity and map to db table
@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

  // define the fields
  // annotate the fields with db column names
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "youtube_channel")
  private String youtubeChannel;

  @Column(name = "hobby")
  private String hobby;

  @OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL)
  private Instructor instructor;

  // create constructors

  public InstructorDetail() {
  }

  public InstructorDetail(String youtubeChannel, String hobby) {
    this.youtubeChannel = youtubeChannel;
    this.hobby = hobby;
  }

  // generate getter/setter methods

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getYoutubeChannel() {
    return this.youtubeChannel;
  }

  public void setYoutubeChannel(String youtubeChannel) {
    this.youtubeChannel = youtubeChannel;
  }

  public String getHobby() {
    return this.hobby;
  }

  public void setHobby(String hobby) {
    this.hobby = hobby;
  }
  
  public Instructor getInstructor() {
    return this.instructor;
  }

  public void setInstructor(Instructor instructor) {
    this.instructor = instructor;
  }

  // generate toString() method
  @Override
  public String toString() {
    return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
  }
}
