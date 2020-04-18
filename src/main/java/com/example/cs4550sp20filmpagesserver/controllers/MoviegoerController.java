package com.example.cs4550sp20filmpagesserver.controllers;

import com.example.cs4550sp20filmpagesserver.models.Moviegoer;
import com.example.cs4550sp20filmpagesserver.services.MoviegoerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class MoviegoerController {
    @Autowired
    MoviegoerService service;

    @GetMapping("/profile")
    public Moviegoer getLoggedInMoviegoer(HttpSession session) {
        return (Moviegoer) session.getAttribute("profile");
    }

    @PostMapping("/register")
    public Moviegoer createMoviegoer(HttpSession session,
                                     @RequestBody Moviegoer moviegoer) {
        Moviegoer newMoviegoer = service.createMoviegoer(moviegoer);
        session.setAttribute("profile", newMoviegoer);
        return newMoviegoer;
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

    @GetMapping("/api/moviegoers/{username}/{password}")
    public Moviegoer findMoviegoerByCredentials(@PathVariable("username") String username,
                                                @PathVariable("password") String password) {
        return service.findMoviegoerByCredentials(username, password);
    }

}
