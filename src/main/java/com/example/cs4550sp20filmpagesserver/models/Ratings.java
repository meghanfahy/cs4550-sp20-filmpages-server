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

  private String movie;

  public Ratings(Integer rating, Critic critic, String movie){
    this.rating = rating;
    this.critic = critic;
    this.movie = movie;
  }

  public Ratings(){}

  public void fillBlanks(Ratings other){
    if (this.rating == null){
      this.rating = other.rating;
    }
    if (this.critic == null){
      this.critic = other.critic;
    }
    if (this.movie == null){
      this.movie = other.movie;
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

  public String getMovie(){
    return movie;
  }

  public void setMovie(String movie){
    this.movie = movie;
  }

  public Critic getCritic(){
    return critic;
  }

  public void setCritic(){
    this.critic = critic;
  }

}
