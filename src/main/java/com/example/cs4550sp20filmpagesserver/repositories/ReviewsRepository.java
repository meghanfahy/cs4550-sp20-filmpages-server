package com.example.cs4550sp20filmpagesserver.repositories;

import com.example.cs4550sp20filmpagesserver.models.Reviews;
import com.example.cs4550sp20filmpagesserver.models.Critic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewsRepository extends CrudRepository<Reviews, Integer> {
@Query("SELECT review FROM Reviews review")
  List<Reviews> findAllReviews();

@Query("SELECT review FROM Reviews review WHERE review.id=:reviewId")
  Reviews findReviewById(@Param("reviewId") Integer reviewId);

@Query("SELECT review FROM Reviews review WHERE " +
        "review.critic=:critic")
  List<Reviews> findReviewsByCriticId(@Param("critic") Critic critic);

  @Query("SELECT review FROM Reviews review WHERE " +
          "review.movie=:movie")
  List<Reviews> findReviewsByMovieId(@Param("movie") String movie);}

