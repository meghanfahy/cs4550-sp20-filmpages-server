package com.example.cs4550sp20filmpagesserver.controllers;

import com.example.cs4550sp20filmpagesserver.models.Moviegoer;
import com.example.cs4550sp20filmpagesserver.services.MoviegoerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@CrossOrigin(origins = {"http://localhost:3000",
        "https://cs4550-sp20-filmpages-demo2.herokuapp.com"},
        allowCredentials = "true")
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
        if (newMoviegoer != null) {
            session.setAttribute("profile", newMoviegoer);
        }
        return newMoviegoer;
    }

    @PostMapping("/logout")
    public int logout(HttpSession session) {
        if (session.getAttribute("profile") == null) {
            return 0;
        }
        session.setAttribute("profile", null);
        return 1;
    }

    // TODO: Make this more secure (i.e., don't include stuff in uri)
    @GetMapping("/login/{username}/{password}")
    public Moviegoer findMoviegoerByCredentials(HttpSession session,
                                                @PathVariable("username") String username,
                                                @PathVariable("password") String password) {
        Moviegoer moviegoer = service.findMoviegoerByCredentials(username,
                password);
        if (moviegoer != null) {
            session.setAttribute("profile", moviegoer);
        }
        return moviegoer;
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

    @PostMapping("/profile/favoritedCinemas/{cinemaId}")
    public int addFavoriteCinema(HttpSession session,
                                 @PathVariable("cinemaId") String cinemaId) {
        Moviegoer user = (Moviegoer) session.getAttribute("profile");
        if (user == null) {
            return 0;
        }
        return service.addFavoriteCinema(user, cinemaId);
    }

    @DeleteMapping("/profile/favoritedCinemas/{cinemaId}")
    public int removeFavoriteCinema(HttpSession session,
                                    @PathVariable("cinemaId") String cinemaId) {
        Moviegoer user = (Moviegoer) session.getAttribute("profile");
        if (user == null) {
            return 0;
        }
        return service.removeFavoriteCinema(user, cinemaId);
    }

    @PostMapping("/profile/favoritedMovies/{movieId}")
    public int addFavoriteMovie(HttpSession session,
                                @PathVariable("movieId") String movieId) {
        Moviegoer user = (Moviegoer) session.getAttribute("profile");
        if (user == null) {
            return 0;
        }
        return service.addFavoriteMovie(user, movieId);
    }

    @DeleteMapping("/profile/favoritedMovies/{movieId}")
    public int removeFavoriteMovie(HttpSession session,
                                   @PathVariable("movieId") String movieId) {
        Moviegoer user = (Moviegoer) session.getAttribute("profile");
        if (user == null) {
            return 0;
        }
        return service.removeFavoriteMovie(user, movieId);
    }

}
