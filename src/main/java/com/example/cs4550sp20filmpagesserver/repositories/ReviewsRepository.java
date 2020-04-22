package com.example.cs4550sp20filmpagesserver.repositories;

import com.example.cs4550sp20filmpagesserver.models.Reviews;
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
            "review.critic.id=:criticId")
    List<Reviews> findReviewsByCriticId(@Param("criticId") int criticId);

    @Query("SELECT review FROM Reviews review WHERE " +
            "review.movie=:movie")
    List<Reviews> findReviewsByMovieId(@Param("movie") String movie);
}

