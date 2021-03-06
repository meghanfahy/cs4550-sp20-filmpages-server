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
        if (moviegoerRepo.findMoviegoerByUsername(moviegoer.getUsername()) != null) {
            return null; // Already exists by username.
        } else {
            return moviegoerRepo.save(moviegoer);
        }
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
        if (resp != null && resp.checkPassword(password)) {
            return resp;
        } else {
            return null;
        }
    }

    public int addFavoriteCinema(Moviegoer user, String cinemaId) {
        boolean b = user.addFavoriteCinema(cinemaId);
        if (b) {
            moviegoerRepo.save(user);
        }
        return b ? 1 : 0;
    }

    public int removeFavoriteCinema(Moviegoer user, String cinemaId) {
        boolean b = user.removeFavoriteCinema(cinemaId);
        if (b) {
            moviegoerRepo.save(user);
        }
        return b ? 1 : 0;
    }

    public int addFavoriteMovie(Moviegoer user, String movieId) {
        boolean b = user.addFavoriteMovie(movieId);
        if (b) {
            moviegoerRepo.save(user);
        }
        return b ? 1 : 0;
    }

    public int removeFavoriteMovie(Moviegoer user, String movieId) {
        boolean b = user.removeFavoriteMovie(movieId);
        if (b) {
            moviegoerRepo.save(user);
        }
        return b ? 1 : 0;
    }

}
