package com.example.cs4550sp20filmpagesserver.services;
import com.example.cs4550sp20filmpagesserver.models.Moviegoer;
import com.example.cs4550sp20filmpagesserver.repositories.MoviegoerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class MoviegoerService {

  @Autowired
  MoviegoerRepository moviegoerRepo;

  public List<Moviegoer> findAllMoviegoers() {
    return moviegoerRepo.findAllMoviegoers();
  }

  public Moviegoer createMoviegoer(Moviegoer moviegoer) {
    return moviegoerRepo.save(moviegoer);
  }

  public int deleteMoviegoer(Integer moviegoerId) {
    moviegoerRepo.deleteById(moviegoerId);
    return 1;
  }

  public int updateMoviegoer(Integer moviegoerId, Moviegoer updatedMoviegoer) {
    moviegoerRepo.updateMoviegoer(updatedMoviegoer, moviegoerId);
    return 1;
  }

  public Moviegoer findMoviergoerById(Integer moviegoerId) {
    return moviegoerRepo.findMoviegoerById(moviegoerId);
  }

}
