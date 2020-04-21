package com.example.cs4550sp20filmpagesserver.services;
import com.example.cs4550sp20filmpagesserver.models.Ratings;
import com.example.cs4550sp20filmpagesserver.models.Critic;
import com.example.cs4550sp20filmpagesserver.repositories.RatingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class RatingsService {
  @Autowired
  RatingsRepository ratingsRepo;

  public List<Ratings> findAllRatings(){
    return ratingsRepo.findAllRatings();
  }

  public Ratings createRating(Ratings rating){
    return ratingsRepo.save(rating);
  }

  public int deleteRating(Integer ratingId){
    ratingsRepo.deleteById(ratingId);
    return 1;
  }

  public int updateRating(Integer ratingId, Ratings updatedRating){
    if (ratingsRepo.existsById(ratingId)) {
      updatedRating.fillBlanks(ratingsRepo.findRatingById(ratingId));
      updatedRating.setId(ratingId);
      ratingsRepo.save(updatedRating);
      return 1;
    } else {
      return 0;
    }
  }

  public Ratings findRatingById(Integer ratingId){
    return ratingsRepo.findRatingById(ratingId);
  }

  public List<Ratings> findRatingByCriticId (Critic critic){
    return ratingsRepo.findRatingsByCriticId(critic);
  }

  public List<Ratings> findRatingByMovieId(String movieId){
    return ratingsRepo.findRatingsByMovieId(movieId);
  }
}


