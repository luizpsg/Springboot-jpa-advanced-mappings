package com.luizpaulo.advancedmappings.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class Review {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "comment")
  private String comment;
  
  public Review() {
  }

  public Review(String comment) {
    this.comment = comment;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getComment() {
    return this.comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  @Override
  public String toString() {
    return "Review {" +
      " id='" + getId() + "'" +
      ", comment='" + getComment() + "'" +
      "}";
  }

}
