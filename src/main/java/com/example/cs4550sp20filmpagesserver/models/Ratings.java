package com.example.cs4550sp20filmpagesserver.models;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Set;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "USR_TYPE")
@Entity
@Table(name="ratings")

public class Ratings {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Integer id;

  private Integer rating;

  private Critic critic;

  public Ratings(Integer rating, Critic critic){
    this.rating = rating;
    this.critic = critic;
  }

  public Ratings(){}

  public void fillBlanks(Ratings other){
    if (this.rating == null){
      this.rating = other.rating;
    }
    if (this.critic == null){
      this.critic = other.critic;
    }
  }

  public Integer getId(){
    return id;
  }

  public void setId(Integer id){
    this.id = id;
  }

  public Integer getRating(){
    return rating;
  }

  public void setRating(Integer rating){
    this.rating = rating;
  }

  public Critic getCritic(){
    return critic;
  }

  public void setCritic(){
    this.critic = critic;
  }

}
