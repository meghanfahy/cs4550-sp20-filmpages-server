package com.example.cs4550sp20filmpagesserver.repositories;
import com.example.cs4550sp20filmpagesserver.models.Moviegoer;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MoviegoerRepository extends CrudRepository<Moviegoer, Integer>{
  @Query("SELECT moviegoer FROM Moviegoer moviegoer")
  public List<Moviegoer> findAllMoviegoers();

  @Query("SELECT moviegoer FROM Moviegoer moviegoer WHERE moviegoer.id=:moviergoerId")
  public Moviegoer findMoviegoerById(@Param("moviegoerId") Integer moviegoerId);

  @Modifying
  @Query("UPDATE Moviegoer moviegoer SET moviegoer=:moviegoer WHERE moviegoer.id=:moviegoerId")
  public int updateMoviegoer(@Param("moviegoer") Moviegoer moviegoer, @Param("moviegoerId") Integer moviegoerId);
}
