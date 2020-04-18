package com.example.cs4550sp20filmpagesserver.controllers;

import com.example.cs4550sp20filmpagesserver.services.MoviegoerService;
import com.example.cs4550sp20filmpagesserver.models.Moviegoer;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@CrossOrigin(origins = "*")
public class MoviegoerController {
  @Autowired
  MoviegoerService service;

  @PostMapping("/api/moviegoers")
  public Moviegoer createMoviegoer(@RequestBody Moviegoer moviegoer) {
    return service.createMoviegoer(moviegoer);
  }


  @PutMapping("/api/moviegoers/{moviegoerId}")
  public int updateMoviegoer(@PathVariable("moviegoerId") Integer moviegoerId, @RequestBody Moviegoer moviegoer) {
    return service.updateMoviegoer(moviegoerId, moviegoer);
  }

  @DeleteMapping("/api/moviegoers/{moviegoerId}")
  public int deleteMoviegoer(@PathVariable("moviegoerId") Integer moviegoerId) {
    return service.deleteMoviegoer(moviegoerId);
  }

  @GetMapping("/api/moviegoers")
  public List<Moviegoer> findAllMoviegoers() {
    return service.findAllMoviegoers();
  }

  @GetMapping("/api/moviegoers/{moviegoerId}")
  public Moviegoer findMoviergoerById(@PathVariable("moviegoerId") Integer moviegoerId) {
    return service.findMoviergoerById(moviegoerId);
  }

}
