package com.example.cs4550sp20filmpagesserver.models;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("C")
public class Critic extends Moviegoer {

    // Stuff particular to Critics.
    // e.g. reviews/ratings

  private Integer id;

  private Ratings rating;

  private Reviews review;

  @ElementCollection
  private Set<Ratings> ratings;

  @ElementCollection
  private Set<Reviews> reviews;

  public Critic (Ratings rating, Reviews review, Set<Ratings> ratings, Set<Reviews> reviews){
    this.rating = rating;
    this.review = review;
    this.ratings = ratings;
    this.reviews = reviews;
  }

  public Critic(){}

  public void fillBlanks(Critic other){
    if (this.rating == null){
      this.rating = other.rating;
    }
    if (this.review == null){
      this.review = review;
    }
  }

  public Ratings getRating(){
    return rating;
  }

  public void setRating(Ratings rating){
    this.rating = rating;
  }

  public Reviews getReview(){
    return review;
  }

  public void setReview(Reviews review){
    this.review = review;
  }

  public Set<Ratings> getRatings(){
    return ratings;
  }

  public void setRatings(Set<Ratings> ratings){
    this.ratings = ratings;
  }

  public Set<Reviews> getReviews(){
    return reviews;
  }

  public void setReviews(Set<Reviews> reviews){
    this.reviews = reviews;
  }

  public boolean addReview(Reviews reviewId) {
    if (this.reviews.contains(reviewId)) {
      return false;
    }
    this.reviews.add(reviewId);
    return true;
  }

  public boolean removeReview(Reviews reviewId) {
    return this.reviews.remove(reviewId);
  }

  public boolean addRating(Ratings ratingId) {
    if (this.ratings.contains(ratingId)) {
      return false;
    }
    this.ratings.add(ratingId);
    return true;
  }

  public boolean removeRating(Ratings ratingId) {
    return this.ratings.remove(ratingId);
  }
}
