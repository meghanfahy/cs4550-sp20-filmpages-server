package com.example.cs4550sp20filmpagesserver.services;
import com.example.cs4550sp20filmpagesserver.models.Reviews;
import com.example.cs4550sp20filmpagesserver.models.Critic;
import com.example.cs4550sp20filmpagesserver.repositories.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ReviewsService {

  @Autowired
  ReviewsRepository reviewsRepo;

  public List<Reviews> findAllReviews(){
    return reviewsRepo.findAllReviews();
  }

  public Reviews createReview(Reviews review){
    return reviewsRepo.save(review);
  }

  public int deleteReview(Integer reviewId){
    reviewsRepo.deleteById(reviewId);
    return 1;
  }

  public int updateReview(Integer reviewId, Reviews updatedReview){
    if (reviewsRepo.existsById(reviewId)) {
      updatedReview.fillBlanks(reviewsRepo.findReviewById(reviewId));
      updatedReview.setId(reviewId);
      reviewsRepo.save(updatedReview);
      return 1;
    } else {
      return 0;
    }
  }

  public Reviews findReviewById(Integer reviewId){
    return reviewsRepo.findReviewById(reviewId);
  }

  public List<Reviews> findReviewByCriticId (Critic critic){
    return reviewsRepo.findReviewsByCriticId(critic);
  }
}
