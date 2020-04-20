package com.example.cs4550sp20filmpagesserver.models;

import javax.persistence.*;
import java.util.List;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "USR_TYPE")
@Entity
@Table(name = "moviegoers")
public class Moviegoer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //    @JsonIgnore // What's the best way to do this?
    private String password;

    private String username;

    private String name;

    private java.sql.Date dob;

    @ElementCollection
    private List<String> favoritedMovies;

    @ElementCollection
    private List<String> favoritedCinemas;

    public Moviegoer(String name, java.sql.Date dob,
                     String password, String username,
                     List<String> favoritedMovies, List<String> favoritedCinemas) {
        this.name = name;
        this.dob = dob;
        this.password = password;
        this.username = username;
        this.favoritedMovies = favoritedMovies;
        this.favoritedCinemas = favoritedCinemas;
    }

    public Moviegoer() {
    }

    public void fillBlanks(Moviegoer other) {
        if (this.name == null) {
            this.name = other.name;
        }
        if (this.dob == null) {
            this.dob = other.dob;
        }
        if (this.username == null) {
            this.username = other.username;
        }
        if (this.password == null) {
            this.password = other.password;
        }
        if (this.favoritedMovies == null) {
            this.favoritedMovies = other.favoritedMovies;
        }
        if (this.favoritedCinemas == null) {
            this.favoritedCinemas = other.favoritedCinemas;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public java.sql.Date getDob() {
        return dob;
    }

    public void setDob(java.sql.Date dob) {
        this.dob = dob;
    }

    public List<String> getFavoritedMovies() {
        return favoritedMovies;
    }

    public void setFavoritedMovies(List<String> favoritedMovies) {
        this.favoritedMovies = favoritedMovies;
    }

    public List<String> getFavoritedCinemas() {
        return favoritedCinemas;
    }

    public void setFavoritedCinemas(List<String> favoritedCinemas) {
        this.favoritedCinemas = favoritedCinemas;
    }

    public boolean addFavoriteCinema(String cinemaId) {
        if (this.favoritedCinemas.contains(cinemaId)) {
            return false;
        }
        this.favoritedCinemas.add(cinemaId);
        return true;
    }

    public boolean removeFavoriteCinema(String cinemaId) {
        return this.favoritedCinemas.remove(cinemaId);
    }

    public boolean addFavoriteMovie(String movieId) {
        if (this.favoritedMovies.contains(movieId)) {
            return false;
        }
        this.favoritedMovies.add(movieId);
        return true;
    }

    public boolean removeFavoriteMovie(String movieId) {
        return this.favoritedMovies.remove(movieId);
    }
}


