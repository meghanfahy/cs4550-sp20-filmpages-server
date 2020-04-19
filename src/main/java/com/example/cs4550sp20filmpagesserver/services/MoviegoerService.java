package com.example.cs4550sp20filmpagesserver.services;

import com.example.cs4550sp20filmpagesserver.models.Moviegoer;
import com.example.cs4550sp20filmpagesserver.repositories.MoviegoerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        if (moviegoerRepo.existsById(moviegoerId)) {
            updatedMoviegoer.fillBlanks(moviegoerRepo.findMoviegoerById(moviegoerId));
            updatedMoviegoer.setId(moviegoerId);
            moviegoerRepo.save(updatedMoviegoer);
            return 1;
        } else {
            return 0;
        }
//    moviegoerRepo.updateMoviegoer(updatedMoviegoer, moviegoerId);
//    return 1;
    }

    public Moviegoer findMoviergoerById(Integer moviegoerId) {
        return moviegoerRepo.findMoviegoerById(moviegoerId);
    }

    public Moviegoer findMoviegoerByCredentials(String username, String password) {
        Moviegoer resp = moviegoerRepo.findMoviegoerByUsername(username);
        System.out.println("=== Fetching user by credentials.");
        System.out.println("Username " + username);
        System.out.println("Password " + password);
        System.out.println("Fetched Username " + resp.getUsername());
        if (resp.getPassword().equals(password)) {
            System.out.println("=== Correct password!");
            return resp;
        } else {
            System.out.println("=== Incorrect password!");
            return null;
        }
    }

}
