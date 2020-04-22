package com.example.cs4550sp20filmpagesserver.controllers;

import com.example.cs4550sp20filmpagesserver.models.Reviews;
import com.example.cs4550sp20filmpagesserver.services.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = {"http://localhost:3000",
        "https://cs4550-sp20-filmpages-demo2.herokuapp.com",
        "https://cs4550-sp20-filmpages-final.herokuapp.com"},
        allowCredentials = "true")

public class ReviewsController {
    @Autowired
    ReviewsService service;

    @PostMapping("/api/reviews")
    public Reviews createReview(@RequestBody Reviews review) {
        return service.createReview(review);
    }

    @PutMapping("/api/reviews/{reviewId}")
    public int updateReview(@PathVariable("reviewId") Integer reviewId, @RequestBody Reviews review) {
        return service.updateReview(reviewId, review);
    }

    @DeleteMapping("/api/reviews/{reviewId}")
    public int deleteReview(@PathVariable("reviewId") Integer reviewId) {
        return service.deleteReview(reviewId);
    }

    @GetMapping("/api/reviews")
    public List<Reviews> findAllReviews() {
        return service.findAllReviews();
    }

    @GetMapping("/api/reviews/{reviewId}")
    public Reviews findReviewById(@PathVariable("reviewId") Integer reviewId) {
        return service.findReviewById(reviewId);
    }

    @GetMapping("/api/critics/{criticId}/reviews")
    public List<Reviews> findReviewsByCriticId(@PathVariable("criticId") int criticId) {
        return service.findReviewByCriticId(criticId);
    }

    @GetMapping("/api/movies/{movieId}/reviews")
    public List<Reviews> findReviewsByMovieId(@PathVariable("movieId") String movieId) {
        return service.findReviewByMovieId(movieId);
    }
}
