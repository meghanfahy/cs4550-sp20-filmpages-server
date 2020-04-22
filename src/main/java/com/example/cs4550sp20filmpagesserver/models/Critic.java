package com.example.cs4550sp20filmpagesserver.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

@Entity
@DiscriminatorValue("C")
public class Critic extends Moviegoer {

    // Stuff particular to Critics.
    // e.g. reviews/ratings

    @JsonIgnore
    @OneToMany(mappedBy = "critic")
    private List<Ratings> ratings;

    @JsonIgnore
    @OneToMany(mappedBy = "critic")
    private List<Reviews> reviews;

    public Critic(String name, java.sql.Date dob,
                  String password, String username,
                  Set<String> favoritedMovies,
                  Set<String> favoritedCinemas,
                  Boolean isCritic,
                  List<Ratings> ratings,
                  List<Reviews> reviews) {
        super(name, dob, password, username, favoritedMovies,
                favoritedCinemas, isCritic);
        this.ratings = ratings;
        this.reviews = reviews;
        super.setCritic(true);
    }

    public Critic() {
    }

    public void fillBlanks(Critic other) {
        if (this.ratings == null) {
            this.ratings = other.ratings;
        }
        if (this.reviews == null) {
            this.reviews = reviews;
        }
    }

    public List<Ratings> getRatings() {
        return ratings;
    }

    public void setRatings(List<Ratings> ratings) {
        this.ratings = ratings;
    }

    public List<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(List<Reviews> reviews) {
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
