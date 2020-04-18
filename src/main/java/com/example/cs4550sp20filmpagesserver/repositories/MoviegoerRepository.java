package com.example.cs4550sp20filmpagesserver.repositories;

import com.example.cs4550sp20filmpagesserver.models.Moviegoer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MoviegoerRepository extends CrudRepository<Moviegoer, Integer> {
    @Query("SELECT moviegoer FROM Moviegoer moviegoer")
    List<Moviegoer> findAllMoviegoers();

    @Query("SELECT moviegoer FROM Moviegoer moviegoer WHERE moviegoer.id=:moviegoerId")
    Moviegoer findMoviegoerById(@Param("moviegoerId") Integer moviegoerId);

    @Query("SELECT moviegoer FROM Moviegoer moviegoer WHERE " +
            "moviegoer.username=:username AND moviegoer.password=:password")
    Moviegoer findMoviegoerByCredentials(@Param("username") String username,
                                         @Param("password") String password);

//    @Modifying
//    @Query("UPDATE Moviegoer moviegoer SET moviegoer=:moviegoer WHERE moviegoer.id=:moviegoerId")
//    public int updateMoviegoer(@Param("moviegoer") Moviegoer moviegoer, @Param("moviegoerId") Integer moviegoerId);
}
