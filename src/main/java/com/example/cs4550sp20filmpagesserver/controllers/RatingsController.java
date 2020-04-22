package com.example.cs4550sp20filmpagesserver.controllers;
import com.example.cs4550sp20filmpagesserver.models.Critic;
import com.example.cs4550sp20filmpagesserver.models.Ratings;
import com.example.cs4550sp20filmpagesserver.services.RatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = {"http://localhost:3000",
        "https://cs4550-sp20-filmpages-demo2.herokuapp.com",
        "https://cs4550-sp20-filmpages-final.herokuapp.com"},
        allowCredentials = "true")

public class RatingsController {
  @Autowired
  RatingsService service;

  @PostMapping("/api/ratings")
  public Ratings createRating(@RequestBody Ratings rating) {
    return service.createRating(rating);
  }

  @PutMapping("/api/ratings/{ratingId}")
  public int updateRating(@PathVariable("ratingId") Integer ratingId, @RequestBody Ratings rating) {
    return service.updateRating(ratingId, rating);
  }

  @DeleteMapping("/api/ratings/{ratingId}")
  public int deleteRating(@PathVariable("ratingId") Integer ratingId) {
    return service.deleteRating(ratingId);
  }

  @GetMapping("/api/ratings")
  public List<Ratings> findAllRatings() {
    return service.findAllRatings();
  }

  @GetMapping("/api/ratings/{ratingId}")
  public Ratings findRatingById(@PathVariable("ratingId") Integer ratingId) {
    return service.findRatingById(ratingId);
  }

  @GetMapping("/api/critics/{criticId}/ratings")
  public List<Ratings> findRatingsByCriticId(@PathVariable("criticId") int criticId) {
    return service.findRatingByCriticId(criticId);
  }

  @GetMapping("/api/movies/{movieId}/ratings")
  public List<Ratings> findRatingsByMovieId(@PathVariable("movieId") String movieId) {
    return service.findRatingByMovieId(movieId);
  }
}
