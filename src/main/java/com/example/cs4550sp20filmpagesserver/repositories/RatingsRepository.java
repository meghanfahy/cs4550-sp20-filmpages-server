package com.example.cs4550sp20filmpagesserver.repositories;

import com.example.cs4550sp20filmpagesserver.models.Ratings;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RatingsRepository extends CrudRepository<Ratings, Integer> {
    @Query("SELECT rating FROM Ratings rating")
    List<Ratings> findAllRatings();

    @Query("SELECT rating FROM Ratings rating WHERE rating.id=:ratingId")
    Ratings findRatingById(@Param("ratingId") Integer ratingId);

    @Query("SELECT rating FROM Ratings rating WHERE " +
            "rating.critic.id=:criticId")
    List<Ratings> findRatingsByCriticId(@Param("criticId") int criticId);

    @Query("SELECT rating FROM Ratings rating WHERE " +
            "rating.movie=:movie")
    List<Ratings> findRatingsByMovieId(@Param("movie") String movie);
}


