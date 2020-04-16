package com.example.cs4550sp20filmpagesserver.models;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;


import java.util.Date;


@Entity
@Table(name = "critics")
public class Critic {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  @JsonIgnore
  @ManyToOne

  private Integer dob;

  // Constructor
  public Critic(String name, Integer dob) {
    this.name = name;
    this.dob = dob;
  }


  public Critic() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getDob() {
    return dob;
  }

  public void setDob(Integer dob) {
    this.dob = dob;
  }
}
