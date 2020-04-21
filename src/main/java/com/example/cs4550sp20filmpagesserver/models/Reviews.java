package com.example.cs4550sp20filmpagesserver.models;

import javax.persistence.*;
import java.util.Set;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "USR_TYPE")
@Entity
@Table(name="reviews")
public class Reviews {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String review;

  private Critic critic;

  public Reviews(String review, Critic critic){
    this.review = review;
    this.critic = critic;
  }

  public Reviews(){}

  public void fillBlanks(Reviews other){
    if (this.review == null){
      this.review = other.review;
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

  public String getReview(){
    return review;
  }

  public void setReview(String review){
    this.review = review;
  }

  public Critic getCritic(){
    return critic;
  }

  public void setCritic(){
    this.critic = critic;
  }


}
